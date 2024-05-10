package com.kh.isecon.DAO;

import com.kh.isecon.COMMON.Common;
import com.kh.isecon.VO.MusicVo;

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

    public List<MusicVo> playListMusicSelect(String pname){

        String sql = "SELECT *  FROM playlist where pname = "+ pname;
        List<MusicVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
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

}
