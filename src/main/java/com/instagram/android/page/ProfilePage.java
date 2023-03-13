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
    private final By lblLeastInteracted = By.xpath("//android.widget.LinearLayout[@content-desc='Least Interacted With']/android.widget.LinearLayout");
    private final By btnSeeAllSuggestions = By.id("com.instagram.android:id/see_all_button");
    private final By btnLoadMore = By.id("com.instagram.android:id/row_load_more_button");
    private final By lblUsernameCard = By.xpath("(//android.widget.LinearLayout[@resource-id='com.instagram.android:id/follow_list_container'])[2]");
    private final By lblUsernames = By.xpath("//android.widget.TextView[@resource-id ='com.instagram.android:id/follow_list_username']");
    private final By lblSuggestionTopic = By.id("com.instagram.android:id/row_header_textview");


    private boolean isScreenScrollable = true;
    private HashSet<String> set = new HashSet<>();


    //////
//    Point source;


    //////


    public void clickOnFollowingButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(btnFollowing)).click();
    }

    public boolean isLeastInteractedLabelDisplaying(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait.until(ExpectedConditions.elementToBeClickable(lblLeastInteracted)).isDisplayed();
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


//        int X = driver.findElement(lblLeastInteracted).getRect().x + (driver.findElement(lblLeastInteracted).getSize().width / 2);
//        int StartY = driver.findElement(lblLeastInteracted).getRect().y + (driver.findElement(lblLeastInteracted).getSize().height / 4);
//        int EndY = driver.findElement(lblLeastInteracted).getRect().y + (driver.findElement(lblLeastInteracted).getSize().height * 3 / 4);
//
//
//        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
//        Sequence dragNDrop = new Sequence(finger, 1);
//        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
//                PointerInput.Origin.viewport(), X, StartY));
//        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
//        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
//                PointerInput.Origin.viewport(), X, EndY));
//        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//        driver.perform(Arrays.asList(dragNDrop));


//        try {
//            driver.findElement(btnLoadMore).isDisplayed();
//        }
//        catch (Exception e){
//            e.printStackTrace();



        /////////////////
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(lblLeastInteracted));

    //}
    /*
    *   Do the scrolling while checking
    *   whether the button is visible
    *
     */

    public void initiateTheScrolling(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

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
        this.setUserList();
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


//        for (String element: set){
//            System.out.println("Web elements list ===>"+element);
//        }

        if (driver.findElements(btnLoadMore).isEmpty() && driver.findElements(lblSuggestionTopic).isEmpty()) {

            this.setUserList();
        }

//            if (wait.until(ExpectedConditions.elementToBeClickable(btnLoadMore)).isDisplayed()){


        else {
            if (driver.findElements(btnLoadMore).isEmpty()) {
                driver.findElement(btnLoadMore).click();
            }

            else{
                isScreenScrollable = false;
            }

        }

        System.out.println("Web elements array size --->"+set.size());
    }

    public void scrollToTheEnd(){
        //Using this to load all the elements completely
        this.initiateTheScrolling();

        while (isScreenScrollable) {
//            continueScrolling();

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
            if (set.containsAll(tempUsernames)){
                isScreenScrollable = false; //User has reached the end of the scrollable content
            }

            this.setUserList();

            if (!driver.findElements(btnLoadMore).isEmpty()) {
                driver.findElement(btnLoadMore).click();
                this.setUserList();
            }
//
//            else {
//                if (driver.findElements(btnLoadMore).isEmpty()) {
//                    driver.findElement(btnLoadMore).click();
//                }
//
//                else{
//                    isScreenScrollable = false;
//                }
//
//            }

            System.out.println("Web elements array size --->"+set.size());
        }


    }

    public void setUserList(){
        List<WebElement> we = driver.findElements(lblUsernames);

        for (WebElement element: we){
            this.set.add (element.getText());
        }
    }

    public HashSet<String> getUserList(){
        return set;
    }

    public boolean isSuggestionTopicDisplaying(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblSuggestionTopic));
        return driver.findElement(lblSuggestionTopic).isDisplayed();
    }

}
