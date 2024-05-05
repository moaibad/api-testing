import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class updateTest {

    @Test
    public void testUpdateUser() {
        // Endpoint URL
        String endpoint = "https://dummyapi.io/data/v1/user/{id}";
        // bakcup up https://dummyapi.io/data/v1/user/{userid}

        // Data untuk update
        String userId = "60d0fe4f5311236168a109ca"; // ID pengguna yang akan diupdate
        String firstName = "John Doe"; // Nama baru yang akan diupdate

        // Payload untuk update
        String requestBody = "{ \"name\": \"" + firstName + "\" }";

        // Melakukan request PUT untuk update
        given()
            .contentType("application/json")
            .pathParam("id", userId)
            .body(requestBody)
        .when()
            .put(endpoint)
        .then()
            .statusCode(200) // Memastikan response code adalah 200 OK
            .body("name", equalTo(firstName)); // Memastikan nama pengguna telah diupdate dengan benar
    }
}
