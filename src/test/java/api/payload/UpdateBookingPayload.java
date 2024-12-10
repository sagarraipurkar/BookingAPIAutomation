package api.payload;

import Pojo.AddBookingPlayLoad;

public class UpdateBookingPayload {

	public static AddBookingPlayLoad Updatebooking() {

		AddBookingPlayLoad payload = new AddBookingPlayLoad();
		payload.setFirstname("John");
		payload.setLastname("Lamo");
		payload.setDepositpaid(true);
		return payload;
	}
}
