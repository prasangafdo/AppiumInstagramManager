package com.instagram.android.util;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileWriter {

    public String usersToUnfollow = "./src/main/resources/usersToUnfollow.csv";

    public void writeUsersToUnfollow(HashSet<String> list){
        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(usersToUnfollow);
            for (String str : list) {
                myWriter.write(str + ",");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//    @Test
//    public void aaa(){
//        sss.add("lyuuikl");
//        sss.add("dfgdfg");
//        sss.add("hgfsh");
//        sss.add("fhdh");
//
//        this.writeUsersToUnfollow(sss);
//    }
}
