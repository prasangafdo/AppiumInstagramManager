package com.instagram.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LandingPage extends CommonPage {

    private final By btnProfile = By.id("com.instagram.android:id/profile_tab");
    private final By btnSearch = By.id("com.instagram.android:id/search_tab");

    public void clickOnProfileButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnProfile)).click();
//        driver.findElement(btnProfile).click();
    }

    public void clickOnSearchButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();
//        driver.findElement(btnProfile).click();
    }

}
