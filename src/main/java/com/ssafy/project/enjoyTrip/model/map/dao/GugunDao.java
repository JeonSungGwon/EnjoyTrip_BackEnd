package com.ssafy.project.enjoyTrip.model.map.dao;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.Gugun;


public interface GugunDao {
	List<Gugun> selectGugun(int sidoCode) throws Exception;
}
