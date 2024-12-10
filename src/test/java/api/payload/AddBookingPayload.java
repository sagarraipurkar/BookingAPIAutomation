package api.payload;

import Pojo.AddBookingPlayLoad;
import Pojo.CheckInCheckOut;

public class AddBookingPayload {
	
	
	public static String addbookingpayload() {

	String paylod = "{\r\n"
			+ "    \"firstname\" : \"John\",\r\n"
			+ "    \"lastname\" : \"Doe\",\r\n"
			+ "    \"totalprice\" : \"10000\",\r\n"
			+ "    \"depositpaid\" : true,\r\n"
			+ "    \"bookingdates\" : {\r\n"
			+ "        \"checkin\" : \"2025-02-23\",\r\n"
			+ "        \"checkout\" : \"2025-02-29\"\r\n"
			+ "    },\r\n"
			+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
			+ "}";
	return paylod;
	}
	
	public static AddBookingPlayLoad createBooking(String firstname, String lastname) {
		AddBookingPlayLoad payload = new AddBookingPlayLoad();
		payload.setFirstname(firstname);
		payload.setLastname(lastname);
		payload.setDepositpaid(true);
		payload.setTotalprice(4000);
		
		CheckInCheckOut dates = new CheckInCheckOut();
		dates.setCheckin("2025-01-01");
		dates.setCheckout("2015-01-23");
		
		payload.setBookingdates(dates);
		payload.setAdditionalneeds("lunch");
		return payload;
	}
	
}
