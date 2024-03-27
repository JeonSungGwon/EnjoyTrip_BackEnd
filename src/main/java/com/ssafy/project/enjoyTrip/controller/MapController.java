package com.ssafy.project.enjoyTrip.controller;

import java.io.IOException;
import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.AttractionInfo;
import com.ssafy.project.enjoyTrip.model.map.Gugun;
import com.ssafy.project.enjoyTrip.model.map.Sido;
import com.ssafy.project.enjoyTrip.model.map.service.AttractionInfoService;
import com.ssafy.project.enjoyTrip.model.map.service.AttractionInfoServiceImpl;
import com.ssafy.project.enjoyTrip.model.map.service.GugunService;
import com.ssafy.project.enjoyTrip.model.map.service.GugunServiceImpl;
import com.ssafy.project.enjoyTrip.model.map.service.SidoService;
import com.ssafy.project.enjoyTrip.model.map.service.SidoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/map")
public class MapController extends HttpServlet{
	AttractionInfoService attractionInfoService = AttractionInfoServiceImpl.getAttractionInfoService();
	GugunService gugunService = GugunServiceImpl.getGugunService();
	SidoService sidoService = SidoServiceImpl.getSidoService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		try {
			switch(action) {
			case "sido":
				getSido(req, resp);
				break;
			case "gugun":
				getGugun(req,resp);
				break;
			case "info":
				getInfo(req,resp);
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

	private void getInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int sidoCode = Integer.parseInt(req.getParameter("sidoCode"));
		int gugunCode = Integer.parseInt(req.getParameter("gugunCode"));
		List<AttractionInfo> infoList = attractionInfoService.getAttractionInfo(sidoCode, gugunCode);
		req.setAttribute("infoList", infoList);
	}

	private void getGugun(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int sidoCode = Integer.parseInt(req.getParameter("sidoCode"));
		List<Gugun> gugunList = gugunService.getGugun(sidoCode);
		req.setAttribute("gugunList", gugunList);
	}

	private void getSido(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		List<Sido> sidoList = sidoService.getSido();
		req.setAttribute("sidoList", sidoList);
	}
	
	
}
