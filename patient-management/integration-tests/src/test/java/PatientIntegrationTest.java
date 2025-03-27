import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PatientIntegrationTest {
    static String token;
    private static String createdPatientId;

    @BeforeAll
    static void setUp(){
        RestAssured.baseURI = "http://localhost:4004";
        token = getAuthToken();
    }

    @Test
    public void shouldCreatePatientWithValidToken() {
        String createPatientBody = """
                {
                    "name":"testuser",
                    "email":"t@test.com",
                    "address":"thane",
                    "dateOfBirth":"1997-05-19",
                    "registeredDate":"2025-03-18"
                }
                """;

        Response response = given().header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(createPatientBody)
                .when()
                .post("/api/patients");

        response.then()
                .statusCode(200);

        createdPatientId = (response.jsonPath().getString("id"));

        System.out.println("Created Patient ID: " + createdPatientId);


    }

    // Example of a test for invalid input
    @Test
    public void shouldReturnErrorWithInvalidPatientData() {
        String invalidPatientBody = """
                {
                    "name":"",
                    "email":"invalid-email",
                    "address":"thane"
                }
                """;

        given()
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(invalidPatientBody)
                .when()
                .post("/api/patients")
                .then()
                .statusCode(400); // Or whatever status code your API returns for invalid input
    }


    @Test
    public void shouldReturnPatientsWithValidToken() {
        String token = getAuthToken();

        System.out.println("token : "+token);

        given().header("Authorization", "Bearer "+token)
                .when()
                .get("/api/patients")
                .then()
                .statusCode(200)
                .body("patients.size()", greaterThan(0));

    }

    private static String getAuthToken() {
        String loginPayload = """
          {
            "email": "testuser@test.com",
            "password": "password123"
          }
        """;

        return given()
                .contentType("application/json")
                .body(loginPayload)
                .when()
                .post("/auth/login")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("token");
    }

    // Example of cleanup (if needed)
/*    @AfterEach
    void tearDown() {
        if (createdPatientId != null) {
            given()
                    .header("Authorization", "Bearer " + token)
                    .when()
                    .delete("/api/patients/" + createdPatientId)
                    .then()
                    .statusCode(200); // Or appropriate status code for successful deletion
            System.out.println("Deleted patient with ID: "+ createdPatientId);

        }
    }*/

}
