package daoVeelOpVeelRelatie;

import java.sql.SQLException;

public interface ProductDAO {
	public Product findById(int id) throws SQLException;

}
