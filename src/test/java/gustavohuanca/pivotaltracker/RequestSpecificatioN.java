package gustavohuanca.pivotaltracker;

import gustavohuanca.code.SettingParameter;
import gustavohuanca.code.SettingRequest;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RequestSpecificatioN {
    private static SettingRequest settingRequest;

    @BeforeClass
    public static void setup(){
        SettingParameter settingParameter= new SettingParameter();
        settingParameter.setBaseURL("https://www.pivotaltracker.com");
        settingParameter.setBasePath("/services/v5");
        settingParameter.setContentType(ContentType.JSON);
        settingRequest=new SettingRequest(settingParameter);
    }

    @Test
    public void testGet(){
        String actual = settingRequest.request("/projects/2503580/epics/","name[0]");
        String expected= "Tractor Beams";
        Assert.assertEquals(actual, expected);
    }
}
