package com.instagram.android.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CommonPage {
    public static DesiredCapabilities cap = new DesiredCapabilities();
    private final URL url;
    public static AppiumDriver driver;

    public CommonPage() throws MalformedURLException {
        url = new URL("http://0.0.0.0:4723/wd/hub");

        cap.setCapability("deviceName", "HTC Desire 626 Dual Sim");
        cap.setCapability("udid", "HQ66GBS27849");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "5.1");
        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        cap.setCapability("noReset", "true");
    }

    public void setupDriver(){

        try {
            driver = new AppiumDriver(url, cap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
