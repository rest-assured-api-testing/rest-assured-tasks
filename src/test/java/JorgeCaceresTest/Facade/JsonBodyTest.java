package JorgeCaceresTest.Facade;

import JorgeCaceres.Facade.JsonBody;
import JorgeCaceres.entities.JsonProjectBody;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

class JsonBodyTest {
    @Test
    public void getAProject(){
        JsonProjectBody jsonBody = JsonBody.getProjectBody("2267238674","0c15909dcdf9d6e60767fc261a78335a9477506a");
        String expected = "Inbox";
        String actual = jsonBody.getName();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void createAProject(){
        JsonProjectBody jsonBody = JsonBody.createProjectBody("{\"name\": \"Fake\"}","0c15909dcdf9d6e60767fc261a78335a9477506a");
        String expected = "Fake";
        String actual = jsonBody.getName();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void createASerializedProject(){
        JsonProjectBody test = new JsonProjectBody();
        test.setName("Mago");
        JsonProjectBody jsonBody = JsonBody.createASerializedProject(test,"0c15909dcdf9d6e60767fc261a78335a9477506a");
        String expected = "Mago";
        String actual = jsonBody.getName();
        Assert.assertEquals(expected,actual);
    }
}