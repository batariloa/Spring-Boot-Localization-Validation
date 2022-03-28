package metropolitan.it355.dz05.controller;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;


import metropolitan.it355.dz05.entity.Car;
import metropolitan.it355.dz05.entity.FormWrapper;
import metropolitan.it355.dz05.helperClass.ExtractedData;
import metropolitan.it355.dz05.repository.CarRepository;
import metropolitan.it355.dz05.repository.RentalRepository;

@Controller
public class RentalController {

	
	
	@Autowired
	CarRepository carRep;
	
	@Autowired
	RentalRepository rentRep;
	
	@PostMapping("/cars")
	String addRent(@Valid  @ModelAttribute("wrapper") FormWrapper r, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("ERROR ");
			System.out.println(bindingResult.getAllErrors());
		 	
			
			List<Car> listaAutomobila  = carRep.findAll();
		    
		    ExtractedData ed = new ExtractedData(listaAutomobila);
		    ed.extractDates();
	    	Gson g = new Gson();


			model.addAttribute("lista",listaAutomobila);
			model.addAttribute("wrapper", r);
			model.addAttribute("dates",  g.toJson(ed.getListaNedostupnihDatuma()));
			model.addAttribute("prices",  g.toJson(ed.getListaCena()));
			return "rent";
		
		}
		else {
		
		Car c = carRep.getById(r.getCar().getId());
		r.setCar(c);
		r.getRental().setUp(c.getPricePerDay(), r.getDateRange());
		c.getRentDates().add(r.getRental());
		
	

		
		
		carRep.save(c);
		
		return "success";
		}
	}
	
	
}
