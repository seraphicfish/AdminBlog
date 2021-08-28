package com.swipejobs.service;

import com.swipejobs.domain.Post;
import com.swipejobs.domain.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//This class is used to retrieve the users and posts.

@Service
@Log4j2
public class BlogAdminClientService {

    @Autowired
    private RestTemplate restTemplate;

    //Get all the users

    /**
     * get the user list
     * @return user list
     */
    public List<User> getUsers(){

        List<User> userList = new ArrayList<>();

        log.info("Retrieve the users");
        ResponseEntity<User[]> responseEntity =
                restTemplate.exchange("https://jsonplaceholder.typicode.com/users", HttpMethod.GET, null, User[].class);

        User[] userArray = responseEntity.getBody();

        for(int i= 0; i<userArray.length; i++){

            userList.add(userArray[i]);

        }

        return userList;

    }

    /**
     * get the post list
     * @return Post list
     */
    public List<Post> getPosts(){

        List<Post> postList = new ArrayList<>();

        log.info("Retrieve the posts");

        ResponseEntity<Post[]> responseEntity =
                restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, null, Post[].class);

        Post[] postArray = responseEntity.getBody();

        for(int i= 0; i<postArray.length; i++){

            postList.add(postArray[i]);

        }

        return postList;

    }
}
