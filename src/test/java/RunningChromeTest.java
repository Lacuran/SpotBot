import driver.BaseAbstractTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RunningChromeTest extends BaseAbstractTest {

    public RunningChromeTest() {
    }

    @Test
    public void shouldOpenAndCloseChrome(){
        int a = 5+6;
    }


    @Test
    public void explicitWaitAlertTest(){
        String url = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
        String xpath = "//*[@id='alert']";
        String expectedMessage = "I got opened after 5 secods";

        getDriver().navigateToUrl(url);

        WebElement firstAlert = getDriver().getElement(By.xpath(xpath));
        firstAlert.click();

        //Explicit Wait
        WebDriverWait wait = new WebDriverWait(getDriver().getDriver(),10);
        wait.until(ExpectedConditions.alertIsPresent());

        String actualMessage = getDriver().getAlertText();
        Assert.assertEquals(actualMessage, expectedMessage, "Message do not Match");

        getDriver().acceptAlert();

    }

    @Test
    public void explicitWaitForTextChange(){
        String url = "https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver";
        String xpath = "//*[@id='populate-text']";

        getDriver().navigateToUrl(url);
        WebElement button = getDriver().getElement(By.xpath(xpath));
        button.click();

        WebDriverWait wait = new WebDriverWait(getDriver().getDriver(),15);
        wait.until(ExpectedConditions.textToBePresentInElement(getDriver().getElement(By.xpath("//*[@class='target-text']")), "Selenium Webdriver"));

        String actualText = getDriver().getElement(By.xpath("//*[@class='target-text']")).getText();

        Assert.assertEquals(actualText,"Selenium Webdriver","Text do not Match");
    }

}
