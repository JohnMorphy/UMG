package project.RealEstateApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_role", schema = "spring_realestateapp" )
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_role_name", length = 50)
    private String user_role_name;

	public Long getUser_role_id() {
		return id;
	}

	public String getUser_role_name() {
		return user_role_name;
	}
    
}