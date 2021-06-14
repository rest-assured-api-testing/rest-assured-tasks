package JorgeCaceres.Facade;

import JorgeCaceres.RestAPIs.EndPoints;
import JorgeCaceres.entities.JsonProjectBody;
import io.restassured.response.Response;


public class JsonBody {
    public static JsonProjectBody getProjectBody(String id, String token){
        Response response = EndPoints.getProject(id,token);
        return response.as(JsonProjectBody.class);
    }
}
