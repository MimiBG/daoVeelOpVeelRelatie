package daoVeelOpVeelRelatie;

public class Reiziger {
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private String geboortedatum;
	
	public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achternaam, String geboortedatum) {
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geboortedatum = achternaam;
		
	}

	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public String getGeboortedatum() {
		return geboortedatum;
	}

	public void setGeboortedatum(String geboortedatum) {
		this.geboortedatum = geboortedatum;
	}

}
