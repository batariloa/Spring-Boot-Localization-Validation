package metropolitan.it355.dz05.helperClass;

import java.util.ArrayList;
import java.util.List;

import metropolitan.it355.dz05.entity.Car;

public class ExtractedData {
	List<Car> listaAutomobila =new ArrayList<Car>();;
	List<List<String>> listaNedostupnihDatuma = new ArrayList<>();
	List<Integer> listaCena = new ArrayList<>();
	
	
	
	
	public List<Car> getListaAutomobila() {
		return listaAutomobila;
	}




	public void setListaAutomobila(List<Car> listaAutomobila) {
		this.listaAutomobila = listaAutomobila;
	}




	public List<List<String>> getListaNedostupnihDatuma() {
		return listaNedostupnihDatuma;
	}




	public void setListaNedostupnihDatuma(List<List<String>> listaNedostupnihDatuma) {
		this.listaNedostupnihDatuma = listaNedostupnihDatuma;
	}




	public List<Integer> getListaCena() {
		return listaCena;
	}




	public void setListaCena(List<Integer> listaCena) {
		this.listaCena = listaCena;
	}




	public void extractDates(){
		
		this.listaAutomobila.forEach(element -> {
			List<String> listaDatuma  = new ArrayList<String>();
			if(element.getRentDates()!=null)
		element.getNedostupniDatumi().forEach(datum -> {
			
			listaDatuma.add(datum);
		});
	listaCena.add(element.getPricePerDay());
	System.out.println(element.getPricePerDay() + " cena");
	listaNedostupnihDatuma.add(listaDatuma);
		});
		
		
	}




	public ExtractedData(List<Car> listaAutomobila) {
		super();
		this.listaAutomobila = listaAutomobila;
	}
	
}
