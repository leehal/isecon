package com.kh.isecon.DAO;

import com.kh.isecon.COMMON.Common;
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



    public ProductVo inputSaleView() {
        // 결제 내역 내용 삽입
     try {

        // CartReturnPno
     }catch (Exception e){
         e.printStackTrace();
     }
     return ;
    }
}
