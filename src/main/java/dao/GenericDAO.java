package dao;

import util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO stands for Data Access Object.
 * 
 * @param <T>
 */
public abstract class GenericDAO<T> {

	protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

	public List<T> executeQuery(String query) {
		List<T> list = new ArrayList<>();
		try (Connection conn = JDBCUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {
				list.add(mapResultSetToEntity(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int executeUpdate(String query) {
		try (Connection conn = JDBCUtil.getConnection(); Statement stmt = conn.createStatement()) {
			return stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
