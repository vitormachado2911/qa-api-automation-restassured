package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersTest extends BaseTest {

    @Test
    void deveRetornar200EValidarCamposBasicosAoBuscarUsuarios() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("$", hasSize(10))
                .body("[0].id", notNullValue())
                .body("[0].name", not(isEmptyOrNullString()))
                .body("[0].username", not(isEmptyOrNullString()))
                .body("[0].email", containsString("@"));
    }
}
