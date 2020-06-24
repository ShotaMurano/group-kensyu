package redhot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import redhot.tool.UniversalTool;

public class PreorderDAO extends MainDAO {

	public PreorderDAO() throws DAOException {
		getConnection();
	}

	public int addPreorderQueue(int stockId, int userId) throws DAOException {
		if (UniversalTool.isUserUsable(getBorrowNum(userId), getPreorderNum(userId))) {

			String sql = "INSERT INTO preorder(stock_id, user_id) VALUES(?,?)";

			try (Connection con = getConnection();
					PreparedStatement st = con.prepareStatement(sql);) {
				st.setInt(1, stockId);
				st.setInt(2, userId);

				int rows = st.executeUpdate();
				return rows;

			} catch (SQLException e) {
				throw new DAOException("存在しない書籍、ユーザIDです。", e);
			} catch (Exception e) {
				throw new DAOException("リソースの開放に失敗しました。", e);
			}
		} else {
			return 0;
		}
	}

}
