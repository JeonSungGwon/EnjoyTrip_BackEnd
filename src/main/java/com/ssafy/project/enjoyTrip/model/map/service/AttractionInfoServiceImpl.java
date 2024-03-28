package com.ssafy.project.enjoyTrip.model.map.service;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.AttractionInfo;
import com.ssafy.project.enjoyTrip.model.map.dao.AttractionInfoDao;
import com.ssafy.project.enjoyTrip.model.map.dao.AttractionInfoDaoImpl;

public class AttractionInfoServiceImpl implements AttractionInfoService{
	AttractionInfoDao attractionInfoDao = AttractionInfoDaoImpl.getAttractionInfoDao();
	private static AttractionInfoService attractionInfoService;
	
	private AttractionInfoServiceImpl() {
		super();
	}
	public static AttractionInfoService getAttractionInfoService() {
		if(attractionInfoService == null) attractionInfoService = new AttractionInfoServiceImpl();
		return attractionInfoService;
	}
	
	
	@Override
	public List<AttractionInfo> getAttractionInfo(int sidoCode, int gugunCode, String title) throws Exception {
		return attractionInfoDao.selectAttractionInfo(sidoCode, gugunCode, title);
	}

}
