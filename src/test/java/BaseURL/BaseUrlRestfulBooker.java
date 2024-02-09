package BaseURL;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseUrlRestfulBooker {

    protected RequestSpecification specBaseUrl ;

    @BeforeTest
    public void setUp () {

        specBaseUrl = new RequestSpecBuilder()
                .addHeader("Cookie","token=abc123")
                .addHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .addHeader("Accept","application/json")
                .setBaseUri("https://restful-booker.herokuapp.com")
                .build();
    }
}
