package com.ssafy.project.enjoyTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.project.enjoyTrip.model.Favorite;
import com.ssafy.project.enjoyTrip.model.Member;
import com.ssafy.project.enjoyTrip.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int insertMember(Member member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into member (id, password, nickname) ");
			sql.append("values (?, ?, ?) ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, member.getId());
			pstmt.setString(++index, member.getPassword());
			pstmt.setString(++index, member.getProfileImage());
			return pstmt.executeUpdate();
		} finally {
			DBUtil.close(con,pstmt);
		}
	}

	@Override
	public Member selectMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
