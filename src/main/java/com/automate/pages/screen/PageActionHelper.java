package com.automate.pages.screen;


import com.automate.driver.DriverManager;
import com.automate.reports.ExtentReportLogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.log4testng.Logger;

import java.io.IOException;

public class PageActionHelper {
    private PageActionHelper(){}

    private static final Logger LOGGER = Logger.getLogger(PageActionHelper.class);

    public static boolean isElementNotEnabled(By by) {
        try{
            return DriverManager.getDriver().findElement(by).isDisplayed();
        }
        catch (NoSuchElementException e){
            return true;
        }
    }

    public static void waitAndClick(By by,String elementName) throws IOException {

        try {
            //wait strategy
            DriverManager.getDriver().findElement(by).click();
            ExtentReportLogStatus.logInfo("Clicked on " + elementName);

        } catch (Exception e) {
            ExtentReportLogStatus.logFail("Exception occurred when clicking on - " + elementName, e);
        }
    }

}
