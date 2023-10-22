package com.example.gbc_springsocial54.commentservice.controller;

import com.example.gbc_springsocial54.commentservice.controller.CommentRequest;
import com.example.gbc_springsocial54.commentservice.controller.CommentResponse;
import com.example.gbc_springsocial54.commentservice.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping
    public ResponseEntity<CommentResponse> createComment(@RequestBody CommentRequest commentRequest) {
        CommentResponse commentResponse = commentService.createComment(commentRequest);
        return ResponseEntity.ok(commentResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> getCommentById(@PathVariable String id) {
        CommentResponse commentResponse = commentService.getCommentById(id);
        return ResponseEntity.ok(commentResponse);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentResponse>> getAllCommentsByPostId(@PathVariable String postId) {
        List<CommentResponse> comments = commentService.getAllCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponse> updateComment(@PathVariable String id, @RequestBody CommentRequest commentRequest) {
        CommentResponse updatedComment = commentService.updateComment(id, commentRequest);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable String id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
