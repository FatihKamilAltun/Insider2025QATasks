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


        /*Go to https://useinsider.com/careers/quality-assurance/, click “See all QA jobs”, filter
        jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”, check the
        presence of the job list*/

        //Go to 'https://useinsider.com/careers/quality-assurance/' url
        Driver.getDriver().get(ConfigReader.getProperty("qaJobsUrl"));

        //Accept cookies
        insiderHomePage.webSiteCookie.click();

        //Click the See QA Jobs button
        qaJobsPage.seeAllQAJobsButton.click();
        Thread.sleep(5000);

        //Select the desired location from the location dropdown
        Select selectLocation = new Select(qaJobsPage.filterByLocationDropDown);
        selectLocation.selectByVisibleText("Istanbul, Turkey");

        //Select the desired department from the department dropdown
        Select selectDepartment = new Select(qaJobsPage.filterByDepartmentDropDown);
        selectDepartment.selectByVisibleText("Quality Assurance");
        Thread.sleep(3000);

        //Scroll the page until View Role button
        actions.scrollToElement(qaJobsPage.viewRoleButton).perform();
        Thread.sleep(7000);


        /*Check that all jobs’ Position contains “Quality Assurance”, Department contains
        “Quality Assurance”, and Location contains “Istanbul, Turkey”*/

        //Check each position element. If it contains 'QA' or 'Quality Assurance', increment the flag.
        //Print the message 'QA' or 'Quality Assurance' is present in as many positions as the flag and reset the flag.
        for (WebElement position : qaJobsPage.positionList) {

            if (position.getText().contains("QA") || position.getText().contains("Quality Assurance")) {
                flag++;
            }

        }
        System.out.println(flag+" jobs listed position contains 'QA' or 'Quality Assurance'");
        flag=0;

        //Check each position department element. If it contains 'QA' or 'Quality Assurance', increment the flag.
        //Print the message 'QA' or 'Quality Assurance' is present in as many positions department as the flag and reset the flag.
        for (WebElement positionDepartment : qaJobsPage.positionDepartmentList) {

            if (positionDepartment.getText().contains("QA") || positionDepartment.getText().contains("Quality Assurance")) {
                flag++;
            }

        }
        System.out.println(flag+" jobs listed department contains 'QA' or 'Quality Assurance'");
        flag=0;

        //Check each location element. If it contains 'Istanbul, Turkey', increment the flag.
        //Print the message 'Istanbul, Turkey' is present in as many locations as the flag and reset the flag.
        for (WebElement location : qaJobsPage.locationList) {

            if (location.getText().contains("Istanbul, Turkey")) {
                flag++;
            }

        }
        System.out.println(flag+" jobs listed location contains 'Istanbul, Turkey'");
        flag=0;


        /*Click the “View Role” button and check that this action redirects us to the Lever
        Application form page*/

        //Click the View Role button
        qaJobsPage.viewRoleButton.click();
        Thread.sleep(2000);

        //Get the current window handle value and assign it to the string value.
        //Create an empty string value for the window handle value of the newly opened tab.
        //Assign the window handle values of both tabs to a set.
        //Check each window handle value.
        //If the checked window handle value does not belong to the first tab, assign it to the created String value of the second tab.
        String currentTabWindowHandleValue = Driver.getDriver().getWindowHandle();
        String newTabWindowHandleValue = "";

        Set<String> windowHandleSet = Driver.getDriver().getWindowHandles();
        for (String each : windowHandleSet) {
            if (!each.equals(currentTabWindowHandleValue)) {
                newTabWindowHandleValue = each;
            }
        }


        //Go to the new(second) tab
        Driver.getDriver().switchTo().window(newTabWindowHandleValue);

        //Get the current url
        String currentUrl=Driver.getDriver().getCurrentUrl();

        //If current url contains 'lever' print message
        if (currentUrl.contains("lever")){
            System.out.println("Verified That Directed to Lever Application Form Page");
        }

        //Scroll the page until Lever Logo
        actions.scrollToElement(qaJobsPage.leverLogo).perform();

        //If Lever Logo displayed print message
        if (qaJobsPage.leverLogo.isDisplayed()){
            System.out.println("Verified That Lever Logo Displayed");
        }

        //Dismiss the cookie
        qaJobsPage.leverPageCookieDismissButton.click();

        //Try take screenshot of the redirected page, if not print message
        try {
            screenShot.getScreenshot("Directed to Lever Application Form Page");
        }catch (Exception e){
            System.out.println("Could Not Take Screenshot");
        }

        //Close the browser
        Driver.closeDriver();

    }
}
