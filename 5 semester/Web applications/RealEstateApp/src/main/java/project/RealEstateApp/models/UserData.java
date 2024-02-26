package project.RealEstateApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_data")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    @Column(name = "user_firstname", length = 50, nullable = true)
    private String user_firstname;

    @Column(name = "user_lastname", length = 50, nullable = true)
    private String user_lastname;

    @Column(name = "user_phonenumber", length = 9, nullable = true)
    private Integer user_phonenumber;

	public Long getId() {
		return id;
	}

	public UserEntity getUser() {
		return user;
	}

	public String getUser_firstname() {
		return user_firstname;
	}

	public String getUser_lastname() {
		return user_lastname;
	}

	public Integer getUser_phonenumber() {
		return user_phonenumber;
	}

	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}

	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}

	public void setUser_phonenumber(Integer user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}

	public void setUser(UserEntity savedUser) {
		this.user = savedUser;
		
	}


    
}