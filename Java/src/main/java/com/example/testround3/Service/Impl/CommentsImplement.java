package com.example.testround3.Service.Impl;

import com.example.testround3.Mapper.CommentsMapper;
import com.example.testround3.Model.bo.Response;
import com.example.testround3.Model.bo.ResponseWithData;
import com.example.testround3.Model.dto.CommentsDto;
import com.example.testround3.Model.entity.Comments;
import com.example.testround3.Model.entity.Post;
import com.example.testround3.Model.in.CommentsIn;
import com.example.testround3.Repository.CommentsRepository;
import com.example.testround3.Repository.PostRepository;
import com.example.testround3.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class CommentsImplement implements CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public ResponseWithData getAllComments() {
        List<Comments> listComments = commentsRepository.findAll();
        List<CommentsDto> listCommentsDto = listComments.stream().map(CommentsMapper::EntityToDto).collect(Collectors.toList());
        return new ResponseWithData("success", listCommentsDto);
    }

    @Override
    public Response createNewComment(CommentsIn commentsIn) {
        Comments comments = CommentsMapper.InToEntity(commentsIn);
        if(commentsIn.getId_post()==null){
            comments.setPost(null);
        }else{
            Optional<Post> post = postRepository.findById(commentsIn.getId_post());
            comments.setPost(post.get());
        }
        commentsRepository.save(comments);
        return new Response(true, "add success!");
    }

    @Override
    public Response deleteComment(Integer id) {
        Optional<Comments> comments = commentsRepository.findById(id);
        commentsRepository.delete(comments.get());
        return new Response(true, "delete success!");
    }

    @Override
    public Response updateComment(Integer id, CommentsIn commentsIn) {
        Optional<Comments> comments = commentsRepository.findById(id);
        Comments comments1 = comments.get();
        Optional<Post> post =postRepository.findById(commentsIn.getId_post());
        comments1.setName_comment(commentsIn.getName_comment());
        comments1.setPost(post.get());
        commentsRepository.save(comments1);
        return new Response(true, "update success!");
    }
}
