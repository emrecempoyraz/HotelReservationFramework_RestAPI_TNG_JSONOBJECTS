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

public class CreateNewBooking extends BaseUrlRestfulBooker {

    @Description("Creates new booking on database")
    @Test
    public void createBooking () {
        specBaseUrl.pathParam("pp1","booking");
        JSONObject requestBody = ReservationGeneral.requestBodyJSON();
        JSONObject expectedResponseBody = ReservationGeneral.responseBodyJSON();
        Response response= given().spec(specBaseUrl).contentType(ContentType.JSON).log().all()
                .when().body(requestBody.toString())
                .post("/{pp1}");
        response.prettyPrint();
        JsonPath responseJpath = response.jsonPath();
        assertEquals(response.getStatusCode(), ResponseCodes.successCode);
        assertEquals(responseJpath.getString("booking.firstname"),expectedResponseBody.getJSONObject("booking").getString("firstname"));
        assertEquals(responseJpath.getString("booking.lastname"),expectedResponseBody.getJSONObject("booking").getString("lastname"));
        assertEquals(responseJpath.getInt("booking.totalprice"),expectedResponseBody.getJSONObject("booking").getInt("totalprice"));
        assertEquals(responseJpath.getBoolean("booking.depositpaid"),expectedResponseBody.getJSONObject("booking").getBoolean("depositpaid"));
        assertEquals(responseJpath.getString("booking.bookingdates.checkin"),expectedResponseBody.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"));
        assertEquals(responseJpath.getString("booking.bookingdates.checkout"),expectedResponseBody.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"));
        assertEquals(responseJpath.getString("booking.additionalneeds"),expectedResponseBody.getJSONObject("booking").getString("additionalneeds"));




    }

}
