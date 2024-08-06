package testScript;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.ExcelUtils;

import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import reusableFunction.CommonFunction;
//import utility.ExcelUtils;

public class firstTestNG {

	WebDriver driver;

	ExtentSparkReporter extentSparkReporter;
	   ExtentReports extentReports;
	   ExtentTest extentTest;
	   
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
	       extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
	       


	       //configuration items to change the look and feel
	       //add content, manage tests etc
	       extentSparkReporter.config().setDocumentTitle("Linenchest Automation Report");
	       extentSparkReporter.config().setReportName("Regression Test Report");
	       extentSparkReporter.config().setTheme(Theme.STANDARD);
	       extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	       extentReports = new ExtentReports();
	       extentReports.attachReporter(extentSparkReporter);
	       CommonFunction.OpenBrowser();
	}


	@Test(dataProvider = "dp")
	public void UserLogin(String sUsername, String sPassword)throws Exception {
		extentTest = extentReports.createTest("Test Case 1", "This test case has passed");
		CommonFunction.Login(sUsername, sPassword);
		String methodName = new Exception().getStackTrace()[0].getMethodName();
		 extentTest = extentReports.createTest(methodName,"single_input_test");
	       extentTest.log(Status.PASS,"Starting test to verify single input");

	}

	@AfterMethod
	public void afterMethod() {
		CommonFunction.CloseBrowser();
		 extentReports.flush();
	}


	@DataProvider
	public Object[][] dp() throws Exception{

		Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\assar\\Documents\\Selenium\\LinenchestLogin.xlsx","LoginDetails",1);

		return (testObjArray);

	}

}
