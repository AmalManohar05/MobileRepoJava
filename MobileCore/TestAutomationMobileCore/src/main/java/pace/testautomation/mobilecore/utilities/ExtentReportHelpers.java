package pace.testautomation.mobilecore.utilities;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import pace.testautomation.mobilecore.core.Base;

public class ExtentReportHelpers {
	private static ExtentReports extent = null;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static List<String> lastStackTrace;

	static {
		lastStackTrace = new ArrayList<String>();
	}

	/**
	 * Initialize a new extent report instance if not initialized before.
	 */
	public static void initializeExtentReports() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		String timestamp = dtf.format(now);
		String reportName = System.getProperty("extentReportName") != null ? System.getProperty("extentReportName")
				: "ExtentReport";
		if (extent == null) {
			var htmlReporter = new ExtentSparkReporter("extentReports//" + reportName + "_" + timestamp + ".html");
			htmlReporter.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Author", "PACE");
		}
	}

	/**
	 * Create a new test and add it to the extent report
	 */
	public static void createTest(ITestResult result) {
		Method method = result.getMethod().getConstructorOrMethod().getMethod();
		Test currentTest = method.getAnnotation(Test.class);
		String testName = "Default Test";
		String desc = "Not Applicable";
		List<String> categories = null;
		if (currentTest != null) {
			testName = currentTest.testName().equals("") ? testName : currentTest.testName();
			desc = currentTest.description().equals("") ? desc : currentTest.description();
			if (currentTest.groups().length > 0)
				categories = Arrays.asList(currentTest.groups());
		}

		ExtentTest _test = extent.createTest(testName, desc);
		if (categories != null) {
			for (String category : categories) {
				_test.assignCategory(category);
			}
		}
		test.set(_test);
	}

	/**
	 * Log the test result at the end of test execution
	 */
	public static void logTestEnd(ITestResult result) {
		AppiumDriver driver = null;
		Object currentClass = result.getInstance();
		if (currentClass instanceof Base) {
			Base testInit = (Base) currentClass;
			driver = testInit.driver;
		}
		switch (result.getStatus()) {
		case ITestResult.FAILURE:
			if (lastStackTrace.contains(getStackTrace(result.getThrowable())))
				break;
			test.get().fail("Test Status: FAILED !!");
			if (driver != null) {
				test.get().fail("Failed Url : " + driver.getCurrentUrl());
				test.get().fail(screenShotsCaptureAndReturnModel(driver, result));
			}
			test.get().fail("Failure Message : " + result.getThrowable().getLocalizedMessage());
			test.get().fail("Stack Trace : " + getStackTrace(result.getThrowable()));
			break;
		case ITestResult.SKIP:
			test.get().skip("Test Status: SKIPPED");
			test.get().skip("Reason To Skip : " + result.getThrowable().getLocalizedMessage());
			break;
		case ITestResult.SUCCESS:
			test.get().pass("Test Status: PASSED");
			break;
		default:
			test.get().warning("Unhandled test status: " + result.getStatus());
			break;
		}
	}

	/**
	 * Log the test result at the end of each verify method if verify fails
	 */
	public static void logTestAtVerify(Throwable assertionError, String message, AppiumDriver driver) {
		if (extent == null)
			return;
		ITestResult result = Reporter.getCurrentTestResult();
		result.setStatus(ITestResult.FAILURE);
		result.setThrowable(assertionError);
		test.get().fail("Test Status: Test Failed at VERIFY");
		if (driver != null) {
			test.get().fail("Failed Url : " + driver.getCurrentUrl());
			test.get().fail(screenShotsCaptureAndReturnModel(driver, result));
		}
		test.get().fail("Failure Message : " + message);
		test.get().fail("Stack Trace : " + getStackTrace(result.getThrowable()));
		lastStackTrace.add(getStackTrace(result.getThrowable()));
	}

	/**
	 * Log the message to the extent report *
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ExtentReportHelpers.log("Enter the login username as 'Admin'");
	 * 
	 * ExtentReportHelpers.log("Enter the login password as 'admin123'");
	 * }
	 * </pre>
	 */
	public static void log(String message) {
		if (extent == null)
			return;
		String isExtentLoggerEnabled = System.getProperty("isExtentLoggerEnabled");
		if (isExtentLoggerEnabled != null && isExtentLoggerEnabled.equals("true")) {
			test.get().info(message);
		}

	}

	/**
	 * Generate the html report
	 */
	public static void generateReport() {
		extent.flush();
	}

	private static Media screenShotsCaptureAndReturnModel(AppiumDriver driver, ITestResult result) {
		String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot,
				result.getMethod().getMethodName() + "_FailedScreenshot").build();
	}

	private static String getStackTrace(Throwable throwable) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		throwable.printStackTrace(pw);
		return sw.toString();
	}
}
