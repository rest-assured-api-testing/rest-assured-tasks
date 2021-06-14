package cristianchoquetest;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class apitest {

    @Test
    public void test1() {
        given()
                .log().all()
                .header("Authorization","Bearer 01f43459372ebd473e01f786b9a66c6d0304756e")
                .when()
                .get("https://api.todoist.com/rest/v1/projects")
                .then()
                .log().body();
    }
}
