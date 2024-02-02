package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
