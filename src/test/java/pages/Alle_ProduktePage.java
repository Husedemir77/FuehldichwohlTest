package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utillities.BrowserSize;
import utillities.Driver;
import utillities.ParentClass;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Alle_ProduktePage extends ParentClass {


    By Cookies = By.xpath("(//button[@data-cookiefirst-outline-accent-color='true'])[1]");
    By AlleProdukteMainMenu = By.xpath("(//a[@class='gm-anchor'])[1]");
    By Links = By.xpath("//div[@class='qodef-woo-product-inner']/parent::*");
    By ImageMagnificationClick = By.xpath("(//a[@class='qodef-popup-item'])[1]");
    By ListOfImages = By.cssSelector("div.qodef-woo-product-image");
    By ImageSmall = By.xpath("(//a[@class='qodef-popup-item'])[1]");
    By ImageBig = By.cssSelector("img.mfp-img");
    By ListOfLinks = By.cssSelector("a.qodef-woo-product-title-link");
    By ProductLists = By.xpath("(//div[@class='qodef-woo-product-inner']/parent::*)[59]");
    By CartButtonList = By.cssSelector("div.qodef-woo-buttons-holder>.button");
    By AddToCartButton = By.cssSelector("button[name=add-to-cart]");
    By WarenkorbAnzeigenButton = By.cssSelector("div.woocommerce-message>.button");
    By DescriptionTab = By.cssSelector("description_tab active");
    By AdditionalInformationTab = By.cssSelector("additional_information_tab");
    By ReviewsTab = By.cssSelector("reviews_tab");
    By DescriptionText = By.cssSelector("div#tab-description");
    By ArrowPlus = By.cssSelector("span.arrow_carrot-up");
    By ArrowMinus = By.cssSelector("span.arrow_carrot-down");
    By WarencorbQuantity = By.xpath("(//span[@class='woocommerce-Price-amount amount'])[4]");
    By WarencorbQuantityText = By.xpath("//input[@class='input-text qty text qodef-quantity-input']");
    By WarenkorbAktualisieren = By.xpath("(//button[@class='button'])[2]");
    By WeiterZurKasseButton = By.xpath("//a[@class='checkout-button button alt wc-forward']");
    By WarenkorbSumme = By.xpath("(//bdi)[5]");


    // Bewertungen Locators
    By BewertungenTab=By.xpath("//li[@class='reviews_tab active']");
    By StarRating = By.cssSelector("select#rating");
    By StarFive=By.xpath("//a[@class='star-5 active']");
    By Kommentar = By.cssSelector("textarea#comment");
    By Name = By.cssSelector("input#author");
    By Email = By.cssSelector("input#email");
    By Website = By.cssSelector("input#url");
    By CommentCookiesCheckbox = By.cssSelector("input#wp-comment-cookies-consent");
    By SendenButton = By.cssSelector("button#submit");


    //Todo Kasse Locators
    By BankuberweisungCheckbox = By.cssSelector("input[id=payment_method_bacs]");
    By PaypalCheckbox = By.cssSelector("input#payment_method_paypal_plus");
    By DatenschutzerklärungCheckbox = By.cssSelector("input#terms");
    By KostenpflichtigBestellen = By.cssSelector("button#place_order");

    // Rechnungsdetails locators
    By KundenkontoCheckbox = By.id("createaccount");
    By Vorname = By.id("billing_first_name");
    By Nachname = By.cssSelector("input#billing_last_name");
    By Firmenname = By.id("billing_company");
    By Land = By.id("billing_country");
    By Strasse = By.id("billing_address_1");
    By Wohnung = By.id("billing_address_2");
    By Posleitzahl = By.id("billing_postcode");
    By Stadt = By.id("billing_city");
    By Telefon = By.id("billing_phone");
    By EMail = By.cssSelector("input[type='email']");
    //Lieferung Locators
    By LieferungCheckbox = By.cssSelector("input[id=ship-to-different-address-checkbox]");
    By Vorname2 = By.id("shipping_first_name");
    By Nachname2 = By.id("shipping_last_name");
    By Firmenname2 = By.id("shipping_company");
    By Land2 = By.id("shipping_country");
    By Strasse2 = By.id("shipping_address_1");
    By Wohnung2 = By.id("shipping_address_2");
    By Posleitzahl2 = By.id("shipping_postcode");
    By Stadt2 = By.id("shipping_city");
    By Anmerkungen = By.id("order_comments");


    public void getHomePage() {
        setBrowserSizeTo(BrowserSize.max);
        String url = "https://fuehldichwohl24.de/";

        if (!driver.getCurrentUrl().contains(url))
            driver.get(url);
        clickTo(Cookies);
    }

    public void getAlleProduktePage() {

        clickTo(AlleProdukteMainMenu);

    }

    public void allProducktVisible() {
        List<WebElement> images = getElements(ListOfImages);
        for (int i = 0; i < images.size(); i++) {
            Assert.assertTrue(images.get(i).isDisplayed());
            System.out.println(images.get(i).isDisplayed());
        }

    }

    public void allProducktLinks() {

        List<WebElement> links = getElements(ListOfLinks);
        for (int i = 0; i < links.size(); i++) {
            Assert.assertTrue(links.get(i).isEnabled());

            System.out.println(links.get(i).getText());
            System.out.println(links.get(i).isDisplayed());
        }

    }

    public void randomProducktBasketButton() {
        List<WebElement> elements = driver.findElements(CartButtonList);
        Random r = new Random();
        int randomValue = r.nextInt(elements.size());
        elements.get(randomValue).click();

    }

    public void imageMagnification() {
        List<WebElement> elements = driver.findElements(CartButtonList);
        Random r = new Random();
        int randomValue = r.nextInt(elements.size());
        elements.get(randomValue).click();
        int height1 = driver.findElement(ImageSmall).getSize().height;
        clickTo(ImageMagnificationClick);
        int height2 = driver.findElement(ImageBig).getSize().height;
        Assert.assertNotEquals(height1, height2);
        System.out.println("height1: " + driver.findElement(ImageSmall).getSize().height);
        System.out.println("height2: " + driver.findElement(ImageBig).getSize().height);

    }

    public void producktPurchase() {

//        Wait wait = new WebDriverWait(driver, 4);
//        List<WebElement> elements = driver.findElements(Links);
//        Random r = new Random();
//        int randomValue = r.nextInt(elements.size());
//        elements.get(randomValue).click();
        clickTo(ProductLists);
        clickTo(AddToCartButton);
//        clickTo(ArrowPlus);
//        clickTo(WarenkorbAktualisieren);
        clickTo(WarenkorbAnzeigenButton);

        clickTo(WeiterZurKasseButton);

    }

    public void lieferungClick() {
        clickTo(LieferungCheckbox);
    }

    public void addRechnungDetails(Map<String, String> map) {
        String vorname = map.get("Vorname");
        String nachname = map.get("Nachname");
        String firmenname = map.get("Firmenname");
        String land = map.get("Land");
        String strasse = map.get("Strasse");
        String wohnung = map.get("Wohnung");
        String postleitzahl = map.get("Posleitzahl");
        String stadt = map.get("Stadt");
        String telefon = map.get("Telefon");
        String email = map.get("EMail");
        sendKeysTo(Vorname, map.get("Vorname"));
        sendKeysTo(Nachname, nachname);
        sendKeysTo(Firmenname, firmenname);
      //  selectTo(Land,land);
        sendKeysTo(Strasse, strasse);
        sendKeysTo(Wohnung, wohnung);
        sendKeysTo(Posleitzahl, postleitzahl);
        sendKeysTo(Stadt, stadt);
        sendKeysTo(Telefon, telefon);
        sendKeysTo(Email,email);



    }

    public void addLieferungDetails(Map<String, String> map) {
        String vorname = map.get("Vorname2");
        String nachname = map.get("Nachname2");
        String firmenname = map.get("Firmenname2");
        String land = map.get("Land2");
        String strasse = map.get("Strasse2");
        String wohnung = map.get("Wohnung2");
        String postleitzahl = map.get("Posleitzahl2");
        String stadt = map.get("Stadt2");
        String anmerkungen = map.get("Anmerkungen");

        sendKeysTo(Vorname2, vorname);
        sendKeysTo(Nachname2, nachname);
        sendKeysTo(Firmenname2, firmenname);
        //  selectOption(Land2,land);
        sendKeysTo(Strasse, strasse);
        sendKeysTo(Wohnung2, wohnung);
        sendKeysTo(Posleitzahl2, postleitzahl);
        sendKeysTo(Stadt2, stadt);
        sendKeysTo(Anmerkungen, anmerkungen);
        //clickTo(BankuberweisungCheckbox);
        clickTo(DatenschutzerklärungCheckbox);
        //  clickTo(KostenpflichtigBestellen);


    }

    public void warenkorbArrowUpUpdate() throws InterruptedException {

        List<WebElement> elements = driver.findElements(ProductLists);
        Random r = new Random();
        int randomValue = r.nextInt(elements.size());
        elements.get(randomValue).click();
        clickTo(AddToCartButton);
        clickTo(WarenkorbAnzeigenButton);
        String quantity1 = driver.findElement(WarencorbQuantity).getText();
        clickTo(ArrowPlus);
        clickTo(WarenkorbAktualisieren);
        Thread.sleep(3000);
        String quantity2 = driver.findElement(WarencorbQuantity).getText();
        Assert.assertNotEquals(quantity1, quantity2);
        System.out.println("quantity1: " + quantity1);
        System.out.println("quantity2: " + quantity2);



    }

    public void warenkorbArrowDownUpdate() throws InterruptedException {
        clickTo(AlleProdukteMainMenu);
        List<WebElement> elements = driver.findElements(ProductLists);
        Random r = new Random();
        int randomValue = r.nextInt(elements.size());
        elements.get(randomValue).click();
        clickTo(AddToCartButton);
        clickTo(WarenkorbAnzeigenButton);
        String quantity1 = driver.findElement(WarencorbQuantity).getText();
        clickTo(ArrowMinus);
        clickTo(WarenkorbAktualisieren);
        Thread.sleep(3000);
        String quantity2 = driver.findElement(WarencorbQuantity).getText();
        Assert.assertNotEquals(quantity1, quantity2);
        System.out.println("quantity1: " + quantity1);
        System.out.println("quantity2: " + quantity2);


    }

    public void warenkorbQuantityUpdate() throws InterruptedException {
        List<WebElement> elements = driver.findElements(ProductLists);
        Random r = new Random();
        int randomValue = r.nextInt(elements.size());
        elements.get(randomValue).click();
        clickTo(AddToCartButton);
        clickTo(WarenkorbAnzeigenButton);
        String quantity1 = driver.findElement(WarencorbQuantity).getText();
        clear(WarencorbQuantityText);
        sendKeysTo(WarencorbQuantityText, "5");
        clickTo(WarenkorbAktualisieren);
        Thread.sleep(3000);
        String quantity2 = driver.findElement(WarencorbQuantity).getText();
        Assert.assertNotEquals(quantity1, quantity2);
        System.out.println("quantity1: " + quantity1);
        System.out.println("quantity2: " + quantity2);



    }
    public  void warenkorbSummeControl()
    {
        List<WebElement> elements = driver.findElements(ProductLists);
        Random r = new Random();
        int randomValue = r.nextInt(elements.size());
        elements.get(randomValue).click();
        clickTo(AddToCartButton);
        clickTo(WarenkorbAnzeigenButton);
        Assert.assertEquals(driver.findElement(WarencorbQuantity).getText(),driver.findElement(WarenkorbSumme).getText());
        System.out.println(driver.findElement(WarencorbQuantity).getText());
        System.out.println(driver.findElement(WarenkorbSumme).getText());
        

    }

    public void bewertungenAdd(Map<String, String> map) throws InterruptedException {
        String kommentar=map.get("Kommentar");
        String name=map.get("Name");
        String email=map.get("Email");
        String website=map.get("Website");
        List<WebElement> elements = driver.findElements(ProductLists);
        Random r = new Random();
        int randomValue = r.nextInt(elements.size());
        elements.get(randomValue).click();
        Thread.sleep(3000);
        clickTo(BewertungenTab);
        clickTo(StarFive);
        sendKeysTo(Kommentar,kommentar);
        sendKeysTo(Name,name);
        sendKeysTo(Email,email);
        sendKeysTo(Website,website);
        clickTo(CommentCookiesCheckbox);
        //clickTo(SendenButton);




    }

}







