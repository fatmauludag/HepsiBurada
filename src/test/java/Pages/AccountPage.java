package Pages;

import Base.BasePage;
import Models.AddressInfo;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {

        super(driver);
    }

    @Step("Hesabımdan adrese tıkla")
    public AccountPage clickAddresses() {
        click(By.cssSelector("#AccountMenu > div > div > div:nth-child(2) > div > div:nth-child(6) > a > div.NavigationMenuItem-3JKIS"));
        return new AccountPage(driver);
    }
@Step("Adresten sonra yeni adres ekle seçimi")
    public AccountPage clickAddNewAddress() {
        click(By.cssSelector(".icon-add-new"));
        return new AccountPage(driver);
    }
@Step("Yeni adres ekranınında Ad bilgisini gir <name>")
    private AccountPage newAddressInfoName(String name) {
        sendKeys(By.id("first-name"), name);
        return new AccountPage(driver);
    }
@Step("Yeni adres ekranınında Soyad bilgisini gir <name>")
    private AccountPage newAddressInfoSurName(String name) {
        sendKeys(By.id("last-name"), name);
        return new AccountPage(driver);
    }
@Step("Yeni adres ekranınında İlçe bilgisini gir <index>")
    private AccountPage newAddressInfoTown(int index) {
        click(By.cssSelector("#form-address > div > div > section:nth-child(3) > div:nth-child(3) > div > div > button"));

        clickWithAction(By.cssSelector("#form-address > div > div > section:nth-child(3) > div:nth-child(3) > div > div > div > ul > li:nth-child(" + index + ") > a"));

        return new AccountPage(driver);
    }

    private AccountPage newAddressInfoDistrict(int index) {
        click(By.cssSelector("#form-address > div > div > section:nth-child(3) > div:nth-child(4) > div > div.btn-group.bootstrap-select.required > button"));
        clickWithAction(By.cssSelector("#form-address > div > div > section:nth-child(3) > div:nth-child(4) > div > div.btn-group.bootstrap-select.required > div > ul > li:nth-child("+index+") > a"));

        return new AccountPage(driver);
    }
    private AccountPage newAddressInfoAddress(String address) {
        sendKeys(By.id("address"), address);
        return new AccountPage(driver);
    }

    private AccountPage newAddressInfoAddressName(String addressName) {
        sendKeys(By.id("address-name"), addressName);
        return new AccountPage(driver);
    }

    private AccountPage newAddressInfoPhoneNumber(String phone) {
        sendKeys(By.id("phone"), phone);
        return new AccountPage(driver);
    }

    public AccountPage submitAddress() {
        click(By.id(".btn-save-address"));
        return new AccountPage(driver);
    }
    public AccountPage fillAddressInfo(AddressInfo addrInfo) {
        return newAddressInfoName(addrInfo.UserName)
                .newAddressInfoSurName(addrInfo.UserSurname)
                .newAddressInfoTown(addrInfo.TownIndex)
                .newAddressInfoDistrict(addrInfo.DistrictIndex)
                .newAddressInfoAddress(addrInfo.AddressContent)
                .newAddressInfoAddressName(addrInfo.AddressName)
                .newAddressInfoPhoneNumber(addrInfo.UserPhone);
    }

}
