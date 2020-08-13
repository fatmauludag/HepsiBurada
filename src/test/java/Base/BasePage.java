package Base;
import Constants.ConstantBasePage;
import Pages.AccountPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public ExpectedCondition<Boolean> documentReady = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement findElement(By by) {
        untilElementAppear(by);
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Step("home page aç")
    public HomePage callHomePage() {
        driver.get("https://www.hepsiburada.com/");
        return new HomePage(driver);
    }
    public LoginPage callLoginPage() {
        driver.get("https://giris.hepsiburada.com/");
        return new LoginPage(driver);
    }

    public CartPage callCartPage() {
        driver.get("https://www.hepsiburada.com/ayagina-gelsin/sepetim");
        return new CartPage(driver);
    }
    public AccountPage callAccountPage(){
        driver.get("https://www.hepsiburada.com/hesabim");
        return  new AccountPage(driver);
    }

    public AccountPage gotoMyAccount() {
        click(ConstantBasePage.MY_ACCOUNT);
        return new AccountPage(driver);
    }

    public void click(By by) {
        untilElementClickable(by);
        findElement(by).click();
    }
    @Step("<by> lı elemente <text> değerini yaz")
    public void sendKeys(By by, String text) {
        isElementDisplayed(by);
        WebElement el = findElement(by);

        el.clear();
        el.sendKeys(text);

        // Assert.assertEquals(el.getText(),text);
    }

    public void assertInput(By by, String expectedText) {
        WebElement el = findElement(by);
        Assert.assertEquals(el.getText(),expectedText);
    }

    public String getText(By by) {
        return findElement(by).getText();
    }

    public String getAttribute(By by, String name) {
        return findElement(by).getAttribute(name);
    }

    public void selectOptionByValue(By by, String value) {
        Select select = new Select(findElement(by));
        select.selectByValue(value);
    }

    public void selectOptionByIndex(By by, int index) {
        Select select = new Select(findElement(by));
        select.selectByIndex(index);
    }

    public void clickWithAction(By by) {
        Actions actions = new Actions(driver);

        actions
                .moveToElement(findElement(by))
                .click()
                .build()
                .perform();
    }

    public void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }

    public boolean isElementDisplayed(By by) {
        return findElement(by).isDisplayed();
    }

    public void untilElementAppear(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void untilElementClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public Boolean waitUntilPageLoad() {
        return wait.until(documentReady);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
