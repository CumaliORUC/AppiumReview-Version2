package appium_TestNG;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class eCommerce extends BaseTest{
    @Test
    public void FillForm() {

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Cumali Oruc");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

    }
}
