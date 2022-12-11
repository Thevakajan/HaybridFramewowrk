package steps;

import org.testng.Assert;
import java.io.IOException;
import static com.automate.pages.spadesapp.SpadesLandingPage.*;

public class SpadesLandingSteps   {


    public static void CustomerLandingSteps() throws IOException {
        Assert.assertTrue(isLandingPagePageDisplayed(),"That Logo is Not display here ") ;
        Assert.assertTrue(isViewMenuDisplayed(),"That Menu is Not display here");
        Assert.assertTrue(isOutletNameDisplayed(),"That outlet name is Not display here");
        Assert.assertTrue(isTableNumDisplayed(),"That Table is Not display here");
        RefreshYourBillClick();
        NotYourTableClick();
       // ViewMenuClick();
    }

}
