package appium_TestNG;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class longPress_ScrollDown extends BaseTest01 {
    @Test
    public void longPress(){
      //longPress
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
       WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        // Java long press
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(), "duration",2000
        ));

        boolean sampleMenuDisplayed=driver.findElements(By.className("android.widget.TextView")).get(0).isDisplayed();
        Assert.assertTrue(sampleMenuDisplayed);
    }

    @Test
    public void scrollDown(){
        //Android UI automator desteği ile bunu yapabiliriz. Google'ın UIautomator2 e kattığı bir özelliktir.
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));")).click();
    }

    @Test
    public void swipe(){
        String elementAttribute;
        //Android UI automator desteği ile bunu yapabiliriz. Google'ın UIautomator2 e kattığı bir özelliktir.
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement ele=driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        elementAttribute=ele.getAttribute("focusable");

        Assert.assertEquals(elementAttribute,"true"); //element has not been swiped yet. so Attirbute is true

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "direction", "left",
                "percent", 0.75
        ));
        elementAttribute=ele.getAttribute("focusable");
        Assert.assertEquals(elementAttribute,"false");
    }
}
