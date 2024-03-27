package com.ssafy.project.enjoyTrip.model.map.service;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.Gugun;

public interface GugunService {

	List<Gugun> getGugun(int sidoCode) throws Exception;
}
