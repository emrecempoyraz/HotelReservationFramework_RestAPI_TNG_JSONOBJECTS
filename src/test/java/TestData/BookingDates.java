package TestData;

import org.json.JSONObject;

public class BookingDates {

    /*
    {
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
}
     */
   public static JSONObject bookingDatesBody (String checkin,String checkout) {
      JSONObject bookingDates = new JSONObject();
      bookingDates.put("checkin",checkin);
      bookingDates.put("checkout",checkout);
      return bookingDates;
   }
}
