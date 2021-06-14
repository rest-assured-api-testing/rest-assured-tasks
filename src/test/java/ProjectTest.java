import danielaSCA.TestLayer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.http.HttpStatus;

public class ProjectTest {

    @Test
    public void createProject() {
        Object project = new Object();
        project.setName("Testing");
        project.setColor(42);
        TestLayer.postStatement("2c5090848fc1b7a3d738a7b8f2e5418be887d510", project)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void findProject() {
        TestLayer.getStatement("2c5090848fc1b7a3d738a7b8f2e5418be887d510", "2267562928")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void deleteProject() {
        TestLayer.deleteStatement("2c5090848fc1b7a3d738a7b8f2e5418be887d510", "2267562928")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

}
