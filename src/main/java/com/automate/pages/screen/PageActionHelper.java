package com.automate.pages.screen;


import com.automate.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class PageActionHelper {
    private PageActionHelper(){}

    public static boolean isElementNotEnabled(By by) {
        try{
            return DriverManager.getDriver().findElement(by).isDisplayed();
        }
        catch (NoSuchElementException e){
            return true;
        }
    }
    public boolean logoIsDispalyeds(WebElement element) {
        return element.isDisplayed();
    }
}
