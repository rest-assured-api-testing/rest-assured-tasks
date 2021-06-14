package EdsonAnawayaTests.Entity;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class TestStr {
    private static String token = "156721c42720001c6856e1afe292880e776ec1d5";
    private static final String BASE_URL = "https://api.todoist.com";
    private static RequestSpecification request;
    private static Response response;

    public static void authorization() {
        request = RestAssured.given().auth().oauth2(token);
    }

    public static void configuration(String baseURI, String basePath) {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }

    public static Response post(String path, Project object) {
        RestAssured.baseURI = BASE_URL;
        response = request.body(object).when().post(path);
        return response;
    }

    public static Response get(String path) {
        RestAssured.baseURI = BASE_URL;
        Response response = request.log().all().when().get(path);
        return response;
    }

    public static Response get(String path, String param) {
        RestAssured.baseURI = BASE_URL;
        request.pathParam("param", param);
        Response response = request.when().get(path + "/{param}");
        return response;
    }

}
