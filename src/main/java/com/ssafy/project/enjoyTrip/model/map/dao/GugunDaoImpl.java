package com.ssafy.project.enjoyTrip.model.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.Gugun;
import com.ssafy.project.enjoyTrip.util.DBUtil;

public class GugunDaoImpl implements GugunDao{

	private static GugunDao gugunDao;

	public GugunDaoImpl() {
		super();
	}
	public static GugunDao getGugunDao() {
		if(gugunDao == null) gugunDao = new GugunDaoImpl();
		return gugunDao;
	}

	@Override
	public List<Gugun> selectGugun(int sidoCode) throws Exception {
		Connection con = null;
        PreparedStatement pstmt = null;
        List<Gugun> list = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select * ");
            sql.append("from gugun ");
            sql.append("where sido_code = ? ");
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setInt(1, sidoCode);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                list.add(new Gugun(rs.getInt("gugun_code"),rs.getString("gugun_name"), rs.getInt("sido_code")));
            }
            return list;
        } finally {
            DBUtil.close(con,pstmt);
        }
	}

}
