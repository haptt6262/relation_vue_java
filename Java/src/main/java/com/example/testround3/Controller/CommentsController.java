package com.example.testround3.Controller;

import com.example.testround3.Model.in.CommentsIn;
import com.example.testround3.Service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;
    @GetMapping("")
    public ResponseEntity<?> getAllComments(){
        return new ResponseEntity<>(commentsService.getAllComments(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> createNewComment(@RequestBody CommentsIn commentsIn){
        return new ResponseEntity<>(commentsService.createNewComment(commentsIn), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id){
        return new ResponseEntity<>(commentsService.deleteComment(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Integer id, @RequestBody CommentsIn commentsIn){
        return new ResponseEntity<>(commentsService.updateComment(id, commentsIn), HttpStatus.OK);
    }
}
