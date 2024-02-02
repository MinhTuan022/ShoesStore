package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Comment;
import com.example.shoesstore.Model.Requests.CreateCommentRequest;

import java.util.List;

public interface CommentService {

    List<Comment> getAllComment();
    Comment createComment(CreateCommentRequest request);

    Comment updateComment(Long cmtId, CreateCommentRequest request);

    void deleteComment(Long cmtId);


}
