package com.example.testround3.Service.Impl;

import com.example.testround3.Mapper.PostMapper;
import com.example.testround3.Model.bo.Response;
import com.example.testround3.Model.bo.ResponseWithData;
import com.example.testround3.Model.dto.PostDto;
import com.example.testround3.Model.entity.Post;
import com.example.testround3.Model.in.PostIn;
import com.example.testround3.Repository.PostRepository;
import com.example.testround3.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class PostImplement implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public ResponseWithData getPostsWithPagination(Integer activePage, Integer limit) {
        Pageable pageable = PageRequest.of(activePage, limit);
        Page<Post> list = postRepository.finAll(pageable);
        int totalPages = list.getTotalPages();
        List<PostDto> listPostDto =  list.stream().map(PostMapper::EntityToDto).collect(Collectors.toList());
        return new ResponseWithData("success", totalPages, listPostDto);
    }

    @Override
    public ResponseWithData getPosts() {
        List<Post> listPosts = postRepository.findAll();
        List<PostDto> listPostDto =  listPosts.stream().map(PostMapper::EntityToDto).collect(Collectors.toList());
        return new ResponseWithData("success", listPostDto);
    }


    @Override
    public Response createNewPost(PostIn postIn) {
        Post post = PostMapper.InToEntity(postIn);
        postRepository.save(post);
        return new Response(true, "add success!");
    }

    @Override
    public Response deletePost(Integer id) {
        Optional<Post> post = postRepository.findById(id);
        postRepository.delete(post.get());
        return new Response(true, "delete success!");
    }

    @Override
    public Response updatePost(Integer id, PostIn postIn) {
        Optional<Post> post = postRepository.findById(id);
        Post post1 = post.get();
        post1.setName(postIn.getName());
        post1.setMota(postIn.getMota());
        postRepository.save(post1);
        return new Response(true, "update success!");
    }
}
