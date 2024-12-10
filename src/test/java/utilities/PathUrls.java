package utilities;

public enum PathUrls {
	
	CreateBooking("/booking"),
	generatetoken("/auth"),
	updateBooking("/booking/{Bookingid}");

	private String url;

	private PathUrls(String url) {
		this.url = url;
	}
	
	public String getPathUrl() {
		return url;
	}
}
