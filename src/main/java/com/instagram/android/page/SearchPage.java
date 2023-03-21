package com.instagram.android.page;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SearchPage extends CommonPage{

private final By txtSearchBar = By.id("com.instagram.android:id/action_bar_search_edit_text");
private final By btnAccountsTab = By.xpath("//android.widget.FrameLayout[@content-desc=\"Accounts\"]");
    // User acceount view //android.widget.LinearLayout[contains(@resource-id,'row_search_user_info_container')]
    public void searchByUsername(String username){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(txtSearchBar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(txtSearchBar)).sendKeys(username);
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done")); //This is used to click the return key
    }

    public void selectAccounts(){
        driver.findElement(btnAccountsTab).click();
    }


}
