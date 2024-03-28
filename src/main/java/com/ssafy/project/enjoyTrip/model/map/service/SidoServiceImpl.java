package com.ssafy.project.enjoyTrip.model.map.service;

import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.Sido;
import com.ssafy.project.enjoyTrip.model.map.dao.SidoDao;
import com.ssafy.project.enjoyTrip.model.map.dao.SidoDaoImpl;

public class SidoServiceImpl implements SidoService {
	SidoDao sidoDao = SidoDaoImpl.getsidoDao();

	private static SidoService sidoService;

	private SidoServiceImpl() {
		super();
	}

	public static SidoService getSidoService() {
		if (sidoService == null)
			sidoService = new SidoServiceImpl();
		return sidoService;
	}

	@Override
	public List<Sido> getSido() throws Exception {
		return sidoDao.selectSido();
	}

}
