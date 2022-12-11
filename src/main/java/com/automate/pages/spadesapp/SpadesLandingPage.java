package com.automate.pages.spadesapp;

import org.openqa.selenium.By;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.automate.pages.screen.PageActionHelper.isElementNotEnabled;


public class SpadesLandingPage {

    private static  By LOGO_Display = By.xpath("//img[@data-id='logo']");


    @FindBy(xpath = "//img[@data-id='logo']")
    private static WebElement logo;



    private static boolean  isLandingPagePageDisplayed(){
        return isElementNotEnabled(LOGO_Display);


//              NewDriverManager.getDriver().findElement(LOGO_Display).isDisplayed();
    }
    //***Restaurant Details**

    public static void LandingToSpadesApplication(){
        isLandingPagePageDisplayed();
     }

    @FindBy(xpath = "//a[@data-id='outlet_name_btn']")
    private static WebElement outletName;

    @FindBy(xpath = "//a[@data-id='viewmenu_btn']")
    private static WebElement viewMenu;

    @FindBy(xpath = "menu_title")
    private static WebElement titleMenu;

    @FindBy(xpath = "//button[@type='button']")
    private static WebElement pay;



}
