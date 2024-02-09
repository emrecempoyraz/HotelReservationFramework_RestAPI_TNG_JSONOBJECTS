package TestMain;

import BaseURL.BaseUrlRestfulBooker;
import TestData.ResponseCodes;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import TestData.ReservationGeneral ;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GetBookingByID extends BaseUrlRestfulBooker {

    @Description("Request bookings by id with details")
    @Test
    public void getBookingID () {
        specBaseUrl.pathParams("pp1","booking","pp2","5");
        JSONObject expectedResponseBody = ReservationGeneral.requestBodyJSON();
        Response response = given().spec(specBaseUrl).when().get("{pp1}/{pp2}");
        response.prettyPrint();
        JsonPath responseJpath = response.jsonPath();
        assertEquals(response.getStatusCode(),ResponseCodes.successCode);
        assertEquals(response.getContentType(),ResponseCodes.contentType);
        assertEquals(responseJpath.getString("firstname"),expectedResponseBody.getString("firstname"));
        assertEquals(responseJpath.getString("lastname"),expectedResponseBody.getString("lastname"));
        assertEquals(responseJpath.getInt("totalprice"),expectedResponseBody.getInt("totalprice"));
        assertEquals(responseJpath.getBoolean("depositpaid"),expectedResponseBody.getBoolean("depositpaid"));
        assertEquals(responseJpath.getString("bookingdates.checkin"),expectedResponseBody.getJSONObject("bookingdates").getString("checkin"));
        assertEquals(responseJpath.getString("bookingdates.checkout"),expectedResponseBody.getJSONObject("bookingdates").getString("checkout"));
        assertEquals(responseJpath.getString("additionalneeds"),expectedResponseBody.getString("additionalneeds"));

    }



    /*
    "firstname": "Mary",
    "lastname": "Smith",
    "totalprice": 600,
    "depositpaid": false,
    "bookingdates": {
        "checkin": "2023-05-05",
        "checkout": "2024-01-01"
    }
     */
}
