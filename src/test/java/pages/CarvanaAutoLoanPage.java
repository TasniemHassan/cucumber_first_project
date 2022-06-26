package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaAutoLoanPage {

    public CarvanaAutoLoanPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@data-cv-test='headerFinanceLoanCalc']")
    public WebElement autoLoan;

    @FindBy(xpath = "//input[@name='vehiclePrice']")
    public WebElement vehiclePrice;

    @FindBy(id = "creditBlock")
    public WebElement creditStore;

    @FindBy(xpath = "//input[@name='downPayment']")
    public WebElement downPayment;

    @FindBy(xpath = "//div[contains(@class, 'loan-calculator-display is-monthly-display')]")
    public WebElement montlyPayment;

    @FindBy(xpath = "//select[@name='loanTerm']")
    public WebElement loanTerm;

}
