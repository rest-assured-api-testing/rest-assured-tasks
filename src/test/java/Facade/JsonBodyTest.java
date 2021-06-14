package Facade;

import entities.JsonProjectBody;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

class JsonBodyTest {
    @Test
    public void getAProject(){
        JsonProjectBody jsonBody = JsonBody.getProjectBody("2267238674","0c15909dcdf9d6e60767fc261a78335a9477506a");
        String expected = "Inbox";
        String actual = jsonBody.getName();
        Assert.assertEquals(expected,actual);
    }

}