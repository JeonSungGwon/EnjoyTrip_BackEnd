package com.ssafy.project.enjoyTrip.controller;

import java.io.IOException;
import java.util.List;

import com.ssafy.project.enjoyTrip.model.Member;
import com.ssafy.project.enjoyTrip.model.map.Sido;
import com.ssafy.project.enjoyTrip.model.map.service.SidoService;
import com.ssafy.project.enjoyTrip.model.map.service.SidoServiceImpl;
import com.ssafy.project.enjoyTrip.model.service.MemberService;
import com.ssafy.project.enjoyTrip.model.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	MemberService memberService = MemberServiceImpl.getMemberService();
	SidoService sidoService = SidoServiceImpl.getSidoService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		try {
			switch (action) {
			case "doLogin":
				doLogin(req, resp);
				break;
			case "doSignup":
				doSignup(req, resp);
				break;
			case "updateProfile":
				updateMember(req, resp);
				break;
			case "login":
				navigateToLoginPage(req, resp);
				break;
			case "signup":
				navigateToSignupPage(req, resp);
				break;
			case "mypage":
				navigateToMyPage(req, resp);
				break;
			case "home":
				navigateToHome(req, resp);
				break;
			case "community":
				navigateToCommunity(req, resp);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void navigateToCommunity(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("/community.jsp").forward(req, resp);
	}

	private void navigateToHome(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("/main.jsp").forward(req, resp);
	}

	private void navigateToMyPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("/mypage.jsp").forward(req, resp);		
	}

	private void navigateToLoginPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	private void navigateToSignupPage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.getRequestDispatcher("/signup.jsp").forward(req, resp);
	}

	private void updateMember(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		Member member = new Member();
		member.setProfileImage(req.getParameter("profileImage"));
		System.out.println(req.getParameter("memberNo") + ", " + req.getParameter("profileImage"));
		
		//memberService.updateProfile(memberNo, member);
	}

	private void doSignup(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Member member = new Member();
		member.setId(req.getParameter("id"));
		member.setPassword(req.getParameter("password"));
		member.setNickname(req.getParameter("nickName"));
//        member.setProfileImage(req.getParameter("profileImage"));
		memberService.signup(member);

		HttpSession session = req.getSession();
		session.setAttribute("isNotMember", false);
		resp.sendRedirect(req.getContextPath() + "/index.jsp");
	}

	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Member member = new Member();
		member.setId(req.getParameter("id"));
		member.setPassword(req.getParameter("password"));
		Member findMember = memberService.login(member);
		HttpSession session = req.getSession();
		if (findMember != null) {
			List<Sido> sidoList = sidoService.getSido();
			req.setAttribute("sidoList", sidoList);
			session.setAttribute("member", findMember);
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
			// resp.sendRedirect(req.getContextPath() + "/main.jsp");
		} else {
			req.setAttribute("isNotMember", true);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
	}
}