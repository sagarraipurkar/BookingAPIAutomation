package api.test;

import java.io.IOException;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import utilities.Common_base;

public class UpdateBooking {

	public static void main(String[] args) throws IOException {
//	 Generate_Token tok = new Generate_Token();
//	 String token = tok.e_token();
		RestAssured.baseURI = Common_base.getEnvUrl("baseurl");

		String response = given().log().all().auth().basic("admin", "password123")
				.header("Content-Type", "application/json")
				.body("{\r\n" + "    \"firstname\" : \"Sagar\",\r\n" + "    \"lastname\" : \"Doe\",\r\n"
						+ "    \"totalprice\" : 122,\r\n" + "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-21\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
				.when().put("/booking/620").then().log().all().extract().response().toString();

	}
}