package com.instagram.android.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

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

//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
//                ".scrollIntoView(new UiSelector().resourceIdMatches(\"com.instagram.android:id/row_load_more_button\"))")); //id is correct. But scrolling doesn't work
//
//        driver.findElement(AppiumBy.androidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));

//        Point source = dragMe.getCenter();
//        Point target = driver.findElementByAccessibilityId("dropzone").getCenter();
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence dragNDrop = new Sequence(finger, 1);
//        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),
//                PointerInput.Origin.viewport(), source.x, source.y));
//        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
//                PointerInput.Origin.viewport(),target.x, target.y));
//        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(dragNDrop))
//
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        HashMap<String, String> scrollObject = new HashMap<>();
//        scrollObject.put("direction", "down");
//        js.executeScript("mobile: swipe", scrollObject);


        int X = driver.findElement(btnSeeAllSuggestions).getRect().x + (driver.findElement(btnSeeAllSuggestions).getSize().width / 2);
        int StartY = driver.findElement(btnSeeAllSuggestions).getRect().y + (driver.findElement(btnSeeAllSuggestions).getSize().height / 4);
        int EndY = driver.findElement(btnSeeAllSuggestions).getRect().y + (driver.findElement(btnSeeAllSuggestions).getSize().height * 3 / 4);


        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
                PointerInput.Origin.viewport(), X, StartY));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), X, EndY));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(dragNDrop));
    }
    /*
    *   Do the scrolling while checking
    *   whether the button is visible
    *
     */

}
