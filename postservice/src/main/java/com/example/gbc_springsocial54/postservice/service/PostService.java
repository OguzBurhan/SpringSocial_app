package com.example.gbc_springsocial54.postservice.service;

import com.example.gbc_springsocial54.postservice.controller.PostRequest;
import com.example.gbc_springsocial54.postservice.controller.PostResponse;

import java.util.List;

public interface PostService {
    void createPost(PostRequest postRequest);
    String updatePost(String postId, PostRequest postRequest);
    void deletePost(String postId);
    List<PostResponse> getAllPosts();


}
