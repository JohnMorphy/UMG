package project.RealEstateApp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OfferDTO {

    private Long id;
    private Long user_id;
    private String description;
    private String title;
    private String offer_postalCode;
    private Integer offer_price;
    private Integer area_in_meters;
    private String expiration_date;
    private String city;
    private String street;
    private String address;
    
	public OfferDTO(Long id, Long user_id, String description, String title, String offer_postalCode,
			Integer offer_price, Integer area_in_meters, String expiration_date, String city, String street,
			String address) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.description = description;
		this.title = title;
		this.offer_postalCode = offer_postalCode;
		this.offer_price = offer_price;
		this.area_in_meters = area_in_meters;
		this.expiration_date = expiration_date;
		this.city = city;
		this.street = street;
		this.address = address;
	}
	
	public OfferDTO() {
		super();
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

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOffer_postalCode() {
		return offer_postalCode;
	}

	public void setOffer_postalCode(String offer_postalCode) {
		this.offer_postalCode = offer_postalCode;
	}

	public Integer getOffer_price() {
		return offer_price;
	}

	public void setOffer_price(Integer offer_price) {
		this.offer_price = offer_price;
	}

	public Integer getArea_in_meters() {
		return area_in_meters;
	}

	public void setArea_in_meters(Integer area_in_meters) {
		this.area_in_meters = area_in_meters;
	}
	
	public String getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(String expiration_date) {
		this.expiration_date = expiration_date;
	}

	public void setExpirationDateThreeMonthsFromNow() {
	    LocalDateTime expirationDateTime = LocalDateTime.now().plusMonths(3);
	    LocalDate expirationDate = expirationDateTime.toLocalDate();
	    String formattedExpirationDate = expirationDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	    this.expiration_date = formattedExpirationDate;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "OfferDTO [id=" + id + ", user_id=" + user_id + ", description=" + description + ", title=" + title
				+ ", offer_postalCode=" + offer_postalCode + ", offer_price=" + offer_price + ", area_in_meters="
				+ area_in_meters + ", expiration_date=" + expiration_date + ", city=" + city + ", street=" + street
				+ ", address=" + address + "]";
	}

	
	
}
