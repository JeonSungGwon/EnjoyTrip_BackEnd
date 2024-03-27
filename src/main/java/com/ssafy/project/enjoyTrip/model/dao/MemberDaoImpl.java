package com.ssafy.project.enjoyTrip.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssafy.project.enjoyTrip.model.Member;
import com.ssafy.project.enjoyTrip.util.DBUtil;

public class MemberDaoImpl implements MemberDao {

	private static MemberDao memberDao;
	
    private MemberDaoImpl() {}
    public static MemberDao getMemberDao() {
    	if(memberDao == null) memberDao = new MemberDaoImpl(); 
    	return memberDao;
    }

	@Override
    public int insertMember(Member member) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DBUtil.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("insert into member (id, password, nickname) ");
            sql.append("values (?, ?, ?) ");
            pstmt = con.prepareStatement(sql.toString());
            int index = 0;
            pstmt.setString(++index, member.getId());
            pstmt.setString(++index, member.getPassword());
            pstmt.setString(++index, member.getNickname());
            return pstmt.executeUpdate();
        } finally {
            DBUtil.close(con,pstmt);
        }
    }

    @Override
    public Member selectMember(Member member) throws Exception{
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DBUtil.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select * ");
            sql.append("from member ");
            sql.append("where id = ? and password = ? ");
            pstmt = con.prepareStatement(sql.toString());
            int index = 0;
            pstmt.setString(++index, member.getId());
            pstmt.setString(++index, member.getPassword());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new Member(rs.getInt("no"), rs.getString("id"), rs.getString("password"), rs.getString("nickname"), rs.getString("profileImage"));
            }
            return null;
        } finally {
            DBUtil.close(con,pstmt);
        }
    }

    @Override
    public int updateMember(Member member) {
        // TODO Auto-generated method stub
        return 0;
    }

}
