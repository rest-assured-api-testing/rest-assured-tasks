package JorgeCaceres.RestAPIs;


import JorgeCaceres.entities.JsonProjectBody;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndPoints {
    private static final String BASE_URL="https://api.todoist.com";

    public static Response getProject(String id, String token) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        Response response = request.get("/rest/v1/projects/"+id);
        return response;

    }
    public static Response createProject(String body, String token) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        Response response = request.body(body).post("/rest/v1/projects");
        return response;
    }
    public static Response createSerializedProject(JsonProjectBody body, String token){
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");
        Response response = request.body(body).post("/rest/v1/projects");
        return response;

    }    public static Response updateProject(String body,String id, String token) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        Response response = request.body(body).post("/rest/v1/projects/" + id);
        return response;
    }
    public static Response deleteProject(String id, String token) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        Response response = request.delete("/rest/v1/projects/" +id);
        return response;
    }
    public static void authenticate( RequestSpecification request){

    }
}
