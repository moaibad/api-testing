import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GETMethodTest {

    String validToken = "662e6015bb70a73efe2595f9";
    String invalidToken = "token0412";

    @Test
    void testCase01GetRequestWithoutAppId(){

        Response response = RestAssured.given()
                .header("app-id", "")
                .get("https://dummyapi.io/data/v1/user/");

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 403);

        // Memeriksa response body
        String expectedResponseBody = "APP_ID_MISSING";
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase02GetRequestWithInvalidAppId(){

        Response response = RestAssured.given()
                .header("app-id", invalidToken)
                .get("https://dummyapi.io/data/v1/user/");

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 403);

        // Memeriksa response body
        String expectedResponseBody = "APP_ID_NOT_EXIST";
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase03GetRequestWithValidAppId(){

        Response response = RestAssured.given()
                .header("app-id", validToken)
                .get("https://dummyapi.io/data/v1/user/");

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Memeriksa response body
        String expectedResponseBody = "{\"data\":["
                + "{"
                    + "\"id\":\"60d0fe4f5311236168a109ca\","
                    + "\"title\":\"ms\","
                    + "\"firstName\":\"Sara\","
                    + "\"lastName\":\"Andersen\","
                    + "\"picture\":\"https://randomuser.me/api/portraits/women/58.jpg\""
                + "},";
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase04GetAllUser(){

        Response response = RestAssured.given()
                .header("app-id", validToken)
                .get("https://dummyapi.io/data/v1/user/");

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Memeriksa response body
        String expectedResponseBody = "{\"data\":["
                + "{"
                    + "\"id\":\"60d0fe4f5311236168a109ca\","
                    + "\"title\":\"ms\","
                    + "\"firstName\":\"Sara\","
                    + "\"lastName\":\"Andersen\","
                    + "\"picture\":\"https://randomuser.me/api/portraits/women/58.jpg\""
                + "},";
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase05GetUserWithRegisteredId(){

        String userId = "60d0fe4f5311236168a109cc";

        Response response = RestAssured.given()
                .header("app-id", validToken)
                .get("https://dummyapi.io/data/v1/user/" + userId);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Memeriksa response body
        String expectedResponseBody = "{"
                    + "\"id\":\"60d0fe4f5311236168a109cc\","
                    + "\"title\":\"ms\","
                    + "\"firstName\":\"Adina\","
                    + "\"lastName\":\"Barbosa\","
                    + "\"picture\":\"https://randomuser.me/api/portraits/med/women/28.jpg\","
                    + "\"gender\":\"female\","
                    + "\"email\":\"edina.barbosa@example.com\","
                    + "\"dateOfBirth\":\"1952-09-03T13:27:29.424Z\","
                    + "\"phone\":\"(64) 5796-9260\","
                    + "\"location\":{"
                        + "\"street\":\"8750, Rua Carlos Gomes\","
                        + "\"city\":\"Recife\","
                        + "\"state\":\"CearÃ¡\","
                        + "\"country\":\"Brazil\","
                        + "\"timezone\":\"+1:00\""
                    + "},"
                    + "\"registerDate\":\"2021-06-21T21:02:07.719Z\","
                    + "\"updatedDate\":\"2021-06-21T21:02:07.719Z\""
                + "}";
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase06GetUserWithNotRegisteredId(){

        String userId = "60d0fe4f5311236268a109cd";

        Response response = RestAssured.given()
                .header("app-id", validToken)
                .get("https://dummyapi.io/data/v1/user/" + userId);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 404);

        // Memeriksa response body
        String expectedResponseBody = "RESOURCE_NOT_FOUND";
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }

    @Test
    void testCase07GetUserWithInvalidIdFormat(){

        String userId = "60d0fe4f5311236347985465789342678524";

        Response response = RestAssured.given()
                .header("app-id", validToken)
                .get("https://dummyapi.io/data/v1/user/" + userId);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400);

        // Memeriksa response body
        String expectedResponseBody = "PARAMS_NOT_VALID";
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(expectedResponseBody));
    }
}
