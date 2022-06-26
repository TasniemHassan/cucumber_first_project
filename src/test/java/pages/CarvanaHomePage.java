package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaHomePage {

    public CarvanaHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[data-cv-test='headerCarFinderLink']")
    public WebElement carFinderButton;

    @FindBy(css= "a[data-cv-test='headerTradesLink']")
    public WebElement sellTradeMenuItemLink;

    @FindBy(css = "div[data-cv-test='headerFinanceDropdown']")
    public WebElement financingMenuItemLink;

}
