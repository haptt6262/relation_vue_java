package com.example.testround3.Mapper;

import com.example.testround3.Model.dto.CommentsDto;
import com.example.testround3.Model.entity.Comments;
import com.example.testround3.Model.in.CommentsIn;

public class CommentsMapper {
    public static Comments InToEntity(CommentsIn commentsIn){
        Comments comments = new Comments();
        comments.setName_comment(commentsIn.getName_comment());
        return comments;
    }
    public static CommentsDto EntityToDto(Comments comments){
        CommentsDto commentsDto = new CommentsDto();
        commentsDto.setId(comments.getId());
        commentsDto.setName_comment(comments.getName_comment());
        if(comments.getPost()==null){
            commentsDto.setName_post(null);
            commentsDto.setId_post(null);
        }else{
            commentsDto.setName_post(comments.getPost().getName());
            commentsDto.setId_post(comments.getPost().getId());
        }
        return commentsDto;
    }
}
