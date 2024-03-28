package com.ssafy.project.enjoyTrip.model.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.Sido;
import com.ssafy.project.enjoyTrip.util.DBUtil;

public class SidoDaoImpl implements SidoDao {
	private static SidoDao sidoDao;

	public SidoDaoImpl() {
		super();
	}

	public static SidoDao getsidoDao() {
		if (sidoDao == null)
			sidoDao = new SidoDaoImpl();
		return sidoDao;
	}

	@Override
	public List<Sido> selectSido() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<Sido> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("from sido ");
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Sido(rs.getInt("sido_code"), rs.getString("sido_name")));
			}
			return list;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

}
