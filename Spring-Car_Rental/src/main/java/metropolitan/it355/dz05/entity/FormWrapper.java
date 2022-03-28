package metropolitan.it355.dz05.entity;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class FormWrapper {


	@Valid
	private Car car;
	
	
	@Valid
	private Rental rental;
	
	String dateRange;
	

	public String getDateRange() {
		return dateRange;
	}
	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}
	public Rental getRental() {
		return rental;
	}
	public void setRental(Rental rental) {
		this.rental = rental;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public FormWrapper() {
		super();
	}
	
}
