package project.RealEstateApp.dto;



public class UserDataDTO {

    private Long id;
    private Long user_id;
    private String user_firstname;
    private String user_lastname;
    private Integer user_phonenumber;
	
    public UserDataDTO() {
    	super();
    }
    
    public UserDataDTO(Long id, Long userID, String user_firstname, String user_lastname, Integer user_phonenumber) {
		super();
		this.id = id;
		this.user_id = userID;
		this.user_firstname = user_firstname;
		this.user_lastname = user_lastname;
		this.user_phonenumber = user_phonenumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long userID) {
		this.user_id = userID;
	}
	public String getUser_firstname() {
		return user_firstname;
	}
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}
	public String getUser_lastname() {
		return user_lastname;
	}
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}
	public Integer getUser_phonenumber() {
		return user_phonenumber;
	}
	public void setUser_phonenumber(Integer user_phonenumber) {
		this.user_phonenumber = user_phonenumber;
	}

    
    
}