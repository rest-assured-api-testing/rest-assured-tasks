package joelrojastest;

import entities.Project;
import io.restassured.response.Response;
import joelrojas.RequestManager;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static joelrojas.config.Configuration.CONFIG;

public class ApiTodoistTest {

    @DataProvider(name = "testProvider")
    public static Object[][] testProvider() {
        return new Object[][]{
                {"2267203087", "Te damos la bienvenida \uD83D\uDC4B"},
                {"2267203088", "Prueba los Paneles"},
                {"2267236196", "Test List"}
        };
    }

    @Test
    public void testACreateProject() {
        Project project = new Project("API Testing13", 43, true);

        Response response = RequestManager.createAEntity(project, CONFIG.getProperty("ENDPOINT_PROJECTS")
                , CONFIG.getProperty("TOKEN"));

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
    }

    @Test(dataProvider = "testProvider")
    public void testGetProjectNames(String id, String expectedResult) {
        Response response = RequestManager.getAProject(CONFIG.getProperty("ENDPOINT_PROJECT"), id
                , CONFIG.getProperty("TOKEN"));

        Project project = response.as(Project.class);

        Assert.assertEquals(project.getName(), expectedResult);
    }

}
