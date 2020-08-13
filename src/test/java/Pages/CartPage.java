package Pages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public double getCartTotalPrice() throws InterruptedException {
        String totalPrice = getText(By.cssSelector(".total-price span"));
        return Double.parseDouble(totalPrice.replace(",", "."));
    }

    public ProductListPage priceCompareBasket(){
        // gelen detay ile ilk click önceki fiyat karşılaştırma
        return new ProductListPage (driver);
    }


}
