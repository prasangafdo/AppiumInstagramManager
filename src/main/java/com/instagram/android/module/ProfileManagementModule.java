package com.instagram.android.module;

import com.instagram.android.page.LandingPage;
import com.instagram.android.page.ProfilePage;

public class ProfileManagementModule {
    private static final LandingPage landing = new LandingPage();
    private static final ProfilePage profile = new ProfilePage();

    public static void navigateToProfile(){
        landing.clickOnProfileButton();
    }
    public static void navigateToFollowingList(){
        profile.clickOnFollowingButton();
    }
    public static void navigateToFollowersList(){
        profile.clickOnFollowersButton();
    }
    public static boolean isLeastInteractedLabelDisplaying(){
        return profile.isLeastInteractedLabelDisplaying();
    }
    public static boolean isRemoveButtonDisplaying(){
        return profile.isRemoveButtonDisplaying();
    }
    public static void scrollTillLoadMoreButtonDisplays() throws InterruptedException {
        profile.scrollTillLoadMoreButtonDisplays();
        System.out.println(profile.getUserList().toString()); //for debugging only
    }
    public static void scrollToTheEnd(){
        profile.scrollToTheEnd();
    }
    public static void scrollToTheTop(){
        profile.scrollToTheTop();
    }
    public static void gatherElements(){
        profile.gatherElements();
        System.out.println(profile.getUserList().toString());
    }
    public static boolean isSuggestionTopicDisplaying(){
        return profile.isSuggestionTopicDisplaying();
    }



}
