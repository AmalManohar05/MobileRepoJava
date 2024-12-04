package pace.testautomation.mobilecore.extensions;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Supplier;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import pace.testautomation.mobilecore.utilities.Locator;

public class AppiumDriverExtensions {

	/**
	 * Wait for text to be present in element value
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForTextToBePresentInElementValue(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForTextToBePresentInElementValue(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The element who's value attribute is being checked
	 * @param text    : The text to be present in the value attribute
	 */
	public static void waitForTextToBePresentInElementValue(AppiumDriver driver, WebElement element, String text,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}

	/**
	 * Wait for text to be present in element value
	 * 
	 * <pre>
	 * How to use :
	 *{@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForTextToBePresentInElementValue(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForTextToBePresentInElementValue(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier for the element who's value attribute is being
	 *                checked
	 * @param text    : The text to be present in the value attribute
	 */
	public static void waitForTextToBePresentInElementValue(AppiumDriver driver, Supplier<WebElement> element,
			String text, Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		wait.until(ExpectedConditions.textToBePresentInElementValue(element.get(), text));
	}

	/**
	 * Wait for staleness of element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForStalenessOf(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForStalenessOf(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The element who's staleness is being checked
	 */
	public static void waitForStalenessOf(AppiumDriver driver, WebElement element, Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	/**
	 * Wait for staleness of element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForStalenessOf(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForStalenessOf(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier of the element who's staleness is being checked
	 */
	public static void waitForStalenessOf(AppiumDriver driver, Supplier<WebElement> element,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		wait.until(ExpectedConditions.stalenessOf(element.get()));
	}

	/**
	 * To get the page source of the last loaded page
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * String pageSource = AppiumDriverExtensions.getPageSource(driver);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 * @return Page source details as string
	 */
	public static String getPageSource(AppiumDriver driver) {
		return driver.getPageSource();
	}

	/**
	 * Wait for text to be present in element value
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForTextToBePresentInElementValue(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForTextToBePresentInElementValue(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The string locator value of the element who's value
	 *                    attribute is being checked
	 * @param text        : The text to be present in the value attribute
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForTextToBePresentInElementValue(AppiumDriver driver, String element, String text,
			Enum<?> locatorType, Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath(element), text));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.id(element), text));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(AppiumBy.accessibilityId(element), text));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.name(element), text));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.className(element), text));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.cssSelector(element), text));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.linkText(element), text));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.partialLinkText(element), text));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.tagName(element), text));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Wait for text to be present in element value
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForTextToBePresentInElementValue(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForTextToBePresentInElementValue(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The supplier of the string locator value for the element
	 *                    who's value attribute is being checked
	 * @param text        : The text to be present in the element's value attribute
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForTextToBePresentInElementValue(AppiumDriver driver, Supplier<String> element, String text,
			Enum<?> locatorType, Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath(element.get()), text));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.id(element.get()), text));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(AppiumBy.accessibilityId(element.get()), text));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.name(element.get()), text));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.className(element.get()), text));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.cssSelector(element.get()), text));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.linkText(element.get()), text));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.partialLinkText(element.get()), text));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.textToBePresentInElementValue(By.tagName(element.get()), text));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Wait for frame to be available and switch to it
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForFrameToBeAvailableAndSwitchToIt(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForFrameToBeAvailableAndSwitchToIt(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The string locator value for the frame element
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForFrameToBeAvailableAndSwitchToIt(AppiumDriver driver, String element, Enum<?> locatorType,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(element)));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(element)));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(AppiumBy.accessibilityId(element)));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(element)));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className(element)));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(element)));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.linkText(element)));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.partialLinkText(element)));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName(element)));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Execution wait for an element to be present for up to a particular duration
	 * and throws exception.
	 * 
	 * <pre>
	* {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForElement(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForElement(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The string locator value for the element who's presence
	 *                    is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForElement(AppiumDriver driver, String element, Enum<?> locatorType,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(element)));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(element)));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(element)));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element)));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(element)));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(element)));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(element)));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Execution wait for an element to be present for up to a particular duration
	 * and throws exception.
	 * 
	 * <pre>
	 * How to use :
	* {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForElement(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForElement(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The supplier of the string locator value for the element
	 *                    who's presence is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForElement(AppiumDriver driver, Supplier<String> element, Enum<?> locatorType,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(element.get())));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Wait until element to be click for a particular duration
	 * 
	 * <pre>
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForElementClickable(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForElementClickable(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The element who's enabled state is being checked
	 */
	public static void waitForElementClickable(AppiumDriver driver, WebElement element, Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Wait until element to be click for a particular duration
	 * 
	 * <pre>
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForElementClickable(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForElementClickable(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier of the element who's enabled state is being
	 *                checked
	 */
	public static void waitForElementClickable(AppiumDriver driver, Supplier<WebElement> element,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element.get()));
		} catch (Exception e) {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Wait until element to be click for a particular duration
	 * 
	 * <pre>
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForElementClickable(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForElementClickable(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The string locator value for the element who's enabled
	 *                    state is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForElementClickable(AppiumDriver driver, String element, Enum<?> locatorType,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(element)));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(element)));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.className(element)));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(element)));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(element)));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(element)));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Wait until element to be click for a particular duration
	 * 
	 * <pre>
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForElementClickable(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForElementClickable(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The supplier of the string locator value for the element
	 *                    who's enabled state is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForElementClickable(AppiumDriver driver, Supplier<String> element, Enum<?> locatorType,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.id(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.name(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.className(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.elementToBeClickable(By.tagName(element.get())));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Wait until element to be visible for a particular duration
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForElementIsVisible(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForElementIsVisible(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The string locator value for the element who's
	 *                    visibility is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForElementIsVisible(AppiumDriver driver, String element, Enum<?> locatorType,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(element)));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element)));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element)));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element)));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(element)));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Wait until element to be visible for a particular duration
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForElementIsVisible(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForElementIsVisible(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The supplier of the string locator value for the element
	 *                    who's visibility is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForElementIsVisible(AppiumDriver driver, Supplier<String> element, Enum<?> locatorType,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(element.get())));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Wait until element to be invisible for a particular duration
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForElementInvisible(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForElementInvisible(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The string locator value for the element who's
	 *                    invisibility is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForElementInvisible(AppiumDriver driver, String element, Enum<?> locatorType,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(element)));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(AppiumBy.accessibilityId(element)));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(element)));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(element)));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(element)));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(element)));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText(element)));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(element)));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Wait until element to be Invisible for a particular duration using web
	 * element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.waitForElementInvisible(driver, LoginUsernameTextbox, "user@test.in");
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.waitForElementInvisible(driver, LoginUsernameTextbox, "user@test.in", Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The supplier of the string locator value for the element
	 *                    who's invisibility is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 */
	public static void waitForElementInvisible(AppiumDriver driver, Supplier<String> element, Enum<?> locatorType,
			Duration... customDuration) {
		WebDriverWait wait = new WebDriverWait(driver,
				customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(AppiumBy.accessibilityId(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.partialLinkText(element.get())));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName(element.get())));
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Sets the implicit wait timeout for the driver instance
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * To use with default wait duration, i.e, 60 seconds
	 * AppiumDriverExtensions.implicitlyWait(driver);
	 * 
	 * To use with custom wait duration, for eg, 90 seconds
	 * AppiumDriverExtensions.implicitlyWait(driver, Duration.ofSeconds(90));
	 * }
	 * </pre>
	 * 
	 * @param driver         : The instance of AppiumDriver on which the implicit
	 *                       wait timeout is applied.
	 * @param customDuration :Optional custom duration to override the default
	 *                       implicit wait timeout.
	 */
	public static void implicitlyWait(AppiumDriver driver, Duration... customDuration) {
		driver.manage().timeouts()
				.implicitlyWait(customDuration.length == 0 ? Duration.ofSeconds(60) : customDuration[0]);
	}

	/**
	 * Check the element exist in the DOM.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.isElementExists(driver, _loginButtonLocator, Locator.LocatorType.Xpath);
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The string locator value for the element who's presence
	 *                    is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 * @return Whether or not the element is present in the DOM (true/false)
	 */
	public static boolean isElementExists(AppiumDriver driver, String element, Enum<?> locatorType) {
		try {
			if (locatorType.equals(Locator.LocatorType.Xpath)) {
				driver.findElement(By.xpath((element)));
			} else if (locatorType.equals(Locator.LocatorType.Id)) {
				driver.findElement(By.id((element)));
			} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
				driver.findElement(AppiumBy.accessibilityId(element));
			} else if (locatorType.equals(Locator.LocatorType.Name)) {
				driver.findElement(By.name((element)));
			} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
				driver.findElement(By.className((element)));
			} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
				driver.findElement(By.cssSelector((element)));
			} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
				driver.findElement(By.linkText((element)));
			} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
				driver.findElement(By.partialLinkText((element)));
			} else if (locatorType.equals(Locator.LocatorType.TagName)) {
				driver.findElement(By.tagName((element)));
			} else {
				throw new NoSuchElementException();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check the element exist in the DOM.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.isElementExists(driver, _loginButtonLocator, Locator.LocatorType.Xpath);
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The supplier of the string locator value for the element
	 *                    who's presence is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 * @return Whether or not the element is present in the DOM (true/false)
	 */
	public static boolean isElementExists(AppiumDriver driver, Supplier<String> element, Enum<?> locatorType) {
		try {
			if (locatorType.equals(Locator.LocatorType.Xpath)) {
				driver.findElement(By.xpath((element.get())));
			} else if (locatorType.equals(Locator.LocatorType.Id)) {
				driver.findElement(By.id((element.get())));
			} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
				driver.findElement(AppiumBy.accessibilityId(element.get()));
			} else if (locatorType.equals(Locator.LocatorType.Name)) {
				driver.findElement(By.name((element.get())));
			} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
				driver.findElement(By.className((element.get())));
			} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
				driver.findElement(By.cssSelector((element.get())));
			} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
				driver.findElement(By.linkText((element.get())));
			} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
				driver.findElement(By.partialLinkText((element.get())));
			} else if (locatorType.equals(Locator.LocatorType.TagName)) {
				driver.findElement(By.tagName((element.get())));
			} else {
				throw new NoSuchElementException();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Check the element displayed in UI.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.isElementDisplayed(driver, _loginButtonLocator, Locator.LocatorType.Xpath);
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The string locator value for the element who's
	 *                    visibility is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 * @return Whether or not the element is displayed in the UI (true/false)
	 */
	public static boolean isElementDisplayed(AppiumDriver driver, String element, Enum<?> locatorType) {
		boolean isDisplayed = false;
		try {
			if (locatorType.equals(Locator.LocatorType.Xpath)) {
				isDisplayed = driver.findElement(By.xpath((element))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.Id)) {
				isDisplayed = driver.findElement(By.id((element))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
				isDisplayed = driver.findElement(AppiumBy.accessibilityId(element)).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.Name)) {
				isDisplayed = driver.findElement(By.name((element))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
				isDisplayed = driver.findElement(By.className((element))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
				isDisplayed = driver.findElement(By.cssSelector((element))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
				isDisplayed = driver.findElement(By.linkText((element))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
				isDisplayed = driver.findElement(By.partialLinkText((element))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.TagName)) {
				isDisplayed = driver.findElement(By.tagName((element))).isDisplayed();
			} else {
				throw new NoSuchElementException();
			}
			return isDisplayed;
		} catch (Exception e) {
			return isDisplayed;
		}
	}

	/**
	 * Check the element displayed in UI.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.isElementDisplayed(driver, _loginButtonLocator, Locator.LocatorType.Xpath);
	 * }
	 * </pre>
	 * 
	 * @param driver      : The current appium driver instance
	 * @param element     : The supplier of the string locator value for the element
	 *                    who's visibility is being checked
	 * @param locatorType : The locator type enum value for locating the element
	 * @return Whether or not the element is displayed in the UI (true/false)
	 */
	public static boolean isElementDisplayed(AppiumDriver driver, Supplier<String> element, Enum<?> locatorType) {
		boolean isDisplayed = false;
		try {
			if (locatorType.equals(Locator.LocatorType.Xpath)) {
				isDisplayed = driver.findElement(By.xpath((element.get()))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.Id)) {
				isDisplayed = driver.findElement(By.id((element.get()))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
				isDisplayed = driver.findElement(AppiumBy.accessibilityId(element.get())).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.Name)) {
				isDisplayed = driver.findElement(By.name((element.get()))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
				isDisplayed = driver.findElement(By.className((element.get()))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
				isDisplayed = driver.findElement(By.cssSelector((element.get()))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
				isDisplayed = driver.findElement(By.linkText((element.get()))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
				isDisplayed = driver.findElement(By.partialLinkText((element.get()))).isDisplayed();
			} else if (locatorType.equals(Locator.LocatorType.TagName)) {
				isDisplayed = driver.findElement(By.tagName((element.get()))).isDisplayed();
			} else {
				throw new NoSuchElementException();
			}
			return isDisplayed;
		} catch (Exception e) {
			return isDisplayed;
		}
	}

	/**
	 * Drag and drop.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.dragAndDrop(driver, ImageElement, TrashBinElement);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 * @param source : The element to be moved
	 * @param target : The element to which the source element is moved
	 */
	public static void dragAndDrop(AppiumDriver driver, WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(source).moveToElement(target).dragAndDrop(source, target).build().perform();
	}

	/**
	 * Drag and drop.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.dragAndDrop(driver, ImageElement, TrashBinElement);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 * @param source : The supplier of the element to be moved
	 * @param target : The supplier of the element to which the source element is
	 *               moved
	 */
	public static void dragAndDrop(AppiumDriver driver, Supplier<WebElement> source, Supplier<WebElement> element) {
		Actions actions = new Actions(driver);
		actions.clickAndHold(source.get()).moveToElement(element.get()).dragAndDrop(source.get(), element.get()).build()
				.perform();
	}

	/**
	 * Drag and drop with offset
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.dragAndDrop(driver, ImageElement, 100, 150);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param source  : The element to be moved
	 * @param offsetX : The x coordinate distance to be moved
	 * @param offsetY : The y coordinate distance to be moved
	 */
	public static void dragAndDrop(AppiumDriver driver, WebElement source, int offsetX, int offsetY) {
		Actions actions = new Actions(driver);
		actions.click(source).moveByOffset(offsetX, offsetY).release().build().perform();
	}

	/**
	 * Drag and drop with offset
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.dragAndDrop(driver, ImageElement, 100, 150);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param source  : The supplier of the element to be moved
	 * @param offsetX : The x coordinate distance to be moved
	 * @param offsetY : The y coordinate distance to be moved
	 * 
	 * @author PACE Team
	 * @version 1.0.0
	 * @since 2023-03-01
	 */
	public static void dragAndDrop(AppiumDriver driver, Supplier<WebElement> source, int offsetX, int offsetY) {
		Actions actions = new Actions(driver);
		actions.click(source.get()).moveByOffset(offsetX, offsetY).release().build().perform();
	}

	/**
	 * Move to element and click using action class
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.moveToElementAndClick(driver, AddButton);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The element to be clicked
	 */
	public static void moveToElementAndClick(AppiumDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	/**
	 * Move to element and click using action class
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.moveToElementAndClick(driver, AddButton);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier of the element to be clicked
	 */
	public static void moveToElementAndClick(AppiumDriver driver, Supplier<WebElement> element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element.get()).click().perform();
	}

	/**
	 * Mouse Hover using action class
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.mouseHover(driver, AddButton);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The element to which mouse is hovered
	 */
	public static void mouseHover(AppiumDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	/**
	 * Mouse Hover using action class
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.mouseHover(driver, AddButton);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier of the element to which mouse is hovered
	 */
	public static void mouseHover(AppiumDriver driver, Supplier<WebElement> element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element.get()).perform();
	}

	/**
	 * Double Click using action class
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.doubleClick(driver, AcceptButton);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The element to be clicked
	 */
	public static void doubleClick(AppiumDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	/**
	 * Double Click using action class
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.doubleClick(driver, AcceptButton);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier of the element to be clicked
	 */
	public static void doubleClick(AppiumDriver driver, Supplier<WebElement> element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element.get()).perform();
	}

	/**
	 * Send keys using action class
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.sendKeysUsingActions(driver, LoginUsernameTextbox, "user@test.in");
	 * }
	 * </pre>
	 * 
	 * @param driver     : The current appium driver instance
	 * @param element    : The element to which keys are send
	 * @param keysToSend : Keys to be sent
	 */
	public static void sendKeysUsingActions(AppiumDriver driver, WebElement element, String keysToSend) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, keysToSend).perform();
	}

	/**
	 * Send keys using action class
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.sendKeysUsingActions(driver, LoginUsernameTextbox, "user@test.in");
	 * }
	 * </pre>
	 * 
	 * @param driver     : The current appium driver instance
	 * @param element    : The supplier of the element to which keys are send
	 * @param keysToSend : Keys to be sent
	 */
	public static void sendKeysUsingActions(AppiumDriver driver, Supplier<WebElement> element, String keysToSend) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element.get(), keysToSend).perform();
	}

	/**
	 * Locate the element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.locateElement(driver, _loginButtonLocator, Locator.LocatorType.Xpath);
	 * }
	 * </pre>
	 * 
	 * @param driver          : The current appium driver instance
	 * @param elementToLocate : The string locator value for the element to be
	 *                        located
	 * @param locatorType     : The locator type enum value for locating the element
	 * @return Webelement based on locator type
	 */
	public static WebElement locateElement(AppiumDriver driver, String elementToLocate, Enum<?> locatorType) {
		WebElement element = null;
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			element = driver.findElement(By.xpath((elementToLocate)));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			element = driver.findElement(By.id((elementToLocate)));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			element = driver.findElement(AppiumBy.accessibilityId(elementToLocate));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			element = driver.findElement(By.name((elementToLocate)));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			element = driver.findElement(By.linkText((elementToLocate)));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			element = driver.findElement(By.partialLinkText((elementToLocate)));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			element = driver.findElement(By.cssSelector((elementToLocate)));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			element = driver.findElement(By.className((elementToLocate)));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			element = driver.findElement(By.tagName((elementToLocate)));
		} else {
			throw new NoSuchElementException();
		}

		return element;
	}

	/**
	 * Locate the element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.locateElement(driver, _loginButtonLocator, Locator.LocatorType.Xpath);
	 * }
	 * </pre>
	 * 
	 * @param driver          : The current appium driver instance
	 * @param elementToLocate : The supplier of the string locator value for the
	 *                        element to be located
	 * @param locatorType     : The locator type enum value for locating the element
	 * @return Webelement based on locator type
	 */
	public static WebElement locateElement(AppiumDriver driver, Supplier<String> elementToLocate, Enum<?> locatorType) {
		WebElement element = null;
		if (locatorType.equals(Locator.LocatorType.Xpath)) {
			element = driver.findElement(By.xpath((elementToLocate.get())));
		} else if (locatorType.equals(Locator.LocatorType.Id)) {
			element = driver.findElement(By.id((elementToLocate.get())));
		} else if (locatorType.equals(Locator.LocatorType.AccessibilityId)) {
			element = driver.findElement(AppiumBy.accessibilityId(elementToLocate.get()));
		} else if (locatorType.equals(Locator.LocatorType.Name)) {
			element = driver.findElement(By.name((elementToLocate.get())));
		} else if (locatorType.equals(Locator.LocatorType.LinkText)) {
			element = driver.findElement(By.linkText((elementToLocate.get())));
		} else if (locatorType.equals(Locator.LocatorType.PartialLinkText)) {
			element = driver.findElement(By.partialLinkText((elementToLocate.get())));
		} else if (locatorType.equals(Locator.LocatorType.CssSelector)) {
			element = driver.findElement(By.cssSelector((elementToLocate.get())));
		} else if (locatorType.equals(Locator.LocatorType.ClassName)) {
			element = driver.findElement(By.className((elementToLocate.get())));
		} else if (locatorType.equals(Locator.LocatorType.TagName)) {
			element = driver.findElement(By.tagName((elementToLocate.get())));
		} else {
			throw new NoSuchElementException();
		}

		return element;
	}

	/**
	 * Get all elements in to a list.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.getAllElementsIntoList(driver, _tabHeaderLocator);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The string locator value for the elements
	 * @return List of web elements
	 */
	public static List<WebElement> getAllElementsIntoList(AppiumDriver driver, String element) {
		List<WebElement> webElements = driver.findElements(By.xpath(element));
		return webElements;
	}

	/**
	 * Get all elements in to a list.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.getAllElementsIntoList(driver, _tabHeaderLocator);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier of the string locator value for the elements
	 * @return List of web elements
	 */
	public static List<WebElement> getAllElementsIntoList(AppiumDriver driver, Supplier<String> element) {
		List<WebElement> webElements = driver.findElements(By.xpath(element.get()));
		return webElements;
	}

	/**
	 * Checks whether horizontal scroll is present.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.isHorizonalScrollPresent(driver);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 * @return Whether or not horizontal scroll bar is present in the page
	 *         (true/false)
	 */
	public static boolean isHorizonalScrollPresent(AppiumDriver driver) {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		boolean scrollStatus = (Boolean) javascript
				.executeScript("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
		return scrollStatus;
	}

	/**
	 * Checks whether vertical scroll is present.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.isVerticalScrollPresent(driver);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 * @return Whether or not vertical scroll bar is present in the page
	 *         (true/false)
	 */
	public static boolean isVerticalScrollPresent(AppiumDriver driver) {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		boolean scrollStatus = (Boolean) javascript
				.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
		return scrollStatus;
	}

	/**
	 * Scroll to element using javascript.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.javascriptScrollIntoWebelementView(driver, contactInfoLink);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The element to which scroll is needed
	 */
	public static void javascriptScrollIntoWebelementView(AppiumDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Scroll to element using javascript.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.javascriptScrollIntoWebelementView(driver, contactInfoLink);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier of the element to which scroll is needed
	 */
	public static void javascriptScrollIntoWebelementView(AppiumDriver driver, Supplier<WebElement> element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element.get());
	}

	/**
	 * Scroll to the top of the page.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.scrollToTop(driver);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 */
	public static void scrollToTop(AppiumDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollLeft, 0)");
	}

	/**
	 * Scrolls to the bottom of the page.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.scrollToBottom(driver);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 */
	public static void scrollToBottom(AppiumDriver driver) {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollTo(document.body.scrollLeft, document.body.scrollHeight)");
	}

	/**
	 * Scrolls to the bottom of the page.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.scrollToBottom(driver, 500);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 * @param y      : y co-ordinate value to scroll down
	 */
	public static void scrollToBottom(AppiumDriver driver, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollLeft, " + y + ")");
	}

	/**
	 * Scrolls to the left end of the page.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.scrollToLeft(driver);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 */
	public static void scrollToLeft(AppiumDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollTop)");
	}

	/**
	 * Scrolls to the right end of the page
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.scrollToRight(driver);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 */
	public static void scrollToRight(AppiumDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollWidth, document.body.scrollTop)");
	}

	/**
	 * Scrolls to the right end of the page
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.scrollToRight(driver, 200);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 * @param x      : x coordinate value to scroll right
	 */
	public static void scrollToRight(AppiumDriver driver, int x) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(" + x + ", document.body.scrollTop)");
	}

	/**
	 * Click element using javascript executor.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.javascriptClick(driver, LoginButton);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The element to be clicked
	 */
	public static void javascriptClick(AppiumDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	/**
	 * Click element using javascript executor.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.javascriptClick(driver, LoginButton);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier of the element to be clicked
	 */
	public static void javascriptClick(AppiumDriver driver, Supplier<WebElement> element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element.get());
	}

	/**
	 * Clear text using javascript executor.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.clearTextUsingJavascriptExecutor(driver, LoginUsernameTextbox);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The element to be cleared
	 */
	public static void clearTextUsingJavascriptExecutor(AppiumDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", element);
	}

	/**
	 * Clear text using javascript executor.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.clearTextUsingJavascriptExecutor(driver, LoginUsernameTextbox);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier of the element to be cleared
	 */
	public static void clearTextUsingJavascriptExecutor(AppiumDriver driver, Supplier<WebElement> element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", element.get());
	}

	/**
	 * Clear text using backspace.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.clearTextUsingBackSpace(driver, LoginUsernameTextbox, 10);
	 * }
	 * </pre>
	 * 
	 * @param driver             : The current appium driver instance
	 * @param element            : The element to be cleared
	 * @param numberOfCharacters : Number of backspace needed
	 */
	public static void clearTextUsingBackSpace(AppiumDriver driver, WebElement element, int numberOfCharacters) {
		for (int count = 1; count <= numberOfCharacters; count++) {
			element.sendKeys(Keys.BACK_SPACE);
		}
	}

	/**
	 * Clear text using backspace.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.clearTextUsingBackSpace(driver, LoginUsernameTextbox, 10);
	 * }
	 * </pre>
	 * 
	 * @param driver             : The current appium driver instance
	 * @param element            : The supplier of the element to be cleared
	 * @param numberOfCharacters : Number of backspace needed
	 */
	public static void clearTextUsingBackSpace(AppiumDriver driver, Supplier<WebElement> element,
			int numberOfCharacters) {
		for (int count = 1; count <= numberOfCharacters; count++) {
			element.get().sendKeys(Keys.BACK_SPACE);
		}
	}

	/**
	 * Focus an element using java script executor.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.setFocusOnAnElement(driver, LoginUsernameTextbox);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The element to be focused
	 */
	public static void setFocusOnAnElement(AppiumDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].focus();", element);
	}

	/**
	 * Focus an element using java script executor.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.setFocusOnAnElement(driver, LoginUsernameTextbox);
	 * }
	 * </pre>
	 * 
	 * @param driver  : The current appium driver instance
	 * @param element : The supplier of the element to be focused
	 */
	public static void setFocusOnAnElement(AppiumDriver driver, Supplier<WebElement> element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].focus();", element.get());
	}

	/**
	 * Generate locator
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.generateLocator(driver, _locatorForReplacerButton, "SignUp", Locator.LocatorType.Xpath);
	 * }
	 * </pre>
	 * 
	 * @param driver         : The current appium driver instance
	 * @param dynamicLocator : The string locator value containing 'replacer' part
	 * @param replaceValue   : The dynamic value which will replace the 'replacer'
	 * @param locatorType    : The locator type enum value for locating the element
	 * @return Web element generated using specified locator type
	 */
	public static WebElement generateLocator(AppiumDriver driver, String dynamicLocator, String replaceValue,
			Enum<?> locateType) {
		return locateElement(driver, dynamicLocator.replace("replacer", replaceValue), locateType);
	}

	/**
	 * Generate locator
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.generateLocator(driver, _locatorForReplacerButton, "SignUp", Locator.LocatorType.Xpath);
	 * }
	 * </pre>
	 * 
	 * @param driver         : The current appium driver instance
	 * @param dynamicLocator : The supplier of the string locator value containing
	 *                       'replacer' part
	 * @param replaceValue   : The dynamic value which will replace the 'replacer'
	 * @param locatorType    : The locator type enum value for locating the element
	 * @return Web element generated using specified locator type
	 */
	public static WebElement generateLocator(AppiumDriver driver, Supplier<String> dynamicLocator, String replaceValue,
			Enum<?> locateType) {
		return locateElement(driver, dynamicLocator.get().replace("replacer", replaceValue), locateType);
	}

	/**
	 * Generate locator
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * String _locatorForReplacerButton = "//replacer1[@type="replacer2"]";
	 * AppiumDriverExtensions.generateLocator(driver, _locatorWithReplacers, valuesToReplace,
	 * 		Locator.LocatorType.Xpath);
	 * }
	 * </pre>
	 * 
	 * @param driver         : The current appium driver instance
	 * @param dynamicLocator : The string locator value containing multiple
	 *                       replacer(n) parts
	 * @param replaceValue   : The List of dynamic value which will replace the
	 *                       'replacer(n)'
	 * @param locatorType    : The locator type enum value for locating the element
	 * @return Web element generated using specified locator type
	 */
	public static WebElement generateLocator(AppiumDriver driver, String dynamicLocator, List<String> replaceValue,
			Enum<?> locateType) {
		for (int i = 1; i <= replaceValue.size(); i++) {
			dynamicLocator = dynamicLocator.replace("replacer" + i, replaceValue.get(i - 1));
		}

		return locateElement(driver, dynamicLocator, locateType);
	}

	/**
	 * Generate locator
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * Supplier<String> _locatorWithReplacers = () -> "//replacer1[@type="replacer2"]";
	 * AppiumDriverExtensions.generateLocator(driver, _locatorWithReplacers, valuesToReplace,
	 * 		Locator.LocatorType.Xpath);
	 * }
	 * </pre>
	 * 
	 * @param driver         : The current appium driver instance
	 * @param dynamicLocator : The supplier of the string locator value containing
	 *                       multiple replacer(n) parts
	 * @param replaceValue   : The List of dynamic value which will replace the
	 *                       'replacer(n)'
	 * @param locatorType    : The locator type enum value for locating the element
	 * @return Web element generated using specified locator type
	 */
	public static WebElement generateLocator(AppiumDriver driver, Supplier<String> dynamicLocator,
			List<String> replaceValue, Enum<?> locateType) {
		String newLocator = dynamicLocator.get();
		for (int i = 1; i <= replaceValue.size(); i++) {
			newLocator = newLocator.replace("replacer" + i, replaceValue.get(i - 1));
		}
		return locateElement(driver, newLocator, locateType);
	}

	/**
	 * Generate locators into list
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.generateLocatorsIntoList(driver, _locatorWithReplacer, "SignUp");
	 * }
	 * </pre>
	 * 
	 * @param driver         : The current appium driver instance
	 * @param dynamicLocator : The string locator value containing replacer part
	 * @param replaceValue   : The dynamic value which will replace the 'replacer'
	 * @return List of generate locator
	 */
	public static List<WebElement> generateLocatorsIntoList(AppiumDriver driver, String dynamicLocator,
			String replaceValue) {
		return getAllElementsIntoList(driver, dynamicLocator.replace("replacer", replaceValue));
	}

	/**
	 * Generate locators into list
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.generateLocatorsIntoList(driver, _locatorWithReplacer, "SignUp");
	 * }
	 * </pre>
	 * 
	 * @param driver         : The current appium driver instance
	 * @param dynamicLocator : The supplier of the string locator value containing
	 *                       replacer part
	 * @param replaceValue   : The dynamic value which will replace the 'replacer'
	 * @return List of generate locator
	 */
	public static List<WebElement> generateLocatorsIntoList(AppiumDriver driver, Supplier<String> dynamicLocator,
			String replaceValue) {
		return getAllElementsIntoList(driver, dynamicLocator.get().replace("replacer", replaceValue));
	}

	/**
	 * Confirms the alert pop up.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.confirmtAlert(driver);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 */
	public static void confirmtAlert(AppiumDriver driver) {
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}

	/**
	 * Dismisses the alert pop up.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * AppiumDriverExtensions.dismissAlert(driver);
	 * }
	 * </pre>
	 * 
	 * @param driver : The current appium driver instance
	 */
	public static void dismissAlert(AppiumDriver driver) {
		driver.switchTo().alert().dismiss();
		driver.switchTo().defaultContent();
	}
}