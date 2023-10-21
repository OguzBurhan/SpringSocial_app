package ca.gbc.userservice.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User model representing a user entity for JPA with a relational database.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // Marks this class as a JPA entity
@Table(name = "users") // Specifies the name of the database table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies auto-generation of primary key
	private Long id; // Unique identifier for each user

	private String username; // Username of the user

	private String password; // Password for the user (consider encrypting/hashing in real applications)
}


