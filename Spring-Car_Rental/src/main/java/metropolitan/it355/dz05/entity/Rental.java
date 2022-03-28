package metropolitan.it355.dz05.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Entity
public class Rental {

	 @Id
	 @GeneratedValue
	 private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	LocalDate fromDate;
	LocalDate toDate;


	
	@Valid
	@ManyToOne(cascade=CascadeType.ALL)
	Customer customer;

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	int price;
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public Rental() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setUp(int price, String dateRange) {
		
		String from;
		String to;
	from = dateRange.substring(0,10);
		
	to = dateRange.substring(13);
	
    DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/uuuu");
  
	System.out.println("dejt " + dateRange);
	this.fromDate = LocalDate.parse(from, formatters);
	this.toDate = LocalDate.parse(to, formatters);
	
	
		System.out.println(dateRange+ "sss" +  this.fromDate + " ss " + this.toDate );
		long daysBetween = ChronoUnit.DAYS.between(this.fromDate, this.toDate);
		this.price = (int) (daysBetween * price);
	}
	
}
