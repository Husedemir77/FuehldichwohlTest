package stepDefinitions;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Alle_ProduktePage;
import utillities.Driver;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AlleProdukteSteps {

    Alle_ProduktePage alle_produktePage = new Alle_ProduktePage();

    @Given("^user on Home Page$")
    public void user_on_Home_Page() {
        alle_produktePage.getHomePage();

    }


    @When("^user navigate to Alle Produkte Page$")
    public void userNavigateToAlleProduktePage() {
        alle_produktePage.getAlleProduktePage();


    }

    @Then("^all product images should be visible$")
    public void allProductImagesShouldBeVisible() {
        alle_produktePage.allProducktVisible();

    }

    @Then("^all product links should be properly defined$")
    public void allProductLinksShouldBeProperlyDefined() {
        alle_produktePage.allProducktLinks();


    }

    @Then("^all product should be properly defined,when click to basket button$")
    public void allProductShouldBeProperlyDefinedWhenClickToBasketButton() {
        alle_produktePage.randomProducktBasketButton();

    }

    @Then("^all product images should be properly defined,when click to images magnification button$")
    public void allProductImagesShouldBeProperlyDefinedWhenClickToImagesMagnificationButton() {
        alle_produktePage.imageMagnification();

    }

    @Then("user can navigate to the product purchase page")
    public void user_can_navigate_to_the_product_purchase_page() {
       alle_produktePage.producktPurchase();
    }

    @Then("user click to lieferung checkbox")
    public void user_click_to_lieferung_checkbox() {
        alle_produktePage.lieferungClick();
    }
    @Then("user should fill to the Rechnungdetails field")
    public void user_should_fill_to_the_rechnungdetails_field(DataTable dataTable) {
        Map<String,String> map=dataTable.asMap(String.class,String.class);
        alle_produktePage.addRechnungDetails(map);

    }

    @Then("user should fill to the Lieferungdetails field")
    public void user_should_fill_to_the_lieferungdetails_field(DataTable dataTable) {
        Map<String,String> map=dataTable.asMap(String.class,String.class);
        alle_produktePage.addLieferungDetails(map);

    }
    @Then("user should be able to update the Warenkorb")
    public void user_should_be_able_to_update_the_warenkorb() throws InterruptedException {

        alle_produktePage.warenkorbArrowUpUpdate();
        alle_produktePage.warenkorbArrowDownUpdate();
    }
    @Then("user should be able to send the quantity in the warenkorb")
    public void user_should_be_able_to_send_the_quantity_in_the_warenkorb() throws InterruptedException {
        alle_produktePage.warenkorbQuantityUpdate();
    }
    @Then("user should be able to check the summe in Warenkorb")
    public void user_should_be_able_to_check_the_summe_in_warenkorb() {

        alle_produktePage.warenkorbSummeControl();
    }
    @Then("user should be able to add bewertungen")
    public void user_should_be_able_to_add_bewertungen(DataTable dataTable)throws InterruptedException {
        Map<String,String> map=dataTable.asMap(String.class,String.class);
        alle_produktePage.bewertungenAdd(map);

    }
}