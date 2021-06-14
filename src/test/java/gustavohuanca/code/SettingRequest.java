package gustavohuanca.code;

import gustavohuanca.code.typeCall.IRequestCall;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

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
     * @return
     */
    public String request(IRequestCall iRequestCall, String pathEndPoint){
        setupMainURL();
        showLogging();
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(contentType)
                .build();
        return iRequestCall.answerToCall(pathEndPoint);
    }


    /**
     * Set up URL base
     */
    private void setupMainURL(){
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
}
