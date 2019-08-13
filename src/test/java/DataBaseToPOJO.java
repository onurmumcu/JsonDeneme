import java.sql.SQLException;


import org.testng.annotations.Test;

public class DataBaseToPOJO extends Baglanti {
	
	
@Test
public void deneme() throws SQLException {
	rs=st.executeQuery("select * from CustomerInfo where location = 'Asia';");
		while(rs.next()) {
			CustomerInfo cus =new CustomerInfo();
			
			cus.setCourseName(rs.getString(1));
			cus.setPurchasedDate(rs.getString(2));
			cus.setAmount(rs.getInt(3));
			cus.setLocation(rs.getString(4));
			
			System.out.println(cus.getCourseName());
			System.out.println(cus.getPurchasedDate());
			System.out.println(cus.getAmount());
			System.out.println(cus.getLocation());
		}
		
}	
		
	}


