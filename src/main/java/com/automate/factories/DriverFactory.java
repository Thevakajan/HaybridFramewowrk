package com.automate.factories;

import com.automate.driver.Drivers;
import com.automate.driver.DriverManager;
import com.automate.enums.MobilePlatformName;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.util.Objects;

public final class DriverFactory {

    private DriverFactory() {}

    public static void initializeDriver(MobilePlatformName mobilePlatformName, String devicename, String udid, int port, String emulator) throws IOException {
        AppiumDriver driver;
        switch (mobilePlatformName) {
            case ANDROID:
                driver = Drivers.createAndroidDriverForNativeApp(devicename, udid, port, emulator);
                break;
            case ANDROID_WEB:
                driver = Drivers.createAndroidDriverForWeb( devicename,udid, port, emulator);
                break;
            case IOS:
                driver = Drivers.createIOSDriverForNativeApp(devicename, udid, port);
                break;
            case IOS_WEB:
                driver = Drivers.createIOSDriverForWeb(devicename, udid, port);
                break;
            default:
                throw new ExceptionInInitializerError("Platform name " + mobilePlatformName +"is not found. Please check the platform name");
        }
        DriverManager.setAndWebDriver(driver);
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
