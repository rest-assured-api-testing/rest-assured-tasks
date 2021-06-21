package joelrojas;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestManager {

    public static <T> Response createAEntity(T entity, String url, String token) {
        RequestSpecification requestSpecification = addAuthorization(token);
        return postRequest(addBody(requestSpecification, entity), url);
    }

    public static Response getAProject(String url, String id,String token) {
        RequestSpecification requestSpecification = addAuthorization(token)
                .pathParam(PathParam.ID, id);
        return getRequest(requestSpecification,url);
    }

    public static Response getRequest(RequestSpecification requestSpecification, String url) {
        return requestSpecification.get(url);
    }

    public static Response postRequest(RequestSpecification requestSpecification, String url) {
        return requestSpecification.post(url);
    }

    public static RequestSpecification addAuthorization(String token) {
        return RestAssured.given().auth().oauth2(token);
    }

    public static <T> RequestSpecification addBody(RequestSpecification requestSpecification, T entity) {
        return requestSpecification.contentType(ContentType.JSON).body(entity).log().body();
    }
}
