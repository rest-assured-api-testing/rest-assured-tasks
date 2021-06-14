package PaolaAguilar.AbstractRest;

import PaolaAguilar.Entities.Project;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAbstract {
    private static final String AUTH_TOKEN = "560c31cc58cc2c911b2af745deaca827ee63decb";
    private static final String BASE_URL = "https://api.todoist.com/rest/v1/";


    public static Response getProject(String idProject) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + AUTH_TOKEN)
                .header("Content-Type", "application/json");
        return request.get("projects/" + idProject);
    }

    public static  Response addProject(Project project) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + AUTH_TOKEN)
                .header("Content-Type", "application/json");
        return request.body(project).post("projects");
    }

    public static Response updateProject(String contentUpdate, String id) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + AUTH_TOKEN)
                .header("Content-Type", "application/json");
        return request.body(contentUpdate).post("projects/" + id);
    }

    public static Response deleteProject(String idProject) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + AUTH_TOKEN)
                .header("Content-Type", "application/json");
        return request.delete("projects/" + idProject);
    }
}

