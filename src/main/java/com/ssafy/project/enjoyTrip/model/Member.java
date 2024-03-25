package com.ssafy.project.enjoyTrip.model;

public class Member {
	private int no;
	private String id;
	private String password;
	private String nickname;
	private String profileImage;
	
	public Member() {}
	
	public Member(int no, String id, String password, String nickname, String profileImage) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.profileImage = profileImage;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", password=" + password + ", nickname=" + nickname
				+ ", profileImage=" + profileImage + "]";
	}
	
	
	
	
	
}
