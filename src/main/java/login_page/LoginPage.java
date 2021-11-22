package login_page;

import base_elements.LoginForm;
import driver.WebDriverController;
import user.User;

public class LoginPage extends LoginForm {

    private final User user = new User("mlem", "mlem2");

    public LoginPage(WebDriverController driverController) {
        super(driverController);
    }

    public void login(WebDriverController driverController){
        driverController.getDriver().navigate().to("https://www.facebook.com/");
        acceptCookie();
        loginUser(user);
    }
}
