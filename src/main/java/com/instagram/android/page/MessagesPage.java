package com.instagram.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagesPage extends CommonPage{

    private final By btnMessages = By.id("com.instagram.android:id/action_bar_inbox_button");
    private final By lblMessagesHeader = By.id("com.instagram.android:id/header_text");
    private final By btnChatThreadOfUnreadUsers= By.xpath("//android.widget.TextView[@resource-id='com.instagram.android:id/row_inbox_digest' and contains(@text,'Sent')]/parent::android.view.View");

    public void clickOnMessagesButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnMessages)).click();
    }

    public boolean isMessagesTopicDisplayingProperly(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblMessagesHeader)).getText().equals("Messages");
//        driver.findElement(btnProfile).click();
    }

   /*
    *   gasther web elements
    *   loop and navigate to other users page
    *   do the unfollowing
    */



}
