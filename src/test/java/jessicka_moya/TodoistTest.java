package jessicka_moya;

import io.restassured.response.Response;
import jessicka_moya.entities.Project;
import jessicka_moya.todoist_api.ConfigurationRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoistTest {

    @Test
    public void testGetProjectNames() {
        String expectedResult = "Project API favorite";
        Response response = ConfigurationRequest.getProject("2267256371");
        Project project = response.as(Project.class);
        Assert.assertEquals(project.getName(), expectedResult);
    }
}
