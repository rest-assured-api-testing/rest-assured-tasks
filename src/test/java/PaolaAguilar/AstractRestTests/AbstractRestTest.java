package PaolaAguilar.AstractRestTests;

import PaolaAguilar.AbstractRest.RestAbstract;
import PaolaAguilar.Entities.Project;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AbstractRestTest {
    private static Response response;

    @Test
    public void getProjectById() {
        String idProject = "2267203567";
        response = RestAbstract.getProject(idProject);
        Project projects = response.getBody().as(Project.class);
        String projectNameExpected = "Inbox";
        Assert.assertEquals(projects.getName(), projectNameExpected);
    }

    @Test
    public void addNewProject() {
        Project project = new Project();
        project.setName("API");
        int expectedStatusCode = 200;
        response = RestAbstract.addProject(project);
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    @Test
    public void updateProjectById() {
        String updateString = "{\"name\": \"Other name\"}";
        String idProject = "2267561282";
        response = RestAbstract.updateProject(updateString, idProject);
        int expectedStatusCode = 204;
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    @Test
    public void deleteProjectById() {
        String idProject = "2267561282";
        response = RestAbstract.deleteProject(idProject);
        int expectedStatusCode = 204;
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }
}
