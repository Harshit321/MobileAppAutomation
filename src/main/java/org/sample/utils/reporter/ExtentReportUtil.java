package org.sample.utils.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.sample.utils.DateHelper;
import org.sample.utils.logger.LoggerUtil;
import org.testng.ITestResult;

import java.io.File;

public class ExtentReportUtil {

    static LoggerUtil LOGGER = new LoggerUtil(ExtentReportUtil.class);

    public static ExtentTest test;

    private static ExtentSparkReporter extentReporter;

    private static ExtentReports extent;

    private ExtentReportUtil() {
    }

    public static String startReporter(String reportName, Theme theme) {
        extentReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + File.separator + "target" +
                        File.separator + "reports" + File.separator + reportName + "_" +
                        DateHelper.getCurrentTimeAsString() + ".html"
        );
        extent = new ExtentReports();
        extent.attachReporter(extentReporter);
        // Writing system info into report file
        extentReporter.config().setDocumentTitle(reportName);
        extentReporter.config().setReportName(reportName);
        extentReporter.config().setTheme(theme);
        extentReporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
        return extentReporter.getFile().getAbsolutePath();
    }

    public static void startTest(String test_description) {
        LOGGER.info(test_description);
        test = extent.createTest(test_description);
    }

    public static void logStepInfo(String step_info) {
        LOGGER.info(step_info);
        try {
            test.log(Status.INFO, step_info);
        } catch (Exception e) {
            LOGGER.error("Test Status not found! Check if assertion is in Test Class only " + e);
        }
    }

    public static void logTestFailure(ITestResult result) {
        test.log(Status.FAIL, MarkupHelper.createLabel(
                result.getName() + " - Test Case Failed", ExtentColor.RED));
    }

    public static void logTestSuccess(ITestResult result) {
        test.log(Status.PASS, MarkupHelper.createLabel(
                result.getName() + " - Test Case Passed", ExtentColor.GREEN));
    }

    public static void logTestSkipped(ITestResult result) {
        test.log(Status.SKIP, MarkupHelper.createLabel(
                result.getName() + " - Test Case Skipped", ExtentColor.YELLOW));
    }

    public static void writeTestResultsToFile() {
        extent.flush();
    }

}
