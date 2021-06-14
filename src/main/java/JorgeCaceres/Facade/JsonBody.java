package JorgeCaceres.Facade;

import JorgeCaceres.RestAPIs.EndPoints;
import JorgeCaceres.entities.JsonProjectBody;
import io.restassured.response.Response;


public class JsonBody {
    public static JsonProjectBody getProjectBody(String id, String token){
        Response response = EndPoints.getProject(id,token);
        return response.as(JsonProjectBody.class);
    }
    public static JsonProjectBody createProjectBody(String body, String token){
        Response response = EndPoints.createProject(body,token);
        return response.as(JsonProjectBody.class);
    }
    public static JsonProjectBody createASerializedProject(JsonProjectBody body, String token){
        Response response = EndPoints.createSerializedProject(body,token);
        return response.as(JsonProjectBody.class);
    }
}
