package com.kh.isecon.DAO;

import com.kh.isecon.COMMON.Common;
import com.kh.isecon.VO.CartVo;
import com.kh.isecon.VO.ProductVo;
import com.kh.isecon.VO.SaleVo;
import com.kh.isecon.VO.UsersVo;

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
            String query = "SELECT * FROM SALE WHERE UNO"+uno;
            conn = Common.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int sno = rs.getInt("SNO");
                int pno = rs.getInt("PNO");

                ProductDao dao = new ProductDao();
                ProductVo pvo = dao.productSelect(pno);
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
}
