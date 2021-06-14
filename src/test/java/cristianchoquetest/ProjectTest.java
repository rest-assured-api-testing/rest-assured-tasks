package cristianchoquetest;

import cristianFCHQ.Object;
import org.testng.annotations.Test;
import org.apache.http.HttpStatus;

public class ProjectTest {

    @Test
    public void createProject() {
        Object project = new Object();
        project.setName("Testing Created");
        project.setColor(42);
        Apitest.postStatement(project)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void findProject() {
        Apitest.getStatement("2267568000")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void deleteProject() {
        Apitest.deleteStatement("2267568000")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

}
