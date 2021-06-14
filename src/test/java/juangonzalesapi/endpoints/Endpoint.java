package juangonzalesapi.endpoints;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import juangonzalesapi.entities.CreateProjectRequest;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class Endpoint {
    private static final String BASE_URL = "https://api.todoist.com";
    private static final String BASE_PATH = "/rest/v1";
    private static final String TOKEN = "a42b7cfa9a9db1cd8f8336f9f7bc51ff6fdc866e";

    public static void setupCOnfiguration(String baseURI, String basePath){
        RestAssured.baseURI = "https://api.todoist.com";
        RestAssured.basePath = "/rest/v1";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }


    public static Response createProject(String token,  CreateProjectRequest project) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given() .auth().oauth2(token);
        //request.header("Content-Type", "application/json");
        Response response = request.body(project).when().post("/projects");
        return response;
    }

    public static Response findProject(String token ,String idProject) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given() .auth().oauth2(token);
        request.pathParam("idProject",idProject);
        Response response = request.when().get("/projects/{idProject}");
        return response;
    }

}
