package redhot.dao;

import java.sql.Connection;

public class BookManageDAO extends MainDAO {
	private Connection con;

	public BookManageDAO() throws DAOException {
		getConnection();
	}

}
