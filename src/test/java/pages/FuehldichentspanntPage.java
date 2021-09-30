package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import stepDefinitions.FuehldichentspanntDefss;
import utillities.ParentClass;

import java.util.List;
import java.util.Random;

public class FuehldichentspanntPage extends ParentClass {


        By acceptAll = By.xpath("(//span[@class='cf1y60'])[1]");
        By mainKonto= By.xpath("(//span[@class='gm-menu-item__txt-wrapper'])[7]");
        By userName = By.id("username");
        By password = By.id("password");
        By rememberMe = By.id("rememberme");
        By loginButton = By.xpath("//button[@value='Anmelden']");
        By fuehlSpannt = By.id("menu-item-5956");
        By fuehlSpanntText = By.xpath("//h1[@class='qodef-m-title entry-title']");
        By fuehlDichSpanntMenus = By.xpath("(//div [@class='vc_row wpb_row vc_row-fluid'])[1]");
        By fuehlDichSpanntProducts = By.xpath("//div[@class='qodef-woo-product-inner']/parent::*");
        By buttonWirk = By.cssSelector("#select2-pa_wirkstoffdosierung-container");
        By inhalt = By.xpath("(//ul[@class='select2-results__options']/li)[2]");
        By buttoninhalt = By.cssSelector("#select2-pa_inhalt-container");
        By buttonwarenkorb = By.xpath("//button[@class='single_add_to_cart_button button alt disabled wc-variation-selection-needed']");










        public void login(){
                clickTo(acceptAll);
                clickTo(mainKonto);
                sendKeysTo(userName, "tarikavci3435");
                sendKeysTo(password,"YHcoV)K*#ZK(");
               // parentClass.clickTo(rememberme);
              clickTo(loginButton);
        }

        public void fuehlSpannt(){
                clickTo(fuehlSpannt);
              //verifyElementContainsText(fuehlSpanntText, "fühldichentspannt");
        }

        public void fuehlSpanntProducts() throws InterruptedException {
                WebElement fuhlDichSpantMenu = driver.findElement(fuehlSpannt);
                Actions actions = new Actions(driver);
                actions.moveToElement(fuhlDichSpantMenu).perform();
                List<WebElement> menus = driver.findElements(fuehlDichSpanntMenus);
                Random random = new Random();
                //int randomZahl = menus.size();
                int randomSubMenus = random.nextInt(2);
                actions.moveToElement(menus.get(randomSubMenus)).click().perform();
                //actions.moveToElement(menus.get(randomZahl)).click().perform();

                List<WebElement> products = driver.findElements(fuehlDichSpanntProducts);
                int productZahl = products.size();
                int randomProduct = random.nextInt(productZahl);
                actions.moveToElement(products.get(randomProduct)).click().perform();

                if (driver.findElement(By.xpath("//label[contains(text(), 'Wirkstoffdosierung')]")).isDisplayed() ){
                        Thread.sleep(2000);
                        WebElement buttonInhalt = driver.findElement(buttonWirk);
                        buttonInhalt.click();
                        Thread.sleep(2000);
                        WebElement Inhalt = driver.findElement(inhalt);
                        Inhalt.click();
                        WebElement buttonWarenkorb = driver.findElement(buttonwarenkorb);
                        buttonWarenkorb.click();
                }
                Thread.sleep(1000);

                //else {
                // WebElement buttonWarenkorb = driver.findElement(buttonwarenkorb);
                     //   buttonWarenkorb.click();
                //}


                if (driver.findElement(By.xpath("//label[contains(text(), 'Inhalt')]")).isDisplayed()){
                        Thread.sleep(1000);
                        WebElement buttonInhalt = driver.findElement(buttoninhalt);
                        buttonInhalt.click();
                        WebElement inhaltt = driver.findElement(inhalt);
                        inhaltt.click();
                        WebElement buttonWarenkorb = driver.findElement(buttonwarenkorb);
                        buttonWarenkorb.click();
                }

                //else {
                     //   WebElement buttonWarenkorb = driver.findElement(buttonwarenkorb);
                    //    buttonWarenkorb.click();
               // }

                WebElement buttonWarenkorb = driver.findElement(buttonwarenkorb);
                buttonWarenkorb.click();


        }

        public void fuehlSpanntProductss() {
                WebElement fuhlDichSpantMenu = driver.findElement(By.id("menu-item-5956"));
                Actions actions = new Actions(driver);
                actions.moveToElement(fuhlDichSpantMenu).perform();
                List<WebElement> menus = driver.findElements(By.xpath("(//div [@class='vc_row wpb_row vc_row-fluid'])[1]"));
                Random random = new Random();
                // int randomZahl = menus.size();
                int randomSubMenus = random.nextInt(2);
                actions.moveToElement(menus.get(randomSubMenus)).click().perform();

                List<WebElement> products = driver.findElements(By.xpath("//div[@class='qodef-woo-product-inner']/parent::*"));
                int productZahl = products.size();
                int randomProduct = random.nextInt(productZahl);
                actions.moveToElement(products.get(randomProduct)).click().perform();

                if (driver.findElement(By.xpath("//label[contains(text(), 'Wirkstoffdosierung')]")).isDisplayed() ){
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


        }



