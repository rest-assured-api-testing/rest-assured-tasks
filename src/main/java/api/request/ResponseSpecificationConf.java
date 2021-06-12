package api.request;

import api.util.RequestMethod;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationConf {
    public static ResponseSpecification getResponseSpecification(RequestMethod method, int status) {
        ResponseSpecification responseSpecification;
        if(method.equals(RequestMethod.GET)) {
            return responseSpecification = new ResponseSpecBuilder()
                    .expectContentType(ContentType.JSON)
                    .expectStatusCode(status)
                    .build();
        } else {
            return responseSpecification = new ResponseSpecBuilder()
                    .expectStatusCode(status)
                    .build();
        }
    }
}
