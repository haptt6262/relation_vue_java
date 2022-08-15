package com.example.testround3.Controller;

import com.example.testround3.Model.in.PostIn;
import com.example.testround3.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
    @GetMapping("/pagination")
    public ResponseEntity<?> getPostsWithPagination(@RequestParam(name = "activePage", required = false) Integer activePage,
                                      @RequestParam(name = "limit", required = false) Integer limit
                                     ){
        return new ResponseEntity<>(postService.getPostsWithPagination(activePage, limit), HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<?> getPosts(){
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }
    @PostMapping("")
    public  ResponseEntity<?> createNewPost(@RequestBody PostIn postIn){
        return new ResponseEntity<>(postService.createNewPost(postIn), HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Integer id){
        return new ResponseEntity<>(postService.deletePost(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable Integer id, @RequestBody PostIn postIn){
        return new ResponseEntity<>(postService.updatePost(id, postIn), HttpStatus.OK);
    }
}
