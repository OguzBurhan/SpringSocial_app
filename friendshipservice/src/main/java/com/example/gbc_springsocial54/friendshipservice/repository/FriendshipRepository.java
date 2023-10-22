package com.example.gbc_springsocial54.friendshipservice.repository;

import com.example.gbc_springsocial54.friendshipservice.model.Friendship;
import com.example.gbc_springsocial54.friendshipservice.model.Friendship.FriendshipStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FriendshipRepository extends MongoRepository<Friendship, String> {

    List<Friendship> findByUserId2AndStatus(String userId2, FriendshipStatus status);

    List<Friendship> findByUserId1AndStatusOrUserId2AndStatus(
            String userId1,
            FriendshipStatus status1,
            String userId2,
            FriendshipStatus status2
    );
}