package Pages;

import Base.BasePage;
import Constants.ConstantProductListPage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProductListPage extends BasePage {
    public ProductListPage(WebDriver driver) {
        super(driver);
    }

@Step("Rasgele marka seçimi yap")
    public ProductListPage chooseRandomBrand() throws InterruptedException {
        int brandCount = findElements(ConstantProductListPage.BRAND_COUNT).size();
        int randomBrandIndex = new Random().nextInt(brandCount) + 1;

        click(By.cssSelector("div > ol > li.box-container.brand > ol > li:nth-child(" + randomBrandIndex + ")"));

        Thread.sleep(2000);

        return new ProductListPage(driver);
    }

@Step("Fiyat aralığı için ilk minimum değeri gir <minPrice>")
    public ProductListPage enterMinPrice(String minPrice) throws InterruptedException {
        sendKeys(ConstantProductListPage.MIN_PRICE, minPrice);

        return new ProductListPage(driver);
    }

    @Step("Fiyat aralığı için ilk maximum değeri gir <maxPrice>")
    public ProductListPage enterMaxPrice(String maxPrice) throws InterruptedException {
        sendKeys(ConstantProductListPage.MAX_PRICE, maxPrice);

        return new ProductListPage(driver);
    }

    @Step("Fiyat aralığını onayla")
    public ProductListPage submitPriceFilter() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1500);

        click(ConstantProductListPage.SUBMIT_PRICE);

        TimeUnit.MILLISECONDS.sleep(1500);
        waitUntilPageLoad();
        return new ProductListPage(driver);
    }

    @Step("Rasgele ürün seçimi yap")
    public ProductDetail chooseRandomProduct() throws InterruptedException {
        int totalProductCount = findElements(ConstantProductListPage.RANDOM_PRODUCT).size();
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
