package com.kh.isecon.DAO;

import com.kh.isecon.COMMON.Common;
import com.kh.isecon.VO.MusicVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MusicDao {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public List<MusicVo> musicSelectAll(){
        List<MusicVo> list = new ArrayList<>();
        try{
            conn = Common.getConnection();
            stmt = conn.createStatement();
            String query = "SELECT * FROM Music";
            rs= stmt.executeQuery(query);

            while (rs.next()){
                int mno = rs.getInt("mno");
                String mname = rs.getString("mname");
                String singer = rs.getString("singer");
                String surl = rs.getString("surl");

                MusicVo vo = new MusicVo(mno,mname,singer,surl);
                list.add(vo);
            }
            Common.close(rs);
            Common.close(stmt);
            Common.close(conn);

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
