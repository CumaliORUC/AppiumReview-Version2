package appium_TestNG;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
//in this class;
//DragAndDrop, Landscape, copyToClipboard, Key Events will be executed
public class dragAndDrop extends BaseTest01{
    @Test
    public void dragAndDrop(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement dragEle=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        //drag and drop gesture
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) dragEle).getId(),
                "endX", 850,  //this part for dropped koordinates
                "endY", 750
        ));
        WebElement droppedTextElement= driver.findElement(By.id("io.appium.android.apis:id/drag_result_text"));
        Assert.assertTrue(droppedTextElement.isDisplayed());
    }
}
