package daoVeelOpVeelRelatie;

import java.util.ArrayList;

public interface OVChipkaart_ProductDAO {

	public OVChipkaart_Product findById(int id);

	public OVChipkaart_Product findByIdInOVChipkaart(int id);

	public ArrayList<OVChipkaart_Product> findByIdInBothTables(int id);
}
