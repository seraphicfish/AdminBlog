package com.swipejobs.service;

import com.swipejobs.domain.Post;
import com.swipejobs.domain.User;
import com.swipejobs.domain.UserPost;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// get the user and that user's posts
@Service
@Log4j2
public class BlogAdminService {

    @Autowired
    private BlogAdminClientService blogAdminClientService;

    public List<UserPost> getUserPosts() throws Exception {

        List<UserPost> userPosts =new ArrayList<>();
        List<User> userList = new ArrayList<>();
        List<Post> postList = new ArrayList<>();

        try{

            log.info("Get the data from get users endpoint");

            userList = blogAdminClientService.getUsers();

        }catch (Exception e){

            throw new Exception("Can't get the users");
        }

        if( userList == null || userList.isEmpty()){

            return null;
        }

        try {

            log.info("Get the data from get posts endpoint");

            postList = blogAdminClientService.getPosts();

        } catch (Exception e){

            throw new Exception("Can't get the posts");
        }

        for(User user: userList){

            List<Post> userPostList = new ArrayList<>();

            if(postList!=null && !postList.isEmpty()) {

                for (Post post : postList) {

                    if ((post.getUserId()).equals(user.getId())) {

                        userPostList.add(post);
                    }
                }
            }
            UserPost userPost = new UserPost(user.getId(), userPostList);

           log.info(userPost.toString());

            userPosts.add(userPost);
        }

        return userPosts;
    }
}
