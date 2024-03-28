package com.ssafy.project.enjoyTrip.model.service;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.Community;

public interface CommunityService {
	int registCommunity(Community community) throws Exception;
	int editCommunity(Community community) throws Exception;
	int removeCommunity(int id) throws Exception;
	Community getCommunityById(int id) throws Exception;
	List<Community> getAllCommunities() throws Exception;
}
