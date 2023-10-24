package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			st= conn.prepareStatement(
					"delete from department "
					+ "where "
					+ "Id = ?");
			st.setInt(1, 5);
			
			int rowsAfecceted = st.executeUpdate();
			
			System.out.println("Done! rows affected: " + rowsAfecceted);
			
		}catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
