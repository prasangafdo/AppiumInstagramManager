package com.instagram.android.module;

import com.instagram.android.page.MessagesPage;

public class ChatModule {

    private static final MessagesPage message = new MessagesPage();

    public static void navigateToMessages(){
        message.clickOnMessagesButton();
    }

    public static boolean isMessagesTopicDisplayingProperly(){
        return message.isMessagesTopicDisplayingProperly(); //convert to boolean
    }

    public static void deleteMessage(){
        message.deleteMessage();
    }


//    deleteMessage();


}
