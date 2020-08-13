package Test;

import Base.BaseTest;
import Models.AddressInfo;
import Pages.CartPage;
import Pages.HomePage;
import com.thoughtworks.gauge.Step;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Main extends BaseTest {
    @Test
    //@Step("deneme")
    @Step("Full testing")
    public void scenario() throws InterruptedException {
        CartPage test = new HomePage(driver)
                .callLoginPage()
                .login("taskmailim2020@gmail.com", "Tasksifre2020")
                .callCartPage();

//        Double totalPrice = test
//                .getCartTotalPrice();

        test
                .callHomePage()
                .chooseRandomCategory()
                .chooseRandomBrand()
                .enterMinPrice("1")
                .enterMaxPrice("6000")
                .submitPriceFilter()
                .chooseRandomProduct()
                .addToCart()
                .closeCartModal()
                //.callCartPage()
                //.increaseCartQuantity()
                .callAccountPage()
                .clickAddresses()
                .clickAddNewAddress()
                .fillAddressInfo(getAccountInfo())
                .submitAddress();

        TimeUnit.MILLISECONDS.sleep(5000);
    }

    private AddressInfo getAccountInfo() {
        AddressInfo payInfo = new AddressInfo();
        payInfo.AddressName = "Adres 1";
        payInfo.AddressContent = "Salacak Mah. Üsküdar";
        payInfo.UserName = "Fatma";
        payInfo.UserSurname = "Uludağ";
        payInfo.UserPhone = "5555555555";
        payInfo.Country = "Türkiye";
        payInfo.City = "İstanbul";
        payInfo.TownIndex = 39;
        payInfo.DistrictIndex = 2;

        return payInfo;
    }
}
