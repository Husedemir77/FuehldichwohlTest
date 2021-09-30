package pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import utillities.BrowserSize;
import utillities.ParentClass;

public class Mein_KontoPage extends ParentClass {
    By Cookies = By.xpath("(//button[@data-cookiefirst-outline-accent-color='true'])[1]");
    By MeinKonto = By.xpath("(//span[@class='gm-menu-item__txt'])[7]");
    By Benutzername=By.cssSelector("input[id=username]");
    By Passwort=By.cssSelector("input[id=password]");
    By Email=By.cssSelector("input[id=reg_email]");
    By AnmeldenButton=By.cssSelector("button[value=Anmelden]");
    By NeuesKundenKontoAnlegenButton=By.cssSelector("button[value='Neues Kundenkonto anlegen']");
    By AngemeldetBleibenCheckbox=By.cssSelector("input[id=rememberme]");
    By PasswortVergessen=By.cssSelector("p[class='woocommerce-LostPassword lost_password']");
    By AlertMessage=By.cssSelector("ul[role=alert]");

    public void getHomePage() {
        setBrowserSizeTo(BrowserSize.max);
        String url = "https://fuehldichwohl24.de/";

        if (!driver.getCurrentUrl().contains(url))
            driver.get(url);
        clickTo(Cookies);
    }

    public void getMeinKontoPage() {

        clickTo(MeinKonto);

    }


    public void meinKontoCreate(){
     sendKeysTo(Benutzername,"testuser@tutusmedia.com");
     sendKeysTo(Passwort,"User1");
     clickTo(AnmeldenButton);
     clickTo(AngemeldetBleibenCheckbox);
     clickTo(PasswortVergessen);
     String message="Fehler: Für diese E-Mail-Adresse existiert bereits ein Kundenkonto. BITTE ANMELDEN.";
     Assert.assertNotEquals(driver.findElement(AlertMessage).getText(),message);
     sendKeysTo(Email,"testuser@tutusmedia.com");
     clickTo(NeuesKundenKontoAnlegenButton);
     Assert.assertEquals(driver.findElement(AlertMessage).getText(),message);



    }



}
