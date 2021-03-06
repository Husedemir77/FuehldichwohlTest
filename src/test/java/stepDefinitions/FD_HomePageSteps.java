package stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import pages.FD_HomePagePages;



public class FD_HomePageSteps {


    FD_HomePagePages fdHomePagePages = new FD_HomePagePages();

    @Given("^navigate to FDW page$")
    public void navigateToFDWPage() {

        fdHomePagePages.navigateToPage();
    }

    @When("^user scrolls down the Page it should load correctly\\.$")
    public void userScrollsDownThePageItShouldLoadCorrectly() {

        fdHomePagePages.scrolling();

    }

    @Then("^images and logos on the Home page should be visible$")
    public void imagesAndLogosOnTheHomePageShouldBeVisible() {
    }


    @Then("^quit the driver$")
    public void quitTheDriver() {
        fdHomePagePages.quitDriver();
    }

    @Then("^check the main tab buttons$")
    public void checkTheMainTabButtons() {
        fdHomePagePages.checkTheButtons();
    }

    @Then("^user check the search function$")
    public void userCheckTheSearchFunction() {

        fdHomePagePages.searchFunction();
    }

    @Then("^user back to mainpage$")
    public void userBackToMainpage() {

    }

    @And("^user click on the main menu buttons$")
    public void userClickOnTheMainMenuButtons() {
        fdHomePagePages.checkLinkTexts(fdHomePagePages.fDG_mainpageBottom, "fühldichgesund");
        fdHomePagePages.checkLinkTexts(fdHomePagePages.fDF_mainpageBottom, "fühldichfit");
        fdHomePagePages.checkLinkTexts(fdHomePagePages.fDE_mainpageBottom, "fühldichentspannt");
        //  fdHomePagePages.checkLinkTexts(fdHomePagePages.mainPageLayer,"Alle Produkte");


    }


    @Then("header texts should match")
    public void headerTextsShouldMatch() {


    }


    @When("user click on a product text and price should match")
    public void userClickOnAProductTextAndPriceShouldMatch() {
        fdHomePagePages.checkProductsInfo();

    }

    @Then("user check the mainpage titel")
    public void userCheckTheMainpageTitel() {
        fdHomePagePages.getPageTitle();

    }
}
