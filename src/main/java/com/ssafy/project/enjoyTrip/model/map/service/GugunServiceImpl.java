package com.ssafy.project.enjoyTrip.model.map.service;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.Gugun;
import com.ssafy.project.enjoyTrip.model.map.dao.GugunDao;
import com.ssafy.project.enjoyTrip.model.map.dao.GugunDaoImpl;

public class GugunServiceImpl implements GugunService {

	GugunDao gugunDao = GugunDaoImpl.getGugunDao();

	private static GugunService gugunService;

	private GugunServiceImpl() {
		super();
	}

	public static GugunService getGugunService() {
		if (gugunService == null)
			gugunService = new GugunServiceImpl();
		return gugunService;
	}

	@Override
	public List<Gugun> getGugun(int sidoCode) throws Exception {
		return gugunDao.selectGugun(sidoCode);
	}

}
