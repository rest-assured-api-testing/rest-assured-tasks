package gustavohuanca.pivotaltracker;

import gustavohuanca.code.SettingParameter;
import gustavohuanca.code.SettingRequest;
import gustavohuanca.code.entities.Epic;
import gustavohuanca.code.typeCall.CallGet;
import gustavohuanca.code.typeCall.CallPost;
import gustavohuanca.code.typeCall.CallStatus;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RequestSpecificatioN {
    private SettingRequest settingRequest;
    private String projectId;

    @BeforeClass
    public void setup() {
        SettingParameter settingParameter = new SettingParameter();
        settingParameter.setBaseURL("https://www.pivotaltracker.com");
        settingParameter.setBasePath("/services/v5");
        settingParameter.setContentType(ContentType.JSON);
        settingParameter.setTokenKey("X-TrackerToken");
        settingParameter.setTokenValue("1d24b2ee47d04c09615c6811a19fba0a");
        settingRequest = new SettingRequest(settingParameter);
        projectId = "2503580";
    }

    @Test
    public void testGetEpics1() {
        String actual = settingRequest.request(new CallGet("name[0]"), "/projects/" + projectId + "/epics/");
        String expected = "Test-NewEpic";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGetEpics2() {
        String actual = settingRequest.request(new CallGet("label[0]", "updated_at"), "/projects/" + projectId + "/epics/");
        String expected = "2021-06-14T01:31:01Z";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testStatus() {
        String actual = settingRequest.request(new CallStatus(), "/projects/" + projectId + "/epics/");
        String expected = "200";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCreateEpic(){
        Epic epic = new Epic();
        epic.setName("Test-NewEpic4");
        epic.setDescription("Test 645, I hope this work");
        String actual = settingRequest.request( new CallPost(epic),"/projects/2504059/epics/");
        String expected= "200";
        Assert.assertEquals(actual, expected);
    }
}
