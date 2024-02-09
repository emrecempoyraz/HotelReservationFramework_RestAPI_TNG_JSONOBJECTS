package TestMain;

import BaseURL.BaseUrlRestfulBooker;
import TestData.ResponseCodes;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookings extends BaseUrlRestfulBooker {

    @Description("Request all bookings from database")
    @Test
    public void getBookings () {
        specBaseUrl.pathParam("pp1","booking");
        Response response = given().spec(specBaseUrl).log().all().when().get("{pp1}");
        Assert.assertEquals(response.getStatusCode(), ResponseCodes.successCode);
    }
}
