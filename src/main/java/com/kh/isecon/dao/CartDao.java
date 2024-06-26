package com.kh.isecon.dao;

import com.kh.isecon.common.Common;
import com.kh.isecon.vo.CartVo;
import com.kh.isecon.vo.ProductVo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    public boolean cartInsert(int pno, int uno) { // 굿즈페이지에서 장바구니에 넣기
        boolean isTrue=false;
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "INSERT INTO CART (CNO, UNO, PNO) VALUES (CNO_SEQ.NEXTVAL ," + uno + "," + pno + ")";
            rs = stmt.executeQuery(query);

            if (rs.next()) isTrue= true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);

        return isTrue;
    }
    public boolean cartDelete(int cno) { // 장바구니 삭제
        boolean isTrue=false;
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "DELETE FROM CART WHERE CNO=" + cno;
            rs = stmt.executeQuery(query);

            if (rs.next()) isTrue= true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);

        return isTrue;
    }


    public List<ProductVo> cartSelect(int uno) { // 장바구니 보기
        List<ProductVo> list = new ArrayList<>();

        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM CART where uno ="+uno;
            rs = stmt.executeQuery(query);

            CartVo vo = new CartVo();

            while (rs.next()) {
                int cno = rs.getInt("CNO");
                int pno = rs.getInt("PNO");

                ProductDao dao = new ProductDao();

                ProductVo pvo = dao.productSelect(pno); // pno로 where문 돌려 나온 product 테이블의 값을 ProductVo 타입으로 리턴
                pvo.setPno(cno);

                list.add(pvo);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }
    public boolean saleDeleteCart(List<Integer> arrayCno, int uno) { // 결제 시 장바구니 삭제 > 결제내역 넘김
        boolean isTrue = false;
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            for (int i : arrayCno) {
                String query = "DELETE FROM CART " +
                        "WHERE CNO=" + i + " AND UNO = " + uno ;

                rs = stmt.executeQuery(query);

                if (rs.next()) isTrue= true;

            }
        } catch (Exception e) {
            e.printStackTrace();


        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);

        return isTrue;
    }


    public int cartReturnPno(int cno) { // 장바구니에서 pno 가져오기
        int pno = 0;

        try {
            conn = Common.getConnection();
            String query = "SELECT PNO FROM CART WHERE CNO = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, cno);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                pno = rs.getInt("PNO");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);

        return pno;
}
    public boolean cartInsertForProduct(int pno, int uno) { // 장바구니 넣기
        int ret = 0;
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "INSERT INTO CART (CNO, UNO, PNO) VALUES (CNO_SEQ.NEXTVAL," + uno + "," + pno + ")";
            ret = stmt.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Common.close(stmt);
        Common.close(conn);

        return ret>0;
    }
}

