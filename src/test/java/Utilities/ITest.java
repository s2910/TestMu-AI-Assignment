package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ITest implements ITestListener {
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;

    public void configureReport(){
        htmlReporter = new ExtentSparkReporter("ExtentListenerReportDemo.html");
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);



        reports.setSystemInfo("Machine", "Sewank PC");
        reports.setSystemInfo("OS","Windows11");


        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("Amazon Test Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestStart(ITestResult result){

    }

    public void onTestSuccess(ITestResult result){
        System.out.println("Name of the test method successfully executed "+result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the Passed test case is: "+result.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Name of test method failed:"+result.getName());
        test=reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the Failed test case is: "+result.getName(),ExtentColor.RED));

        String screenShotPath= System.getProperty("user.dir") +"\\Screenshots\\" + result.getName() + ".png";

        File screenShotFile = new File(screenShotPath);

        if(screenShotFile.exists())
        {
            test.fail("Captured Screenshot is below:" +test.addScreenCaptureFromPath(screenShotPath));
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Name of test method skipped "+result.getName());
        test=reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped test case is: "+result.getName(),ExtentColor.YELLOW));
    }


    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }


    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }


    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("On start method invoked.....");
    }


    public void onFinish(ITestContext context) {
        System.out.println("On Finished method invoked.....");
        reports.flush();
    }
}
