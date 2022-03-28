package metropolitan.it355.dz05.controller;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.w3c.dom.ElementTraversal;

import com.google.gson.Gson;

import metropolitan.it355.dz05.brand.Brand;
import metropolitan.it355.dz05.entity.Car;
import metropolitan.it355.dz05.entity.FormWrapper;
import metropolitan.it355.dz05.entity.Rental;
import metropolitan.it355.dz05.helperClass.ExtractedData;
import metropolitan.it355.dz05.repository.CarRepository;

@Controller
public class CarController {
	List<Car> listaAutomobila =new ArrayList<Car>();

	
	@Autowired
	CarRepository rep;
	
	@GetMapping({"/","/cars"})
	public String hello( Model model) {
    	
		
	    listaAutomobila = rep.findAll();
	    
	    ExtractedData ed = new ExtractedData(listaAutomobila);
	    ed.extractDates();
    	Gson g = new Gson();
    	
    	
/**    	Car c = new Car(Brand.BMW, 250, 3000,"Serija 3","2019", 60);
       	Rental r = new Rental();
       	r.setFromDate(LocalDate.parse("2022-02-02"));
       	r.setToDate(LocalDate.parse("2022-10-02"));
       	List<Rental> rList = new ArrayList<Rental>();
       	rList.add(r);
    	c.setRentDates(rList);
    **/

 
    

		model.addAttribute("lista",listaAutomobila);
		

		
		model.addAttribute("wrapper", new FormWrapper());

		model.addAttribute("dates",  g.toJson(ed.getListaNedostupnihDatuma()));
		model.addAttribute("prices",  g.toJson(ed.getListaCena()));
	
		return "rent";
	}
	


	

}
