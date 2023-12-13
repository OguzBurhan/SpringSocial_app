package com.example.gbc_springsocial54.friendshipservice.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FriendshipRequest {
    private String userId1;
    private String userId2;
}