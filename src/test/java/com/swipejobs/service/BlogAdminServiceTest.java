package com.swipejobs.service;

import com.swipejobs.BlogAdminApplication;
import com.swipejobs.domain.Post;
import com.swipejobs.domain.User;
import com.swipejobs.domain.UserPost;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BlogAdminApplication.class)
@Log4j2
public class BlogAdminServiceTest {

    @MockBean
    BlogAdminClientService blogAdminClientService;

    @Autowired
    BlogAdminService blogAdminService;

    @Test
    public void getposts_successfully() throws Exception {

        when(blogAdminClientService.getUsers()).thenReturn(createUserList());
        when(blogAdminClientService.getPosts()).thenReturn(createPostList());

        List<UserPost> userPostList = new ArrayList<>();
        userPostList = blogAdminService.getUserPosts();
        String title = userPostList.get(0).getPosts().get(0).getTitle();
        assertTrue(userPostList.size()==2);
        assertTrue(title.equals("post for user1"));
    }


    public List<User> createUserList(){

        List<User> userList = new ArrayList<>();
        User user1 = new User();

        user1.setId(1);
        user1.setName("test1");
        user1.setUsername("testUser1");

        User user2 = new User();
        user2.setId(2);
        user2.setName("test2");
        user2.setUsername("testUser2");

        userList.add(user1);
        userList.add(user2);

        return userList;
    }

    public List<Post> createPostList(){


        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();

        post1.setId(1);
        post1.setUserId(1);
        post1.setTitle("post for user1");
        post1.setBody("testing for user1");

        postList.add(post1);

        return postList;
    }
}
