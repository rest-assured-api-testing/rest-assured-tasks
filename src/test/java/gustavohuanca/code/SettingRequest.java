package gustavohuanca.code;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SettingRequest {
    private static String baseURL;
    private static String basePath;
    private static ContentType contentType;
    private String headersKeysAndValues;

    public SettingRequest(SettingParameter settingParameter){
        this.baseURL=settingParameter.getBaseURL();
        this.basePath=settingParameter.getBasePath();
        this.contentType=settingParameter.getContentType();
    }

    /**
     * Request to call
     *
     * @param pathEndPoint
     * @param ParameterToGet
     * @return
     */
    public static String request(String pathEndPoint,String ParameterToGet ){
        setupMainURL();
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(contentType)
                .build();
        Response response = responseCallGet(pathEndPoint);
        return response.jsonPath().getString(ParameterToGet);
    }

    /**
     * Set up URL base
     */
    private static void setupMainURL(){
        RestAssured.baseURI= baseURL;
        RestAssured.basePath= basePath;
    }

    /**
     * Show logging the Response
     */
    private void showLogging(){
        //RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.filters( new ResponseLoggingFilter());

    }

    //   GET
    private  static Response responseCallGet(String pathEndPoint){
        return given()
                .header("X-TrackerToken", "1d24b2ee47d04c09615c6811a19fba0a")
                .header("Content-Type", ContentType.JSON)
                .header("Accept", ContentType.JSON)
                .when()
                .get(pathEndPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

    }
}
