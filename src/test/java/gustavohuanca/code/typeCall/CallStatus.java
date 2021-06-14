package gustavohuanca.code.typeCall;

import static io.restassured.RestAssured.given;

public class CallStatus implements IRequestCall{
    @Override
    public String answerToCall(String pathEndPoint) {
        return responseCallStatus(pathEndPoint)+"";
    }

    private int responseCallStatus(String pathEndPoint){
        return given()
                .when()
                .get("http://zippopotam.us/us/90210")
                .then()
                .extract().statusCode();
    }
}
