package com.instagram.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OtherUserProfilePage extends CommonPage{

    private final By lblUsernameTopic = By.id("com.instagram.android:id/action_bar_title");

    /****
     * Select account from the search view
     *
     * new page
     * ========
     * click on following button - com.instagram.android:id/profile_header_follow_button
     * click on unfollow button - com.instagram.android:id/follow_sheet_unfollow_row
     * click unfollow from popup - com.instagram.android:id/primary_button
     * add a verification point - this is an enhancement
     *
     *
     */

    public boolean isUsernameTopicDisplaying(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(lblUsernameTopic)).isDisplayed();
    }


}
