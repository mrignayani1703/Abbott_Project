package pages;

import base.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.CommonUtils;

public class ProductsPage extends BaseClass {

    AndroidDriver<WebElement> driver;
    @AndroidFindBy(xpath = "//*[contains(@text,'Products')]")
    WebElement tv_ProdctsPage;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    WebElement btn_cart;
    @AndroidFindBy(xpath = "//*[contains(@text,'ADD TO CART')]") //$110.0 //$116.97 //Total Purchase Amount:
    WebElement btn_addToCart;
    @AndroidFindBy(xpath = "//*[contains(@text,'Cart')]") //$110.0 //$116.97 //Total Purchase Amount:
    WebElement tv_Cart;
    @AndroidFindBy(xpath = "//*[contains(@text,'PG 3')]")
    WebElement tv_pg3;
    @AndroidFindBy(xpath = "//*[contains(@text,'Nike SFB Jungle')]")
    WebElement tv_Nike_SFB_Jungle;
    @AndroidFindBy(xpath = "//*[contains(@text,'$ 226.97')]")
    WebElement tv_totalPrice;
    @AndroidFindBy(className = "android.widget.CheckBox")
    WebElement btn_checkBox;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    WebElement btn_website;

    public ProductsPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyProductPage() throws InterruptedException {
        Thread.sleep(5000);
        CommonUtils.isTextPresentInElement(tv_ProdctsPage, "Products");
        CommonUtils.scrollToElementByText(driver,"Nike SFB Jungle",5);
        btn_addToCart.click();
        Thread.sleep(2000);
        tv_Nike_SFB_Jungle.isDisplayed();
        btn_addToCart.click();
        System.out.println("items added successully");
        btn_cart.isDisplayed();
        btn_cart.click();
    }

    public void verifyCartScreen(){
        CommonUtils.isTextPresentInElement(tv_Cart, "Cart");
            System.out.println("Cart page is visible");
            CommonUtils.isTextPresentInElement(tv_pg3, "PG 3");
            CommonUtils.isTextPresentInElement(tv_Nike_SFB_Jungle, "Nike SFB Jungle");
            CommonUtils.isTextPresentInElement(tv_totalPrice, "$ 226.97");
            double a = 110.0;
            double b = 116.97;
            double c = a + b;
            String totalPriceText = tv_totalPrice.getText();
            String extractedValueText = totalPriceText.replace("$", "");
            double extractedValue = Double.parseDouble(extractedValueText);
            Assert.assertEquals(c, extractedValue);

            btn_checkBox.click();
            btn_website.click();

    }
}