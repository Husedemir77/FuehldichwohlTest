package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utillities.ParentClass;

import java.util.List;
import java.util.Random;

public class FuehldichfitPage extends ParentClass {



    By fuehldichfit = By.id("menu-item-5957");
    By fuehldichfitText = By.xpath("//h1[@class='qodef-m-title entry-title']");
    By fuehlFitMenu = By.xpath("(//div [@class='vc_row wpb_row vc_row-fluid'])[4]");
    By fuehlFitProducts = By.xpath("//div[@class='qodef-woo-product-inner']/parent::*");
    By buttonWirk = By.cssSelector("#select2-pa_wirkstoffdosierung-container");
    By inhalt = By.xpath("(//ul[@class='select2-results__options']/li)[2]");
    By buttoninhalt = By.cssSelector("#select2-pa_inhalt-container");
    By buttonwarenkorb = By.xpath("//button[@class='single_add_to_cart_button button alt disabled wc-variation-selection-needed']");
    By button_Warenkorb = By.xpath("//i[@class='groovy-69018-handbag']"); //i[@class='groovy-69018-handbag']
    By zurWarenkorb = By.xpath("//a[contains(text(), 'Warenkorb anzeigen')]");
    By stueck= By.xpath("//div[@class='qodef-quantity-buttons quantity']//input");
    By buttonUpdate = By.xpath("//button[@name='update_cart']");
    By zurKasse = By.xpath("//a[@class='checkout-button button alt wc-forward']");
    By name = By.id("billing_first_name");
    By surName = By.id("billing_last_name");
    By company = By.id("billing_company");
    By street = By.id("billing_address_1");
    By postCode= By.id("billing_postcode");
    By city = By.id("billing_city");
    By phone = By.id("billing_phone");
    By eMail = By.id("billing_email");
    By subMenuu = By.xpath("(//div[@class='wpb_column vc_column_container vc_col-sm-6'])[1]");
    By productFirst = By.xpath("(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[1]");
    By indenWarenkorbb = By.xpath("(//button[@name='add-to-cart'])");
    By productSecond = By.xpath("(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[2]");
    By product2Inhaltt = By.xpath("(//td[@class='value'])[1]");
    By product2Inhaltt90 = By.xpath("((//ul[@class='select2-results__options'])/li)[2]");
    By product2Wirkstof = By.xpath("(//td[@class='value'])[2]");
    By product2Wirkstof1 = By.xpath("((//ul[@class='select2-results__options'])/li)[2]");
    By indenWarenkorbOne = By.xpath("(//button[@type='submit'])[2]");
    By productThree = By.xpath("(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[3]");
    By orderUpp = By.xpath("(//span[@class='qodef-quantity-plus'])");
    By indenWarenkorbSecond = By.xpath("(//button[@name='add-to-cart'])");
    By viewShoppingCartt = By.xpath("//a[@class='button wc-forward']");
    By firstProductt = By.xpath("(((//tbody)[1]/tr)[1])/td");
    By firstProductOne = By.xpath("((//ul[@class='woocommerce-mini-cart cart_list product_list_widget '])/li)/a");














    public void fuehlFit(){
       clickTo(fuehldichfit);
        //verifyElementContainsText(fuehldichfitText, "fühldichfit");
    }



    public void fuehlFitProductss(){
        WebElement fuhlDichSpantMenu = driver.findElement(By.id("menu-item-5957"));
        Actions actions = new Actions(driver);
        actions.moveToElement(fuhlDichSpantMenu).perform();
        List<WebElement> menus = driver.findElements(By.xpath("(//div [@class='vc_row wpb_row vc_row-fluid'])[4]"));
        Random random = new Random();
        int randomZahl = menus.size();
        int randomSubMenus = random.nextInt(randomZahl);
        actions.moveToElement(menus.get(randomSubMenus)).click().perform();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/parent::*"));
        int productZahl = products.size();
        int randomProduct = random.nextInt(productZahl);
        actions.moveToElement(products.get(randomProduct)).click().perform();

        if (driver.findElement(By.xpath("//label[(text()='Wirkstoffdosierung')]")).isDisplayed() ){
            WebElement buttonInhalt = driver.findElement(By.cssSelector("#select2-pa_wirkstoffdosierung-container"));
            buttonInhalt.click();
            WebElement Inhalt = driver.findElement(By.xpath("(//ul[@class='select2-results__options']/li)[2]"));
            Inhalt.click();
        }

        if (driver.findElement(By.xpath("//label[contains(text(), 'Inhalt')]")).isDisplayed() ){
            WebElement buttonInhalt = driver.findElement(By.cssSelector("#select2-pa_inhalt-container"));
            buttonInhalt.click();
            WebElement inhalt = driver.findElement(By.xpath("(//ul[@class='select2-results__options']/li)[2]"));
            inhalt.click();
        }

        WebElement buttonWarenkorb = driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']"));
        buttonWarenkorb.click();


    }

    public void changeTheQuantityInDerWarenkorb() {

        WebElement buttonWarenkorb = driver.findElement(button_Warenkorb);
        buttonWarenkorb.click();
        WebElement zurWarenkorbb = driver.findElement(zurWarenkorb);
        zurWarenkorbb.click();
        // Thread.sleep(3000);

//        WebElement firstPries = driver.findElement(By.xpath("//td[@class='product-price']//span//bdi"));
//        String firstPriesText = firstPries.getText();
//        System.out.println(firstPriesText);

        WebElement stuck = driver.findElement(stueck);
        stuck.clear();
        stuck.sendKeys("4");
        WebElement buttonUpdatee = driver.findElement(buttonUpdate);
        buttonUpdatee.click();
        // waiting(2000);
        //Thread.sleep(3000);

        WebElement zurKassee = driver.findElement(zurKasse);
        zurKassee.click();


    }

    public void addtoBagAndCheckout(){

       clickTo(name);
        sendKeysTo(name,"Tutus Media");
        clickTo(surName);
       sendKeysTo(surName, "Tester");
        //clickTo(company);
       sendKeysTo(company, "Tutus");
        //clickTo(street);
       sendKeysTo(street, "Tutus Str.");
     //clickTo(postCode);
        sendKeysTo(postCode, "35041");
        //clickTo(city);
       sendKeysTo(city, "Frankfurt");
        //clickTo(phone);
       sendKeysTo(phone, "0123456789");
       clear(eMail);
      sendKeysTo(eMail, "testuser@tutusmedia.com");

    }

    public void deleteTheFirstProduct(){
        Actions actions = new Actions(driver);
        WebElement mainMenu = driver.findElement(fuehldichfit);
        actions.moveToElement(mainMenu);

        WebElement subMenu = driver.findElement(subMenuu);
        actions.moveToElement(subMenu);
        actions.click().build().perform();

        WebElement product1= driver.findElement(productFirst);
        product1.click();

        WebElement indenWarenkorb= driver.findElement(indenWarenkorbb);
        indenWarenkorb.click();
        driver.navigate().back();
        driver.navigate().back();

        WebElement product2= driver.findElement(productSecond);
        product2.click();
        //waiting(1000);
        WebElement product2Inhalt= driver.findElement(product2Inhaltt);
        product2Inhalt.click();
        //li[@class='select2-results__option select2-results__option--highlighted']
        //waiting(1000);
        WebElement product2Inhalt90= driver.findElement(product2Inhaltt90);
        product2Inhalt90.click();
        //waiting(1000);
        WebElement product2Wirkstoff= driver.findElement(product2Wirkstof);
        product2Wirkstoff.click();
        WebElement product2Wirkstoff1= driver.findElement(product2Wirkstof1);
        product2Wirkstoff1.click();
        WebElement indenWarenkorb1 = driver.findElement(indenWarenkorbOne);
        indenWarenkorb1.click();
        driver.navigate().back();
        driver.navigate().back();

        WebElement product3= driver.findElement(productThree);
        product3.click();
        WebElement orderUp = driver.findElement(orderUpp);
        orderUp.click();
        WebElement indenWarenkorb2 = driver.findElement(indenWarenkorbSecond);
        indenWarenkorb2.click();

        WebElement buttonWarenkorb = driver.findElement(button_Warenkorb);
        buttonWarenkorb.click();

        WebElement viewShoppingCart = driver.findElement(viewShoppingCartt);
        viewShoppingCart.click();

        // WebElement buttonWarenkorb1 = driver.findElement(By.xpath("//i[@class='groovy-69018-handbag']"));
        // buttonWarenkorb1.click();
        //WebElement firstProduct1 = driver.findElement(By.xpath("(//ul[@class='woocommerce-mini-cart cart_list product_list_widget '])/li"));
        //firstProduct1.clear();

        WebElement firstProduct = driver.findElement(firstProductt);
        //waiting(2000);
        firstProduct.click();
        //waiting(2000);
        actions.clickAndHold();
        WebElement buttonWarenkorb1 = driver.findElement(button_Warenkorb);
        //waiting(2000);
        buttonWarenkorb1.click();
        //waiting(2000);
        actions.clickAndHold();
        WebElement firstProduct1 = driver.findElement(firstProductOne);
        firstProduct1.click();
        //waiting(2000);

    }

}
