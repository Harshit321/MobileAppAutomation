package org.sample.listeners;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.sample.utils.reporter.ExtentReportUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class AppiumListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportUtil.startTest(result.getName() + "-" +
                result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportUtil.logTestSuccess(result);
//        ExtentReportUtil.startTest("Test Passed: " + result.getTestName() + "-" +
//                result.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportUtil.logTestFailure(result);
//        ExtentReportUtil.startTest("Test Failed: " + result.getTestName() + "-" +
//                result.getMethod().getDescription());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportUtil.logTestSkipped(result);
//        ExtentReportUtil.startTest("Test Skipped: " + result.getTestName() + "-" +
//                result.getMethod().getDescription());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReportUtil.startReporter("APP-TEST-AUTOMATION-REPORT", Theme.DARK);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportUtil.writeTestResultsToFile();
    }
}
