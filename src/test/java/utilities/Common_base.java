package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import api.test.Generate_Token;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class Common_base {
	public static RequestSpecification request;
	static Generate_Token tok = new Generate_Token();
	static String token = "";
	
	public static String getEnvUrl(String key) throws IOException {
		
		FileInputStream fs = new FileInputStream("C:\\Eclipse New\\NewWorkSpace\\BookingApi\\src\\test\\java\\EnviormentUrls.properties");
		Properties prop = new Properties();
		prop.load(fs);
		return prop.getProperty(key);
		
	}
	
	public static RequestSpecification RequestSpecification() throws IOException {
		
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		request = new RequestSpecBuilder().setBaseUri(Common_base.getEnvUrl("baseurl")).addHeader("Content-Type", "application/json")
				.addHeader("Cookie", "token=" + getToken())
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return request;
	}
	
	  public static String getToken() throws IOException {
	        if (token.isEmpty()) {
	            token = tok.e_token(); // Fetch the token from Generate_Token class
	        }
	        return token;
	    }
}