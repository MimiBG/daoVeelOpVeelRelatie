package daoVeelOpVeelRelatie;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	
	public Product(int productNummer, String productNaam, String beschrijving, int prijs) {
		this.productNaam = productNaam;
		this.productNummer = productNummer;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
	}
	
	public Product() {
		
	}
	
	public int getProductNummer() {
		return productNummer;
	}

	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}

	public String getProductNaam() {
		return productNaam;
	}

	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	

}
