package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.FuehldichfitPage;

public class FuehldichfitDefss  {


    FuehldichfitPage fuehldichfit = new FuehldichfitPage();




    @When("Click an fühldichfit and check to text")
    public void clickAnFühldichfitAndCheckToText() {
        fuehldichfit.fuehlFit();
    }

    @Then("RandomToFitsAndRandomToProduct")
    public void randomtofitsandrandomtoproduct() {
        fuehldichfit.fuehlFitProductss();
    }

    @And("AddToBagAndCheckout")
    public void addtobagandcheckout() {
        fuehldichfit.changeTheQuantityInDerWarenkorb();
        fuehldichfit.addtoBagAndCheckout();
    }

    @And("Delete the first product")
    public void deleteTheFirstProduct() {
        fuehldichfit.deleteTheFirstProduct();

    }
}
