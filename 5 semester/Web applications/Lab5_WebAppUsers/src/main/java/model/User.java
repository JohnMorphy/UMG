package model;


public class User {

	private int id;
	private String first_name;
	private String last_name;
	private int year_of_study;
	private String email;
	private Long personal_id;
	private String country;
	
	public User() {}	
	
	public User(int id, String first_name, String last_name, int year_of_study, String email, Long personal_id, String country) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.year_of_study = year_of_study;
		this.email = email;
		this.personal_id = personal_id;
		this.country = country;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getYear_of_study() {
		return year_of_study;
	}

	public void setYear_of_study(int year_of_study) {
		this.year_of_study = year_of_study;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPersonal_id() {
		return personal_id;
	}

	public void setPersonal_id(Long personal_id) {
		this.personal_id = personal_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	
}
