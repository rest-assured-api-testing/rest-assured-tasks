package EdsonAnawayaTests;

import EdsonAnawayaTests.Entity.Project;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static EdsonAnawayaTests.Entity.TestStr.*;

public class EdsonAnawayaTest {

    @BeforeClass
    public void createRequestSpecification() {
        configuration("https://api.todoist.com", "/rest/v1");
    }

    @Test
    public void testGetProjects() {
        authorization();
        Response response = get("/projects");
        int expected = 200;
        int actual = response.getStatusCode();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAProject() {
        authorization();
        Response response = get("/projects", "2267214766");
        String expected = "Shopping List Update";
        String actual = response.path("name");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreateProject() {
        Project project = new Project();
        project.setName("New list");
        project.setColor(43);

        authorization();
        Response response = post("/projects", project);
        int expected = 200;
        int actual = response.getStatusCode();
        Assert.assertEquals(expected, actual);
    }
}
