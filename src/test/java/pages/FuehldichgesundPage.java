package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utillities.ParentClass;

import java.util.List;
import java.util.Random;

public class FuehldichgesundPage extends ParentClass {

//    By buttonfuehldichgesundPage = By.cssSelector("span.gm-menu-item__txt-wrapper");
//    By buttonUntenMenus = By.cssSelector("div.vc_row > div.wpb_column");

    By cookies = By.xpath("//button[@class='cf2Lf6']");
    By fuehldichgesundMenus = By.xpath("//a[@target='_self']");
    By menu2 = By.xpath("//div[@class='term-description'] // p");

    By produksAll = By.xpath("//div[@class='qodef-woo-product-inner']/parent::*");
    By zahlSteht1 = By.xpath("//p[@class='woocommerce-result-count']");
    By nameProduct = (By.xpath("//div[@class='summary entry-summary']//h1"));
    By wirkstoffdosierungButton = (By.cssSelector("#select2-pa_wirkstoffdosierung-container"));
    By inhalt = (By.xpath("(//ul[@class='select2-results__options']/li)[2]"));
    By buttonInhalt = (By.cssSelector("#select2-pa_inhalt-container"));
    By buttonWarenkorb1 = (By.xpath("//button[@class='single_add_to_cart_button button alt']"));
    By nameProduct1 = (By.xpath("//div[@class='summary entry-summary']//h1"));
    By productInWarenkorb = (By.xpath("//td[@class='product-name']//a"));
    By stuck = (By.xpath("//div[@class='qodef-quantity-buttons quantity']//input"));
    By buttonUpdate = (By.xpath("//button[@name='update_cart']"));
    By firstPries = (By.xpath("//td[@class='product-price']//span//bdi"));
    By zwischenSumme = (By.xpath("(//td[@data-title='Zwischensumme']//span//bdi)[2]"));
    By productList = By.xpath("//div[@class='qodef-woo-product-inner']/parent::*");
    By html = (By.cssSelector("html"));


    public void navigateToPage(String url) {
        driver.manage().window().maximize();
        driver.get(url);
        clickTo(cookies);
    }

    public void moveToElement(By element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(element)).perform();
    }

    public void hoverFuehldichgesundMenus() {

        Actions actions = new Actions(driver);
        moveToElement(fuhlDichGesundMenu);

        List<WebElement> menus = driver.findElements(fuehldichgesundMenus);
        actions.moveToElement(menus.get(0)).click().perform();
        WebElement menu1 = driver.findElement(menu2);
        Assert.assertEquals(menu1.getText(), "Herz-Kreislauf, Blut & Blutgefäße");
        driver.navigate().back();

        moveToElement(fuhlDichGesundMenu);
        menus = driver.findElements(fuehldichgesundMenus);
        actions.moveToElement(menus.get(1)).click().perform();
        menu1 = driver.findElement(menu2);
        Assert.assertEquals(menu1.getText(), "Entzündungen & Infektionen");

        moveToElement(fuhlDichGesundMenu);
        menus = driver.findElements(fuehldichgesundMenus);
        actions.moveToElement(menus.get(2)).click().perform();
        menu1 = driver.findElement(menu2);
        Assert.assertEquals(menu1.getText(), "Gelenke & Knochen");

        moveToElement(fuhlDichGesundMenu);
        menus = driver.findElements(fuehldichgesundMenus);
        actions.moveToElement(menus.get(3)).click().perform();
        menu1 = driver.findElement(menu2);
        Assert.assertEquals(menu1.getText(), "Immunsystem & Allergien");

        moveToElement(fuhlDichGesundMenu);
        menus = driver.findElements(fuehldichgesundMenus);
        actions.moveToElement(menus.get(4)).click().perform();
        menu1 = driver.findElement(menu2);
        Assert.assertEquals(menu1.getText(), "Magen, Darm, Harnwege & Blase");

        moveToElement(fuhlDichGesundMenu);
        menus = driver.findElements(fuehldichgesundMenus);
        actions.moveToElement(menus.get(5)).click().perform();
        menu1 = driver.findElement(menu2);
        Assert.assertEquals(menu1.getText(), "Zellen, Haut & Gewebe");

    }

    public void navigateSubMenusAndCheck() {
        gotoSubMenus(0);
        gotoSubMenus(1);
        gotoSubMenus(2);
        gotoSubMenus(3);
        gotoSubMenus(4);
        gotoSubMenus(5);
    }

    public void gotoSubMenus(int nummerMenu) {

        moveToElement(fuhlDichGesundMenu);
        List<WebElement> menus = driver.findElements(fuehldichgesundMenus);
        Actions actions = new Actions(driver);
        actions.moveToElement(menus.get(nummerMenu)).click().perform();
        List<WebElement> products = driver.findElements(produksAll);
        int productZahl = products.size();
        WebElement zahlSteht = driver.findElement(zahlSteht1);
        int nummer = textToInteger(zahlSteht);
        Assert.assertEquals(productZahl, nummer);
        driver.navigate().back();
    }

    public int textToInteger(WebElement element) {
        String text = element.getText();
        text = text.replaceAll("[A-z]", "");
        text = text.trim();
        int nummer = Integer.parseInt(text);
        return nummer;
    }

    public void randomSubMenusAddProduct() throws InterruptedException {

        Actions actions = new Actions(driver);
        moveToElement(fuhlDichGesundMenu);
        List<WebElement> menus = driver.findElements(fuehldichgesundMenus);
        Random random = new Random();
        int randomSubMenus = random.nextInt(6);
        actions.moveToElement(menus.get(randomSubMenus)).click().perform();
        List<WebElement> products = driver.findElements(productList);
        int productZahl = products.size();
        int randomProduct = random.nextInt(productZahl);
        actions.moveToElement(products.get(randomProduct)).click().perform();
        Thread.sleep(2000);

        String htmlText = driver.findElement(html).getText();

        if (htmlText.contains("Wirkstoffdosierung")) {
            clickTo(wirkstoffdosierungButton);
            clickTo(inhalt);
        }

        if (htmlText.contains("Inhalt")) {
            clickTo(buttonInhalt);
            clickTo(inhalt);
        }

        clickTo(buttonWarenkorb1);
    }

    public void checkInDenWarenkorb() {

        String name = driver.findElement(nameProduct1).getText();
        System.out.println(name);
        clickTo(buttonWarenkorb);
        clickTo(zurWarenkorb);
        String textInWarenkorb = driver.findElement(productInWarenkorb).getText();
        Assert.assertTrue(textInWarenkorb.contains(name));
    }

    public void changeTheQuantity() throws InterruptedException {
        clickTo(buttonWarenkorb);
        clickTo(zurWarenkorb);
        driver.findElement(stuck).clear();
        sendKeysTo(stuck, "4");
        clickTo(buttonUpdate);
        Thread.sleep(6000);
    }

    public void checkPriesAndSum() {

        String firstPriesText = driver.findElement(firstPries).getText();
        double first = nurPrice(firstPriesText);
        String zwischenSummeText = driver.findElement(zwischenSumme).getText();
        double totalPrice = nurPrice(zwischenSummeText);
        Assert.assertEquals(totalPrice, (first * 4));

    }

    public void removeThePro() {
        clickTo(buttonRemove);
    }

    public void checkTheMenuLink() {
        Assert.assertEquals(getText(menuText), "fühldichgesund");
    }

    public void checkTheNot() {
        String text = driver.findElement(textLeer).getText();
        Assert.assertEquals(text, "Dein Warenkorb ist gegenwärtig leer.");
    }

    public void goToWarenkorb() {
        clickTo(buttonWarenkorb);
        clickTo(zurWarenkorb);
    }


















































    public By buttonWarenkorb = By.xpath("//i[@class='groovy-69018-handbag']");
    public By fuhlDichGesundMenu = By.xpath("(//span[@class='qodef-menu-item-inner'])[2]");
    public By menuText = By.xpath("//h1[@class='qodef-m-title entry-title']");
    public By buttonRemove = By.xpath("//a[@class='remove']");
    public By textLeer = (By.xpath("//p[@class='cart-empty woocommerce-info']"));
    public By zurWarenkorb = (By.xpath("//a[contains(text(), 'Warenkorb anzeigen')]"));


}



