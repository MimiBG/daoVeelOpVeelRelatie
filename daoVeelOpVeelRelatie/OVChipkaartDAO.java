package daoVeelOpVeelRelatie;

import java.util.ArrayList;

public interface OVChipkaartDAO {
	public OVChipkaart findById(int id);
	public ArrayList<OVChipkaart> findByReiziger(int id);
	public OVChipkaart insertOVChipkaart(OVChipkaart ovchipkaart);
	public OVChipkaart updateOVChipkaart(OVChipkaart ovchipkaart);
	public OVChipkaart deleteOVChipkaart(int id);
	public OVChipkaart selectOVChipkaartWithReizigerInfo(int id);

}
