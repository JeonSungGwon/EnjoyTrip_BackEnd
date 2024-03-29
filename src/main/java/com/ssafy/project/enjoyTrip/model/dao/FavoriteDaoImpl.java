package com.ssafy.project.enjoyTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.project.enjoyTrip.model.Favorite;
import com.ssafy.project.enjoyTrip.util.DBUtil;

public class FavoriteDaoImpl implements FavoriteDao {
	private static FavoriteDao favoriteDao;

	private FavoriteDaoImpl() {
	}

	public static FavoriteDao getFavoriteDao() {
		if (favoriteDao == null)
			favoriteDao = new FavoriteDaoImpl();
		return favoriteDao;
	}

	@Override
	public int insertFavorite(Favorite favorite) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into favorite(member_no, contentId, addr, title, image) ");
			sql.append("values (?, ?, ?, ?, ?) ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index, favorite.getMemberNo());
			pstmt.setString(++index, favorite.getContentId());
			pstmt.setString(++index, favorite.getAddr());
			pstmt.setString(++index, favorite.getTitle());
			pstmt.setString(++index, favorite.getImage());
			return pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	@Override
	public int deleteFavorite(String contentId) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from favorite ");
			sql.append("where contentId = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, contentId);
			return pstmt.executeUpdate();
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	@Override
	public List<Favorite> selectFavorite(int memberNo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		List<Favorite> list = new ArrayList<>();
		try {
			con = DBUtil.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * ");
			sql.append("from favorite ");
			sql.append("where member_no = ? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, memberNo);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new Favorite(rs.getInt("no"), rs.getInt("member_no"), rs.getString("contentId"),
						rs.getString("addr"), rs.getString("title"), rs.getString("image")));
			}
			return list;
		} finally {
			DBUtil.close(con, pstmt);
		}
	}

	@Override
	public Favorite selectFavoriteBycontendId(String contentId) throws Exception {
		return null;
	}

}
