import com.instagram.android.module.ProfileManagementModule;
import com.instagram.android.page.CommonPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestRunner {

    @Test
    public void navigateToFollowingList()  {
        SoftAssert softAssert = new SoftAssert();
        CommonPage commonPage = new CommonPage(); //Will update this later
        commonPage.setupDriver();
        ProfileManagementModule.navigateToProfile();
        ProfileManagementModule.navigateToFollowingList();
        softAssert.assertTrue(ProfileManagementModule.isLeastInteractedLabelDisplaying());
        ProfileManagementModule.scrollToTheEnd();
        ProfileManagementModule.scrollToTheTop();
        ProfileManagementModule.gatherFollowingUsers();
        ProfileManagementModule.navigateToProfile();
        ProfileManagementModule.navigateToFollowersList();
        softAssert.assertTrue(ProfileManagementModule.isRemoveButtonDisplaying());
        ProfileManagementModule.scrollToTheEndOfFollowingList();
        ProfileManagementModule.scrollToTheTop();
        ProfileManagementModule.gatherFollowers();//Not working. Needs separate method
//        softAssert.assertTrue(ProfileManagementModule.isSuggestionTopicDisplaying());
        softAssert.assertAll();
    }

    //add more test scenarios
}
