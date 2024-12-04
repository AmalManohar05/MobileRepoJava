package pace.testautomation.mobilecore.core;

import java.io.File;
import java.net.InetAddress;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ServiceBuilder {
	/**
	 * Constructs an appium service instance based on properties loaded from the pom file. 
	 * Appium service builder is initialized with the path to the
	 * Appium server executable (main.js) This will be automatically overwritten in
	 * case of cloud executions based on the cloud configurations
	 * 
	 * @return Appium service instance configured with the specified properties.
	 * @throws Exception If there is an error loading properties or configuring the
	 *                   Appium service.
	 */
	public AppiumDriverLocalService buildAppiumService() throws Exception {
		return new AppiumServiceBuilder()
				.withAppiumJS(new File(System.getProperty("user.home") + File.separator
						+ "AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress(InetAddress.getLocalHost().getHostAddress())
				.usingPort(Integer.valueOf(System.getProperty("appiumPort"))).build();
	}
}
