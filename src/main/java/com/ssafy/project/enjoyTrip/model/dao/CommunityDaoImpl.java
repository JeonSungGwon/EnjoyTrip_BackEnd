package com.ssafy.project.enjoyTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.project.enjoyTrip.model.Community;
import com.ssafy.project.enjoyTrip.model.Favorite;
import com.ssafy.project.enjoyTrip.util.DBUtil;

public class CommunityDaoImpl implements CommunityDao {
	private static CommunityDao communityDao;

	private CommunityDaoImpl() {
	}

	public static CommunityDao getCommunityDao() {
		if (communityDao == null)
			communityDao = new CommunityDaoImpl();
		return communityDao;
	}

	@Override
	public int insertCommunity(Community community) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into community(title, addr, author, image, content) ");
			sql.append("values (?, ?, ?, ?, ?) ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, community.getTitle());
			pstmt.setString(++index, community.getAddr());
			pstmt.setString(++index, community.getAuthor());
			pstmt.setString(++index, community.getImage());
			pstmt.setString(++index, community.getContent());

			return pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	@Override
	public int deleteCommunity(int id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from community ");
			sql.append("where id = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	@Override
	public int updateCommunity(Community community) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update community ");
			sql.append("set title = ?, image = ?, content = ? ");
			sql.append("where id = ? ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, community.getTitle());
			pstmt.setString(++index, community.getImage());
			pstmt.setString(++index, community.getContent());
			pstmt.setInt(++index, community.getId());
			return pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	@Override
	public Community getCommunityById(int id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("from community ");
			sql.append("where id = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(id, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Community(rs.getString("title"), rs.getString("addr"), rs.getString("author"),
						rs.getString("image"), rs.getString("content"));
			}
			return null;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	@Override
	public List<Community> getAllCommunities() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<Community> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("from community ");
			pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Community(rs.getString("title"), rs.getString("addr"), rs.getString("author"),
						rs.getString("image"), rs.getString("content")));
			}
			return list;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

}
