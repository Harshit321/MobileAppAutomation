package org.sample.pages;

import org.sample.utils.OneHundredMsPage;
import org.sample.utils.logger.LoggerUtil;

public class LaunchPage extends OneHundredMsPage {
    static final LoggerUtil LOGGER = new LoggerUtil(LaunchPage.class);

    public void setJoiningLinkTextBox() {
        LOGGER.info("In LaunchPage -> In method -> setJoiningLinkTextBox");
        String joiningUrl = "https://demo-hms-michaelmagic.app.100ms.live/meeting/vaf-mutx-qwl";
        setText(joiningUrl, "joiningLinkTextBox");
        click("joinNowBtn");
    }


}
