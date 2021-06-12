package api.request;

import api.util.RequestMethod;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationConf {
    public static RequestSpecification getRequestSpecificationConf(String path, RequestMethod requestMethod) {
        RequestSpecification requestSpecification;
        if (requestMethod.equals(RequestMethod.POST)) {
            return requestSpecification = new RequestSpecBuilder()
                    .setBaseUri("https://api.todoist.com/rest/v1")
                    .setBasePath(path)
                    .setContentType(ContentType.JSON)
                    .build();
        } else {
            return requestSpecification = new RequestSpecBuilder()
                    .setBaseUri("https://api.todoist.com/rest/v1")
                    .setBasePath(path)
                    .build();
        }
    }
}
