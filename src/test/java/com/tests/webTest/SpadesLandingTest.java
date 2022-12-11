package com.tests.webTest;

import base.WebBaseTest;
import com.automate.customAnnotations.FrameworkAnnotation;
import com.automate.enums.CategoryType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import static steps.SpadesLandingSteps.CustomerLandingSteps;

public class SpadesLandingTest extends WebBaseTest {



    @FrameworkAnnotation(author = "K.P Theva", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
    @Test(description = "Spades app Bill Landing Test")
    public void verifyLandingPage() throws IOException {
        softAssert = new SoftAssert();
        CustomerLandingSteps();
        softAssert.assertAll();
    }

}
