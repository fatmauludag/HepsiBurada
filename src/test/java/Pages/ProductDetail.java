package Pages;

import Base.BasePage;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetail extends BasePage {
    public ProductDetail(WebDriver driver) {
        super(driver);
    }
@Step("Sepete ekle")
    public ProductDetail addToCart() {
        click(By.id("addToCart"));
        return new ProductDetail(driver);
    }
@Step("Sepete eklendi bilgisi kapat")
    public ProductDetail closeCartModal() {
        try {
            click(By.cssSelector(".hb_sfc_close"));
        } catch (Exception ignored) {

        }
        return new ProductDetail(driver);
    }
//Gelen ürün bazlı çalışıp çalışmama durumu oluyor
    public ProductDetail increaseCartQuantity() {
        click(By.cssSelector(".icon-plus"));
        click(By.cssSelector(".icon-plus"));
        return new ProductDetail(driver);
    }
}
