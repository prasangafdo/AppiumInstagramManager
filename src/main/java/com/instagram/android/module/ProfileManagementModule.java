package com.instagram.android.module;

import com.instagram.android.page.LandingPage;
import com.instagram.android.page.ProfilePage;
import com.instagram.android.util.FileWriter;

import java.io.IOException;
import java.util.HashSet;

public class ProfileManagementModule {
    protected static final LandingPage landing = new LandingPage();
    protected static ProfilePage profile = new ProfilePage();
    private static com.instagram.android.util.FileWriter fileWriter = new FileWriter(); //for testing only

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
        fileWriter.writeUsersIFollow(profile.getFollowingUsersSet());
//        System.out.println("Followers: "+profile.getFollowersSet().size()+profile.getFollowersSet().toString());
//        try {
//            FileWriter myWriter = new FileWriter("followers.txt");
//            myWriter.write("Followers: "+profile.getFollowersSet().size()+profile.getFollowersSet().toString());
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
    }
    public static void gatherFollowingUsers(){
        profile.gatherFollowingUsers();
//        System.out.println("Following: "+profile.getFollowingUsersSet().size()+profile.getFollowingUsersSet().toString());
//        try {
//            FileWriter myWriter = new FileWriter("following.txt");
//            myWriter.write("Following: "+profile.getFollowingUsersSet().size()+profile.getFollowingUsersSet().toString());
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
    }

    public static void setUsersToUnfollow(){
        profile.setUsersToUnfollow();
    }

//    public static void unfollowUsers(){
//        profile.unfollowUsers();
//    }

    public static HashSet<String> getUsersToUnfollow(){
        return getUsersToUnfollow();
    }

    public static void navigateToSearch(){
        landing.clickOnSearchButton();
    }



    public static boolean isSuggestionTopicDisplaying(){
        return profile.isSuggestionTopicDisplaying();
    }
//    public static void endSession(){
//        .endSession();
//    }



}
