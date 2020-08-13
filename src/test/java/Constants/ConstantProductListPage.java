package Constants;

import org.openqa.selenium.By;

public class ConstantProductListPage extends ConstantBasePage{
   public static final By BRAND_COUNT = By.cssSelector("div > ol > li.box-container.brand > ol > li");
   public static final By MIN_PRICE = By.cssSelector("div > ol > li.box-container.fiyat > div > div > div:nth-child(1) > input");
   public static final By MAX_PRICE = By.cssSelector("div > ol > li.box-container.fiyat > div > div > div:nth-child(3) > input");
   public static final By SUBMIT_PRICE =By.cssSelector("div > ol > li.box-container.fiyat > div > div > div.range-contain-row.right > button");
   public static final By RANDOM_PRODUCT =By.cssSelector(".results-container li");

}
