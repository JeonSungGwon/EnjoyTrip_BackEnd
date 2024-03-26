package com.ssafy.project.enjoyTrip.model.service;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.Favorite;

public interface FavoriteService {
	int registFavorite(Favorite favorite) throws Exception;
	int removeFavorite(String contentId) throws Exception;
	List<Favorite> getFavorites(Favorite favorite, int memberNo) throws Exception;
}
