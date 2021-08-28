package com.swipejobs.controller;

import com.swipejobs.domain.UserPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.swipejobs.service.BlogAdminService;

import java.util.List;

@RestController
public class BlogAdminController {

    @Autowired
    private BlogAdminService blogAdminService;

    @GetMapping("/userPosts")
    public ResponseEntity<List<UserPost>> getUserPosts() throws Exception {

        List<UserPost> userPosts = blogAdminService.getUserPosts();

        return new ResponseEntity<List<UserPost>>(userPosts, HttpStatus.OK);
    }
}
