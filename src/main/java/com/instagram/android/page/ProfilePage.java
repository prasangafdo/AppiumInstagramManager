package com.instagram.android.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

import static java.time.Duration.ofMillis;
import static java.util.Collections.singletonList;

public class ProfilePage extends CommonPage{

    private final By btnFollowing = By.id("com.instagram.android:id/row_profile_header_following_container");
    private final By btnFollowers = By.id("com.instagram.android:id/row_profile_header_followers_container");
    private final By lblLeastInteracted = By.xpath("//android.widget.LinearLayout[@content-desc='Least Interacted With']/android.widget.LinearLayout");
    private final By btnSeeAllSuggestions = By.id("com.instagram.android:id/see_all_button");
    private final By btnLoadMore = By.id("com.instagram.android:id/row_load_more_button");
    private final By lblUsernameCard = By.xpath("(//android.widget.LinearLayout[@resource-id='com.instagram.android:id/follow_list_container'])[1]");
    private final By lblUsernames = By.xpath("//android.widget.TextView[@resource-id ='com.instagram.android:id/follow_list_username']");
    private final By lblSuggestionTopic = By.id("com.instagram.android:id/row_header_textview");
    private final By btnFirstRemove = By.xpath("(//android.widget.TextView[@text='Remove'])[1]");
    private final By btnRemove = By.xpath("//android.widget.TextView[not(@text='Follow')]/parent::android.widget.LinearLayout");
    private final By btnFollow = By.xpath("//android.widget.LinearLayout[@text]/parent::android.widget.LinearLayout/android.widget.TextView[@text='Follow']");


    private boolean isScreenScrollable = true;
    private HashSet<String> followingUsersSet = new HashSet<>();
    private HashSet<String> followersUsersSet = new HashSet<>();
    private HashSet<String> tempUsersSet = new HashSet<>();



    public void clickOnFollowingButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(btnFollowing)).click();
    }

    public void clickOnFollowersButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(btnFollowers)).click();
    }


    public boolean isLeastInteractedLabelDisplaying(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.elementToBeClickable(lblLeastInteracted)).isDisplayed();
    }

    public boolean isRemoveButtonDisplaying(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.elementToBeClickable(btnFirstRemove)).isDisplayed();
    }

    public void scrollTillLoadMoreButtonDisplays() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        initiateTheScrolling();
        while (isScreenScrollable) {
            continueScrolling();
        }
//        try {
//            Thread.sleep(1000);
//            while (isScreenScrollable) {
//                continueScrolling();
//            }
////            this.continueScrolling();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }


        }


    public void initiateTheScrolling(){
        if (!tempUsersSet.isEmpty()){
            tempUsersSet.clear();
        }
        Point source = driver.findElement(lblLeastInteracted).getLocation();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), source.x, source.y -  900));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        driver.perform(singletonList(sequence));
        this.setFollowersUserList();
//        for (String element: set){
//            System.out.println("Web elements list ===>"+element);
//        }
//        wait.until(ExpectedConditions.elementToBeClickable(btnLoadMore)).click(); //No longer an issue
    }

    public void continueScrolling() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblUsernameCard));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

//        finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
////        sequence = new Sequence(finger, 1);
//        sequence.addAction(finger.createPointerMove(ofMillis(0),
//                PointerInput.Origin.viewport(), source.x, source.y));
//        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
//        sequence.addAction(new Pause(finger, ofMillis(10)));
//        sequence.addAction(finger.createPointerMove(ofMillis(600),
//                PointerInput.Origin.viewport(), source.x, source.y -  950));
//        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
//
//        driver.perform(singletonList(sequence));
//
//        this.setUserList();
////        for (String element: set){
////            System.out.println("Web elements list ===>"+element);
////        }
//
//        if (driver.findElements(btnLoadMore).isEmpty()) {
//
//            for (String element : set) {
////                System.out.println("Username ===>" + element); //Disable to log the username
////                try {
////                    if (this.isSuggestionTopicDisplaying()){
////                        this.isScreenScrollable = false;
////                    }
////                }
////                catch (Exception e1){
////                    e1.printStackTrace();
////                }
//                if (!driver.findElements(lblSuggestionTopic).isEmpty()) {
//                    this.isSuggestionTopicDisplaying();
//                    this.isScreenScrollable = false;
//                }
//            }
//        }
//
////            if (wait.until(ExpectedConditions.elementToBeClickable(btnLoadMore)).isDisplayed()){
//
//
//        else {
//            driver.findElement(btnLoadMore).click();
//        }
//
////        try {
////            wait.until(ExpectedConditions.elementToBeClickable(btnLoadMore)).click();
////////            Thread.sleep(2000);
//////            isLoadMoreVisible = !driver.findElements(btnLoadMore).isEmpty();
////        }
////        catch (Exception e){
////            e.printStackTrace();
////
////
////        }
//        System.out.println("Web elements array size --->"+set.size());
        Point source = driver.findElement(lblUsernameCard).getLocation();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(100)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), source.x, source.y -  940));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        driver.perform(singletonList(sequence));

        if (driver.findElements(btnLoadMore).isEmpty() && driver.findElements(lblSuggestionTopic).isEmpty()) {

            this.setUserList();
        }
        else {
            if (driver.findElements(btnLoadMore).isEmpty()) {
                driver.findElement(btnLoadMore).click();
            }

            else{
                isScreenScrollable = false;
            }

        }

        System.out.println("Web elements array size --->"+followingUsersSet.size());
    }

    public void scrollToTheEnd(){
        //Using this to load all the elements completely
        this.initiateTheScrolling();

        while (isScreenScrollable) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            wait.until(ExpectedConditions.visibilityOfElementLocated(lblUsernameCard));

            Point source = driver.findElement(lblUsernameCard).getLocation();
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence sequence = new Sequence(finger, 1);
            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            sequence.addAction(finger.createPointerMove(ofMillis(0),
                    PointerInput.Origin.viewport(), source.x, source.y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
            sequence.addAction(new Pause(finger, ofMillis(100)));
            sequence.addAction(finger.createPointerMove(ofMillis(600),
                    PointerInput.Origin.viewport(), source.x, source.y -  99900));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

            driver.perform(singletonList(sequence));

            List<WebElement> elements = driver.findElements(lblUsernames);
            List<String> tempUsernames = new ArrayList<>();

            for (WebElement we: elements){
                tempUsernames.add(we.getText());
            }

            if (tempUsersSet.containsAll(tempUsernames)){
                isScreenScrollable = false; //User has reached the end of the scrollable content
                tempUsersSet.clear();
            }

            this.setUserList();

            if (!driver.findElements(btnLoadMore).isEmpty()) {
                try {
                    driver.findElement(btnLoadMore).click();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                this.setUserList();
            }

//            System.out.println("Web elements array size --->"+set.size());
        }
    }

    public void scrollToTheEndOfFollowingList(){
        //Using this to load all the elements completely
        if (!tempUsersSet.isEmpty()){
            tempUsersSet.clear();
        }
        Point source = driver.findElement(btnFirstRemove).getLocation();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), source.x, source.y -  900));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        driver.perform(singletonList(sequence));
        this.setFollowersUserList();

        isScreenScrollable = true;

        while (isScreenScrollable) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            wait.until(ExpectedConditions.visibilityOfElementLocated(lblUsernameCard));

            source = driver.findElement(lblUsernameCard).getLocation();
            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            sequence = new Sequence(finger, 1);
            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            sequence.addAction(finger.createPointerMove(ofMillis(0),
                    PointerInput.Origin.viewport(), source.x, source.y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
            sequence.addAction(new Pause(finger, ofMillis(100)));
            sequence.addAction(finger.createPointerMove(ofMillis(600),
                    PointerInput.Origin.viewport(), source.x, source.y -  99900));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

            driver.perform(singletonList(sequence));

            List<WebElement> elements = driver.findElements(lblUsernames);
            List<String> tempUsernames = new ArrayList<>();

            for (WebElement we: elements){
                tempUsernames.add(we.getText());
            }

            if (tempUsersSet.containsAll(tempUsernames)){
                isScreenScrollable = false; //User has reached the end of the scrollable content
                tempUsersSet.clear();
            }

            this.setUserList();

            if (!driver.findElements(btnLoadMore).isEmpty()) {
                try {
                    driver.findElement(btnLoadMore).click();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

                this.setUserList();
            }

//            System.out.println("Web elements array size --->"+set.size());
        }
    }

    public void setUserList(){
        List<WebElement> we = driver.findElements(lblUsernames);

        for (WebElement element: we){
            this.tempUsersSet.add (element.getText());
        }
        System.out.println(tempUsersSet.size());
    }

    public void scrollToTheTop(){
        //Move to the top of the screen
        //Verify the scrolling is finished

        isScreenScrollable = true;

        while (isScreenScrollable) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            if (driver.findElements(btnFollow).size()==0){
                wait.until(ExpectedConditions.visibilityOfElementLocated(lblUsernameCard));
            }
            else isScreenScrollable = false;

            Point source;
            PointerInput finger;
            Sequence sequence;

//            source = driver.findElement(lblUsernameCard).getLocation();
//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//            sequence = new Sequence(finger, 1);

            try {
                source = driver.findElement(lblUsernameCard).getLocation();
                finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                sequence = new Sequence(finger, 1);
            }
            catch (Exception e){
                e.printStackTrace();
                source = driver.findElement(btnSeeAllSuggestions).getLocation();
                finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                sequence = new Sequence(finger, 1);
            }
//            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            sequence.addAction(finger.createPointerMove(ofMillis(0),
                    PointerInput.Origin.viewport(), source.x, source.y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
            sequence.addAction(new Pause(finger, ofMillis(100)));
            sequence.addAction(finger.createPointerMove(ofMillis(600),
                    PointerInput.Origin.viewport(), source.x, source.y + 99900));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

            driver.perform(singletonList(sequence));

            isScreenScrollable = true;

//            List<WebElement> elements = driver.findElements(lblUsernames);
////            List<String> tempUsernames = new ArrayList<>();
//
//            for (WebElement we : elements) {
//                tempUsernames.add(we.getText());
//            }
            if (driver.findElements(lblLeastInteracted).size()>0) {
                isScreenScrollable = false; //User has reached the end of the scrollable content
                System.out.println("User reached the top of the scrollable content");
            }

        }
        isScreenScrollable = true;
    }

    public void gatherFollowers(){
        Point source;
        PointerInput finger;
        Sequence sequence;

        try {
            source = driver.findElement(btnFollow).getLocation();
            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            sequence = new Sequence(finger, 1);
            sequence.addAction(finger.createPointerMove(ofMillis(0),
                    PointerInput.Origin.viewport(), source.x, source.y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
            sequence.addAction(new Pause(finger, ofMillis(600)));
            sequence.addAction(finger.createPointerMove(ofMillis(600),
                    PointerInput.Origin.viewport(), source.x, source.y -  900));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

            driver.perform(singletonList(sequence));
            this.setFollowersUserList();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        while (isScreenScrollable) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            wait.until(ExpectedConditions.visibilityOfElementLocated(btnRemove));

            source = driver.findElement(lblUsernameCard).getLocation();
            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            sequence = new Sequence(finger, 1);
            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            sequence.addAction(finger.createPointerMove(ofMillis(0),
                    PointerInput.Origin.viewport(), source.x, source.y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
            sequence.addAction(new Pause(finger, ofMillis(100)));
            sequence.addAction(finger.createPointerMove(ofMillis(600),
                    PointerInput.Origin.viewport(), source.x, source.y - 800));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

            driver.perform(singletonList(sequence));

            List<WebElement> elements = driver.findElements(lblUsernames);
            List<String> tempUsernames = new ArrayList<>();

            for (WebElement we: elements){
                tempUsernames.add(we.getText());
            }
            if (followersUsersSet.containsAll(tempUsernames)){//empty temp list
                isScreenScrollable = false; //User has reached the end of the scrollable content
                System.out.println("User reached the end of the followers list"+this.getFollowersSet().size());
            }
            else this.setFollowersUserList();

//            if (!driver.findElements(btnLoadMore).isEmpty()) {
//                driver.findElement(btnLoadMore).click();
//                this.setUserList();
//            }

//            System.out.println("Web elements array size --->"+set.size());
        }

    }

    public void gatherFollowingUsers(){
        Point source = driver.findElement(lblLeastInteracted).getLocation();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600),
                PointerInput.Origin.viewport(), source.x, source.y -  900));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

        driver.perform(singletonList(sequence));
        this.setFollowingUserList();
        while (isScreenScrollable) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
            wait.until(ExpectedConditions.visibilityOfElementLocated(lblUsernameCard));

            source = driver.findElement(lblUsernameCard).getLocation();
            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            sequence = new Sequence(finger, 1);
            finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            sequence.addAction(finger.createPointerMove(ofMillis(0),
                    PointerInput.Origin.viewport(), source.x, source.y));
            sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
            sequence.addAction(new Pause(finger, ofMillis(100)));
            sequence.addAction(finger.createPointerMove(ofMillis(600),
                    PointerInput.Origin.viewport(), source.x, source.y - 800));
            sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));

            driver.perform(singletonList(sequence));

            List<WebElement> elements = driver.findElements(lblUsernames);
            List<String> tempUsernames = new ArrayList<>();

            for (WebElement we: elements){
                tempUsernames.add(we.getText());
            }
            if (followingUsersSet.containsAll(tempUsernames)){
                isScreenScrollable = false; //User has reached the end of the scrollable content
                System.out.println("line 390 triggered");
            }
            else this.setFollowingUserList();

//            if (!driver.findElements(btnLoadMore).isEmpty()) {
//                driver.findElement(btnLoadMore).click();
//                this.setUserList();
//            }

//            System.out.println("Web elements array size --->"+set.size());
        }

    }

    public void setFollowingUserList(){
        List<WebElement> we = driver.findElements(lblUsernames);

        for (WebElement element: we){
            this.followingUsersSet.add (element.getText());
        }
//        System.out.println(followingUsersSet.size());
    }

    public void setFollowersUserList(){
        List<WebElement> we = driver.findElements(lblUsernames);

        for (WebElement element: we){
            this.followersUsersSet.add (element.getText());
        }
//        System.out.println(followersUsersSet.size());
    }

    public HashSet<String> getFollowingUsersSet(){
        return followingUsersSet;
    }

    public HashSet<String> getFollowersSet(){
        return followersUsersSet;
    }

    public boolean isSuggestionTopicDisplaying(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblSuggestionTopic));
        return driver.findElement(lblSuggestionTopic).isDisplayed();
    }

}
