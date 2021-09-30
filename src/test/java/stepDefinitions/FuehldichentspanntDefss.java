package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.FuehldichentspanntPage;
import utillities.Driver;


import java.util.concurrent.TimeUnit;

public class FuehldichentspanntDefss {
     WebDriver driver;

    FuehldichentspanntPage fuehldichentspannt=new FuehldichentspanntPage();


    @Given("Navigate to FuehldichWohl")
    public void navigateToFuehldichWohl() {
        driver = Driver.getDriver();
        driver.get("https://fuehldichwohl24.de/");
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


        @When("Enter username and password and click")
        public void enterUsernameAndPasswordAndClick () {
        fuehldichentspannt.login();
        }

    @When("Click an Fuehldichentspannt and ckeck to text")
    public void clickAnFuehldichentspanntAndCkeckToText() {
        fuehldichentspannt.fuehlSpannt();
    }

    @Then("Testing of product orders")
    public void testingOfProductOrders() throws InterruptedException {
       // fuehldichentspannt.fuehlSpanntProducts();
        fuehldichentspannt.fuehlSpanntProductss();
    }
}
