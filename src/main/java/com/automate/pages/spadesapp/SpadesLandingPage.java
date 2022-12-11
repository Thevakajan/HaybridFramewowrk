package com.automate.pages.spadesapp;

import org.openqa.selenium.By;
import java.io.IOException;
import static com.automate.pages.screen.PageActionHelper.isElementNotEnabled;
import static com.automate.pages.screen.PageActionHelper.waitAndClick;


public class SpadesLandingPage {
    private static  By LOGO_Display = By.xpath("//img[@data-id='logo']");
    private static  By View_MenuClick = By.xpath("//*[@data-id='viewmenu_btn']");
    private static  By outletName = By.xpath("//*[@data-id='viewmenu_btn']");
    private static  By tableCount = By.xpath("//*[@data-id='table']");
    private static  By refreshButton = By.xpath("//*[@data-id='refresh_bill']//span");
    private static  By not_your_table = By.xpath("//*[@data-id='not_your_table_btn']");




    public static boolean  isLandingPagePageDisplayed(){
        return isElementNotEnabled(LOGO_Display);

    }
    public static boolean  isOutletNameDisplayed(){
        return isElementNotEnabled(outletName);

    }
    public static boolean  isViewMenuDisplayed(){
        return isElementNotEnabled(View_MenuClick);

    }
    public static boolean  isTableNumDisplayed(){
        return isElementNotEnabled(tableCount);

    }
     public static void ViewMenuClick() throws IOException {
         waitAndClick(View_MenuClick,"Landing Page View Menu Click ");
     }
    public static void RefreshYourBillClick() throws IOException {
        waitAndClick(refreshButton,"Refresh Your Bill Click ");
    }
    public static void NotYourTableClick() throws IOException {
        waitAndClick(not_your_table,"Clicked on Not your table ");
    }


}
