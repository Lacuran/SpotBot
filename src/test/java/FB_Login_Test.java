import driver.BaseAbstractTest;
import login_page.LoginPage;
import org.testng.annotations.Test;

public class FB_Login_Test extends BaseAbstractTest {

    @Test
    public void shouldLoginToFB(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getDriver());

    }
}
