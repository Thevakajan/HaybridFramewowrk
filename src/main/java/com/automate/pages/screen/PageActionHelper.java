package com.automate.pages.screen;



import com.automate.driver.DriverManager;
import com.automate.enums.WaitStrategy;
import com.automate.factories.WaitFactory;
import com.automate.reports.ExtentReportLogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class PageActionHelper {

    static WaitFactory waitFactory = new WaitFactory();
    public static final Logger LOG = Logger.getLogger(PageActionHelper.class);

    public static boolean isElementNotEnabled(By by) {
        try{

            waitFactory.waiTillVisible( by,20);

            return DriverManager.getDriver().findElement(by).isDisplayed();
        }
        catch (NoSuchElementException e){
            return true;
        }
    }

    public static void waitAndClick(By by,String elementName) throws IOException {

        try {
            //wait strategy
            WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.CLICKABLE, by);
            DriverManager.getDriver().findElement(by).click();
            LOG.info("Clicked on " + elementName);
            ExtentReportLogStatus.logInfo("Clicked on " + elementName);
        } catch (Exception e) {
            ExtentReportLogStatus.logFail("Exception occurred when clicking on - " + elementName, e);
        }
    }

    public static void enterValue(By by,String value,String elementName) throws IOException {

        try {
            //wait strategy
            WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE, by);
            DriverManager.getDriver().findElement(by).sendKeys(value);
            LOG.info("Entered value - <b>" + value + "</b> in the field " + elementName);
            ExtentReportLogStatus.logInfo("Entered value - <b>" + value + "</b> in the field " + elementName);
        } catch (Exception e) {
            ExtentReportLogStatus.logFail("Exception occurred when clicking on - " + elementName, e);
        }
    }

    public static String getTextValue(By by,String elementName) {
        waitFactory.waitTillElementLoadedLonger(by);

        return WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE, by).getText();

    }

    public static String getText(By by,String elementName) {
//        WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE, by);
        WaitFactory.waiTillVisible(by,10);
        ExtentReportLogStatus.logInfo("getText value - <b>" + elementName + "</b> in the field ");
        return DriverManager.getDriver().findElement(by).getText();
    }
    public static String[] getTextValueAmout(By by) {
        return WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.VISIBLE, by).getText().split(" ",4);


    }



    public String getTitleOfThePage() {
        return DriverManager.getDriver().getTitle();
    }

    public static List<String> getTexts(List<WebElement> element) {
        List<String> texts = new ArrayList<String>();
        for (WebElement ele : element) {
            texts.add(ele.getText());
        }
        return texts;

    }

    public static void Click(WebElement element,String elementName) throws IOException {

        try {
//            WaitFactory.waitForVisibilityElement((By) element,3);
//            WaitFactory.explicitlyWaitForElementLocatedBy(WaitStrategy.CLICKABLE,by);
            element.click();
            LOG.info(elementName + "is clicked");
            ExtentReportLogStatus.logInfo("Clicked on " + elementName);
        } catch (Exception e) {
            ExtentReportLogStatus.logFail("Exception occurred when clicking on - " + elementName, e);
        }

    }


}
