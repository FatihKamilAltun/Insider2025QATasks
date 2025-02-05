package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class InsiderHomePage {

    public InsiderHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement webSiteCookie;

    @FindBy(xpath = "//img[@alt='insider_logo']")
    public WebElement insiderLogo;

    @FindBy(xpath = "(//a[@id='navbarDropdownMenuLink'])[5]")
    public WebElement navBarCompanyMenu;

    @FindBy(xpath = "//span[@class='ins-close-button']")
    public WebElement bigPopUpCloseButton;

    @FindBy(xpath = "//a[text()='Careers']")
    public WebElement companyMenuCareersSubMenu;

    @FindBy(xpath = "//h3[@class='category-title-media ml-0']")
    public WebElement ourLocationsCategoryTitle;

    @FindBy(xpath = "(//h2[@class='elementor-heading-title elementor-size-default'])[2]")
    public WebElement lifeAtInsiderHeadingTitle;

    @FindBy(xpath = "//a[text()='See all teams']")
    public WebElement seeAllTeamsButton;




}
