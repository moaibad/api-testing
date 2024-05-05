import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DELETEMethodTest {

    String validToken = "663783f02e77a585c142311d";
    String invalidToken = "token0412";

    @Test
    void testCase01DeleteRequestWithoutAppId() {

        String userId = "60d0fe4f5311236168a109fc";

        Response response = RestAssured.given()
                .header("app-id", "")
                .delete("https://dummyapi.io/data/v1/user/" + userId);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 403);

        // Memeriksa response body
        String expectedResponseBody = "APP_ID_MISSING";
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase02DeleteRequestWithInvalidAppId() {

        String userId = "60d0fe4f5311236168a109fc";

        Response response = RestAssured.given()
                .header("app-id", invalidToken)
                .delete("https://dummyapi.io/data/v1/user/" + userId);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 403);

        // Memeriksa response body
        String expectedResponseBody = "APP_ID_NOT_EXIST";
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase03DeleteRequestWithValidAppId() {

        String userId = "60d0fe4f5311236168a109d9";

        Response response = RestAssured.given()
                .header("app-id", validToken)
                .delete("https://dummyapi.io/data/v1/user/" + userId);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Memeriksa response body
        String expectedResponseBody = "60d0fe4f5311236168a109d9";

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase04DeleteRequestWithRegisteredId() {

        String userId = "60d0fe4f5311236168a109db";

        Response response = RestAssured.given()
                .header("app-id", validToken)
                .delete("https://dummyapi.io/data/v1/user/" + userId);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Memeriksa response body
        String expectedResponseBody = "60d0fe4f5311236168a109db";

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase05DeleteRequestWithNotRegisteredId() {

        String userId = "60d0fe4f5311336168a109cc";

        Response response = RestAssured.given()
                .header("app-id", validToken)
                .delete("https://dummyapi.io/data/v1/user/" + userId);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);

        // Memeriksa response body
        String expectedResponseBody = "RESOURCE_NOT_FOUND";

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase06DeleteRequestWithInvalidFormatId() {

        String userId = "60d0fe4f5311236347985465789342678524";

        Response response = RestAssured.given()
                .header("app-id", validToken)
                .delete("https://dummyapi.io/data/v1/user/" + userId);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);

        // Memeriksa response body
        String expectedResponseBody = "PARAMS_NOT_VALID";

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

}