package jessicka_moya.todoist_api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ConfigurationRequest {
    public static final String TODOIST_TOKEN = "3c72b9a42be1313c3f48e58c42d1e0290e475d5b";
    public static final String BASE_URI = "https://api.todoist.com/rest/v1/";

    public static Response getProject(String projectId) {
        RestAssured.baseURI = BASE_URI;
        RequestSpecification request = RestAssured.given().auth().oauth2(TODOIST_TOKEN);
        request.header("Content-Type", "application/json");
        request.pathParam("projectId",projectId);
        Response response = request.when().get("/projects/{projectId}");
        return response;
    }
}
