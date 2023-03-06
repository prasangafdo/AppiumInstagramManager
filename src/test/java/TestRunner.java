import com.instagram.android.page.CommonPage;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestRunner {

    @Test
    public void initiateDriver() throws MalformedURLException {
        CommonPage commonPage = new CommonPage();
        commonPage.setupDriver();
    }
}
