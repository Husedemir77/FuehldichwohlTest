package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import pages.Covid19Page;


public class Covid19StepDefs {


    Covid19Page covid19Page = new Covid19Page();

    @Then("Hover on Covid menu")
    public void hoverOnCovidMenu() {
        covid19Page.hoverOnCovid();
    }

    @And("check the Covid menu link")
    public void checkTheCovidMenuLink() {

        covid19Page.checkTheCovidMenu();

    }

    @And("Covid menu random add a Product in den Warenkorb")
    public void covidMenuRandomAddAProductInDenWarenkorb() throws InterruptedException {

        covid19Page.covidMenuRandomAddAProduct();


    }



}
