package danielaSCA;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestLayer {
    private final static String BASE_URL = "https://api.todoist.com/rest/v1";
    private final String token = "2c5090848fc1b7a3d738a7b8f2e5418be887d510";

    public static Response postStatement(String token, Object project) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().auth().oauth2(token);
        request.header("Content-Type", "application/json");
        Response response = request.body(project).when().post("/projects");
        return response;
    }

    public static Response getStatement(String token, String idProject) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().auth().oauth2(token);
        request.pathParam("idProject", idProject);
        Response response = request.when().get("/projects/{idProject}");
        return response;
    }

    public static Response deleteStatement(String token, String idProject) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().auth().oauth2(token);
        request.header("Content-Type", "application/json");
        request.pathParam("idProject", idProject);
        Response response = request.when().delete("/projects/{idProject}");
        return response;
    }
}
