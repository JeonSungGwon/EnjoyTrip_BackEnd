package com.ssafy.project.enjoyTrip.model.dao;

import com.ssafy.project.enjoyTrip.model.Member;

public interface MemberDao {
	int insertMember(Member member) throws Exception;

	Member selectMember(Member member) throws Exception;

	int updateMember(int memberNo, Member member) throws Exception;
}
