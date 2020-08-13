package Pages;

import Base.BasePage;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {
    public Random rnd = new Random();

    public HomePage(WebDriver driver) {
        super(driver);
    }
@Step("Rasgele bir kategori altında bir alt kategori seçilir")
    public ProductListPage chooseRandomCategory() {
        int mainCategoryIndex = rnd.nextInt(7) + 2;

        hoverElement(By.cssSelector(".navigationBar > div:nth-of-type(1) > div > ul > li:nth-child(" + mainCategoryIndex + ")"));

        List<WebElement> subCategories = findElements(By.cssSelector(".navigationBar > div:nth-of-type(1) > div > ul > li:nth-child(" + mainCategoryIndex + ") > div a"));

        WebElement selectedCategory = subCategories.get(rnd.nextInt(subCategories.size()));

        Actions actions = new Actions(driver);

        actions
                .moveToElement(findElement(By.cssSelector(".navigationBar > div:nth-of-type(1) > div > ul > li:nth-child(" + mainCategoryIndex + ")")))
                .moveToElement(selectedCategory)
                .click()
                .build()
                .perform();

        return new ProductListPage(driver);
    }


}
