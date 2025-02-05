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

        Driver.getDriver().get(ConfigReader.getProperty("insiderHomePageUrl"));
        insiderHomePage.webSiteCookie.click();
        Thread.sleep(1000);

        try {
            screenShot.getScreenshot("Home Page Viewed Successfully");
        }catch (Exception e){
            System.out.println("Could Not Take Screenshot");
        }


        if (insiderHomePage.insiderLogo.isDisplayed()) {
            System.out.println("Home Page Viewed Successfully");
        }

        insiderHomePage.navBarCompanyMenu.click();
        Thread.sleep(1000);

        insiderHomePage.companyMenuCareersSubMenu.click();
        Thread.sleep(2000);

        actions.scrollToElement(insiderHomePage.seeAllTeamsButton).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(2000);
        actions.moveToElement(insiderHomePage.seeAllTeamsButton).perform();
        Thread.sleep(2000);
        if (insiderHomePage.seeAllTeamsButton.isDisplayed()) {
            System.out.println("All Teams Blocks Displayed Successfully");
        }
        Thread.sleep(2000);


        insiderHomePage.seeAllTeamsButton.click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);


        actions.scrollToElement(insiderHomePage.ourLocationsCategoryTitle).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        if (insiderHomePage.ourLocationsCategoryTitle.isDisplayed()) {
            System.out.println("Our Locations Blocks Displayed Successfully");
        }
        Thread.sleep(3000);


        actions.scrollToElement(insiderHomePage.lifeAtInsiderHeadingTitle).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        if (insiderHomePage.lifeAtInsiderHeadingTitle.isDisplayed()) {
            System.out.println("Life at Insider Blocks Displayed Successfully");
        }

        Driver.closeDriver();
    }
}