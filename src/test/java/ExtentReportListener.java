import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test;
    private static ExtentSparkReporter sparkReporter;


    @Override
    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/api-testing.html");
        sparkReporter.config().setReportName("API Testing");
        sparkReporter.config().setDocumentTitle("API Testing Report");
        extent.attachReporter(sparkReporter);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        try {
            Desktop.getDesktop().browse(new File("test-output/api-testing.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        test.assignCategory(result.getInstance().getClass().getSimpleName());
        test.log(Status.INFO, "Waktu Eksekusi : " + new Date());
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Case Passed is " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Case Failed is " + result.getName());
        test.log(Status.FAIL, "Test Case Failed Error is " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
    }
}
