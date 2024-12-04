package pace.testautomation.mobilecore.driverfactory;

import pace.testautomation.mobilecore.driverinitializer.DriverInitializer;
import pace.testautomation.mobilecore.driverinitializer.IosDriverInitializer;

public class IosDriverFactory implements DriverManagerFactory {
	@Override
	public DriverInitializer getDriver() {
		return new IosDriverInitializer();
	}

}
