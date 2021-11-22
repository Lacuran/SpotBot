package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverController {

    private WebDriver driver;

    public WebDriverController() {
        runChromeDriver();
        driver.manage().window().maximize();
    }

    public void quit(){
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getElement(By by){
        return driver.findElement(by);
    }

    private void runChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");

        driver = new ChromeDriver(chromeOptions);
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void sendKeysToAlert(String messageToSend){
        driver.switchTo().alert().sendKeys(messageToSend);
    }

    public void navigateToUrl(String url){
        driver.navigate().to(url);
    }
}
