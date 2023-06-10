package pages;

import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;


public class GoogleToGeneralStoreAppPage extends BaseClass {
    public GoogleToGeneralStoreAppPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
        AndroidDriver<WebElement> driver;
        @AndroidFindBy(xpath = "//*[contains(@text,'Google')]")
        WebElement tv_googleTitle;
        @AndroidFindBy(className = "android.widget.EditText")
        WebElement tv_searchBox;
        @AndroidFindBy(xpath = "//*[contains(@text,'General Store')]")
        WebElement tv_validateTitle;

        public void validateGooglePage() throws InterruptedException {
            Thread.sleep(5000);
            CommonUtils.isTextPresentInElement(tv_googleTitle, "Google");
            tv_searchBox.isDisplayed();
            tv_searchBox.click();
            Thread.sleep(2000);
            tv_searchBox.sendKeys("General Store");
            Thread.sleep(1000);
        }
        public void navigateToGeneralStore(){
            driver.navigate().back();
            CommonUtils.isTextPresentInElement(tv_validateTitle, "General Store");
            System.out.println("We are back at General store app home page");
            }
        }
