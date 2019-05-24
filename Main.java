package daoVeelOpVeelRelatie;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		ProductDAO pDAO = new ProductDAOImpl();
		OVChipkaart_ProductDAO ov_pDAO = new OVChipkaart_ProductDAOImpl();

		// Select statement uit product met id 1
		System.out.println("Product rij met id 1");
		System.out.println("Productnaam: " + pDAO.findById(1).getProductNaam());
		System.out.println("Productbeschrijving: " + pDAO.findById(1).getBeschrijving());
		System.out.println("Productprijs: " + pDAO.findById(1).getPrijs());
		
		// Select statement uit ov_chipkaart_product met id 1
		System.out.println("\nOVChipkaart_Product rij zoeken met id 1");
		System.out.println("Kaartnummer: " + ov_pDAO.findById(1).getOvchipkaart().getKaartNummer());
		System.out.println("Productnummer: " + ov_pDAO.findById(1).getProduct().getProductNummer());
		System.out.println("Reisproduct status: " + ov_pDAO.findById(1).getReisproductStatus());
		System.out.println("Laatste update: " + ov_pDAO.findById(1).getLastUpdate());

		// Select statement uit ov_chipkaart_product en ov_chipkaart met id 35283
		System.out.println(
				"\nOVChipkaart_Product rij zoeken uit tabel ov_chipkaart_product en ov_chipkaart met id 35283");
		System.out.println("Kaartnummer: " + ov_pDAO.findByIdInOVChipkaart(35283).getOvproductID());
		System.out.println("Reisproduct status: " + ov_pDAO.findByIdInOVChipkaart(35283).getReisproductStatus());
		System.out
				.println("Kaartnummer: " + ov_pDAO.findByIdInOVChipkaart(35283).getOvchipkaart().getKaartNummer());
		System.out.println("saldo: " + ov_pDAO.findByIdInOVChipkaart(35283).getOvchipkaart().getSaldo());

		// Select statement uit ov_chipkaart_product en ov_chipkaart en product met id = 35283
		System.out.println(
				"\nOVChipkaart_Product rijen zoeken uit tabel ov_chipkaart_product en ov_chipkaart en product met id 35283");
		for (OVChipkaart_Product ov_p : ov_pDAO.findByIdInBothTables(35283)) {
			System.out.println("ov_productID: " + ov_p.getOvproductID());
			System.out.println("Reisproduct status: " + ov_p.getReisproductStatus());
			System.out.println("Kaartnummer: " + ov_p.getOvchipkaart().getKaartNummer());
			System.out.println("saldo: " + ov_p.getOvchipkaart().getSaldo());
			System.out.println("productNaam: " + ov_p.getProduct().getProductNaam() + "\n");
		}
	}
}
