package metropolitan.it355.dz05.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
@Entity
public class Customer {
	
	 @Id
	 @GeneratedValue
	 private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	  @Size(min=1,message="{error.name}")  
	private String name;
 
		@NotBlank(message="{error.surname}")
	private String surname;
	  @NotEmpty(message="{error.phone}")
	private String phone;
	@NotEmpty(message="{error.email}")
	@Email
	private String email;
	@NotBlank(message="{error.adress}")
	private String adress;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public Customer() {
		super();
	}

}
