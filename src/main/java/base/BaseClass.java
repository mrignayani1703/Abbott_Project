package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.URL;

public class BaseClass  {
    public AndroidDriver<WebElement> driver;

    @BeforeTest
    public void setup() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, "android");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/apple/Downloads/General-Store.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "mrigemulator");
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            desiredCapabilities.setCapability("autoAcceptAlerts", true);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver<>(url, desiredCapabilities);
        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
