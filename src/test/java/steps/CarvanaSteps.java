package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utils.ActionsUtil;
import utils.Driver;
import utils.Waiter;

public class CarvanaSteps {
    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarFinderPage carFinderPage;
    CarvanaHelpMeSearchPage carvanaHelpMeSearchPage;
    SellMyCarPage sellMyCarPage;
    CarvanaAutoLoanPage carvanaAutoLoanPage;


    @Before
    public void setup(){
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carFinderPage = new CarFinderPage();
        carvanaHelpMeSearchPage = new CarvanaHelpMeSearchPage();
        sellMyCarPage = new SellMyCarPage();
        carvanaAutoLoanPage = new CarvanaAutoLoanPage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
        Waiter.pause(2);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String menuItem) {
        switch(menuItem) {
            case "CAR FINDER":
                carvanaHomePage.carFinderButton.click();
                break;
            case "SELL/TRADE":
                carvanaHomePage.sellTradeMenuItemLink.click();
            break;
            case"AUTO LOAN CALCULATOR":
                carvanaAutoLoanPage.autoLoan.click();
                break;
            default:
                throw new NotFoundException(menuItem + " is not found!!!");
        }
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {

        switch (text) {
            case "WHAT CAR SHOULD I GET?":
                Assert.assertTrue(carFinderPage.whatCarShouldIGetHeader.isDisplayed());
                Assert.assertEquals(text, carFinderPage.whatCarShouldIGetHeader.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertTrue(carFinderPage.carFindCanHelpTextHeader3.isDisplayed());
                Assert.assertEquals(text, carFinderPage.carFindCanHelpTextHeader3.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertTrue(carvanaHelpMeSearchPage.whatIsMostImportantHeading.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchPage.whatIsMostImportantHeading.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertTrue(carvanaHelpMeSearchPage.subHeading.isDisplayed());
                Assert.assertEquals(text, carvanaHelpMeSearchPage.subHeading.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertTrue(sellMyCarPage.getARealOfferText.isDisplayed());
                Assert.assertEquals(text, sellMyCarPage.getARealOfferText.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertTrue(sellMyCarPage.wePickUpYourCarText.isDisplayed());
                Assert.assertEquals(text, sellMyCarPage.wePickUpYourCarText.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Waiter.pause(5);
                Assert.assertTrue(sellMyCarPage.weCouldntFindVinText.isDisplayed());
                Assert.assertEquals(text, sellMyCarPage.weCouldntFindVinText.getText());
                break;

            default:
                throw new NotFoundException(text + " is not found!!!");
        }
    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String linkText) {
        Assert.assertTrue(carFinderPage.tryCarFinderLink.isDisplayed());
        Assert.assertEquals(linkText, carFinderPage.tryCarFinderLink.getText());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String linkText) {
        carFinderPage.tryCarFinderLink.click();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonText) {
        switch(buttonText){
            case "VIN":
              sellMyCarPage.vinButton.click();
              break;
            case "GET MY OFFER":
                sellMyCarPage.getMyOfferButton.click();
                Waiter.pause(3);
                break;
            default:
                throw new NotFoundException(buttonText + " is not found!!!");

        }

    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String key) {
        sellMyCarPage.vinInputField.sendKeys(key);
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String menuItem) {
        ActionsUtil.moveToElement(carvanaHomePage.financingMenuItemLink);
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String carCost, String price) {
        switch (carCost){
            case"Cost of Car I want":
                carvanaAutoLoanPage.vehiclePrice.sendKeys(price);
                break;
            case"What is Your Down Payment?":
                carvanaAutoLoanPage.downPayment.sendKeys(price);
                break;
            default:
                throw new NotFoundException(price + " can not be found!!!");
        }


    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String element, String dropDown) {
        switch (element){
            case"What’s Your credit Score?":
                Select select = new Select(carvanaAutoLoanPage.creditStore);
                select.selectByIndex(0);
                break;
            case"Choose Your Loan Terms":
                Select select2 = new Select(carvanaAutoLoanPage.loanTerm);
                select2.selectByIndex(1);
                break;
            default:
                throw new NotFoundException(dropDown + " can not be found!!!");
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String payment) {
        Assert.assertEquals(payment, carvanaAutoLoanPage.montlyPayment.getText());
    }
}
