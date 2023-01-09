package spadesappPages.customaterApp;

import com.automate.pages.screen.PageActionHelper;
import com.automate.reports.ExtentReportLogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.io.IOException;

import static com.automate.pages.screen.PageActionHelper.*;

public class SpadesCheckoutPage {

    public static final Logger LOG = Logger.getLogger(PageActionHelper.class);

    private static By TitleYourBill = By.xpath("//h4");
    private static By Staff = By.xpath("//span[@data-id='staff_title']");
    private static By StaffName = By.xpath("//span[@data-id='staff_name']");
    private static By TableTitle = By.xpath("//span[@data-id='table_title']");
    private static By TableNum = By.xpath("//span[@data-id='table_num']");
    private static By HideBillDetails = By.xpath("//div[@data-id='hide_details_collapse']");
    private static By ShowBillDetails = By.xpath("//div[@data-id='show_details_collapse']");


    public  boolean  isCheckoutPageDisplayed(){
        return isElementNotEnabled(TitleYourBill);
    }

    public  boolean  isStaffTitleDisplayed(){
        return isElementNotEnabled(Staff);
    }

    public  String getStaffName() {
        return getText(StaffName,"its Staff Name is Displayed");

    }
    public  String getTable() {
        return getText(TableNum,"its Table Number is Displayed");

    }

    public  boolean  isHideDetailsDisplayed(){
        return isElementNotEnabled(HideBillDetails);
    }

    public  void clickShowBillDetails() throws IOException {
        waitAndClick(ShowBillDetails,"Show Bill Details Collapse");
    }
    public  void clickHideBillDetails() throws IOException {
        waitAndClick(HideBillDetails,"Hide Bill Details Collapse");
    }


    public void itemsDetailsShow() throws IOException {

        if (isHideDetailsDisplayed()==true){

            System.out.println("Already show Bill Details");
            ExtentReportLogStatus.logInfo("Already show Bill Details");

        }else {
            clickHideBillDetails();
            System.out.println("Click on Show Bill Details ");
        }
    }


}
