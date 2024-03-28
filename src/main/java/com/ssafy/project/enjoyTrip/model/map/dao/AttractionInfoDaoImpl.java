package com.ssafy.project.enjoyTrip.model.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.project.enjoyTrip.model.map.AttractionInfo;
import com.ssafy.project.enjoyTrip.util.DBUtil;

public class AttractionInfoDaoImpl implements AttractionInfoDao {

	private static AttractionInfoDao attractionImfoDao;

	public AttractionInfoDaoImpl() {
		super();
	}
	public static AttractionInfoDao getAttractionInfoDao() {
		if(attractionImfoDao == null) attractionImfoDao = new AttractionInfoDaoImpl();
		return attractionImfoDao;
	}
	
	
	@Override
	public List<AttractionInfo> selectAttractionInfo(int sidoCode1, int gugunCode1, String title1) throws Exception {
		Connection con = null;
        PreparedStatement pstmt = null;
        List<AttractionInfo> list = new ArrayList<>();
        try {
            con = DBUtil.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select * ");
            sql.append("from attraction_info ");
            sql.append("WHERE sido_code = ? AND gugun_code = ? AND title LIKE ?;");
            pstmt = con.prepareStatement(sql.toString());
            pstmt.setInt(1, sidoCode1);
            pstmt.setInt(2, gugunCode1);
            pstmt.setString(3, "%" + title1 + "%");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	int contentId = rs.getInt("content_id");
                int contentTypeId = rs.getInt("content_type_id");
                String title = rs.getString("title");
                String addr1 = rs.getString("addr1");
                String addr2 = rs.getString("addr2");
                String zipcode = rs.getString("zipcode");
                String tel = rs.getString("tel");
                String firstImage = rs.getString("first_image");
                String firstImage2 = rs.getString("first_image2");
                int readcount = rs.getInt("readcount");
                int sidoCode = rs.getInt("sido_code");
                int gugunCode = rs.getInt("gugun_code");
                double latitude = rs.getDouble("latitude");
                double longitude = rs.getDouble("longitude");
                String mlevel = rs.getString("mlevel");
                
                // AttractionInfo 객체 생성 후 리스트에 추가
                AttractionInfo attractionInfo = new AttractionInfo(contentId, contentTypeId, title, addr1, addr2,
                        zipcode, tel, firstImage, firstImage2, readcount, sidoCode, gugunCode, latitude, longitude, mlevel);
                list.add(attractionInfo);
            }
            return list;
        } finally {
            DBUtil.close(con,pstmt);
        }
	}

}
