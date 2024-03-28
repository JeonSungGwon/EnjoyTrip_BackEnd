package com.ssafy.project.enjoyTrip.model.service;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.Community;
import com.ssafy.project.enjoyTrip.model.dao.CommunityDao;
import com.ssafy.project.enjoyTrip.model.dao.CommunityDaoImpl;

public class CommunityServiceImpl implements CommunityService{
	private static CommunityService communityService;
	CommunityDao communityDao = CommunityDaoImpl.getCommunityDao();
	
	private CommunityServiceImpl() {}
	
	public static CommunityService getCommunityService() {
		if(communityService == null) communityService = new CommunityServiceImpl();
		return communityService;
	}
	

	@Override
	public int registCommunity(Community community) throws Exception{
		return communityDao.insertCommunity(community);
	}

	@Override
	public int editCommunity(Community community) throws Exception{
		return communityDao.updateCommunity(community);
	}

	@Override
	public int removeCommunity(int id) throws Exception{
		return communityDao.deleteCommunity(id);
	}

	@Override
	public Community getCommunityById(int id) throws Exception{
		return communityDao.getCommunityById(id);
	}

	@Override
	public List<Community> getAllCommunities() throws Exception{
		return communityDao.getAllCommunities();
	}

}
