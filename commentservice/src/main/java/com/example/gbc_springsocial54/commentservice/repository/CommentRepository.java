package ca.gbc.commentservice.repository;

import ca.gbc.commentservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;


import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {

    List<Comment> findByPostId(String postId);
}
//4. Testing:
//        Write integration tests using @SpringBootTest.
//        Use TestContainers to spin up real databases for testing.
//        5. Docker Containerization:
//        Create a Dockerfile for each service.
//        Use Docker Compose to manage and orchestrate multi-container applications.
//        6. JPA Integration & Data Modeling:
//        In User and Comment services:
//        Create JPA entities and repositories.
//        Use data.sql and schema.sql to bootstrap sample user data.
//        Define relationships using JPA annotations like @OneToMany, @ManyToOne.