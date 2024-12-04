package pace.testautomation.mobilecore.driverfactory;

import pace.testautomation.mobilecore.driverinitializer.AndroidDriverInitializer;
import pace.testautomation.mobilecore.driverinitializer.DriverInitializer;

public class AndroidDriverFactory implements DriverManagerFactory {

	@Override
	public DriverInitializer getDriver() {
		return new AndroidDriverInitializer();
	}
}
