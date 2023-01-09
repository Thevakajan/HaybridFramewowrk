package com.automate.driver;

import com.automate.enums.PlatformType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;


import static com.automate.enums.PlatformType.MOBILE;
import static com.automate.enums.PlatformType.WEB;
import static java.lang.ThreadLocal.withInitial;

public class DriverManager {
    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver> MOBILE_DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();
    private static final ThreadLocal<PlatformType> CONTEXT = withInitial(()-> WEB);
    public static  Map<PlatformType,ThreadLocal<WebDriver>> DRIVER_MAP = new EnumMap<>(PlatformType.class);


    public static WebDriver getDriver(){
        return CONTEXT.get() == WEB ?
                threadLocalWebDriver.get():MOBILE_DRIVER_THREAD_LOCAL.get();

    }


    public static void setAndWebDriver(WebDriver driver) {
      if (isMobileDriver(driver)){
          MOBILE_DRIVER_THREAD_LOCAL.set( driver);
          DRIVER_MAP.put(MOBILE,MOBILE_DRIVER_THREAD_LOCAL);
          CONTEXT.set(MOBILE);
      }
      else{
          threadLocalWebDriver.set(driver);
          DRIVER_MAP.put(WEB,threadLocalWebDriver);
          CONTEXT.set(WEB);
      }

    }

    public static void unload() {
        threadLocalWebDriver.remove();
        MOBILE_DRIVER_THREAD_LOCAL.remove();
        CONTEXT.remove();
    }

    private static boolean isMobileDriver(WebDriver driver) {
        return driver instanceof AndroidDriver || driver instanceof IOSDriver;
    }
}
