package com.kh.isecon.DAO;

import com.kh.isecon.COMMON.Common;
import com.kh.isecon.VO.CartVo;
import com.kh.isecon.VO.ProductVo;

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

    public void cartInsert(int pno, int uno) {

        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "INSERT INTO CART (CNO, UNO, PNO) VALUES (CNO_SEQ.NEXTVAL," + uno + pno + ")";
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);
    }

    public void cartDelete(int cno) {

        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "DELETE FROM CART WHERE CNO=" + cno;
            rs = stmt.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);
    }

    public List<ProductVo> CartSelect(int uno) {
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
    public void saleDeleteCart(List<Integer> arrayCno, int uno) {
        try {
            for (int i : arrayCno) {
                String query = "DELETE FROM CART" +
                        "WHERE = CNO" + i + " AND UNO = " + uno ;

                conn = Common.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);

                Common.close(rs);
                Common.close(stmt);
                Common.close(conn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int CartReturnPno(int cno) {
        int pno = 0;

        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT PNO FROM CART WHERE CNO = " + cno;
            rs = stmt.executeQuery(query);

            pno = rs.getInt("PNO");



        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);

        return pno;
}
}

