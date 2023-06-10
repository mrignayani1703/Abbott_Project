package pages;
import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.CommonUtils;
import utils.ConfigReader;

public class HomePage extends BaseClass {

    AndroidDriver<WebElement> driver;
    String country = ConfigReader.getProperty("country");
    String username = ConfigReader.getProperty("username");
    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    WebElement tv_homepageTitle;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    WebElement btn_ChooseCountry;
    @AndroidFindBy(xpath = "//*[contains(@text,'India')]")
    WebElement btn_india;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    WebElement tv_nameField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    WebElement btn_female;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    WebElement btn_letsShop;

    public HomePage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void verifyHomePage() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue(tv_homepageTitle.isDisplayed());
    }

    public void selectCountry() throws InterruptedException {
        btn_ChooseCountry.click();
        Thread.sleep(2000);
        CommonUtils.scrollToElementByText(driver,country,2);
        btn_india.click();
    }

    public void enterNameAndGender() {
        tv_nameField.click();
        tv_nameField.sendKeys(username);
        driver.hideKeyboard();
        btn_female.click();
    }

    public void clickLetsShopButton() {
        Assert.assertTrue(btn_letsShop.isDisplayed());
        btn_letsShop.click();
    }
}





