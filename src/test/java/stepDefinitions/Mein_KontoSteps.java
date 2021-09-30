package stepDefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Mein_KontoPage;

public class Mein_KontoSteps {

    Mein_KontoPage mein_kontoPage=new Mein_KontoPage();

    @When("user navigate to Mein Konto Page")
    public void user_navigate_to_mein_konto_page() {
       mein_kontoPage.getMeinKontoPage();
    }


   @Then("user should be able to create a account")
    public void userShouldBeAbleToCreateAAccount() {

        mein_kontoPage.meinKontoCreate();
    }


}
