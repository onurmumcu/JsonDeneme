
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.google.gson.Gson;

public class CreateNestedJson extends Baglanti {

	@Test
	public void deneme() throws SQLException, JsonGenerationException, JsonMappingException, IOException {

		JSONArray jsonArr = new JSONArray();

		ArrayList<CustomerInfo> aList = new ArrayList<CustomerInfo>();

		rs = st.executeQuery("select * from CustomerInfo where location = 'Asia';");

		while (rs.next()) {
			CustomerInfo cus = new CustomerInfo();
			cus.setCourseName(rs.getString(1));
			cus.setPurchasedDate(rs.getString(2));
			cus.setAmount(rs.getInt(3));
			cus.setLocation(rs.getString(4));
			aList.add(cus);

		}

		for (int i = 0; i < aList.size(); i++) {
			Gson g = new Gson();
			String jsonString = g.toJson(aList.get(i));
			jsonArr.add(jsonString);

		}
		JSONObject jsonObb = new JSONObject();
		jsonObb.put("data", jsonArr);
		
		String unescape = StringEscapeUtils.unescapeJava(jsonObb.toString());
		
		System.out.println(jsonObb.toJSONString());
		System.out.println(unescape);
		
	String bir =unescape.replace("\"{","{");
String iki = bir.replace("}\"", "}");
System.out.println(iki);
	}

}
