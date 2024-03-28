package com.ssafy.project.enjoyTrip.model.service;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.Favorite;
import com.ssafy.project.enjoyTrip.model.dao.FavoriteDao;
import com.ssafy.project.enjoyTrip.model.dao.FavoriteDaoImpl;

public class FavoriteServiceImpl implements FavoriteService {

	private FavoriteDao favoriteDao = FavoriteDaoImpl.getFavoriteDao();
	private static FavoriteService favoriteService;

	public static FavoriteService getMemberService() {
		if (favoriteService == null)
			favoriteService = new FavoriteServiceImpl();
		return favoriteService;
	}

	@Override
	public int registFavorite(Favorite favorite) throws Exception {
		return favoriteDao.insertFavorite(favorite);
	}

	@Override
	public int removeFavorite(String contentId) throws Exception {
		return favoriteDao.deleteFavorite(contentId);
	}

	@Override
	public List<Favorite> getFavorites(int memberNo) throws Exception {
		return favoriteDao.selectFavorite(memberNo);
	}

}
