package cristianchoquetest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Apitest {
    private final static String BASE_URL = "https://api.todoist.com/rest/v1";
    private final static String token = "01f43459372ebd473e01f786b9a66c6d0304756e";

    public static Response postStatement(Object project) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().header("Content-type", "application/json");
        request.header("Authorization","Bearer " + token);
        Response response = request.body(project).when().post("/projects");
        return response;
    }

    public static Response getStatement(String idProject) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().log().all().header("Content-type", "application/json");
        request.header("Authorization","Bearer " + token);
        request.pathParam("idProject", idProject);
        Response response = request.when().get("/projects/{idProject}").then().log().body().extract().response();
        return response;
    }

    public static Response deleteStatement(String idProject) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().header("Content-type", "application/json");
        request.header("Authorization","Bearer " + token);
        request.pathParam("idProject", idProject);
        Response response = request.when().delete("/projects/{idProject}");
        return response;
    }
}