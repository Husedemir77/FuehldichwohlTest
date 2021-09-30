package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pages.FuehldichgesundPage;


public class FueldichGesundStDefs {


    FuehldichgesundPage fdgPage = new FuehldichgesundPage();


    @Given("Navigate to as {string}")
    public void navigateToAs(String url) {
        fdgPage.navigateToPage(url);
    }


    @Then("Hover on fuehldichgesund menu")
    public void hoverOnFuehldichgesundMenu()  {
        fdgPage.moveToElement(fdgPage.fuhlDichGesundMenu);

    }

    @And("check the menu link")
    public void checkTheMenuLink() {
        fdgPage.checkTheMenuLink();

    }

    @And("Hover fuehldichgesundMenus und check")
    public void hoverFuehldichgesundMenusUndCheck()  {
        fdgPage.hoverFuehldichgesundMenus();
    }


    @And("go to subMenus und Product check")
    public void goToSubMenusUndProductCheck() {
        fdgPage.navigateSubMenusAndCheck();
    }


    @And("Random go to submenus und random add a Product in den Warenkorb")
    public void randomGoToSubmenusUndRandomAddAProductInDenWarenkorb() throws InterruptedException {
        fdgPage.randomSubMenusAddProduct();
    }


    @Then("check in den Warenkorb a product")
    public void checkInDenWarenkorbAProduct() {
        fdgPage.checkInDenWarenkorb();
    }

    @Then("change the quantity in der Warenkorb")
    public void changeTheQuantityInDerWarenkorb() throws InterruptedException {
        fdgPage.changeTheQuantity();
    }

    @And("check pries and zwischensumme")
    public void checkPriesAndZwischensumme() {
        fdgPage.checkPriesAndSum();
    }


    @Then("remove the product")
    public void removeTheProduct() {
        fdgPage.removeThePro();
    }

    @And("check the not")
    public void checkTheNot() {
        fdgPage.checkTheNot();
    }

    @And("go to Warenkorb")
    public void goToWarenkorb() {
        fdgPage.goToWarenkorb();
    }
}
