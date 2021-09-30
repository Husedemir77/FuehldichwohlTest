package utillities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ParentClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * class Constructor
     */
    public ParentClass(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, 10);
        setImplicitlyWaitTimeoutTo(10);
    }

    public void setImplicitlyWaitTimeoutTo(int timeSeconds){
        driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
    }
    public WebElement getElement(By by){
        return driver.findElement(by);
    }

    public List<WebElement> getElements(By by){
        return driver.findElements(by);
    }
    /**
     *
     * @param by
     */
    public void clickTo(By by){
        waitToBeEnableFor(by);
        scrollTo(by);
        driver.findElement(by).click();
    }

    public void clear(By by){
        waitToBeEnableFor(by);
        scrollTo(by);
        driver.findElement(by).clear();
    }

    public void sendKeysTo(By by, String textToSend){
        waitToBeEnableFor(by);
        scrollTo(by);
        driver.findElement(by).sendKeys(textToSend);
    }

    public boolean isExists(By by){
        return driver.findElements(by).size()>0;
    }


    public boolean isVisible(By by){
        if (!isExists(by)) return false;
        return driver.findElement(by).isDisplayed();
    }

    public boolean isEnabled(By by){
        if (!isVisible(by)) return false;
        return driver.findElement(by).isEnabled();
    }
    public boolean isHidden(By cssSelector){
        String script = "return arguments[0].getAttribute(\"class\");";
        String ret = ((JavascriptExecutor) driver).executeScript(script, driver.findElement(cssSelector)).toString();
        return !(ret.contains("unfolded") || ret.contains("open"));
    }

    public void waitToBeExistFor(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitToBeVisibleFor(By by){
        waitToBeExistFor(by);
        scrollTo(by);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitToBeEnableFor(By by){
        waitToBeVisibleFor(by);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public void scrollTo(WebElement element){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollTo(By by){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
    }

    public void scrollTo(By by, Boolean bool){
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(" + bool + ");", driver.findElement(by));
    }

    public String getText(By by){
        waitToBeVisibleFor(by);
        return driver.findElement(by).getText();
    }




    /**
     * takeScreenshot
     * @param fileName		fileName
     */
    public void takeScreenshot(String fileName){
        String directoryPath = "screenshots/";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss"));
        String filePath = directoryPath + fileName + "_" + Thread.currentThread().getName() + "_" + dt + ".png";
        try {
            FileUtils.copyFile(file, new File(filePath));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void setBrowserSizeTo(BrowserSize size){
        switch (size){
            case big:
                driver.manage().window().setPosition(new Point(0, 0));
                driver.manage().window().setSize(new Dimension(1350, 730));
                break;
            case half:
                driver.manage().window().setPosition(new Point(0, 0));
                driver.manage().window().setSize(new Dimension(700, 730));
                break;
            default:
                driver.manage().window().maximize();
                break;
        }
    }

    /**
     * select option from dropdown by text
     * @param optionText to select
     */
    public void selectOption(By by, String optionText){
        clickTo(by);
        WebElement option = null;
        scrollTo(option);
        if (option != null) option.click();
    }


    public void waiting(int ms)
    {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param by
     */
    public void hoverOver(By by)
    {
        Actions actions = new Actions(driver);

        //  waitToBeVisibleFor(by);
        scrollTo(by);
        //   wait.until(ExpectedConditions.elementToBeClickable(by));
        actions.moveToElement(getElement(by)).perform();

    }

    // return ByType of WebElement
    public By toByVal(WebElement we) {

        String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
        String locator = data[0];
        String term = data[1];

        switch (locator) {
            case "xpath":
                return By.xpath(term);
            case "css selector":
                return By.cssSelector(term);
            case "id":
                return By.id(term);
            case "tag name":
                return By.tagName(term);
            case "name":
                return By.name(term);
            case "link text":
                return By.linkText(term);
            case "class name":
                return By.className(term);
        }
        return (By) we;
    }


    public double nurPrice(String txt){
        double price=0;
        txt = txt.replaceAll("€","");
        price = Double.parseDouble(txt);
        return price;
    }

    public void moveToElement(By element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(element)).perform();
    }

}
