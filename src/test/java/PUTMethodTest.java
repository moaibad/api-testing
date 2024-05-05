import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PUTMethodTest {

    String validToken = "662e5afebb70a708672595ab";

    @Test
    void testCase03_1() {
        // Endpoint URL
        String endpoint = "https://dummyapi.io/data/v1/user/{userId}";

        // Data untuk update
        String userId = "60d0fe4f5311236168a109ca"; // ID pengguna yang akan diupdate

        // Payload untuk update
        String requestBody = "{"
                    + "\"firstName\": \"Shayne\","
                    + "\"lastName\": \"Pattynama\""
                    + "}";

        // Melakukan request PUT untuk update
        Response response = RestAssured.given()
                .header("app-id", validToken)
                .pathParam("userId", userId)
                .contentType("application/json")
                .body(requestBody)
            .when()
                .put(endpoint);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Memeriksa response body
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Shayne"));
        Assert.assertTrue(responseBody.contains("Pattynama"));
    }

    @Test
    void testCase3_3() {
        // Endpoint URL
        String endpoint = "https://dummyapi.io/data/v1/user/{userId}";

        // Data untuk update
        String userId = "60d0fe4f5311236168a109cb"; // ID pengguna yang akan diupdate

        // Payload untuk update
        String requestBody = "{"
                    + "\"firstName\": \"Aa\""
                    + "}";

        // Melakukan request PUT untuk update
        Response response = RestAssured.given()
                .header("app-id", validToken)
                .pathParam("userId", userId)
                .contentType("application/json")
                .body(requestBody)
            .when()
                .put(endpoint);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Memeriksa response body
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Aa"));
    }

    @Test
    void testCase3_4() {
        // Endpoint URL
        String endpoint = "https://dummyapi.io/data/v1/user/{userId}";

        // Data untuk update
        String userId = "60d0fe4f5311236168a109cb"; // ID pengguna yang akan diupdate

        // Payload untuk update
        String requestBody = "{"
                    + "\"firstName\": \"Shaynee Alexander Pattynamaa Cruz Martinez Sanchez\""
                    + "}";

        // Melakukan request PUT untuk update
        Response response = RestAssured.given()
                .header("app-id", validToken)
                .pathParam("userId", userId)
                .contentType("application/json")
                .body(requestBody)
            .when()
                .put(endpoint);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Memeriksa response body
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Shaynee Alexander Pattynamaa Cruz Martinez Sanchez"));
    }

    @Test
    void testCase3_5() {
        // Endpoint URL
        String endpoint = "https://dummyapi.io/data/v1/user/{userId}";

        // Data untuk update
        String userId = "60d0fe4f5311236168a109d2"; // ID pengguna yang akan diupdate

        // Payload untuk update
        String requestBody = "{"
                    + "\"lastName\": \"Ai\""
                    + "}";

        // Melakukan request PUT untuk update
        Response response = RestAssured.given()
                .header("app-id", validToken)
                .pathParam("userId", userId)
                .contentType("application/json")
                .body(requestBody)
            .when()
                .put(endpoint);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Memeriksa response body
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Ai"));
    }

    @Test
    void testCase3_6() {
        // Endpoint URL
        String endpoint = "https://dummyapi.io/data/v1/user/{userId}";

        // Data untuk update
        String userId = "60d0fe4f5311236168a109d2"; // ID pengguna yang akan diupdate

        // Payload untuk update
        String requestBody = "{"
                    + "\"lastName\": \"Anindita Kusumawardhani Prasetya Putri Wijaya Tama\""
                    + "}";

        // Melakukan request PUT untuk update
        Response response = RestAssured.given()
                .header("app-id", validToken)
                .pathParam("userId", userId)
                .contentType("application/json")
                .body(requestBody)
            .when()
                .put(endpoint);

        // Memeriksa response status code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

        // Memeriksa response body
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("Anindita Kusumawardhani Prasetya Putri Wijaya Tama"));
    }
}
