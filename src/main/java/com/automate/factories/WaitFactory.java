package com.automate.factories;

import com.automate.constants.FrameworkConstants;
import com.automate.enums.WaitStrategy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class WaitFactory {

    private WaitFactory() {
    }

    public static WebElement explicitlyWaitForElementLocatedBy(WaitStrategy waitStrategy, By by) {
        WebElement element = null;
        switch (waitStrategy) {
            case CLICKABLE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.elementToBeClickable(by));
                break;
            case PRESENCE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.presenceOfElementLocated(by));
                break;
            case VISIBLE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
                break;
            case NONE:
                element = DriverManager.getDriver().findElement(by);
                break;
        }
        return element;
    }

    public static WebElement explicitlyWaitForElement(WaitStrategy waitStrategy, MobileElement mobileElement) {
        WebElement element = null;
        switch (waitStrategy) {
            case CLICKABLE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.elementToBeClickable(mobileElement));
                break;
            case VISIBLE:
                element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait())
                        .until(ExpectedConditions.visibilityOf(mobileElement));
                break;
            case NONE:
                element = mobileElement;
                break;
        }
        return element;
    }
}
