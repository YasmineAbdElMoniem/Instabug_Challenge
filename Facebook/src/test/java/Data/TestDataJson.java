package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TestDataJson {

	public String First_Name;
	public String Last_Name;
	public String Phone_Number;
	public String Password;
	public String Day;
	public String Month;
	public String Year;

	public void JsonReader() throws FileNotFoundException, IOException, ParseException {
		String filePath = System.getProperty("user.dir") + "/src/test/java/Data/TestData.json";
		File srcFile = new File(filePath);

		JSONParser parser = new JSONParser();
		JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

		for (Object jsonObj : jarray) {
			JSONObject Test = (JSONObject) jsonObj;
			
			First_Name = (String) Test.get("Fist_Name");			
			System.out.println(First_Name);
			Last_Name = (String) Test.get("Last_Name");			
			System.out.println(First_Name);
			Phone_Number = (String) Test.get("Phone_Number");			
			System.out.println(First_Name);
			Password = (String) Test.get("Password");			
			System.out.println(First_Name);
			Day = (String) Test.get("Day");			
			System.out.println(First_Name);
			Month = (String) Test.get("Month");			
			System.out.println(First_Name);
			Year = (String) Test.get("Year");			
			System.out.println(First_Name);
		}
	}


}
