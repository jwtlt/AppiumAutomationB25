package com.cydeo.pages;

import com.cydeo.utils.*;
import io.appium.java_client.*;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.TimeUnit;

public abstract class WebTestBase {

    public WebTestBase(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    protected WebDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");


        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new RemoteWebDriver(url, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }




    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
