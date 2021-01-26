package com.flurken.webservices.bean;

public class Post {
    private Integer id;
    private String message;

    public Post(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
