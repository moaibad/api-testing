import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateMethodTest {
    String validToken = "662e5afebb70a708672595ab";
    String invalidToken = "token041";
}

@Test
void testCase01CreateRequestWithoutAppId(){
    // Data requestBody
    String requestBody = "{\"firstName\":\"Cinderella\",\"lastName\":\"Ella\",\"email\":\"cinderella@example.com\"}";

    Response response = RestAssured.given()
            .header("Content-Type", "application/json")
            .header("app-id", "") // App-id diset kosong
            .body(requestBody)
            .post("https://dummyapi.io/data/v1/users");

    // Memeriksa response status code
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 403);

    // Memeriksa response body
    String expectedResponseBody = "APP_ID_MISSING";
    String responseBody = response.getBody().asString();
    Assert.assertTrue(responseBody.contains(expectedResponseBody));
}
    
@Test
void testCase02CreateRequestWithInvalidAppId(){
    // Data requestBody
    String requestBody = "{\"firstName\":\"Cinderella\",\"lastName\":\"Ella\",\"email\":\"cinderella@example.com\"}";

    Response response = RestAssured.given()
            .header("Content-Type", "application/json")
            .header("app-id", invalidToken) // App-id diset invalidToken
            .body(requestBody)
            .post("https://dummyapi.io/data/v1/users");

    // Memeriksa response status code
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 403);

    // Memeriksa response body
    String expectedResponseBody = "APP_ID_MISSING";
    String responseBody = response.getBody().asString();
    Assert.assertTrue(responseBody.contains(expectedResponseBody));
}
        
@Test
void testCase03CreateUserWithValidAppId() {
    // Data requestBody
    String requestBody = "{\"firstName\":\"Cinderella\",\"lastName\":\"Ella\",\"email\":\"cinderella@example.com\"}";

    // Token yang valid
    String validToken = "token_yang_valid";

    Response response = RestAssured.given()
            .header("Content-Type", "application/json")
            .header("app-id", validToken) // App-id diset dengan token valid
            .body(requestBody)
            .post("https://dummyapi.io/data/v1/users");

    // Memeriksa response status code
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 200);

    // Memeriksa struktur response body
    String responseBody = response.getBody().asString();
    JsonPath jsonPath = new JsonPath(responseBody);
    Assert.assertTrue(jsonPath.get("id") != null);
    Assert.assertEquals(jsonPath.get("title"), "ms");
    Assert.assertEquals(jsonPath.get("firstName"), "Cinderella");
    Assert.assertEquals(jsonPath.get("lastName"), "Ella");
}

@Test
@Test
void testCase04CreateUserWithEmailNotInDatabase() {
    // Data requestBody
    String requestBody = "{\"firstName\":\"Cinderella\",\"lastName\":\"Ella\",\"email\":\"ella@example.com\"}";

    // Token yang valid
    String validToken = "token_yang_valid";

    Response response = RestAssured.given()
            .header("Content-Type", "application/json")
            .header("app-id", validToken) // App-id diset dengan token valid
            .body(requestBody)
            .post("https://dummyapi.io/data/v1/users");

    // Memeriksa response status code
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 200);

    // Memeriksa struktur response body
    String responseBody = response.getBody().asString();
    JsonPath jsonPath = new JsonPath(responseBody);
    Assert.assertTrue(jsonPath.get("id") != null);
    Assert.assertEquals(jsonPath.get("firstName"), "Cinderella");
    Assert.assertEquals(jsonPath.get("lastName"), "Ella");
    Assert.assertEquals(jsonPath.get("email"), "ella@example.com");
    // Memeriksa lebih banyak atribut sesuai kebutuhan
}

@Test
void testCase05CreateUserWithEmailAlreadyExists() {
    // Data requestBody
    String requestBody = "{\"firstName\":\"Cinderella\",\"lastName\":\"Ella\",\"email\":\"ella@example.com\"}";

    // Token yang valid
    String validToken = "token_yang_valid";

    Response response = RestAssured.given()
            .header("Content-Type", "application/json")
            .header("app-id", validToken) // App-id diset dengan token valid
            .body(requestBody)
            .post("https://dummyapi.io/data/v1/users");

    // Memeriksa response status code
    int statusCode = response.getStatusCode();
    Assert.assertEquals(statusCode, 400);

    // Memeriksa struktur response body
    String responseBody = response.getBody().asString();
    JsonPath jsonPath = new JsonPath(responseBody);
    Assert.assertEquals(jsonPath.get("error"), "BODY_NOT_VALID");
    Assert.assertEquals(jsonPath.get("data.email"), "Email already used");
}

