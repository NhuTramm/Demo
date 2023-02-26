package personnelManagement;

import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	Conn() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			c = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=PersonnelManagementSystem2;user=sa;password=T0n6o2o4o;encrypt=false");
			s = c.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
