package com.ssafy.project.enjoyTrip.model;

public class Community {
    private int id;
    private String title;
    private String addr;
    private String author;
    private String image;
    private String content;

    // 생성자
    public Community() {
    }

    public Community(String title, String addr, String author, String image, String content) {
        this.title = title;
        this.addr = addr;
        this.author = author;
        this.image = image;
        this.content = content;
    }

    // Getter 및 Setter 메서드
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public String getAddr() {
    	return addr;
    }
    
    public void setAddr(String addr) {
    	this.addr = addr;
    }

    // toString 메서드 (디버깅 및 테스트용)
    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", addr='" + addr + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

