package api.test;

import java.io.IOException;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import Pojo.AddBookingPlayLoad;
import api.payload.AddBookingPayload;
import api.payload.UpdateBookingPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import utilities.Common_base;
import utilities.PathUrls;

public class CreateBooking extends AddBookingPayload {
	int bookingid;
	@Test
	public void createbooking() throws IOException {
	AddBookingPlayLoad payload = new AddBookingPlayLoad();
	Response response = given().spec(Common_base.RequestSpecification()).body(AddBookingPayload.createBooking(Common_base.getEnvUrl("firstname"), Common_base.getEnvUrl("lastname"))).when().post(PathUrls.CreateBooking.getPathUrl());
	String response1 = response.asString();
	JsonPath js = new JsonPath(response1);
	bookingid = js.get("bookingid");
	String firstname = js.get("booking.firstname");
	String lastname = js.get("booking.lastname");
	boolean depositepaid = js.get("booking.depositpaid");
	System.out.println(depositepaid);
	System.out.println(bookingid);
	assertEquals(response.statusCode(), 200);
	assertEquals(firstname, Common_base.getEnvUrl("firstname"));
	assertEquals(lastname, Common_base.getEnvUrl("lastname"));
	assertNotNull(bookingid);
	assertNotNull(response.body());
	}
	
//	@Test
//	public void UpdateBooking() throws IOException {
//		Response response = given().log().all().spec(Common_base.RequestSpecification()).pathParam("Bookingid", 215).body(UpdateBookingPayload.Updatebooking())
//				.when().put(PathUrls.updateBooking.getPathUrl());
//		String response1 = response.asString();
//		JsonPath js = new JsonPath(response1);
//		System.out.println();
//		assertEquals(response.statusCode(), 200);
//		
//		
//		
}
