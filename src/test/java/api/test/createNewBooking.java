package api.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.google.gson.Gson;

import Pojo.Booking;
import Pojo.BookingResponse;
import Pojo.Bookingdates;
import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class createNewBooking {

	RequestSpecification request;
	Response response;
	ValidatableResponse validatableresponse;

	@Test
	public void booking_create() {

		Booking book = new Booking();
		book.setFirstname("James");
		book.setLastname("David");
		book.setTotalprice("3000");
		book.setDepositpaid(true);
		book.setAdditionalneeds("Breakfast");

		Bookingdates dates = new Bookingdates();
		dates.setCheckin("2025-02-23");
		dates.setCheckout("2025-02-25");
		book.setBookingdates(dates);

		Gson req = new Gson();
		String bookingRequest = req.toJson(book);

		request = given().log().all().baseUri("https://restful-booker.herokuapp.com").basePath("/booking")
				.contentType(ContentType.JSON).body(bookingRequest);
		response = request.when().post();

		String Requestresponse = response.asString();

		validatableresponse = response.then().log().all();
		validatableresponse.statusCode(200);

		BookingResponse bookingresponse = req.fromJson(Requestresponse, BookingResponse.class);
		System.out.println(bookingresponse.getBookingid());
		System.out.println(bookingresponse.getBooking().getFirstname());
		System.out.println(bookingresponse.getBooking().getBookingdates());

		assertThat(bookingresponse.getBookingid()).isNotNull().isNotZero().isNotZero();
		assertThat(bookingresponse.getBooking().getFirstname()).isNotEmpty().isNotNull().isAlphabetic();

	}

}