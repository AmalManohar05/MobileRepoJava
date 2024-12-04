package pace.testautomation.mobilecore.driverinitializer;

import java.net.InetAddress;
import java.net.URI;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pace.testautomation.apicore.methods.BrowserStackService;

public class AndroidDriverInitializer implements DriverInitializer {
	AppiumDriver driver;

	@Override
	public AppiumDriver initializeDriver() {

		UiAutomator2Options options = new UiAutomator2Options();
		try {
			if (System.getProperty("testEnvironment").equalsIgnoreCase("local")) {
				options.setDeviceName(System.getProperty("localDeviceName"));
				options.setApp(System.getProperty("user.dir") + System.getProperty("filePath"));
				options.setNewCommandTimeout(Duration.ofSeconds(180));
				options.setAppWaitDuration(Duration.ofSeconds(60));
				driver = new AndroidDriver(new URI("http://" + InetAddress.getLocalHost().getHostAddress() + ":"
						+ System.getProperty("appiumPort")).toURL(), options);
			} else {
				options.setPlatformName(System.getProperty("deviceType"));
				options.setNewCommandTimeout(Duration.ofSeconds(180));
				options.setCapability("appium:platformVersion", "12.0");
				options.setCapability("appium:deviceName", System.getProperty("cloudDeviceName"));
				options.setCapability("appium:app", BrowserStackService.browserStackUploadAppUsingApi());
				options.setCapability("automationName", "UiAutomator2");
				options.setCapability("build", System.getProperty("BuildName") + DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDate.now()));
				options.setCapability("name", System.getProperty("SessionName"));
				options.setCapability("browserstackLocal", true);
				options.setCapability("browserstack.debug", true);
				options.setCapability("browserstack.console", "verbose");
				options.setCapability("browserstack.networkLogs", true);
				driver = new AndroidDriver(new URI(String.format("https://%s:%s@hub.browserstack.com/wd/hub", System.getProperty("bsUserName"), System.getProperty("bsPassword"))).toURL(), options);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}