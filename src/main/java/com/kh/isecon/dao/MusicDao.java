package com.kh.isecon.dao;

import com.kh.isecon.common.Common;
import com.kh.isecon.vo.MusicVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public List<MusicVo> musicSelectAll() {
        List<MusicVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Music";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int mno = rs.getInt("mno");
                String mname = rs.getString("mname");
                String singer = rs.getString("singer");
                String surl = rs.getString("surl");

                MusicVo vo = new MusicVo(mno, mname, singer, surl);
                System.out.println(vo.getMno());
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // playListMusicSelect() 에서 사용하려고 만든 함수
    public MusicVo musicOneSelect(int mno){
        MusicVo vo = new MusicVo();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Music where mno ="+mno;
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int mno1 = rs.getInt("MNO");
                String mname = rs.getString("MNAME");
                String singer = rs.getString("SINGER");
                String murl = rs.getString("SURL");

                vo = new MusicVo(mno1,mname,singer,murl);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }


    public void musicInsertPlayList(List<Integer> arrayMno, int uno, String plyname) {

        try {
            for (int i : arrayMno) {

                String query = "INSERT INTO playlist " +
                        "(plno, uno, mno, planme)" +
                        "values (plno_seq.nextval,?,?,?)";

                conn = Common.getConnection();
                pstmt = conn.prepareStatement(query);

                pstmt.setInt(1, uno);
                pstmt.setInt(2, i);
                pstmt.setString(3, plyname);

                Common.close(rs);
                Common.close(stmt);
                Common.close(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MusicVo> playListMusicSelect(String pname, int uno){

        String sql = "SELECT * FROM playlist WHERE plname = ? and uno =?";
        List<MusicVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pname); // pname을 문자열로 처리
            pstmt.setInt(2, uno); // pname을 문자열로 처리
            rs = pstmt.executeQuery();
            while (rs.next()) {
               int mno = rs.getInt("mno");
                MusicDao dao = new MusicDao();
                MusicVo vo = dao.musicOneSelect(mno);
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void musicInsert(MusicVo vo){ // 초반에 DB에 음악 집어넣으려고 만듦
        String sql = "insert into music" +
                "(mno, mname, singer, surl)" +
                "values (mno_seq.nextval, ?, ?, ?)";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);

                pstmt.setString(1,vo.getMname());
                pstmt.setString(2,vo.getSinger());
                pstmt.setString(3,vo.getSurl());
                pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MusicVo> searchMusic(String search) {
        String sql = "select * from music where mname like ? or singer like ?";
        List<MusicVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            String searchWord = "%" + search + "%";
            pstmt.setString(1, searchWord);
            pstmt.setString(2, searchWord);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int mno = rs.getInt("mno");
                String mname = rs.getString("mname");
                String singer = rs.getString("singer");
                String surl = rs.getString("surl");

                MusicVo vo = new MusicVo(mno, mname, singer, surl);
                System.out.println(vo.getMno());
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
