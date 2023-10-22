package com.example.gbc_springsocial54.postservice.service;

import com.example.gbc_springsocial54.postservice.controller.PostRequest;
import com.example.gbc_springsocial54.postservice.controller.PostResponse;

import com.example.gbc_springsocial54.postservice.model.Post;
import com.example.gbc_springsocial54.postservice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public void createPost(PostRequest postRequest){
        Post post = Post.builder()
                .content(postRequest.getContent())
                .build();
        postRepository.save(post);
    }


    @Override
    public String updatePost(String postId, PostRequest postRequest) {
        Query query = new Query();

        query.addCriteria(Criteria.where("id").is(postId));
        Post post = mongoTemplate.findOne(query, Post.class);

        if (post != null) {
            post.setContent(postRequest.getContent());

            return postRepository.save(post).getId();
        }
        return postId.toString();
    }

    @Override
    public void deletePost(String postId){
        log.info("Post {} is selected", postId);
        postRepository.deleteById(postId);
    }

    @Override
    public List<PostResponse> getAllPosts(){
        log.info("Returning all posts");
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this:: mapToPostResponse).toList();
    }

    private PostResponse mapToPostResponse(Post post){
        return PostResponse.builder()
                .Id(post.getId())
                .content(post.getContent()).build();
    }

    /*
    @Override
    public List<HashMap<String, String>> getPostsForUser(String userId){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));

        List<Post> posts = mongoTemplate.find(query, Post.class);
        return mapToHashMapList(posts);
    }

    private List<HashMap<String, String>> mapToHashMapList(List<Post> posts) {
        return posts.stream()
                .map(post -> {
                    HashMap<String, String> postMap = new HashMap<>();
                    postMap.put("postId", post.getId());
                    postMap.put("userId", post.getUserId());
                    postMap.put("content", post.getContent());
                    return postMap;
                })
                .collect(Collectors.toList());
    }
    */

}
