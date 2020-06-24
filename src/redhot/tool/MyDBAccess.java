package redhot.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyDBAccess {

	private String driver;
	private String url;
	private String user;
	private String password;
	private Connection con;
	private Statement st;
	private ResultSet rs;

	/**
	 * コンストラクタ
	 * @param driver ドライバー
	 * @param url URL
	 * @param user ユーザー名
	 * @param password パスワード
	 */
	public MyDBAccess(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}

	/**
	 * 引数なしのコンストラクタ
	 * 既定値を使用する
	 */
	public MyDBAccess() {
		driver = "org.postgresql.Driver";
		url = "jdbc:postgresql:webbook";
		user = "student";
		password = "himitu";
	}

	/**
	 * データベースへの接続を行う
	 */
	public synchronized void open() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		st = con.createStatement();
	}

	/**
	 * SQL 文を実行した結果の ResultSet を返す
	 * @param sql SQL 文
	 */
	public ResultSet getResultSet(String sql) throws Exception {
		if (st.execute(sql)) {
			return st.getResultSet();
		}
		return null;
	}

	/**
	 * SQL 文の実行
	 * @param sql SQL 文
	 */
	public void execute(String sql) throws Exception {
		st.execute(sql);
	}

	/**
	 * データベースへのコネクションのクローズ
	 */
	public synchronized void close() throws Exception {
		if (rs != null)
			rs.close();
		if (st != null)
			st.close();
		if (con != null)
			con.close();
	}
}