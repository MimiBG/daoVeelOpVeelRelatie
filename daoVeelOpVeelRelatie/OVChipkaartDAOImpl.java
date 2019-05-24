package daoVeelOpVeelRelatie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OVChipkaartDAOImpl extends OracleBaseDao implements OVChipkaartDAO {

	@Override
	public OVChipkaart findById(int id) {
		OVChipkaart kaart = new OVChipkaart();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM OV_CHIPKAART WHERE KAARTNUMMER = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				kaart.setKaartNummer(rs.getInt("KAARTNUMMER'"));
				kaart.setGeldigTot(rs.getString("GELDIGTOT"));
				kaart.setKlasse(rs.getInt("KLASSE"));
				kaart.setSaldo(rs.getDouble("SALDO"));
				kaart.setReizigerID(rs.getInt("REIZIGERID"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return kaart;
	}

	@Override
	public ArrayList<OVChipkaart> findByReiziger(int id) {
		ArrayList<OVChipkaart> OVChipkaartLijst = new ArrayList<OVChipkaart>();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM OV_CHIPKAART WHERE reizigerID = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				int kaartNummer = rs.getInt("KAARTNUMMER");
				String geldigTot = rs.getString("GELDIGTOT");
				int klasse = rs.getInt("KLASSE");
				double saldo = rs.getDouble("SALDO");
				int reizigerID = rs.getInt("REIZIGERID");
				OVChipkaart kaart = new OVChipkaart(kaartNummer, geldigTot, klasse, saldo, reizigerID);
				OVChipkaartLijst.add(kaart);
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return OVChipkaartLijst;
	}

	@Override
	public OVChipkaart insertOVChipkaart(OVChipkaart ovchipkaart) {
		try {
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO OV_CHIPKAART VALUES (?,?,?,?,?");
			stmt.setInt(1, ovchipkaart.getKaartNummer());
			stmt.setString(2, ovchipkaart.getGeldigTot());
			stmt.setInt(3, ovchipkaart.getKlasse());
			stmt.setDouble(4, ovchipkaart.getSaldo());
			stmt.setLong(5, ovchipkaart.getReizigerID());
			stmt.execute();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return ovchipkaart;
	}

	@Override
	public OVChipkaart updateOVChipkaart(OVChipkaart ovchipkaart) {
		try {
			PreparedStatement stmt = conn.prepareStatement("UPDATE OV_CHIPKAART SET GELDIGTOT = ?, klasse = ?, saldo = ?, reizigerid = ? WHERE kaartnummer = ?");
			stmt.setString(1, ovchipkaart.getGeldigTot());
			stmt.setInt(2, ovchipkaart.getKlasse());
			stmt.setDouble(3, ovchipkaart.getSaldo());
			stmt.setLong(4, ovchipkaart.getReizigerID());
			stmt.setLong(5, ovchipkaart.getKaartNummer());
			stmt.execute();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return ovchipkaart;
	}

	@Override
	public OVChipkaart deleteOVChipkaart(int id) {
		OVChipkaart kaart = new OVChipkaart();
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM ov_chipkaart WHERE kaartnummer = ?");
			stmt.setInt(1, id);
			stmt.execute();
			stmt.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		kaart.setKaartNummer(id);
		return kaart;
	}

	@Override
	public OVChipkaart selectOVChipkaartWithReizigerInfo(int id) {
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT r.reizigerid, r.achternaam, ov.kaartnummer FROM reiziger r, ov_chipkaart ov WHERE r.reizigerid = ov.reizigerid and r.reizigerid = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int reizigerID = rs.getInt("reizigerid");
				String achternaam = rs.getString("achternaam");
				int kaartNummer = rs.getInt("kaartnummer");
				OVChipkaart kaart = new OVChipkaart();
				Reiziger reiziger = new Reiziger();
				kaart.setReizigerID(reizigerID);
				reiziger.setAchternaam(achternaam);
				kaart.setReiziger(reiziger);
				kaart.setKaartNummer(kaartNummer);
				return kaart;
			}
			rs.close();
			stmt.close();
		} catch ( SQLException sqle) {
			sqle.printStackTrace();
		}
		return null;
	}

}
