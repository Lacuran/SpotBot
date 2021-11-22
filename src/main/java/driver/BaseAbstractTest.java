package driver;

import org.testng.annotations.AfterClass;


public abstract class BaseAbstractTest{

    private static WebDriverController driver;

    public BaseAbstractTest() {
        driver = new WebDriverController();
    }

    public static WebDriverController getDriver() {
        return driver;
    }

    @AfterClass
    public void afterClass(){
        if (driver != null){
            driver.quit();
        }
    }
}
