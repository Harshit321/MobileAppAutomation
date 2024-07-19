package org.sample.app.tests.homepage;

import org.sample.app.tests.testbase.BaseTest;
import org.sample.pages.LaunchPage;
import org.sample.utils.logger.LoggerUtil;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    LoggerUtil LOGGER = new LoggerUtil(HomePageTest.class);

    @Test(description = "Verify Mobile Icon On HomePage")
    public void verifyMobileIconOnHomePage() {
        LOGGER.info("In HomePageTest -> In Test -> verifyMobileIconOnHomePage");
        new LaunchPage().setJoiningLinkTextBox();
    }


}
