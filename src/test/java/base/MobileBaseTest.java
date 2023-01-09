package base;

import com.automate.driver.DeviceManager;
import com.automate.driver.DriverManager;
import com.automate.driver.PlatformManager;
import com.automate.enums.MobilePlatformName;
import com.automate.factories.DriverFactory;
import com.automate.utils.AppiumServerUtils;
import com.automate.utils.screenrecording.ScreenRecordingService;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Objects;

public class MobileBaseTest {

    protected MobileBaseTest() {
    }

    @BeforeSuite(alwaysRun = true)
    protected void beforeSuite() throws IOException {
       // AppiumServerUtils.startAppiumServer();
    }

    @Parameters({"platformName", "udid", "deviceName", "systemPort", "chromeDriverPort", "emulator", "wdaLocalPort",
            "webkitDebugProxyPort"})
    @BeforeMethod
    protected void setUp(String platformName, @Optional String udid, String deviceName, @Optional("androidOnly") String systemPort,
                         @Optional("androidOnly") String chromeDriverPort, @Optional("androidOnly") String emulator,
                         @Optional("iOSOnly") String wdaLocalPort, @Optional("iOSOnly") String webkitDebugProxyPort) throws IOException {
        PlatformManager.setPlatformName(platformName);
        DeviceManager.setDeviceName(deviceName);
        if (Objects.isNull(DriverManager.getDriver())) {
            DriverFactory.initializeDriver(MobilePlatformName.valueOf(platformName.toUpperCase()), deviceName, udid, Integer.parseInt(systemPort), emulator );
        }
        ScreenRecordingService.startRecording();
    }

    @AfterMethod
    protected void tearDown(ITestResult result) throws IOException {
        ScreenRecordingService.stopRecording(result.getName());
        DriverFactory.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    protected void afterSuite() throws IOException {
        AppiumServerUtils.stopAppiumServer();
    }
}
