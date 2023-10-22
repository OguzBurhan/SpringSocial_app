package com.example.gbc_springsocial54.commentservice.service;

import com.example.gbc_springsocial54.commentservice.controller.CommentRequest;
import com.example.gbc_springsocial54.commentservice.controller.CommentResponse;

import com.example.gbc_springsocial54.commentservice.model.Comment;
import com.example.gbc_springsocial54.commentservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentResponse createComment(CommentRequest commentRequest) {
        Comment comment = Comment.builder()
                .postId(commentRequest.getPostId())
                .userId(commentRequest.getUserId())
                .content(commentRequest.getContent())
                .build();

        comment = commentRepository.save(comment);

        return new CommentResponse(comment.getId(), comment.getPostId(), comment.getUserId(), comment.getContent());
    }

    @Override
    public CommentResponse getCommentById(String id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));
        return new CommentResponse(comment.getId(), comment.getPostId(), comment.getUserId(), comment.getContent());
    }

    @Override
    public List<CommentResponse> getAllCommentsByPostId(String postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments.stream()
                .map(comment -> new CommentResponse(comment.getId(), comment.getPostId(), comment.getUserId(), comment.getContent()))
                .collect(Collectors.toList());
    }

    @Override
    public CommentResponse updateComment(String id, CommentRequest commentRequest) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found"));

        comment.setContent(commentRequest.getContent()); // You can add other fields to update as well.

        comment = commentRepository.save(comment);

        return new CommentResponse(comment.getId(), comment.getPostId(), comment.getUserId(), comment.getContent());
    }

    @Override
    public void deleteComment(String id) {
        commentRepository.deleteById(id);
    }
}




