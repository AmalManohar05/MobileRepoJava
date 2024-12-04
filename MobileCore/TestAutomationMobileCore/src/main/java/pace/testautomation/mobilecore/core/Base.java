package pace.testautomation.mobilecore.core;

import java.util.Properties;

import io.appium.java_client.AppiumDriver;
import pace.testautomation.mobilecore.driverfactory.AndroidDriverFactory;
import pace.testautomation.mobilecore.driverfactory.IosDriverFactory;

public class Base {
	public AppiumDriver driver;
	Properties properties;

	/**
	 * Sets up the driver
	 */
	public void driverSetup() {

		try {
			driver = System.getProperty("deviceType").equals("android")
					? new AndroidDriverFactory().getDriver().initializeDriver()
					: new IosDriverFactory().getDriver().initializeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}