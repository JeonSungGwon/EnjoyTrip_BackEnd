package com.ssafy.project.enjoyTrip.controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import com.ssafy.project.enjoyTrip.model.Favorite;
import com.ssafy.project.enjoyTrip.model.service.FavoriteService;
import com.ssafy.project.enjoyTrip.model.service.FavoriteServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/favorite")
public class FavoriteController extends HttpServlet {

	FavoriteService favoriteService = FavoriteServiceImpl.getMemberService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		try {
			switch (action) {
			case "add":
				addFavorite(req, resp);
				break;
			case "remove":
				removeFavorite(req, resp);
				break;
			case "list":
				getFavorites(req, resp);
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getFavorites(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		List<Favorite> list = favoriteService.getFavorites(memberNo);
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("list", list);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(jsonResponse.toString());
		System.out.println("aslkdjaskldsajdljsalkdjsadkldjdljakdjsdjsaldkajdlkajsdkljkalsdjlaskjasdklasdjlk");
	}

	private void removeFavorite(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String contentId = req.getParameter("contentId");
		boolean success = favoriteService.removeFavorite(contentId) >= 1 ? true : false;
		
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", success);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(jsonResponse.toString());
	}

	private void addFavorite(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Favorite favorite = new Favorite();
		favorite.setMemberNo(Integer.parseInt(req.getParameter("memberNo")));
		favorite.setContentId(req.getParameter("contentId"));
		favorite.setAddr(req.getParameter("addr"));
		favorite.setTitle(req.getParameter("title"));
		favorite.setImage(req.getParameter("image"));
		boolean success = favoriteService.registFavorite(favorite) >= 1 ? true : false;

		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("success", success);
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(jsonResponse.toString());
	}
}