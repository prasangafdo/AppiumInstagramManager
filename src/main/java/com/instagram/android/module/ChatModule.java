package com.instagram.android.module;

import com.instagram.android.page.MessagesPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChatModule {

    private static final MessagesPage message = new MessagesPage();

    public static void navigateToMessages(){
        message.clickOnMessagesButton();
    }

    public static boolean isMessagesTopicDisplayingProperly(){
        return message.isMessagesTopicDisplayingProperly();
    }

    public static void getUsernamesOfUnreadUsers(){ //For testing purpose
         message.deleteMessage(message.getUsernamesOfUnreadUsers());
    }


//    public static void deleteMessage(){
//        message.deleteMessage();
//    }


//    deleteMessage();


}
