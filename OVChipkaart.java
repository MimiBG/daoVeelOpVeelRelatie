package daoVeelOpVeelRelatie;

public class OVChipkaart {
	private int kaartNummer;
	private String geldigTot;
	private int klasse;
	private double saldo;
	private int reizigerID;
	private Reiziger reiziger;
	
	public OVChipkaart(int kaartNummer, String geldigTot, int klasse, double saldo, int reizigerID) {
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
	}
	
	public int getReizigerID() {
		return reizigerID;
	}

	public void setReizigerID(int reizigerID) {
		this.reizigerID = reizigerID;
	}

	public OVChipkaart() {}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public String getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(String geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double d) {
		this.saldo = d;
	}

	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}

	public int getKaartNummer11() {
		return 0;
	}

	public String getKaartNummer1() {
		return null;
	}

	public void setKaartNummer1(int kaartNummer2) {
		
	}

	public String getKaartNummer11() {
		return null;
	}

}
