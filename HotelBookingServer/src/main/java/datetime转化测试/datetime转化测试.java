package datetime转化测试;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class datetime转化测试 {
	public static void main(String args[]) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		String database = "jdbc:mysql://localhost:3306/hotelbooking system?serverTimezone=UTC&characterEncoding=utf8&useSSL=true";
		String username = "root";
		String password = "123456";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(database, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String select = "select * from `test`;";
		ps = conn.prepareStatement(select);
		rs = ps.executeQuery();
		Calendar cal = Calendar.getInstance();
		java.util.Date date = new java.util.Date();
		while (rs.next()) {
			if (rs.getString(2) != null) {
				cal.setTime(rs.getTimestamp(2));
			}
			System.out.println(cal.get(Calendar.SECOND));
		}

	}

}
