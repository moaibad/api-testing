import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAPI {

    String token = "662e5b1dbb70a783532595b0";

    @Test
    void testGetList(){

        Response response = RestAssured.given()
                .header("app-id", token)
                .get("https://dummyapi.io/data/v1/user");

        // System.out.println("Response : " + response.asString());
        // System.out.println("Status : " + response.getStatusCode());
        // System.out.println("Body : " + response.getBody().asString());
        // System.out.println("Time taken : " + response.getTime());
        // System.out.println("Header : " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
