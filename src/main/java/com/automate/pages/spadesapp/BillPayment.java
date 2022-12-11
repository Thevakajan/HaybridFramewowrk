package com.automate.pages.spadesapp;

import com.automate.pages.screen.ScreenActions;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

import static com.automate.pages.screen.PageActionHelper.isElementNotEnabled;

public class BillPayment extends ScreenActions {
    @FindBy(id="edit-table-input")
    private static MobileElement txtFieldTableNumber;

    private static By LOGO_Display = By.xpath("//img[@data-id='logo']");

    private static boolean  isLandingPagePageDisplayed(){
        return isElementNotEnabled(LOGO_Display);


//              NewDriverManager.getDriver().findElement(LOGO_Display).isDisplayed();
    }
    //***Restaurant Details**

    public static void LandingToSpadesApplication(){
        isLandingPagePageDisplayed();
    }

    /*enter your table number*/
    public static void enterTablenumber(String tableNumber) throws IOException {
        enterValueAndPressEnter(txtFieldTableNumber, tableNumber, "entered table number text box");
    }
    /*Click not your table Link*/
    public static void btnnotYourTableClick() throws IOException {


        webclicked("XPATH","//div[text()='Not your table?']","click not your table");


    }
}
