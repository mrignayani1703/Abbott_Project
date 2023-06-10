package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CommonUtils {

    private AppiumDriver<WebElement> driver;
    private TouchAction action;

    public static WebElement scrollToElementByText(AndroidDriver<WebElement> driver, String elementText, int maxSwipes) {
        for (int i = 0; i < maxSwipes; i++) {
            try {
                WebElement element = new WebDriverWait(driver, 5)
                        .until(ExpectedConditions.presenceOfElementLocated(
                                MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                                        + "new UiSelector().text(\"" + elementText + "\").instance(0))")));
                return element;
            } catch (NoSuchElementException e) {
                int screenHeight = driver.manage().window().getSize().getHeight();
                int startX = driver.manage().window().getSize().getWidth() / 2;
                int startY = (int) (screenHeight * 0.8);
                int endY = (int) (screenHeight * 0.2);

                TouchAction<?> action = new TouchAction<>(driver);
                action.press(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release().perform();
            }
        }
        throw new NoSuchElementException(String.format("Element with text '%s' not found.", elementText));
    }

    public static boolean isTextPresentInElement(WebElement element, String expectedText) {
        String actualText = element.getAttribute("text");
        return actualText != null && actualText.contains(expectedText);
    }
    public void implicitWait() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
