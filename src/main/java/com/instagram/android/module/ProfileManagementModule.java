package com.instagram.android.module;

import com.instagram.android.page.LandingPage;
import com.instagram.android.page.ProfilePage;

import java.io.FileWriter;
import java.io.IOException;

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
//    public static void scrollTillLoadMoreButtonDisplays() throws InterruptedException {
//        profile.scrollTillLoadMoreButtonDisplays();
//        System.out.println(profile.getUserList().toString()); //for debugging only
//    }
    public static void scrollToTheEnd(){
        profile.scrollToTheEnd();
    }
    public static void scrollToTheEndOfFollowingList(){
        profile.scrollToTheEndOfFollowingList();
    }

    public static void scrollToTheTop(){
        profile.scrollToTheTop();
    }
    public static void gatherFollowers(){
        profile.gatherFollowers();
        System.out.println("Followers: "+profile.getFollowersSet().size()+profile.getFollowersSet().toString());
        try {
            FileWriter myWriter = new FileWriter("followers.txt");
            myWriter.write("Followers: "+profile.getFollowersSet().size()+profile.getFollowersSet().toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void gatherFollowingUsers(){
        profile.gatherFollowingUsers();
        System.out.println("Following: "+profile.getFollowingUsersSet().size()+profile.getFollowingUsersSet().toString());
        try {
            FileWriter myWriter = new FileWriter("following.txt");
            myWriter.write("Following: "+profile.getFollowingUsersSet().size()+profile.getFollowingUsersSet().toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static boolean isSuggestionTopicDisplaying(){
        return profile.isSuggestionTopicDisplaying();
    }



}
