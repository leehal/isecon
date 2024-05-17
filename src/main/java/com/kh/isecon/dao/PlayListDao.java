package com.kh.isecon.dao;

import com.kh.isecon.common.Common;
import com.kh.isecon.vo.PlayListVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayListDao {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public List<PlayListVo> usersPlayListNameSelect(int uno) {
        List<PlayListVo> list = new ArrayList<>();
        try {
            String sql = "select distinct plname from PLAYLIST where uno = ?";
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, uno);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                PlayListVo vo = new PlayListVo();
                String plname = rs.getString("plname");
//                int plno = rs.getInt("plno");

//                vo.setPlno(plno);
                vo.setPlname(plname);
                list.add(vo);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void playListInsert(List<Integer> mnoList, int uno, String plname) {
        String sql = "insert into playlist" +
                "(plno, uno, mno, planme)" +
                "values (plno_seq.nextval, ?, ?, ?)";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int mno : mnoList) {
                pstmt.setInt(1,uno);
                pstmt.setInt(2,mno);
                pstmt.setString(3,plname);
                pstmt.executeUpdate();
            }
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Veiw단에서 기존이름을 저장해주고 바뀐이름과 원래의 이름 둘 다 저장해 보내줘야함. useState 2개 사용
//    double 클릭시 이름을 바꿀 수 있게 되어 새 이름과 기존 이름을 보내 플리의 이름을 바꿈
    public void playListUpdatePlname(String oriplname, String newplname, int uno){
            String sql = "UPDATE playlist SET plname = ? WHERE plname = ? and uno = ?";
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,newplname);
            pstmt.setString(2, oriplname);
            pstmt.setInt(3, uno);
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
