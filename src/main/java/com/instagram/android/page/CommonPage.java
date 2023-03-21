package com.instagram.android.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class CommonPage {
    public static DesiredCapabilities cap = new DesiredCapabilities();
    private URL url = null;
    static AppiumDriver driver;
    private static final CommonPage commonPage = new CommonPage();



    public CommonPage()  {
        try {
            url = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        cap.setCapability("deviceName", "HTC Desire 626 Dual Sim");
        cap.setCapability("udid", "HQ66GBS27849");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "5.1");
        cap.setCapability("appPackage", "com.instagram.android");
        cap.setCapability("appActivity", "com.instagram.mainactivity.MainActivity");
        cap.setCapability("noReset", "true");
        cap.setCapability("unicodeKeyboard", "true");
        cap.setCapability("resetKeyboard", "true");
    }

    public void setupDriverEnvironment(){

        try {
            driver = new AppiumDriver(url, cap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUpDriver(){
        commonPage.setupDriverEnvironment();
    }

}
