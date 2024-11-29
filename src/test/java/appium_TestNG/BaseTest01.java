package appium_TestNG;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest01 {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
        //Create driver
        //Appium code ==> Appium server ==>Mobile
        //to start the appium server automatically, we should give path of main.js to aippiumServicebuilder and IP adress and port number
        //built server
        service=new AppiumServiceBuilder()
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723).build();
        service.start();

        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("Android");
        options.setApp("//Users/cumalioruc//Automation_Testing//GeneralStore//src//test//java//resources//ApiDemos-debug.apk");
        // Add desired capability to automatically grant permissions
        //options.setCapability("autoGrantPermissions", true);
        options.setCapability(MobileCapabilityType.NO_RESET, false);
        options.setCapability("autoAcceptAlert",true);
        driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options); //JAVA 20 den sonra new URL() =>new URI() oldu. URL'e parse ettik.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        //service.stop();
    }

    public void LongPress(WebElement ele) {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(), "duration",2000));
    }

    public void ScrollDown(String text) {
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        //driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"WebView\"))"));
        String scrollCommand = String.format("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", text);
        driver.findElement(AppiumBy.androidUIAutomator(scrollCommand));
    }
}