package daoVeelOpVeelRelatie;

public class OVChipkaart_Product {
	private int ovproductID;
	private Product product;
	private OVChipkaart ovchipkaart;
	private String reisproductStatus;
	private String lastUpdate;
	
	public OVChipkaart_Product(int ovproductID, Product product, OVChipkaart ovchipkaart, String reisproductStatus, String lastUpdate) {
		this.ovchipkaart = ovchipkaart;
		this.product = product;
		this.ovchipkaart = ovchipkaart;
		this.reisproductStatus = reisproductStatus;
		this.lastUpdate = lastUpdate;
	}
	
	public OVChipkaart_Product() {}

	public int getOvproductID() {
		return ovproductID;
	}
	public void setOvproductID(int ovproductID) {
		this.ovproductID = ovproductID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OVChipkaart getOvchipkaart() {
		return ovchipkaart;
	}

	public void setOvchipkaart(OVChipkaart ovchipkaart) {
		this.ovchipkaart = ovchipkaart;
	}

	public String getReisproductStatus() {
		return reisproductStatus;
	}

	public void setReisproductStatus(String reisproductStatus) {
		this.reisproductStatus = reisproductStatus;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public OVChipkaart getOvchipkaart1() {
		return null;
	}

}
