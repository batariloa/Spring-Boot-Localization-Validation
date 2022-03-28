package metropolitan.it355.dz05.brand;



public enum Brand {
 VOLKSWAGEN("Volkswagen"), BMW("BMW"), AUDI("Audi"), RENAULT("Renault"),
 ALFA_ROMEO("Alfa Romeo");
	
 
 private final String brand;
	Brand(String brand){
		this.brand= brand;
		
	}
	public String getBrand() {
		return brand;
	}
	
	

}
