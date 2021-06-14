package JorgeCaceresTest.RestAPIs;


import JorgeCaceres.RestAPIs.EndPoints;
import JorgeCaceres.entities.JsonProjectBody;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class EndPointsTest {
    @Test
    public void shouldGeAProject() {
        Response response = EndPoints.getProject("2267238674", "0c15909dcdf9d6e60767fc261a78335a9477506a");
        int expected = 200;
        int actual = response.getStatusCode();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateAProject() {
        Response response = EndPoints.createProject("{\"name\": \"Shopping List\"}", "0c15909dcdf9d6e60767fc261a78335a9477506a");
        int expected = 200;
        int actual = response.getStatusCode();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldUpdateAProject() {
        Response response = EndPoints.updateProject("{\"name\": \"updated\"}", "2267559334", "0c15909dcdf9d6e60767fc261a78335a9477506a");
        int expected = 204;
        int actual = response.getStatusCode();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDeleteAProject() {
        Response response = EndPoints.deleteProject("2267559334", "0c15909dcdf9d6e60767fc261a78335a9477506a");
        int expected = 204;
        int actual = response.getStatusCode();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateASerializedProject() {
        JsonProjectBody testJsonBody = new JsonProjectBody();
        testJsonBody.setName("serialized");
        Response response = EndPoints.createSerializedProject(testJsonBody,"0c15909dcdf9d6e60767fc261a78335a9477506a");
        int expected = 200;
        int actual = response.getStatusCode();
        Assert.assertEquals(expected, actual);
    }
}