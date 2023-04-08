package com.instagram.android.page;

import io.appium.java_client.android.AndroidTouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MessagesPage extends CommonPage{

    private final By btnMessages = By.id("com.instagram.android:id/action_bar_inbox_button");
    private final By lblMessagesHeader = By.id("com.instagram.android:id/header_text");
    private final By btnChatThreadOfUnreadUsers= By.xpath("//android.widget.TextView[@resource-id='com.instagram.android:id/row_inbox_digest' and contains(@text,'Sent')]/parent::android.view.View");
    private final By btnDelete= By.xpath("//android.widget.TextView[@resource-id = 'com.instagram.android:id/action_sheet_row_text_view' and @text = 'Delete']");
    private final By btnDeleteOnPopup= By.id("com.instagram.android:id/primary_button");

    public void clickOnMessagesButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnMessages)).click();
    }

    public boolean isMessagesTopicDisplayingProperly(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(lblMessagesHeader)).getText().equals("Messages");
//        driver.findElement(btnProfile).click();
    }

    public void deleteMessage(List<WebElement> chats){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(btnChatThreadOfUnreadUsers));
//        Actions actions = new Actions(driver);
//        actions.clickAndHold(driver.findElement(btnChatThreadOfUnreadUsers));
//        actions.perform();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDelete)).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDeleteOnPopup)).click(); //Track usernames - enhancement
        //Check whether the popup is displaying
        for (WebElement str:chats) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(str);
        actions.perform();
            driver.navigate().back();

        }


    }

    public List<WebElement> getUsernamesOfUnreadUsers(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnChatThreadOfUnreadUsers));
        return driver.findElements(btnChatThreadOfUnreadUsers);
    }




   /*
    *   gasther web elements
    *   loop and navigate to other users page
    *   do the deletion
    */



}
