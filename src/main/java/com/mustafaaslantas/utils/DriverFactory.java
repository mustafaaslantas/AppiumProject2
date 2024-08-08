package com.mustafaaslantas.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DriverFactory {
    AppiumDriver driver;
    Properties properties;
    DesiredCapabilities capabilities;

    public DriverFactory(String browser){
        properties = ConfigReader.getProperties();
        capabilities = new DesiredCapabilities();

        if(browser.equals("Android")) {
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "13.0");
            capabilities.setCapability("deviceName", "Android Emulator");
            capabilities.setCapability("udid", "emulator-5554");
//            capabilities.setCapability("appPackage", "com.mobisoft.kitapyurdu");
//            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
        }
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public AppiumDriver getDriver(){
        return driver;
    }
}
