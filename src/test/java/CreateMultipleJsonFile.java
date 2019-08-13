import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateMultipleJsonFile extends Baglanti {
	
	@Test
	public void denem()throws JsonGenerationException, JsonMappingException, IOException, SQLException {
		
		
		ArrayList<CustomerInfo> aList = new ArrayList<CustomerInfo>();
		
		rs=st.executeQuery("select * from CustomerInfo where location = 'Asia';");
		
		while(rs.next()) {
			CustomerInfo cus =new CustomerInfo();
			cus.setCourseName(rs.getString(1));
			cus.setPurchasedDate(rs.getString(2));
			cus.setAmount(rs.getInt(3));
			cus.setLocation(rs.getString(4));
			aList.add(cus);
			
		}
		
		for(int i=0; i<aList.size(); i++) {
			ObjectMapper obj =new ObjectMapper();
			obj.writeValue(new File(System.getProperty("user.dir")+"\\Customer_info"+(i+1)+".json"),aList.get(i));
		
	}

}
}