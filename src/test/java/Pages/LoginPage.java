package Pages;

import Base.BasePage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public HomePage login(String mail, String password) throws InterruptedException {
        sendKeys(By.id("txtUserName"), mail);
        sendKeys(By.id("txtPassword"), password);
        click(By.id("btnLogin"));

        TimeUnit.MILLISECONDS.sleep(1500);
        waitUntilPageLoad();

//        WebElement loginButton;
//        try {
//            loginButton = findElement(By.id("login"));
//        } catch (Exception ex) {
//            loginButton = null;
//        }
//
//        Assert.assertNotNull(loginButton);

        return new HomePage(driver);
    }



}
