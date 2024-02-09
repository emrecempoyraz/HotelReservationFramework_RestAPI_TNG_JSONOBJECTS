package TestData;

import org.json.JSONObject;

public class ReservationGeneral {

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


    public static JSONObject requestBodyJSON() {
        JSONObject requestBody = new JSONObject();
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2013-02-23");
        bookingDates.put("checkout", "2014-10-23");
        requestBody.put("firstname", "Sally");
        requestBody.put("lastname", "Brown");
        requestBody.put("totalprice", "111");
        requestBody.put("depositpaid", true);
        requestBody.put("bookingdates", bookingDates);
        requestBody.put("additionalneeds", "Breakfast");
        return requestBody;
    }

    public static JSONObject responseBodyJSON() {
        JSONObject responseBody = new JSONObject();
        JSONObject bookingBody = requestBodyJSON();
        responseBody.put("bookingid", 24);
        responseBody.put("booking", bookingBody);
        return responseBody;
    }
}

