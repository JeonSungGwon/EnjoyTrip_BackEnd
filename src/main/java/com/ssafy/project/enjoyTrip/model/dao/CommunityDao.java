package com.ssafy.project.enjoyTrip.model.dao;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.Community;

public interface CommunityDao {
	int insertCommunity(Community community) throws Exception;
	int deleteCommunity(int id) throws Exception;
	int updateCommunity(Community community) throws Exception;
	Community getCommunityById(int id) throws Exception;
    List<Community> getAllCommunities() throws Exception;
}
