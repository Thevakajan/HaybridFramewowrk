package com.tests.webTest;

import base.WebBaseTest;
import com.automate.customAnnotations.FrameworkAnnotation;
import com.automate.enums.CategoryType;
import org.testng.annotations.Test;

import static com.automate.pages.spadesapp.SpadesLandingPage.LandingToSpadesApplication;

public class SpadesLandingTest extends WebBaseTest {



    @FrameworkAnnotation(author = "K.P Theva", category = {CategoryType.REGRESSION, CategoryType.SANITY, CategoryType.SMOKE})
    @Test(description = "Spades app Bill Landing Test")
    public void verifyLandingPage(){
        LandingToSpadesApplication();
    }

}
