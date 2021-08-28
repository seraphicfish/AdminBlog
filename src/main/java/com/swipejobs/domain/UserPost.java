package com.swipejobs.domain;

import java.io.Serializable;
import java.util.List;

public class UserPost implements Serializable {

    private Integer userId;
    private List<Post> posts;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public UserPost(Integer userId, List<Post> posts){

        this.userId = userId;
        this.posts = posts;
    }
}
