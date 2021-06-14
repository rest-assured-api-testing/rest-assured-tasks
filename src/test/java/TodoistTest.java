import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoistTest {
    @Test
    public void checkCreateNewProject() {
        ProjectTodoist projectTodoist = new ProjectTodoist();
        projectTodoist.setName("My test is good");
        int expected = 200;
        Response actual = RequestTodoist.createNewProject(projectTodoist);
        Assert.assertEquals(actual.getStatusCode(), expected);
    }

    @Test
    public void checkDeleteProject() {
        int expected = 204;
        Response actual = RequestTodoist.deleteProject("2267254955");
        Assert.assertEquals(actual.getStatusCode(), expected);
    }

    @Test
    public void checkGetProject() {
        int expected = 200;
        Response actual = RequestTodoist.getSingleProject("2267567463");
        Assert.assertEquals(actual.getStatusCode(), expected);
    }
}
