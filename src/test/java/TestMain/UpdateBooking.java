package TestMain;

import BaseURL.BaseUrlRestfulBooker;
import TestData.ReservationGeneral;
import TestData.ResponseCodes;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdateBooking extends BaseUrlRestfulBooker {

    @Description("Updates Booking information")
    @Test
    public void updateBooking () {
        specBaseUrl.pathParams("pp1","booking","pp2",8);
        JSONObject requestBody = ReservationGeneral.requestBodyJSON();
        JSONObject expectedResponseBody = ReservationGeneral.requestBodyJSON();
        Response response= given().spec(specBaseUrl).contentType(ContentType.JSON).log().all()
                .when().body(requestBody.toString())
                .put("{pp1}/{pp2}");
        response.prettyPrint();
        JsonPath responseJpath = response.jsonPath();
        assertEquals(response.getStatusCode(), ResponseCodes.successCode);
        assertEquals(responseJpath.getString("firstname"),expectedResponseBody.getString("firstname"));
        assertEquals(responseJpath.getString("lastname"),expectedResponseBody.getString("lastname"));
        assertEquals(responseJpath.getInt("totalprice"),expectedResponseBody.getInt("totalprice"));
        assertEquals(responseJpath.getBoolean("depositpaid"),expectedResponseBody.getBoolean("depositpaid"));
        assertEquals(responseJpath.getString("bookingdates.checkin"),expectedResponseBody.getJSONObject("bookingdates").getString("checkin"));
        assertEquals(responseJpath.getString("bookingdates.checkout"),expectedResponseBody.getJSONObject("bookingdates").getString("checkout"));
        assertEquals(responseJpath.getString("additionalneeds"),expectedResponseBody.getString("additionalneeds"));
    }

}

