package joelrojastest;

import entities.Project;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Requests {
    public static final String TOKEN = "acea0f034eb75c9d8ed7ca11d0f74376f5b7bba8";

    public static Response createAProject(Project project) {
        String url = "https://api.todoist.com/rest/v1/projects";
        RequestSpecification requestSpecification = given()
                .auth().oauth2(TOKEN)
                .contentType(ContentType.JSON)
                .body(project)
                .log().body();
        return postRequest(requestSpecification, url);
    }

    public static Response getAProject(String id) {
        String url = "https://api.todoist.com/rest/v1/projects/{id}";
        RequestSpecification requestSpecification = given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + TOKEN)
                .pathParam("id", id);
        return getRequest(requestSpecification,url);
    }

    public static Response getRequest(RequestSpecification requestSpecification, String url) {
        return requestSpecification.get(url);
    }

    public static Response postRequest(RequestSpecification requestSpecification, String url) {
        return requestSpecification.post(url);
    }
}
