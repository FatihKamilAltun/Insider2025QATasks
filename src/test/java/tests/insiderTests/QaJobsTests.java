package tests.insiderTests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.InsiderHomePage;
import pages.QaJobsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScreenShot;

import java.util.Set;

public class QaJobsTests {

    QaJobsPage qaJobsPage = new QaJobsPage();
    InsiderHomePage insiderHomePage = new InsiderHomePage();
    Actions actions = new Actions(Driver.getDriver());
    ScreenShot screenShot = new ScreenShot();

    int flag = 0;

    @Test
    public void qaJobsTest() throws InterruptedException {


        Driver.getDriver().get(ConfigReader.getProperty("qaJobsUrl"));
        insiderHomePage.webSiteCookie.click();

        qaJobsPage.seeAllQAJobsButton.click();
        Thread.sleep(5000);

        Select selectLocation = new Select(qaJobsPage.filterByLocationDropDown);
        selectLocation.selectByVisibleText("Istanbul, Turkey");

        Select selectDepartment = new Select(qaJobsPage.filterByDepartmentDropDown);
        selectDepartment.selectByVisibleText("Quality Assurance");

        Thread.sleep(3000);

        actions.scrollToElement(qaJobsPage.viewRoleButton).perform();

        Thread.sleep(7000);

        for (WebElement position : qaJobsPage.positionList) {

            if (position.getText().contains("QA") || position.getText().contains("Quality Assurance")) {
                flag++;
            }

        }
        System.out.println(flag+" jobs listed position contains 'QA' or 'Quality Assurance'");
        flag=0;

        for (WebElement positionDepartment : qaJobsPage.positionDepartmentList) {

            if (positionDepartment.getText().contains("QA") || positionDepartment.getText().contains("Quality Assurance")) {
                flag++;
            }

        }
        System.out.println(flag+" jobs listed department contains 'QA' or 'Quality Assurance'");
        flag=0;

        for (WebElement location : qaJobsPage.locationList) {

            if (location.getText().contains("Istanbul, Turkey")) {
                flag++;
            }

        }
        System.out.println(flag+" jobs listed location contains 'Istanbul, Turkey'");


        qaJobsPage.viewRoleButton.click();
        Thread.sleep(2000);

        String currentTabWindowHandleValue = Driver.getDriver().getWindowHandle();
        String newTabWindowHandleValue = "";

        Set<String> windowHandleSet = Driver.getDriver().getWindowHandles();
        for (String each : windowHandleSet) {
            if (!each.equals(currentTabWindowHandleValue)) {
                newTabWindowHandleValue = each;
            }
        }


        Driver.getDriver().switchTo().window(newTabWindowHandleValue);
        String currentUrl=Driver.getDriver().getCurrentUrl();

        if (currentUrl.contains("lever")){
            System.out.println("Verified That Directed to Lever Application Form Page");
        }

        actions.scrollToElement(qaJobsPage.leverLogo).perform();
        if (qaJobsPage.leverLogo.isDisplayed()){
            System.out.println("Verified That Lever Logo Displayed");
        }

        qaJobsPage.leverPageCookieDismissButton.click();

        try {
            screenShot.getScreenshot("Directed to Lever Application Form Page");
        }catch (Exception e){
            System.out.println("Could Not Take Screenshot");
        }

        Driver.closeDriver();

    }
}
