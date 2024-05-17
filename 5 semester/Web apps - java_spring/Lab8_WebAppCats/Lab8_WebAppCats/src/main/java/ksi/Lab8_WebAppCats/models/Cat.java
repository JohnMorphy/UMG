package ksi.Lab8_WebAppCats.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
public class Cat {
	 
	private @Id @GeneratedValue Long id;
	private String name;
	private String breed;
	
	Cat() {}
	
	public Cat(String name, String breed) {
		this.name = name;
		this.breed = breed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		
		if (!(object instanceof Cat)) {
			 return false;
		}
		
		Cat cat = (Cat) object;
		return Objects.equals(this.id, cat.id) && Objects.equals(this.name, cat.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.name, this.breed);
	}

	
	@Override
	public String toString() {
		return "Cat{" + "id=" + this.id + ", name='" + this.name + '\'' + ", breed='" +
				this.breed + '\'' + '}';
	}

	 
}