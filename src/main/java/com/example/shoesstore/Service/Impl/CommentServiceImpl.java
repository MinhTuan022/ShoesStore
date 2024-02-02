package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.Comment;
import com.example.shoesstore.Entity.Product;
import com.example.shoesstore.Entity.User;
import com.example.shoesstore.Exception.ResourceNotFoundException;
import com.example.shoesstore.Model.Requests.CreateCommentRequest;
import com.example.shoesstore.Repository.CommentRepository;
import com.example.shoesstore.Repository.ProductRepository;
import com.example.shoesstore.Repository.UserRepository;
import com.example.shoesstore.Service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    CommentRepository commentRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    @Override
    public List<Comment> getAllComment() {
        return commentRepository.findAll();
    }

    @Override
    public Comment createComment(CreateCommentRequest request) {
        User user = userRepository.findById(request.getUId()).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        Product product = productRepository.findById((request.getProId())).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        Comment comment = new Comment();
        comment.setCmtDate(getDateTime(LocalDateTime.now()));
        comment.setCmtContent(request.getCmtContent());
        comment.setCmtState(request.isCmtState());
        comment.setUser(user);
        comment.setProduct(product);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public Comment updateComment(Long cmtId, CreateCommentRequest request) {
        User user = userRepository.findById(request.getUId()).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        Product product = productRepository.findById((request.getProId())).orElseThrow(() -> new ResourceNotFoundException("Not Found"));

        Comment comment = commentRepository.findById(cmtId).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        comment.setCmtDate(getDateTime(LocalDateTime.now()));
        comment.setCmtContent(request.getCmtContent());
        comment.setCmtState(request.isCmtState());
        comment.setUser(user);
        comment.setProduct(product);
        commentRepository.save(comment);
        return comment;
    }

    @Override
    public void deleteComment(Long cmtId) {
        Comment comment = commentRepository.findById(cmtId).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        commentRepository.delete(comment);
    }


    public String getDateTime(LocalDateTime DateF) {
        // Lấy ngày giờ hiện tại
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return DateF.format(formatter);
    }
}
