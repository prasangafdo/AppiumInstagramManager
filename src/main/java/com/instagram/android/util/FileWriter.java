package com.instagram.android.util;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileWriter {

    public String usersToUnfollow = "./src/main/resources/usersToUnfollow.csv";
    public String usersIFollow = "./src/main/resources/usersIFollow.csv";
    public String followersList = "./src/main/resources/followers.csv";

    public void writeUsersToUnfollow(HashSet<String> list) {
        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(usersToUnfollow);
            for (String str : list) {
                myWriter.write(str + ",");
            }
            myWriter.close();
            System.out.println("Successfully wrote to usersToUnfollow.csv");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeUsersIFollow(HashSet<String> list) {
        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(usersIFollow);
            for (String str : list) {
                myWriter.write(str + ",");
            }
            myWriter.close();
            System.out.println("Successfully wrote to usersIFollow.csv.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeFollowers(HashSet<String> list) {
        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(followersList);
            for (String str : list) {
                myWriter.write(str + ",");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
