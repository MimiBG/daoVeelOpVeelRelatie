package daoVeelOpVeelRelatie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAOImpl extends OracleBaseDao implements ProductDAO {
	
	public ProductDAOImpl() throws SQLException {
		getConnection();
	}
	
	@Override
	public Product findById(int id) throws SQLException {
		Product p = new Product();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM PRODUCT WHERE productnummer = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				p.setProductNummer(rs.getInt("productnummer"));
				p.setProductNaam(rs.getString("productnaam"));
				p.setBeschrijving(rs.getString("beschrijving"));
				p.setPrijs(rs.getDouble("prijs"));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		return p;
	}

}
