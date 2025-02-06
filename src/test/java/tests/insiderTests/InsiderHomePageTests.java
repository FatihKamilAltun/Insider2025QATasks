package tests.insiderTests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.InsiderHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScreenShot;


public class InsiderHomePageTests {

    InsiderHomePage insiderHomePage = new InsiderHomePage();
    Actions actions = new Actions(Driver.getDriver());
    ScreenShot screenShot = new ScreenShot();

    @Test
    public void homePageTests() throws InterruptedException {

        /*Visit 'https://useinsider.com/' and check Insider home page is opened or not*/


        //Go to 'https://useinsider.com/' url
        Driver.getDriver().get(ConfigReader.getProperty("insiderHomePageUrl"));

        //Accept cookies
        insiderHomePage.webSiteCookie.click();
        Thread.sleep(1000);

        //Try home page is viewed take screenshot, if not print message
        try {
            screenShot.getScreenshot("Home Page Viewed Successfully");
        }catch (Exception e){
            System.out.println("Could Not Take Screenshot");
        }

        //If logo in the home page is displayed print message
        if (insiderHomePage.insiderLogo.isDisplayed()) {
            System.out.println("Home Page Viewed Successfully");
        }

        /*Select the “Company” menu in the navigation bar, select “Careers” and check Career
        page, its Locations, Teams, and Life at Insider blocks are open or not*/


        //Click the Company Menu
        insiderHomePage.navBarCompanyMenu.click();
        Thread.sleep(1000);

        //Click the Career Menu
        insiderHomePage.companyMenuCareersSubMenu.click();
        Thread.sleep(2000);

        //Scroll the page until See all Teams button
        actions.scrollToElement(insiderHomePage.seeAllTeamsButton).perform();

        //Press the Arrow Down key
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);

        //If button is displayed print message
        if (insiderHomePage.seeAllTeamsButton.isDisplayed()) {
            System.out.println("All Teams Blocks Displayed Successfully");
        }
        Thread.sleep(2000);

        //Click the See all Teams button
        insiderHomePage.seeAllTeamsButton.click();
        Thread.sleep(1000);

        //Press the Page Down key
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

        //Scroll the page until Our Locations title
        actions.scrollToElement(insiderHomePage.ourLocationsCategoryTitle).perform();
        Thread.sleep(1000);

        //Press the Page Down key
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //If title is displayed print message
        if (insiderHomePage.ourLocationsCategoryTitle.isDisplayed()) {
            System.out.println("Our Locations Blocks Displayed Successfully");
        }
        Thread.sleep(3000);

        //Scroll the page until Life at Insider title
        actions.scrollToElement(insiderHomePage.lifeAtInsiderHeadingTitle).perform();
        Thread.sleep(1000);

        //Press the Page Down key
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //If title is displayed print message
        if (insiderHomePage.lifeAtInsiderHeadingTitle.isDisplayed()) {
            System.out.println("Life at Insider Blocks Displayed Successfully");
        }

        //Close the browser
        Driver.closeDriver();
    }
}