package com.instagram.android.page;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;


public class SearchPage extends CommonPage{

private final By txtSearchBar = By.id("com.instagram.android:id/action_bar_search_edit_text");
private final By btnAccountsTab = By.xpath("//android.widget.FrameLayout[@content-desc='Accounts']");
private final By lblUserNames = By.xpath("//android.widget.LinearLayout[contains(@resource-id,'row_search_user_info_container')]");

    public void searchByUsername(String username){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(txtSearchBar)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtSearchBar)).click();
        wait.until(ExpectedConditions.elementToBeClickable(txtSearchBar)).sendKeys(username);
        System.out.println("Unfollowing: ".concat(username));
        driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done")); //This is used to click the return key
    }

    public void selectFirstRecordFromSearchResults(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        wait.until(ExpectedConditions.elementToBeClickable(lblUserNames)).click();
    }

    public void selectAccountsFromTabs(){ //from tab
        driver.findElement(btnAccountsTab).click();
    }


}
