package com.kh.isecon.dao;

import com.kh.isecon.common.Common;
import com.kh.isecon.vo.UsersVo;
import com.kh.isecon.vo.WeatherVo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherDao {

    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public Boolean WeatherUpdate(WeatherVo vo) {
        boolean isTrue = false;
        // 방송 정보 수정
        try {
            String query = " UPDATE WEATHER SET WDATE = (TO_CHAR(SYSDATE, 'YYYY.MM.DD')), ONAIR = ? WHERE UNO = ?";
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, vo.getOnair());
            pstmt.setInt(2, vo.getUno());
            pstmt.executeUpdate();
            isTrue = true;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            Common.close(pstmt);
            Common.close(conn);
        }
        return isTrue;
    }

    public List<WeatherVo> weatherAll() {
        List<WeatherVo> list = new ArrayList<>();
        // 방송 정보 수정
        try {
            String query = " SELECT * FROM WEATHER";
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery(query);
        while (rs.next()){
            int wno = rs.getInt("WNO");
            int uno = rs.getInt("UNO");
            Date wdate = rs.getDate("WDATE");
            int onair = rs.getInt("ONAIR");
            WeatherVo weatherVo = new WeatherVo(wno,uno,wdate,onair);
            list.add(weatherVo);
        }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            Common.close(pstmt);
            Common.close(conn);
        }
        return list;
    }
}
