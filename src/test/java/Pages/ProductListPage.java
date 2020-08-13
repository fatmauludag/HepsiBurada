package Pages;

import Base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProductListPage extends BasePage {
    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public ProductListPage chooseRandomBrand() throws InterruptedException {
        int brandCount = findElements(By.cssSelector("div > ol > li.box-container.brand > ol > li")).size();
        int randomBrandIndex = new Random().nextInt(brandCount) + 1;

        click(By.cssSelector("div > ol > li.box-container.brand > ol > li:nth-child(" + randomBrandIndex + ")"));

        Thread.sleep(2000);

        return new ProductListPage(driver);
    }

    public ProductListPage enterMinPrice(String minPrice) throws InterruptedException {
        sendKeys(By.cssSelector("div > ol > li.box-container.fiyat > div > div > div:nth-child(1) > input"), minPrice);

        return new ProductListPage(driver);
    }

    public ProductListPage enterMaxPrice(String maxPrice) throws InterruptedException {
        sendKeys(By.cssSelector("div > ol > li.box-container.fiyat > div > div > div:nth-child(3) > input"), maxPrice);

        return new ProductListPage(driver);
    }

    public ProductListPage submitPriceFilter() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1500);

        click(By.cssSelector("div > ol > li.box-container.fiyat > div > div > div.range-contain-row.right > button"));

        TimeUnit.MILLISECONDS.sleep(1500);
        waitUntilPageLoad();
        return new ProductListPage(driver);
    }

    public ProductDetail chooseRandomProduct() throws InterruptedException {
        int totalProductCount = findElements(By.cssSelector(".results-container li")).size();
        Assert.assertTrue(totalProductCount > 0);

        int randomProductIndex = new Random().nextInt(totalProductCount) + 1;

        click(By.cssSelector(".results-container li:nth-child(" + randomProductIndex + ")"));

        Thread.sleep(2000);

        return new ProductDetail(driver);
    }

    public ProductListPage priceCompare() {
        // gelen detay ile ilk click önceki fiyat karşılaştırma
        return new ProductListPage(driver);
    }

}
