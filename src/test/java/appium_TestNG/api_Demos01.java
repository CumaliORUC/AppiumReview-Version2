package appium_TestNG;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class api_Demos01 extends BaseTest01 {
    @Test
    public void clickOnPreference() {
         //xpath, id, classname bunlar Selenium dan gelen locatorlar
        //eger accessibilityID, androidUIAutomator gibi locatorları kullanmak istiyorsan bu durumda AppiumBy kullanacağız.
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        //driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Gulcem");
        driver.findElement(By.id("android:id/button1")).click();
        //Eger elimizde bir locator bir den fazla element getiriyorsa bu durumda istidiğmiz elementi
        // index numarasına göre bulabiliriz.
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }
}
