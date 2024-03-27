package com.ssafy.project.enjoyTrip.controller;

import java.io.IOException;

import com.ssafy.project.enjoyTrip.model.Favorite;
import com.ssafy.project.enjoyTrip.model.service.FavoriteService;
import com.ssafy.project.enjoyTrip.model.service.FavoriteServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/favorite")
public class FavoriteController extends HttpServlet{

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
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}


	private void removeFavorite(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String contentId = req.getParameter("contentId");
		favoriteService.removeFavorite(contentId);
		
	}


	private void addFavorite(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Favorite favorite = new Favorite();
		favorite.setMemberNo(Integer.parseInt(req.getParameter("memberNo")));
		favorite.setContentId(req.getParameter("contentId"));
		favorite.setAddr(req.getParameter("addr"));
		favorite.setTitle(req.getParameter("title"));
		favorite.setImage(req.getParameter("image"));
		favoriteService.registFavorite(favorite);
	}
	
	
}
