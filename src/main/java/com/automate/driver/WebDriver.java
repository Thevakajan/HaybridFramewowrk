package com.automate.driver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.Objects;
import java.util.concurrent.TimeUnit;



public class WebDriver {
    public static org.openqa.selenium.WebDriver createWebDriver(String browser){
        try {
            if(browser.equalsIgnoreCase("Chrome")) {
                WebDriverManager.chromedriver().setup();
                DriverManager.setAndWebDriver(new ChromeDriver());
                System.out.println("Browser: Chrome");
                System.out.println("Chrome Browser setup by Thread "+Thread.currentThread().getId());

            }else {
                WebDriverManager.safaridriver().setup();
                DriverManager.setAndWebDriver(new SafariDriver());
                System.out.println("Browser: Safari");
                System.out.println("Safari Browser setup by Thread "+Thread.currentThread().getId());
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverManager.getDriver().manage().window().maximize();
        return DriverManager.getDriver();
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
