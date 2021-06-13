package gustavohuanca.code.typeCall;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CallGet implements IRequestCall {
    private String parameterToGet;
    private String arrayToGet;
    private String typeCall;

    public CallGet(String parameterToGet) {
        this.parameterToGet = parameterToGet;
    }

    public CallGet(String arrayToGet, String parameterToGet) {
        this.parameterToGet = parameterToGet;
        this.arrayToGet = arrayToGet;
    }

    @Override
    public String answerToCall(String pathEndPoint) {
        Response response = responseCallGet(pathEndPoint);
        return getParameterInTypeJSON(response);
    }

    /**
     * Get all structure type JSON
     *
     * @param pathEndPoint
     * @return
     */
    private Response responseCallGet(String pathEndPoint) {
        return given()
                .header("X-TrackerToken", "1d24b2ee47d04c09615c6811a19fba0a")
                .when()
                .get(pathEndPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract().response();
    }

    /**
     * Select the answer according input setting
     *
     * @param response
     * @return
     */
    private String getParameterInTypeJSON(Response response){
        if ("".equals(arrayToGet) | arrayToGet == null) return getParameter(response);
        return getParameterInArray(response);
    }

    /**
     * Get parameter type JSON
     *
     * @param response
     * @return
     */
    private String getParameter(Response response){
        return response.jsonPath().getString(parameterToGet);
    }

    /**
     * Get parameter in array type JSON
     *
     * @param response
     * @return
     */
    private String getParameterInArray(Response response){
        Map<String, String> arrayParameter = response.jsonPath().getMap(arrayToGet);
        return arrayParameter.get(parameterToGet);
    }
}
