package base;

import com.automate.driver.DriverManager;
import com.automate.driver.WebDriver;
import com.automate.utils.configloader.JsonUtils;
import com.automate.utils.screenrecording.ScreenRecordingService;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class WebBaseTest {

    public SoftAssert softAssert = new SoftAssert();

    @Parameters({"platform"})
    @BeforeMethod
    protected void webSetUp(String browser ) throws IOException {
        WebDriver.createWebDriver(browser);
        DriverManager.getDriver().get(JsonUtils.getValue("url"));
    }


    @AfterMethod
    protected void tearDown(ITestResult result) throws IOException {
        ScreenRecordingService.stopRecording(result.getName());
        WebDriver.quitDriver();
    }
}
