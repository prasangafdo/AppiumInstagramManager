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
        ProfileManagementModule.gatherElements();
        ProfileManagementModule.navigateToProfile();
        ProfileManagementModule.navigateToFollowersList();

//        softAssert.assertTrue(ProfileManagementModule.isSuggestionTopicDisplaying());
        softAssert.assertAll();
    }
}
