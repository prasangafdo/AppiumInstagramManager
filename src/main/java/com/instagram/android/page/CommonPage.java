package com.instagram.android.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class CommonPage {
    public static UiAutomator2Options options = new UiAutomator2Options();
    private URL url = null;
    static AndroidDriver driver;
    private static final CommonPage commonPage = new CommonPage();



    public CommonPage()  {
        try {
            url = new URL("http://0.0.0.0:4723/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        options.setCapability("deviceName", "Redmi Note 11");
        options.setCapability("udid", "f26fba68");
        options.setCapability("platformName", "Android");
        options.setCapability("platformVersion", "13");
        options.setCapability("appPackage", "com.instagram.android");
//        options.setCapability("appActivity", "com.instagram.mainactivity.MainActivity");
        options.setCapability("noReset", "true");
        options.setCapability("unicodeKeyboard", "true");
        options.setCapability("resetKeyboard", "true");
    }

    public void setupDriverEnvironment(){

        try {
            driver = new AndroidDriver(url, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUpDriver(){
        commonPage.setupDriverEnvironment();
        int retries = 3;
        while (retries > 0) {
            try {
                driver.activateApp("com.instagram.android");
                break; // If successful, exit the loop
            } catch (Exception e) {
                retries--;
                try {
                    Thread.sleep(1000); // Wait before retrying
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public static void endSession(){
        driver.quit();
    }

    public void navigateBack(){
        driver.navigate().back();
    }

}
