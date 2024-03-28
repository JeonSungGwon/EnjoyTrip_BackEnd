package com.ssafy.project.enjoyTrip.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import com.ssafy.project.enjoyTrip.model.Community;
import com.ssafy.project.enjoyTrip.model.Favorite;
import com.ssafy.project.enjoyTrip.model.service.CommunityService;
import com.ssafy.project.enjoyTrip.model.service.CommunityServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/community")
public class CommunityController extends HttpServlet{
	CommunityService communityService = CommunityServiceImpl.getCommunityService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		try {
			switch(action) {
			case "list":
				getAllCommunities(req, resp);
				break;
			case "edit":
				editCommunity(req, resp);
				break;
			case "remove":
				removeCommunity(req, resp);
				break;
			case "detail":
				getCommunityById(req, resp);
				break;
			case "regist":
				registCommunity(req,resp);
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void getCommunityById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int id = Integer.parseInt(req.getParameter("id"));
		Community community = communityService.getCommunityById(id);
		
		JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("community", community);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse.toString());
	}

	private void registCommunity(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Community community = new Community();
		community.setTitle(req.getParameter("title"));
		community.setAuthor(req.getParameter("author"));
		community.setImage(req.getParameter("image"));
		community.setContent(req.getParameter("content"));
		boolean success = communityService.registCommunity(community) >= 1 ? true : false;
		
		JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("success", success);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse.toString());
	}

	private void removeCommunity(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		int id = Integer.parseInt(req.getParameter("id"));
		boolean success = communityService.removeCommunity(id) >= 1 ? true : false;
        
		JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("success", success);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse.toString());
	}

	private void editCommunity(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		Community community = new Community();
		community.setTitle(req.getParameter("title"));
		community.setAuthor(req.getParameter("author"));
		community.setImage(req.getParameter("image"));
		community.setContent(req.getParameter("content"));
		communityService.editCommunity(community);
	}

	private void getAllCommunities(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		List<Community> list = communityService.getAllCommunities();
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("list", list);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse.toString());
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/~").forward(req, resp);
	}
	
}
