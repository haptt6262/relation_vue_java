package com.example.testround3.Service;

import com.example.testround3.Model.bo.Response;
import com.example.testround3.Model.bo.ResponseWithData;
import com.example.testround3.Model.in.CommentsIn;
import org.springframework.stereotype.Service;

@Service
public interface CommentsService {
    ResponseWithData getAllComments();
    Response createNewComment(CommentsIn commentsIn);
    Response deleteComment(Integer id);
    Response updateComment(Integer id, CommentsIn commentsIn);
}
