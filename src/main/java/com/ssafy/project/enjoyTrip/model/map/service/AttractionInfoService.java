package com.ssafy.project.enjoyTrip.model.map.service;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.AttractionInfo;

public interface AttractionInfoService {
	List<AttractionInfo> getAttractionInfo(int sidoCode, int gugunCode) throws Exception;
}
