package api.request;

import api.util.RequestMethod;
import io.restassured.RestAssured;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;

public class Request {

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;
    private AuthenticationSpecification authenticationSpecification;
    public Request configureRequest(String endpoint, RequestMethod method, int status) {
        requestSpecification = RequestSpecificationConf.getRequestSpecificationConf(endpoint, method);
        responseSpecification = ResponseSpecificationConf.getResponseSpecification(method, status);
        return this;
    }
    public int createResource(Object bodyData) {
        return given()
                .spec(requestSpecification)
                .auth()
                .oauth2("44a745758a62dfab98da770ae70c98eb824acc2b")
                .body(bodyData)
                .post()
                .then()
                .log().body()
                .spec(responseSpecification)
                .extract()
                .response().getStatusCode();
    }
    public <T> T getResourceData(Long id, Class<T> responseClass) {
        RestAssured restAssured;
        return given()
                .spec(requestSpecification)
                .auth()
                .oauth2("44a745758a62dfab98da770ae70c98eb824acc2b")
                .when()
                .pathParam("id", id)
                .get()
                .then()
                .log().body()
                .spec(responseSpecification)
                .extract()
                .as(responseClass);
    }
}
