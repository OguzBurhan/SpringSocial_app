package com.example.gbc_springsocial54.commentservice.repository;

import com.example.gbc_springsocial54.commentservice.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findByPostId(String postId);
}
