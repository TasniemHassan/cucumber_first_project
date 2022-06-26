package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SellMyCarPage {
    public SellMyCarPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className="sc-cc10da00-0")
    public WebElement getARealOfferText;

    @FindBy(css=".sc-4ef54ea5-17")
    public WebElement wePickUpYourCarText;

    @FindBy(css="button[data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(css=".FormInput-oo6j68-5")
    public WebElement vinInputField;

    @FindBy(css="button[data-cv-test='heroGetMyOfferButton']")
    public WebElement getMyOfferButton;

    @FindBy(css=".sc-fTFLOO")
    public WebElement weCouldntFindVinText;
}
