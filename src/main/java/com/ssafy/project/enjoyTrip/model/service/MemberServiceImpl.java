package com.ssafy.project.enjoyTrip.model.service;

import com.ssafy.project.enjoyTrip.model.Member;
import com.ssafy.project.enjoyTrip.model.dao.MemberDao;
import com.ssafy.project.enjoyTrip.model.dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao = MemberDaoImpl.getMemberDao();

	private static MemberService memberService;

	public static MemberService getMemberService() {
		if (memberService == null)
			memberService = new MemberServiceImpl();
		return memberService;
	}

	@Override
	public int signup(Member member) throws Exception {
		return memberDao.insertMember(member);
	}

	@Override
	public Member login(Member member) throws Exception {
		return memberDao.selectMember(member);
	}

	@Override
	public int updateProfile(int memberNo, Member member) throws Exception {
		return memberDao.updateMember(memberNo, member);
	}

	@Override
	public int removeMember(int no) throws Exception {
		return memberDao.deleteMember(no);
	}

}
