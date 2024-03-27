package com.ssafy.project.enjoyTrip.controller;

import java.io.IOException;

import com.ssafy.project.enjoyTrip.model.Member;
import com.ssafy.project.enjoyTrip.model.service.MemberService;
import com.ssafy.project.enjoyTrip.model.service.MemberServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/member")
public class MemberController extends HttpServlet{
    MemberService memberService = MemberServiceImpl.getMemberService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            switch(action){
            case "login":
                login(req,resp);
                break;
            case "signup":
                signup(req,resp);
                break;
            case "signupForm":
                signupForm(req,resp);
                break;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void signupForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        req.getRequestDispatcher("/signup.jsp").forward(req, resp);
    }

    private void signup(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Member member = new Member();
        member.setId(req.getParameter("id"));
        member.setPassword(req.getParameter("password"));
        member.setNickname(req.getParameter("nickName"));
//        member.setProfileImage(req.getParameter("profileImage"));
        memberService.signup(member);
        resp.sendRedirect(req.getContextPath() + "/signpage.jsp");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Member member = new Member();
        member.setId(req.getParameter("id"));
        member.setPassword(req.getParameter("password"));
        Member findMember = memberService.login(member);
        if(findMember != null) {
            HttpSession session = req.getSession();
            session.setAttribute("member", findMember);
            resp.sendRedirect(req.getContextPath() + "/mainpage.jsp");
        }
        
    }
    
    
}