package com.kh.isecon.dao;

import com.kh.isecon.common.Common;
import com.kh.isecon.vo.CartVo;
import com.kh.isecon.vo.ProductVo;
import com.kh.isecon.vo.SaleVo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SaleDao {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public List<ProductVo> saleView(int uno) {
        List<ProductVo> list = new ArrayList<>();
        // 유저 결제 내역 조회

        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM SALE WHERE UNO ="+uno;
            rs = stmt.executeQuery(query);


            while (rs.next()) {
                int sno = rs.getInt("SNO");
                int pno = rs.getInt("PNO");

                ProductDao dao = new ProductDao();

                ProductVo pvo = dao.productSelect(pno);
                pvo.setPno(sno);

                list.add(pvo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);

        return list;
    }



    public boolean inputSaleView(List<Integer> arrayPno, int uno) {
        // 결제 내역 내용 삽입
        boolean isTrue = false;
     try {
         for (int i : arrayPno) {
             String query = "INSERT INTO SALE (SNO, UNO, PNO) VALUES (SNO_SEQ.NEXTVAL," + uno + "," + i + ")";

             conn = Common.getConnection();
             stmt = conn.createStatement();
             rs = stmt.executeQuery(query);

             if (rs.next()) isTrue = true;
         }

     }catch (Exception e){
         e.printStackTrace();
     }
        Common.close(rs);
        Common.close(stmt);
        Common.close(conn);

        return isTrue;
    }
    public boolean productInsertSale(int pno, int uno) { // 상품 상세페이지 바로 구매
        int ret = 0;
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "INSERT INTO SALE (SNO, UNO, PNO) VALUES (SNO_SEQ.NEXTVAL," + uno + "," + pno + ")";
            ret = stmt.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Common.close(stmt);
        Common.close(conn);

        return ret>0;
    }
}
