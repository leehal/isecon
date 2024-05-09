package com.kh.isecon.DAO;

import com.kh.isecon.COMMON.Common;
import com.kh.isecon.VO.UsersVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsersDao {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    public UsersVo userInfo(int uno){
        UsersVo vo = new UsersVo();
        try {
            String query = "SELECT * FROM USERS WHERE UNO ="+uno;
            conn = Common.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            uno = rs.getInt("UNO");
            String id = rs.getString("ID");
            String phone = rs.getString("PHONE");
            String address = rs.getString("ADDRESS");
            char admin = rs.getString("ADMIN").charAt(1);
            String nickname = rs.getString("nickname");

            vo = new UsersVo(uno,id,phone,address,admin,nickname);

            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}
