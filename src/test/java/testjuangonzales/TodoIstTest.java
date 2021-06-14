package testjuangonzales;

import juangonzalesapi.endpoints.Endpoint;
import juangonzalesapi.entities.CreateProjectRequest;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TodoIstTest {

    @BeforeTest
    public void setup(){
        Endpoint.setupCOnfiguration("https://api.todoist.com","/rest/v1");
    }

    @Test
    public void createProject() {
        CreateProjectRequest project = new CreateProjectRequest();
        project.setName("API Testing 5");
        project.setColor(43);
        Endpoint.createProject("a42b7cfa9a9db1cd8f8336f9f7bc51ff6fdc866e",project).then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void findProject() {
        Endpoint.findProject("a42b7cfa9a9db1cd8f8336f9f7bc51ff6fdc866e","2267559900").then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

}
