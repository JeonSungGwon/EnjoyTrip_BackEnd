package com.ssafy.project.enjoyTrip.model;

public class Favorite {
	private int no;
	private int memberNo;
	private String contentId;
	private String addr;
	private String title;
	private String image;
	
	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Favorite(int no, int memberNo, String contentId, String addr, String title, String image) {
		this.no = no;
		this.memberNo = memberNo;
		this.contentId = contentId;
		this.addr = addr;
		this.title = title;
		this.image = image;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Favorite [no=" + no + ", memberNo=" + memberNo + ", contentId=" + contentId + ", addr=" + addr
				+ ", title=" + title + ", image=" + image + "]";
	}
	
}
