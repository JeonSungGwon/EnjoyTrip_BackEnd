package com.ssafy.project.enjoyTrip.model.service;

import com.ssafy.project.enjoyTrip.model.Member;

public interface MemberService {
	int signup(Member member) throws Exception;

	Member login(Member member) throws Exception;
		
	int updateProfile(int memberNo, Member member) throws Exception;
	
	int removeMember(int no) throws Exception;
}
