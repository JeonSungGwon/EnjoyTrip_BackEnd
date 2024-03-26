package com.ssafy.project.enjoyTrip.model.dao;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.Favorite;

public interface FavoriteDao {
    public int insertFavorite(Favorite favorite) throws Exception;
    public int deleteFavorite(String contentId) throws Exception;
    public List<Favorite> selectFavorite(Favorite favorite, int memberNo) throws Exception;
    public Favorite selectFavoriteBycontendId(String contentId) throws Exception;
}
