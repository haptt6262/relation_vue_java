package com.example.testround3.Service;

import com.example.testround3.Model.bo.Response;
import com.example.testround3.Model.bo.ResponseWithData;
import com.example.testround3.Model.in.PostIn;
import org.springframework.stereotype.Service;

@Service
public interface PostService{
    ResponseWithData getPostsWithPagination(Integer activePage, Integer limit);
    ResponseWithData getPosts();
    Response createNewPost(PostIn postIn);
    Response deletePost(Integer id);
    Response updatePost(Integer id, PostIn postIn);
}
