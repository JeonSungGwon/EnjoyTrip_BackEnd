package com.ssafy.project.enjoyTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.project.enjoyTrip.model.Member;
import com.ssafy.project.enjoyTrip.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao;

	private MemberDaoImpl() {
	}

	public static MemberDao getMemberDao() {
		if (memberDao == null)
			memberDao = new MemberDaoImpl();
		return memberDao;
	}

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
			pstmt.setString(++index, member.getNickname());
			return pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	@Override
	public Member selectMember(Member member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("from member ");
			sql.append("where id = ? and password = ? ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, member.getId());
			pstmt.setString(++index, member.getPassword());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Member(rs.getInt("no"), rs.getString("id"), rs.getString("password"),
						rs.getString("nickname"), rs.getString("profileImage"));
			}
			return null;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	@Override
	public int updateMember(int memberNo, Member member) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update member set nickname = ?, profileImage = ? where no = ? ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, member.getNickname());
			pstmt.setString(++index, member.getProfileImage());
			pstmt.setInt(++index, memberNo);
			return pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	@Override
	public int deleteMember(int no) throws Exception {
	    Connection con = null;
	    PreparedStatement pstmt1 = null;
	    PreparedStatement pstmt2 = null;
	    try {
	        con = DBUtil.getConnection();
	        // 첫 번째 쿼리: favorite 테이블에서 해당 회원 번호의 레코드 삭제
	        String sql1 = "DELETE FROM favorite WHERE member_no = ?";
	        pstmt1 = con.prepareStatement(sql1);
	        pstmt1.setInt(1, no);
	        pstmt1.executeUpdate();

	        // 두 번째 쿼리: member 테이블에서 해당 회원 번호의 레코드 삭제
	        String sql2 = "DELETE FROM member WHERE no = ?";
	        pstmt2 = con.prepareStatement(sql2);
	        pstmt2.setInt(1, no);
	        return pstmt2.executeUpdate();
	    } finally {
	        // 리소스 해제
	        DBUtil.close(con, pstmt1);
	        DBUtil.close(null, pstmt2); // pstmt2는 pstmt1이 완료된 후에 생성되므로 pstmt1이 null인지 확인할 필요가 없습니다.
	    }
	}



}
