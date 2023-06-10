package tests;
import base.BaseClass;
import org.testng.annotations.Test;
import pages.GoogleToGeneralStoreAppPage;
import pages.HomePage;
import pages.ProductsPage;

public class GeneralStoreTest extends BaseClass {


    @Test (priority = 0)
     public void homeTest() throws InterruptedException {
        HomePage page = new HomePage(driver);
        page.verifyHomePage();
        page.selectCountry();
        page.enterNameAndGender();
        page.clickLetsShopButton();
  }

    @Test (priority = 1)
    public void productTest() throws InterruptedException {
        ProductsPage pg = new ProductsPage(driver);
        pg.verifyProductPage();
    }

    @Test (priority = 2)
    public void validateCartScreen(){
        ProductsPage pg = new ProductsPage(driver);
        pg.verifyCartScreen();
    }

    @Test (priority = 3)
        public void validateGoogleScreen() throws InterruptedException {
        GoogleToGeneralStoreAppPage tv = new GoogleToGeneralStoreAppPage(driver);
        tv.validateGooglePage();
    }

    @Test (priority = 4)
    public void validateGoogleToAppScreen(){
        GoogleToGeneralStoreAppPage tv = new GoogleToGeneralStoreAppPage(driver);
        tv.navigateToGeneralStore();
    }
}
