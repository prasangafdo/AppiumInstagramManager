package com.instagram.android.module;

import com.instagram.android.page.LandingPage;

public class ProfileManagementModule {
    private static final LandingPage landing = new LandingPage();

    public static void navigateToProfile(){
        landing.clickOnProfileButton();
    }

}
