package com.instagram.android.module;

import com.instagram.android.page.*;

import java.util.HashSet;


public class SearchModule {
    private static final SearchPage search = new SearchPage();
    private static final ProfilePage profile = new ProfilePage();
    private static final OtherUserProfilePage otherProfile = new OtherUserProfilePage();
    private static final LandingPage landing = new LandingPage();

//    public static HashSet<String> getUsersToUnfollow(){
//
//    }

    public static void searchByUsername() throws InterruptedException {
            for (String username:profile.getUsersToUnfollow()) {
                search.searchByUsername(username);
                search.selectAccountsFromTabs();
                search.selectFirstRecordFromSearchResults();
                if (otherProfile.isUsernameTopicDisplaying()){
                    otherProfile.clickOnFollowingButton();
                    otherProfile.clickOnUnfollowButton();
                    otherProfile.clickOnUnfollowFromPopup();//Unfollow completed. Add a step to navigate back to search
                    landing.clickOnSearchButton();
                }
            }
            //Create a new method in profile page for unfollowing process and call the method here

//        search.searchByUsername(profile.getUsersToUnfollow());
    }

}