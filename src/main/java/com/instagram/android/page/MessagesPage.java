package com.instagram.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagesPage extends CommonPage{

    private final By btnMessages = By.id("com.instagram.android:id/action_bar_inbox_button");
    private final By lblMessagesHeader = By.id("com.instagram.android:id/header_text");

    public void clickOnMessagesButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnMessages)).click();
//        driver.findElement(btnProfile).click();
    }

    public boolean isMessagesTopicDisplayingProperly(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblMessagesHeader)).getText().equals("Messages");
//        driver.findElement(btnProfile).click();
    }



}
