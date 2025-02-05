package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class QaJobsPage {

    public QaJobsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[text()='See all QA jobs']")
    public WebElement seeAllQAJobsButton;

    @FindBy(xpath = "//select[@name='filter-by-location']")
    public WebElement filterByLocationDropDown;

    @FindBy(xpath = "//select[@name='filter-by-department']")
    public WebElement filterByDepartmentDropDown;

    @FindBy(xpath = "//p[@class='position-title font-weight-bold']")
    public List<WebElement> positionList;

    @FindBy(xpath = "//span[@class='position-department text-large font-weight-600 text-primary']")
    public List<WebElement> positionDepartmentList;

    @FindBy(xpath = "//div[@class='position-location text-large']")
    public List<WebElement> locationList;

    @FindBy(xpath = "(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'])[2]")
    public WebElement viewRoleButton;

    @FindBy(xpath = "//img[@alt='Lever logo']")
    public WebElement leverLogo;

    @FindBy(xpath = "(//button[@class='button button-sm cc-btn cc-dismiss'])[1]")
    public WebElement leverPageCookieDismissButton;
}
