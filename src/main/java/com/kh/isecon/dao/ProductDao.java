package com.kh.isecon.dao;

import com.kh.isecon.common.Common;
import com.kh.isecon.vo.ProductVo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public List<ProductVo> productSelectList() { // 굿즈 페이지 상품 전체 보여주기
        List<ProductVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM PRODUCT";
            rs = stmt.executeQuery(query);

            while(rs.next()) {
                int pno = rs.getInt("PNO");
                String pname = rs.getString("PNAME");
                int price = rs.getInt("PRICE");
                String option = rs.getString("OPN");
                String pimg = rs.getString("PIMG");
                String pdimg = rs.getString("PDIMG");

                ProductVo vo = new ProductVo(pno, pname, price, option, pimg, pdimg);
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

    public List<ProductVo> productdetail(String pname){ // 해당 굿즈의 상세 페이지를 보여주기
    List<ProductVo> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM PRODUCT WHERE PNAME =" +"'"+ pname+"'";
            rs = stmt.executeQuery(query);

            while(rs.next()) {
                int pno = rs.getInt("PNO");
                pname = rs.getString("PNAME");
                int price = rs.getInt("PRICE");
                String option = rs.getString("OPN");
                String pimg = rs.getString("PIMG");
                String pdimg = rs.getString("PDIMG");

                ProductVo vo = new ProductVo(pno, pname, price, option, pimg, pdimg);
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
    public ProductVo productSelect(int pno){ // 장바구니에 상품(Product) 항목 간략하게 보여주기
        ProductVo vo = new ProductVo();
        try{
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM PRODUCT WHERE PNO =" + pno;
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                pno = rs.getInt("PNO");
                String pname = rs.getString("PNAME");
                int price = rs.getInt("PRICE");
                String option = rs.getString("OPN");
                String pimg = rs.getString("PIMG");
                String pdimg = rs.getString("PDIMG");

                vo = new ProductVo(pno, pname,price, option, pimg, pdimg);

            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

}