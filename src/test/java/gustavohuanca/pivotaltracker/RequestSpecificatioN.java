package gustavohuanca.pivotaltracker;

import gustavohuanca.code.SettingParameter;
import gustavohuanca.code.SettingRequest;
import gustavohuanca.code.typeCall.CallGet;
import gustavohuanca.code.typeCall.CallStatus;
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
    public void testGet1(){
        String actual = settingRequest.request( new CallGet("name[0]"),"/projects/2503580/epics/");
        String expected= "Tractor Beams";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testGet2(){
        String actual = settingRequest.request( new CallGet("label[1]","updated_at"),"/projects/2503580/epics/");
        String expected= "2021-06-13T01:25:02Z";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testStatus(){
        String actual = settingRequest.request( new CallStatus(),"/projects/2503580/epics/");
        String expected= "200";
        Assert.assertEquals(actual, expected);
    }
}
