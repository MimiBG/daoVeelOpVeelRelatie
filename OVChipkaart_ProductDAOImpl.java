package daoVeelOpVeelRelatie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OVChipkaart_ProductDAOImpl extends OracleBaseDao implements OVChipkaart_ProductDAO {

	@Override
	public OVChipkaart_Product findById(int id) {
		OVChipkaart_Product ov_product = new OVChipkaart_Product();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ov_chipkaart_product WHERE ovproductid = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				int ovproductID = rs.getInt("ovproductid");
				int kaartNummer = rs.getInt("kaartnummer");
				int productNummer = rs.getInt("productnummer");
				String reisproductStatus = rs.getString("reisproductstatus");
				String lastUpdate = rs.getString("lastupdate");
				
				OVChipkaart kaart = new OVChipkaart();
				Product product = new Product();
				
				ov_product.setOvproductID(ovproductID);
				ov_product.setReisproductStatus(reisproductStatus);
				ov_product.setLastUpdate(lastUpdate);
				
				kaart.setKaartNummer(kaartNummer);
				product.setProductNummer(productNummer);
				
				ov_product.setOvchipkaart(kaart);
				ov_product.setProduct(product);
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return ov_product;
	}

	@Override
	public OVChipkaart_Product findByIdInOVChipkaart(int id) {
		OVChipkaart_Product ov_product = new OVChipkaart_Product();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT ov_c_p.ovproductid, ov_c_p.reisproductstatus, ov_c.kaartnummer, ov_c.saldo " + 
					"FROM ov_chipkaart_product ov_c_p, ov_chipkaart ov_c " + 
					"WHERE ov_c.kaartnummer = ov_c_p.kaartnummer AND ov_c.kaartnummer = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				int ovproductID = rs.getInt("ovproductid");
				String reisproductStatus = rs.getString("reisproductstatus");
				int kaartNummer = rs.getInt("kaartnummer");
				double saldo = rs.getDouble("saldo");
				
				OVChipkaart kaart = new OVChipkaart();
				ov_product.setOvproductID(ovproductID);
				ov_product.setReisproductStatus(reisproductStatus);
				kaart.setKaartNummer(kaartNummer);
				kaart.setSaldo(saldo);
				ov_product.setOvchipkaart(kaart);
			}
			rs.close();
			stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return ov_product;
	}
	@Override
	public ArrayList<OVChipkaart_Product> findByIdInBothTables(int id) {
		ArrayList<OVChipkaart_Product> ov_pList = new ArrayList<OVChipkaart_Product>();
		try {
			PreparedStatement stmt = conn.prepareStatement("SELECT ov_c_p.ovproductid, ov_c_p.reisproductstatus, ov_c.kaartnummer, ov_c.saldo, p.productnaam " + 
					"FROM ov_chipkaart_product ov_c_p, ov_chipkaart ov_c, product p " + 
					"WHERE ov_c.kaartnummer = ov_c_p.kaartnummer AND ov_c_p.kaartnummer = ?");
			
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				OVChipkaart_Product ov_product = new OVChipkaart_Product();
				int ovproductID = rs.getInt("ovproductid");
				String reisproductStatus = rs.getString("reisproductstatus");
				int kaartNummer = rs.getInt("kaartnummer");
				double saldo = rs.getDouble("saldo");
				String productNaam = rs.getString("productnaam");
				
				OVChipkaart kaart = new OVChipkaart();
				Product p = new Product();
				ov_product.setOvproductID(ovproductID);
				ov_product.setReisproductStatus(reisproductStatus);
				kaart.setKaartNummer(kaartNummer);
				kaart.setSaldo(saldo);
				p.setProductNaam(productNaam);
				ov_product.setOvchipkaart(kaart);
				ov_product.setProduct(p);
				ov_pList.add(ov_product);
			}
			rs.close();
			stmt.close();
			
		} catch ( SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return ov_pList;
	}

	
}
