


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Baglanti {
	Connection conn;
	Statement st;
	ResultSet rs;
	

	@BeforeTest
	public void databaseBaglan() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business","root","2135");
		st=conn.createStatement();
		//rs= st.executeQuery("use Business;");
		
		System.out.println("Database basari ile baglanildi");
		System.out.println("---------------------------------------------------------");
	}
	
	
	@AfterTest
	public void databaseKapat() throws SQLException {
		conn.close();
	System.out.println("--------------------------------------------------------------");	
	System.out.println("Database basari ile kapatildi");
	}
	
	
	
	

}
