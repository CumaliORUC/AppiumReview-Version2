package appium_TestNG;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//in this class;
// copyToClipboard, Key Events will be executed
public class ClipBoardAnd_LandScape extends BaseTest01{
 /*
  @BeforeMethod
    public void gotoWifi(){
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
    }
  */

    @Test
    public void clipBoard() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.setClipboardText("Duru Vildan");
        driver.findElement(By.className("android.widget.EditText")).sendKeys(driver.getClipboardText());
        driver.findElement(By.id("android:id/button1")).click();
        //landscape mode
        DeviceRotation rotation=new DeviceRotation(0,0,90);
        driver.rotate(rotation);
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

    @Test
    public void keyEvents() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Gulcemm");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.FORWARD));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

}
