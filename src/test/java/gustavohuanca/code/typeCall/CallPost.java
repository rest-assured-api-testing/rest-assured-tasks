package gustavohuanca.code.typeCall;

import gustavohuanca.code.SettingParameter;
import gustavohuanca.code.entities.Epic;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class CallPost implements IRequestCall{
    private Epic epic;

    public CallPost(Epic epic){
        this.epic=epic;
    }

    @Override
    public String answerToCall(String pathEndPoint) {
        return responseCallStatus(pathEndPoint)+"";
    }


    private int responseCallStatus(String pathEndPoint){
        return given()
                .header(SettingParameter.getTokenKey(), SettingParameter.getTokenValue())
                .contentType(ContentType.JSON)
                .body(epic)
                .when()
                .post(pathEndPoint)
                .then()
                .extract().statusCode();
    }
}
