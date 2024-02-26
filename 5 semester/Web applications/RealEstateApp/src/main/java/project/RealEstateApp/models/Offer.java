package project.RealEstateApp.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, unique = false)
    private UserEntity user_id;

    @Column(name = "description", length = 2000, nullable = false)
    private String description;
    
    @Column(name = "title", length = 50, nullable = false)
    private String title;
    
    @Column(name = "offer_postalcode", length = 50, nullable = false)
    private String offer_postalCode;

    @Column(name = "offer_price", nullable = false)
    private Integer offer_price;
    
    @Column(name = "area_in_meters", nullable = false)
    private Integer area_in_meters;
    
    @Column(name = "expiration_date", nullable = false)
    private LocalDate expiration_date;

    @Column(name = "city", length = 50, nullable = false)
    private String city;
    
    @Column(name = "street", length = 50, nullable = false)
    private String street;
    
    @Column(name = "address", length = 50, nullable = false)
    private String address;

	public Long getOffer_id() {
		return id;
	}

	public UserEntity getUser_id() {
		return user_id;
	}

	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}

	public String getOffer_postalCode() {
		return offer_postalCode;
	}

	public Integer getOffer_price() {
		return offer_price;
	}

	public Integer getArea_in_meters() {
		return area_in_meters;
	}

	public LocalDate getExpiration_date() {
		return expiration_date;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getAddress() {
		return address;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOffer_postalCode(String offer_postalCode) {
		this.offer_postalCode = offer_postalCode;
	}

	public void setOffer_price(Integer offer_price) {
		this.offer_price = offer_price;
	}

	public void setArea_in_meters(Integer area_in_meters) {
		this.area_in_meters = area_in_meters;
	}

	public void setExpiration_date(LocalDate expiration_date) {
		this.expiration_date = expiration_date;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser_id(UserEntity user_id) {
		this.user_id = user_id;
	}
	
	@OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private List<PropertyPhoto> photos;

    public List<PropertyPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PropertyPhoto> photos) {
        this.photos = photos;
    }
	
    
}
