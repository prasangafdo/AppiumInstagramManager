package com.instagram.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OtherUserProfilePage extends CommonPage{

    private final By lblUsernameTopic = By.id("com.instagram.android:id/action_bar_title");
//    private final By btnFollowing = By.id("com.instagram.android:id/profile_header_follow_button");
    private final By btnFollowing = By.xpath("//android.widget.TextView[contains(@resource-id,'follow_button') and (@text='Following')]");
    private final By btnUnfollow = By.id("com.instagram.android:id/follow_sheet_unfollow_row");
    private final By btnUnfollowPopup = By.id("com.instagram.android:id/primary_button");

    /****
     * add a verification point - this is an enhancement
     */

    public boolean isUsernameTopicDisplaying(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(lblUsernameTopic)).isDisplayed();
    }

    public void clickOnFollowingButton(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(btnFollowing)).click();
        }
        catch (Exception e){
            e.printStackTrace();

        }

    }
    public void clickOnUnfollowButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnUnfollow)).click();
    }
    public void clickOnUnfollowFromPopup() throws InterruptedException {//Add a verification here ******************
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.elementToBeClickable(btnUnfollowPopup)).click();
        try {
            wait.until(ExpectedConditions.elementToBeClickable(btnUnfollowPopup)).click();
        }
        catch (Exception e){
            System.out.println("Unfollowed a public account");
        }
    }



}
