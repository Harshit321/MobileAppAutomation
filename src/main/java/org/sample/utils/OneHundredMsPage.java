package org.sample.utils;

import org.sample.utils.fileUtils.FileUtils;
import org.sample.utils.locatorutils.MobilePage;
import org.sample.utils.locatorutils.MobilePageFactory;
import org.sample.utils.logger.LoggerUtil;

import java.io.File;

public class OneHundredMsPage {

    static final LoggerUtil LOGGER = new LoggerUtil(OneHundredMsPage.class);

    private final static String LOCATORS_DIR = System.getProperty("user.dir") +
            File.separator + "src/test/resources/locators";

    private MobilePage page;

    public OneHundredMsPage() {
        page = MobilePageFactory.getPage(FileUtils.loadFile(getLocatorsFilePath()));
    }

    protected String getLocatorsFilePath() {
        return LOCATORS_DIR + File.separator + getLocatorFileName();
    }

    protected String getLocatorFileName() {
        String className = this.getClass().getSimpleName().toLowerCase();
        return className.substring(0, className.length() - 4) + "page.yaml";
    }


    public void click(String... keys) {
        ElementActionUtils.click(page.getLocator(keys));
    }

    public void setText(String text, String... keys) {
        ElementActionUtils.setText(page.getLocator(keys), text);
    }

    public String getText(String... keys) {
        return ElementActionUtils.getText(page.getLocator(keys));
    }


}
