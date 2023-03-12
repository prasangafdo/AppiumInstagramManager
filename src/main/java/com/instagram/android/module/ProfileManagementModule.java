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
    public static boolean isLeastInteractedLabelDisplaying(){
        return profile.isLeastInteractedLabelDisplaying();
    }
    public static void scrollTillLoadMoreButtonDisplays() throws InterruptedException {
        profile.scrollTillLoadMoreButtonDisplays();
        System.out.println(profile.getUserList().toString()); //for debugging only
    }
    public static boolean isSuggestionTopicDisplaying(){
        return profile.isSuggestionTopicDisplaying();
    }



}
