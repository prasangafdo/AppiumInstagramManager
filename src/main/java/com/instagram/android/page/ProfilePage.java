package com.instagram.android.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends CommonPage{

    private final By btnFollowing = By.id("com.instagram.android:id/row_profile_header_following_container");
    private final By lblLeastInteracted = By.xpath("//android.widget.LinearLayout[@content-desc='Least Interacted With']/android.widget.LinearLayout");
    private final By btnSeeAllSuggestions = By.id("com.instagram.android:id/see_all_button");
    private final By btnLoadMore = By.xpath("//div[contains(@class,'inspected-element-box')]");



    public void clickOnFollowingButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(btnFollowing)).click();
    }

    public boolean isLeastInteractedLabelDisplaying(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.elementToBeClickable(lblLeastInteracted)).isDisplayed();
    }

    public void scrollTillLoadMoreButtonDisplays(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
//        driver.findElementBy
//        wait.until(ExpectedConditions.)

//        WebElement element = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).index(0)).scrollIntoView(new UiSelector().text(\"ruerr_g\"))"));

        By detectiveNovel = AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.instagram.android:id/row_load_more_button\"))"); //xpath is correct. But scrolling doesn't work
        driver.findElement(detectiveNovel).getText();
    }
    /*
    *   Do the scrolling while checking
    *   whether the button is visible
    *
     */

}
