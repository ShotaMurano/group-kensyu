package redhot.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainDAO {

	private Connection con;
	final private String url = "jdbc:postgresql:webbook";
	final private String user = "student";
	final private String pass = "himitu";
	private int id;
	private int stockid;

	protected Connection getConnection() throws DAOException {
		if (con != null) {
			return con;
		}
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (Exception e) {
			throw new DAOException("接続に失敗しました", e);
		}
	}

	public int getBorrowNum(int id) {
		this.id = id;
		return this.id;
	}

	public int getPreorderNum(int id) {
		this.id = id;
		return this.id;
	}

	public boolean isLate() {
		return true;
	}

	public String getBookStatus(int stockid) {
		this.stockid = id;
		return "hello";
	}
}
