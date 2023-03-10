import com.instagram.android.module.ProfileManagementModule;
import com.instagram.android.page.CommonPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TestRunner {

    @Test
    public void navigateToFollowingList() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        CommonPage commonPage = new CommonPage(); //Will update this later
        commonPage.setupDriver();
        ProfileManagementModule.navigateToProfile();
        ProfileManagementModule.navigateToFollowingList();
        softAssert.assertTrue(ProfileManagementModule.isLeastInteractedLabelDisplaying());
        ProfileManagementModule.scrollToTheEnd();

//        ProfileManagementModule.scrollTillLoadMoreButtonDisplays();
//        softAssert.assertTrue(ProfileManagementModule.isSuggestionTopicDisplaying());
        softAssert.assertAll();
    }
}
