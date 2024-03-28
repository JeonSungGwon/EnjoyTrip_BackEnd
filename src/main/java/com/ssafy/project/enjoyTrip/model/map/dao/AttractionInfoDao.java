package com.ssafy.project.enjoyTrip.model.map.dao;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.AttractionInfo;

public interface AttractionInfoDao {
	List<AttractionInfo> selectAttractionInfo(int sidoCode, int gugunCode, String title) throws Exception;

}
