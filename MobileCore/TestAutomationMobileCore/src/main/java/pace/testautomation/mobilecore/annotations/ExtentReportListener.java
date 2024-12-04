package pace.testautomation.mobilecore.annotations;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pace.testautomation.mobilecore.utilities.ExtentReportHelpers;

public class ExtentReportListener implements ITestListener {

	private boolean isReportNeeded = false;

	public ExtentReportListener() {
		ExtentReportHelpers.initializeExtentReports();
	}

	/**
	 * @author PACE Team
	 */
	@Override
	public void onTestStart(ITestResult result) {

		Class<?> testClass = result.getTestClass().getRealClass();
		ExtentReport extentReportAnnotation = testClass.getAnnotation(ExtentReport.class);
		isReportNeeded = extentReportAnnotation != null;

		if (isReportNeeded) {
			ExtentReportHelpers.createTest(result);
		}
	}

	/**
	 * @author PACE Team
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		if (isReportNeeded) {
			ExtentReportHelpers.logTestEnd(result);
		}
	}

	/**
	 * @author PACE Team
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		if (isReportNeeded) {
			ExtentReportHelpers.logTestEnd(result);
		}
	}

	/**
	 * @author PACE Team
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		if (isReportNeeded) {
			ExtentReportHelpers.logTestEnd(result);
		}
	}

	/**
	 * @author PACE Team
	 */
	@Override
	public void onFinish(ITestContext context) {
		if (isReportNeeded) {
			ExtentReportHelpers.generateReport();
		}
	}
}