import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseRead {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=null;
	conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "2135");
	Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery("select * from CustomerInfo where location = 'Asia';");
	
	
	while(rs.next()) {
	System.out.println(rs.getString(1));
	System.out.println(rs.getString(2));
	System.out.println(rs.getInt(3));
	System.out.println(rs.getString(4));
}
	
	
	
	
}
}