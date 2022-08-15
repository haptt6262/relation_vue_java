package com.example.testround3.Mapper;

import com.example.testround3.Model.dto.PostDto;
import com.example.testround3.Model.entity.Post;
import com.example.testround3.Model.in.PostIn;

public class PostMapper {
    public static Post InToEntity(PostIn postIn){
        Post post = new Post();
        post.setName(postIn.getName());
        post.setMota(postIn.getMota());
        return post;
    }
    public static PostDto EntityToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setName(post.getName());
        postDto.setMota(post.getMota());
        return postDto;
    }
}
