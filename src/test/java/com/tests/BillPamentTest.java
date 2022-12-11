package com.tests;

import base.BaseTest;
import com.automate.customAnnotations.FrameworkAnnotation;
import com.automate.driver.DriverManager;
import com.automate.enums.CategoryType;
import com.automate.utils.configloader.JsonUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class BillPamentTest extends BaseTest {

    @FrameworkAnnotation(author = "User-1", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
    @Test(description = "BillpaymentProcess")
    public void billPaymentProcess() throws IOException {
        DriverManager.getDriver().get(JsonUtils.getValue("url"));
//        ScreenActions.staticWait(2);
     //   BillPayment.LandingToSpadesApplication();
      //  BillPayment.enterTablenumber("99");
    }
}
