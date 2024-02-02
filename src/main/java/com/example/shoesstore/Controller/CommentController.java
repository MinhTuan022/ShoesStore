package com.example.shoesstore.Controller;

import com.example.shoesstore.Entity.Comment;
import com.example.shoesstore.Model.Requests.CreateCommentRequest;
import com.example.shoesstore.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    ResponseEntity<List<Comment>> getAllComment(){
        List<Comment> commentList = commentService.getAllComment();
        return ResponseEntity.ok(commentList);
    }
    @PostMapping("/create")
    ResponseEntity<Comment> createComment(@RequestBody CreateCommentRequest request){
        Comment comment = commentService.createComment(request);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/update/{cmtId}")
    ResponseEntity<Comment> updateComment(@PathVariable Long cmtId, @RequestBody CreateCommentRequest request){
        Comment comment = commentService.updateComment(cmtId, request);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping ("delete/{cmtId}")
    ResponseEntity<String> deleteComment(@PathVariable Long cmtId){
        commentService.deleteComment(cmtId);
        return ResponseEntity.ok("Xóa Thành Công!");
    }
}
