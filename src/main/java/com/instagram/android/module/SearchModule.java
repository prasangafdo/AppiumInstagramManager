package com.instagram.android.module;

import com.instagram.android.page.*;


public class SearchModule extends ProfileManagementModule{
    private static final SearchPage search = new SearchPage();
//    private static final ProfilePage profile = new ProfilePage();
    private static final OtherUserProfilePage otherProfile = new OtherUserProfilePage();
//    private static final LandingPage landing = new LandingPage();


    public static void searchByUsernameAndUnfollow() {
            for (String username:profile.getUsersToUnfollow()) {
                search.searchByUsername(username);
                search.selectAccountsFromTabs();
                search.selectFirstRecordFromSearchResults();
                if (otherProfile.isUsernameTopicDisplaying()){
                    try{
                        otherProfile.clickOnFollowingButton();
                        otherProfile.clickOnUnfollowButton();
                        otherProfile.clickOnUnfollowFromPopup();
                        landing.clickOnSearchButton();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        landing.clickOnSearchButton();
                    }
                }
            }
    }

}