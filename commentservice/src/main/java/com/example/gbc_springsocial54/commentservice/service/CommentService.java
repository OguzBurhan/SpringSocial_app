package com.example.gbc_springsocial54.commentservice.service;

import com.example.gbc_springsocial54.commentservice.controller.CommentRequest;
import com.example.gbc_springsocial54.commentservice.controller.CommentResponse;

import java.util.List;

public interface CommentService {

    CommentResponse createComment(CommentRequest commentRequest);

    CommentResponse getCommentById(String id);

    List<CommentResponse> getAllCommentsByPostId(String postId);

    CommentResponse updateComment(String id, CommentRequest commentRequest);

    void deleteComment(String id);
}