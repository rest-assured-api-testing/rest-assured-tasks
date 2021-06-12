import api.constants.Endpoints;
import api.model.Project;
import api.request.Request;
import api.util.RequestMethod;
import api.util.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectsTest {

    private Request request;
    @BeforeClass
    public void init() {
        this.request = new Request();
    }
    @Test
    public void shouldReturnProject() {
        Long id = 2267249741L;
        request.configureRequest(Endpoints.GET_A_PROJECT, RequestMethod.GET, Status.STATUS_200);
        Project actual = request.getResourceData(id, Project.class);
        Assert.assertNotNull(actual.getId());
    }
    @Test
    public void shouldCreateAProject() {
        Project project = createProject(42, "testProj", true, true);
        request.configureRequest(Endpoints.CREATE_A_PROJECT, RequestMethod.POST, Status.STATUS_200);
        int expected = 200;
        int actual = request.createResource(project);
        Assert.assertEquals(actual, expected);
    }
    public Project createProject(int color, String name, boolean shared, boolean favorite) {
        Project project = new Project();
        project.setColor(color);
        project.setName(name);
        project.setShared(shared);
        project.setFavorite(favorite);
        return project;
    }
}
