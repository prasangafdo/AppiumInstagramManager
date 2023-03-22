package com.instagram.android.module;

import com.instagram.android.page.ProfilePage;
import com.instagram.android.page.SearchPage;

import java.util.HashSet;


public class SearchModule {
    private static final SearchPage search = new SearchPage();
    private static final ProfilePage profile = new ProfilePage();

//    public static HashSet<String> getUsersToUnfollow(){
//
//    }

    public static void searchByUsername(){

            for (String username:profile.getUsersToUnfollow()) {
                search.searchByUsername(username);
                search.selectAccountsFromTabs();
                search.selectFirstRecordFromSearchResults();
            }
            //Create a new method in profile page for unfollowing process and call the method here

//        search.searchByUsername(profile.getUsersToUnfollow());
    }

}