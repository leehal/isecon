package com.kh.isecon.dao;

import com.kh.isecon.common.Common;
import com.kh.isecon.vo.UsersVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsersDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;


    public UsersVo userInfo(int uno){
        // 유저 정보 가져오기
        UsersVo vo = new UsersVo();
        try {
            String query = "SELECT * FROM USERS WHERE UNO ="+uno;
            conn = Common.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            if(rs.next()) {
                uno = rs.getInt("UNO");
                String id = rs.getString("ID");
                String pwd = rs.getString("PWD");
                String phone = rs.getString("PHONE");
                String address = rs.getString("ADDRESS");
                char admin = rs.getString("ADMIN").charAt(0);
                String nickname = rs.getString("NICKNAME");

                vo = new UsersVo(uno,id,pwd,phone,address,admin,nickname);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);

        return vo;
    }

    public Boolean UserUpDate(UsersVo vo) {
        // 유저 정보 수정
        try {
            String query = "UPDATE USERS SET PWD=?, PHONE=?, ADDRESS=?, NICKNAME=? WHERE uno=?";
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, vo.getPwd());
            pstmt.setString(2, vo.getPhone());
            pstmt.setString(3, vo.getAddress());
            pstmt.setString(4, vo.getNickname());
            pstmt.setInt(5, vo.getUno());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            Common.close(pstmt);
            Common.close(conn);
        }
    }

    public boolean UsersDelete(int uno) {
        // 유저 회원 탈퇴
        boolean isTrue = false;
        try {
            System.out.println("함수진입");
            String query = "DELETE FROM users WHERE uno = ?";
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, uno);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                isTrue = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            Common.close(pstmt);
            Common.close(conn);

        return isTrue;
    }
    public int LoginCheck(UsersVo vo){
        int uno=0;
        // 로그인
        try {
            String query = "SELECT * FROM USERS WHERE ID ='"+ vo.getId() +"' and pwd ='"+vo.getPwd()+"'";
            conn = Common.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            if(rs.next()) {
               uno= rs.getInt("uno");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);

        return uno;
   }
   public boolean UsersInsert(UsersVo vo){
        // 회원가입
       boolean isTrue = false;
        try {

            String query = "INSERT INTO USERS (UNO,ID,PWD,PHONE,ADDRESS,ADMIN,NICKNAME) VALUES(uno_seq.nextVal,?,?,?,?,0,?)";

            System.out.println("함수진입");
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPwd());
            pstmt.setString(3, vo.getPhone());
            pstmt.setString(4, vo.getAddress());
            pstmt.setString(5, vo.getNickname());
            int result = pstmt.executeUpdate();
            if (result==1){
                isTrue = true;
            }


        }catch (Exception e){
            e.printStackTrace();
        }
       Common.close(pstmt);
       Common.close(conn);
       return isTrue;
   }
   public boolean idSearch(String id, String name){
        // 비밀번호를 찾기 위한 아이디/이름 확인
        try {
            String query = "SELECT * FROM USERS WHERE ID ='"+id+"'and name='"+name+"'";
            conn = Common.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            if(rs.next()){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

       Common.close(rs);
       Common.close(stmt);
       Common.close(conn);

        return false;
   }

   public void changePwd(UsersVo vo){
        // 비밀번호 재설정
       try {
           String query = "UPDATE USERS SET (PWD)='"+vo.getPwd()+"'where uno="+vo.getUno();
           conn = Common.getConnection();
           stmt = conn.createStatement();
           rs = stmt.executeQuery(query);

       }catch (Exception e) {
           e.printStackTrace();
       }
       Common.close(rs);
       Common.close(stmt);
       Common.close(conn);
   }
}
