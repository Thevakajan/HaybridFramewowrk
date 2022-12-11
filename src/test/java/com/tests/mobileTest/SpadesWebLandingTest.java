package com.tests.mobileTest;

import base.BaseTest;
import com.automate.customAnnotations.FrameworkAnnotation;
import com.automate.driver.DriverManager;
import com.automate.enums.CategoryType;
import com.automate.utils.configloader.JsonUtils;
import org.testng.annotations.Test;
import java.io.IOException;
import static steps.SpadesLandingSteps.CustomerLandingSteps;

public class SpadesWebLandingTest extends BaseTest {


    @FrameworkAnnotation(author = "K.P Theva", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
    @Test(description = "Spades app Bill Landing Test")
    public void verifyLandingPage() throws IOException {
        DriverManager.getDriver().get(JsonUtils.getValue("url"));
        CustomerLandingSteps();
    }
}
