import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateOneJsonFile extends Baglanti {
	
	@Test
	public void deneme() throws JsonGenerationException, JsonMappingException, IOException, SQLException {
		CustomerInfo cus =new CustomerInfo();
		rs=st.executeQuery("select * from CustomerInfo where location = 'Asia';");
		
		while(rs.next()) {
			
			
			cus.setCourseName(rs.getString(1));
			cus.setPurchasedDate(rs.getString(2));
			cus.setAmount(rs.getInt(3));
			cus.setLocation(rs.getString(4));
			
		}
		
		
		ObjectMapper obj =new ObjectMapper();
		obj.writeValue(new File(System.getProperty("user.dir")+"\\Customer_info.json"),cus);
		
		System.out.println(System.getProperty("user.dir")+"\\Customer_info.json");
	}
	

}
