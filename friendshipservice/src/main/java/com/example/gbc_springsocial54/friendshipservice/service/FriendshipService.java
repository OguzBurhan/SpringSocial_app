package com.example.gbc_springsocial54.friendshipservice.service;

import com.example.gbc_springsocial54.friendshipservice.model.Friendship;
// Assuming FriendshipStatus is inside the Friendship class.
import com.example.gbc_springsocial54.friendshipservice.model.Friendship.FriendshipStatus;

import java.util.List;

public interface FriendshipService {

    List<Friendship> findAll();

    Friendship findById(String id);

    Friendship save(Friendship friendship);

    Friendship update(String id, Friendship friendship);

    boolean delete(String id);

    Friendship sendFriendRequest(Friendship friendshipRequest);

    Friendship approveFriendRequest(String id);

    Friendship declineFriendRequest(String id);

    List<Friendship> findPendingRequests(String userId);

    List<Friendship> findFriendsForUser(String userId);

    boolean removeFriend(String id);

}