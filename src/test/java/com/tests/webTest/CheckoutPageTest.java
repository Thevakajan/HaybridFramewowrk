package com.tests.webTest;

import base.WebBaseTest;
import com.automate.customAnnotations.FrameworkAnnotation;
import com.automate.enums.CategoryType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import spadesappPages.customaterApp.SpadesCheckoutPage;
import spadesappPages.customaterApp.SpadesLandingPage;

import java.io.IOException;

public class CheckoutPageTest extends WebBaseTest {

    SpadesLandingPage landingPage = new SpadesLandingPage();
    SpadesCheckoutPage checkoutPage = new SpadesCheckoutPage();
    SoftAssert softAssert = new SoftAssert();

    @FrameworkAnnotation(author = "K.P Theva", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
    @Test(description = "Spades app Checkout Page Test")
    public void verifyCheckoutPage() throws IOException {

        landingPage.PayBillClick();
        softAssert.assertTrue(checkoutPage.isCheckoutPageDisplayed(),"doesn't displaying checkout page");
        softAssert.assertTrue(checkoutPage.isStaffTitleDisplayed(),"doesn't displaying Staff Title in Checkout Page ");

        String staffName = checkoutPage.getStaffName();
        softAssert.assertEquals(staffName,staffName,"doesn't displaying Staff Name in checkout Page");

        String tableNumber = checkoutPage.getTable();
        softAssert.assertEquals(tableNumber,tableNumber,"doesn't displaying Table Number in checkout Page");

        checkoutPage.itemsDetailsShow();


        softAssert.assertAll();
    }

}
