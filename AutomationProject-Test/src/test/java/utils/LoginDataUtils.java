package utils;

import org.testng.annotations.DataProvider;

public class LoginDataUtils {

	@DataProvider(name = "login", parallel = true) // Defining name for the data provider
	// 	@DataProvider(name = "login", indices = {1}) - specifying indices will select particular data 0 indices *** indices = {1,2} will select mentioned indices value - 
	//  sequence or range of data cannot be passed
	public String[][] getData() {
		String[][] data = new String[2][2];
		
		data[0][0] = "student";
		data[0][1] = "Password123";
		
		data[1][0] = "student1";
		data[1][1] = "Password12";
		
		return data;
	}
}
