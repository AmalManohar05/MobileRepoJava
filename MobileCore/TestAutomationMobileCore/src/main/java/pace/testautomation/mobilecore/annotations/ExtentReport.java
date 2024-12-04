package pace.testautomation.mobilecore.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Extent report annotation interface.
 * 
 * <pre>
 * How to use :
 * {@code
 * Step 1: Add ExtentReportListener to the TestClass
 * Step 2: Add @ExtentReport annotation to the TestClass
 * }
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExtentReport {

}
