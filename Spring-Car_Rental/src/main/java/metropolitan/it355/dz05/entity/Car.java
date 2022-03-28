package metropolitan.it355.dz05.entity;

import java.io.Serializable;
import java.time.LocalDate;


import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

import metropolitan.it355.dz05.brand.Brand;



@Component
@Entity
public class Car implements Serializable{

	
	@NotNull(message = "{error.car}")
	 @Id
	 @GeneratedValue
	 private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", hp=" + hp + ", kubikaza=" + kubikaza + ", model=" + model
				+ ", godiste=" + godiste + ", pricePerDay=" + pricePerDay + ", rentDates=" + rentDates + "]";
	}

	private Brand brand;
	private int hp;
	private int kubikaza;
	private String model;
	private String godiste;
	private int pricePerDay;
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
    List<Rental> rentDates = new ArrayList<>(); 
	
		public List<Rental> getRentDates() {
		return rentDates;
	}

	public void setRentDates(List<Rental> rentDates) {
		this.rentDates = rentDates;
	}

		public int getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(int pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

		public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getKubikaza() {
		return kubikaza;
	}

	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}



		public String getGodiste() {
		return godiste;
	}

	public void setGodiste(String godiste) {
		this.godiste = godiste;
	}

		public Car(){
			
		}


		public Car(Brand brand, int hp, int kubikaza, String model, String godiste, int pricePerDay
			) {
			super();
			
			this.brand = brand;
			this.hp = hp;
			this.kubikaza = kubikaza;
			this.model = model;
			this.godiste = godiste;
			this.pricePerDay = pricePerDay;
		
		}

		public List<String> getNedostupniDatumi() {
			
			List<String> sviNedostupni = new ArrayList<>();
			  DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.CANADA);
			            
			
			this.rentDates.forEach(renta-> {
				if(renta.fromDate!= null && renta.toDate!=null) {
				List<LocalDate> totalDates =  renta.fromDate.datesUntil(renta.toDate)
						  .collect(Collectors.toList());
				totalDates.forEach(element-> { 
					String formatiran = element.format(dateFormatter);
				sviNedostupni.add(formatiran);
					
				});
			
				}	
			});
			
			return sviNedostupni;
		
			
			
		}

	
}
