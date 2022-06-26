package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarFinderPage {
    public CarFinderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css=".leftSide h1")
    public WebElement whatCarShouldIGetHeader;

    @FindBy(css=".leftSide h3")
    public WebElement carFindCanHelpTextHeader3;

    @FindBy(css="a[data-qa='router-link']")
    public WebElement tryCarFinderLink;

}
