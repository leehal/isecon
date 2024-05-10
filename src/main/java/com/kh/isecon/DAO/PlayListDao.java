package com.kh.isecon.DAO;

import com.kh.isecon.COMMON.Common;
import com.kh.isecon.VO.MusicVo;
import com.kh.isecon.VO.PlayListVo;

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

    public List<String> usersPlayListNameSelect(int uno) {
        List<String> list = new ArrayList<>();
        try {
            String sql = "select DISTINCT plnmme from PLAYLIST where uno =" + uno;
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String plname = rs.getString("plname");
                list.add(plname);
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
                "(plno, uno, mno. planme)" +
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
//    public void playListUpdatePlname()
}
