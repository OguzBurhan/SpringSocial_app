package com.example.gbc_springsocial54.friendshipservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "friendships")
public class Friendship {

    @Id
    private String id;

    private String userId1;
    private String userId2;

    private FriendshipStatus status;

    public enum FriendshipStatus {
        PENDING,
        APPROVED,
        DECLINED
    }


    public static Friendship sendFriendRequest(String userId1, String userId2) {
        return Friendship.builder()
                .userId1(userId1)
                .userId2(userId2)
                .status(FriendshipStatus.PENDING)
                .build();
    }


    public void approveFriendRequest() {
        if (this.status == FriendshipStatus.PENDING) {
            this.status = FriendshipStatus.APPROVED;
        } else {
            throw new IllegalStateException("Friendship request is not pending.");
        }
    }


    public void declineFriendRequest() {
        if (this.status == FriendshipStatus.PENDING) {
            this.status = FriendshipStatus.DECLINED;
        } else {
            throw new IllegalStateException("Friendship request is not pending.");
        }
    }
}