package com.kh.isecon.DAO;

import com.kh.isecon.COMMON.Common;
import com.kh.isecon.VO.ProductVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductDao {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public ProductVo productDetail (int pno){ // 해당 굿즈의 상세 페이지를 보여주기
    ProductVo vo = new ProductVo();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELELTE * FROM PRODUCT WHERE PNO =" + pno;
            rs = stmt.executeQuery(query);

            pno = rs.getInt("PNO");
            String pname = rs.getString("PNAME");
            int price = rs.getInt("PRICE");
            String option = rs.getString("OPTIONS");
            String pimg = rs.getString("PIMG");

            vo = new ProductVo(pno, pname, price, option, pimg);

            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }
}