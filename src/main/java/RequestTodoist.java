import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestTodoist {
    private static String URL = "https://api.todoist.com/rest/v1/projects";
    private static String TOKEN = "ad1055bfd0e8b0fc32d603e28d015044e5d65cc0";

    public static Response createNewProject(ProjectTodoist projectTodoist) {
        RestAssured.baseURI = URL;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification
                .auth().oauth2(TOKEN)
                .contentType(ContentType.JSON)
                .body(projectTodoist)
                .log().body();
        return requestSpecification.post(URL);
    }

    public static Response deleteProject(String projectId) {
        RestAssured.baseURI = URL;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification
                .auth().oauth2(TOKEN)
                .contentType(ContentType.JSON)
                .delete(URL + "/" + projectId);
        return requestSpecification.delete(URL + "/" + projectId);
    }

    public static Response getSingleProject(String projectId) {
        RestAssured.baseURI = URL;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification
                .auth().oauth2(TOKEN)
                .contentType(ContentType.JSON)
                .get(URL + "/" + projectId);
        return requestSpecification.get(URL + "/" + projectId);
    }
}
