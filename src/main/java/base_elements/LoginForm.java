package base_elements;

import driver.BaseAbstractForm;
import driver.WebDriverController;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import user.User;

public class LoginForm extends BaseAbstractForm {

    public LoginForm(WebDriverController driverController) {
        super(driverController);
        PageFactory.initElements(driverController.getDriver(), this);
    }

    @FindBy(xpath = "//button[@data-cookiebanner='accept_button']")
    public WebElement cookieAcceptButton;
    @FindBy(xpath = "//*[@id='email']")
    public WebElement login;
    @FindBy(xpath = "//*[@id='pass']")
    public WebElement password;
    @FindBy(xpath = "//*[@name='login']")
    public WebElement loginButton;


    public void acceptCookie(){
        cookieAcceptButton.click();
    }

    public void sendUserCredentials(User user){
        login.sendKeys(user.getUsername());
        password.sendKeys(user.getPassword());
    }

    public void loginUser(User user){
        sendUserCredentials(user);
        loginButton.click();
    }
}
