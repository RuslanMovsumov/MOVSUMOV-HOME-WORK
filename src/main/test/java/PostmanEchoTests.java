import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTests {

    private final String BASE_URL = "https://postman-echo.com/";

    @Test
    public void testGetMethod() {
        RestAssured.baseURI = BASE_URL;

        given()
            .param("foo1", "bar1")
            .param("foo2", "bar2")
        .when()
            .get("get")
        .then()
            .statusCode(200)
            .body("args.foo1", equalTo("bar1"))
            .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostMethod() {
        RestAssured.baseURI = BASE_URL;

        given()
            .contentType(ContentType.JSON)
            .body("{\"foo\": \"bar\"}")
        .when()
            .post("post")
        .then()
            .statusCode(200)
            .body("json.foo", equalTo("bar"));
    }

    @Test
    public void testPutMethod() {
        RestAssured.baseURI = BASE_URL;

        given()
            .contentType(ContentType.JSON)
            .body("{\"foo\": \"updatedBar\"}")
        .when()
            .put("put")
        .then()
            .statusCode(200)
            .body("json.foo", equalTo("updatedBar"));
    }

    @Test
    public void testDeleteMethod() {
        RestAssured.baseURI = BASE_URL;

        given()
            .param("foo", "bar")
        .when()
            .delete("delete")
        .then()
            .statusCode(200)
            .body("args.foo", equalTo("bar"));
    }
}
