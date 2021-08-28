package com.swipejobs.controller;

import com.swipejobs.BlogAdminApplication;
import com.swipejobs.domain.Post;
import com.swipejobs.domain.UserPost;
import com.swipejobs.service.BlogAdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BlogAdminController.class)
public class BlogAdminControllerTest {

    @MockBean
    private BlogAdminService blogAdminService;

    @Autowired
    private MockMvc mockMvc;

  @Test
  public void testGetUserPosts_Success() throws Exception {

      List<UserPost> userPosts = new ArrayList<>();

      List<Post> postList = new ArrayList<>();

      Post post1 = new Post();
      post1.setId(1);
      post1.setUserId(1);
      post1.setTitle("controller test");
      post1.setBody("controller test is passed");

      Post post2 = new Post();
      post2.setId(2);
      post2.setUserId(1);
      post2.setTitle("controller test 2");
      post2.setBody("controller test 2 is passed");

      postList.add(post1);
      postList.add(post2);

      UserPost userPost = new UserPost(1,postList );
      userPosts.add(userPost);


      when(blogAdminService.getUserPosts()).thenReturn(userPosts);

      mockMvc.perform(get("/userPosts"))
              .andExpect(status().isOk())
              .andExpect(jsonPath("$", hasSize(1)));

  }

}
