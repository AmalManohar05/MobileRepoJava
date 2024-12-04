package pace.testautomation.mobilecore.extensions;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.base.Supplier;

public class ElementExtensions {
	/**
	 * Check whether the element is present or not.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.isElementPresent(SignInButton);
	 * }
	 * </pre>
	 * 
	 * @param element : The element who's presence is being checked
	 * @return Whether the element is present or not (true/false)
	 */
	public static boolean isElementPresent(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check whether the element is present or not.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.isElementPresent(SignInButton);
	 * }
	 * </pre>
	 * 
	 * @param element : The supplier for the element who's presence is being checked
	 * @return Whether the element is present or not (true/false)
	 */
	public static boolean isElementPresent(Supplier<WebElement> element) {
		if (element.get().isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Getting the selected value in a drop down.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.getSelectedDropDown(CountryListDropDown);
	 * }
	 * </pre>
	 * 
	 * @param element : The element for the drop down
	 * @return Selected option of drop down
	 */
	public static String getSelectedDropDown(WebElement element) {
		Select ddl = new Select(element);
		return ddl.getFirstSelectedOption().getText();
	}

	/**
	 * Getting the selected value in a drop down.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.getSelectedDropDown(CountryListDropDown);
	 * }
	 * </pre>
	 * 
	 * @param element : The supplier of the element for the drop down
	 * @return Selected option of drop down
	 */
	public static String getSelectedDropDown(Supplier<WebElement> element) {
		Select ddl = new Select(element.get());
		return ddl.getFirstSelectedOption().getText();
	}

	/**
	 * Getting the selected list of values from a drop down.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.getSelectedListOptions(CountryListDropDown);
	 * }
	 * </pre>
	 * 
	 * @param element :The element for the drop down
	 * @return Selected list of option from drop down
	 */
	public static List<WebElement> getSelectedListOptions(WebElement element) {
		Select ddl = new Select(element);
		return ddl.getAllSelectedOptions();
	}

	/**
	 * Getting the selected list of values from a drop down.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.getSelectedListOptions(CountryListDropDown);
	 * }
	 * </pre>
	 * 
	 * @param element :The supplier of the element for the drop down
	 * @return Selected list of option from drop down
	 */
	public static List<WebElement> getSelectedListOptions(Supplier<WebElement> element) {
		Select ddl = new Select(element.get());
		return ddl.getAllSelectedOptions();
	}

	/**
	 * Select an option from drop down by value.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.selectDropDownListByValue(CountryListDropDown, "India");
	 * }
	 * </pre>
	 * 
	 * @param element : The element for the drop down
	 * @param value   : The value for the list option
	 */
	public static void selectDropDownListByValue(WebElement element, String value) {
		Select ddl = new Select(element);
		ddl.selectByValue(value);
	}

	/**
	 * Select an option from drop down by value.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.selectDropDownListByValue(CountryListDropDown, "India");
	 * }
	 * </pre>
	 * 
	 * @param element : The supplier of the element for the drop down
	 * @param value   : The value for the list option
	 */
	public static void selectDropDownListByValue(Supplier<WebElement> element, String value) {
		Select ddl = new Select(element.get());
		ddl.selectByValue(value);
	}

	/**
	 * Getting text from an element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.getElementText(DashboardHeader);
	 * }
	 * </pre>
	 * 
	 * @param element : The element who's text is being fetched
	 * @return Element text
	 */
	public static String getElementText(WebElement element) {
		return element.getText();
	}

	/**
	 * Getting text from an element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.getElementText(DashboardHeader);
	 * }
	 * </pre>
	 * 
	 * @param element : The supplier of the element who's text is being fetched
	 * @return Element text
	 */
	public static String getElementText(Supplier<WebElement> element) {
		return element.get().getText();
	}

	/**
	 * Getting attribute value from an element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.getElementAttribute(LoginUsernameTextbox, "placeholder");
	 * }
	 * </pre>
	 * 
	 * @param element : The element who's attribute value is being fetched
	 * @param value   : The required attribute name
	 * @return Element attribute value
	 */
	public static String getElementAttribute(WebElement element, String value) {
		return element.getAttribute(value);
	}

	/**
	 * Getting attribute value from an element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.getElementAttribute(LoginUsernameTextbox, "placeholder");
	 * }
	 * </pre>
	 * 
	 * @param element : The supplier of the element who's attribute value is being
	 *                fetched
	 * @param value   : The required attribute name
	 * @return Element attribute value
	 */
	public static String getElementAttribute(Supplier<WebElement> element, String value) {
		return element.get().getAttribute(value);
	}

	/**
	 * Select an option from drop down by text.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.selectDropDownListByText(CountryDropDownList, "INDIA");
	 * }
	 * </pre>
	 * 
	 * @param element : The element of the drop down
	 * @param text    : The text of the option
	 */
	public static void selectDropDownListByText(WebElement element, String text) {
		Select ddl = new Select(element);
		ddl.selectByVisibleText(text);
	}

	/**
	 * Select an option from drop down by text.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.selectDropDownListByText(CountryDropDownList, "INDIA");
	 * }
	 * </pre>
	 * 
	 * @param element : The supplier of the element of the drop down
	 * @param text    : The text of the option
	 */
	public static void selectDropDownListByText(Supplier<WebElement> element, String text) {
		Select ddl = new Select(element.get());
		ddl.selectByVisibleText(text);
	}

	/**
	 * Click on the given element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.click(AddButton);
	 * }
	 * </pre>
	 * 
	 * @param element : The supplier of the element to be clicked
	 */
	public static void click(Supplier<WebElement> element) {
		element.get().click();
	}

	/**
	 * Click on the given element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.click(AddButton);
	 * }
	 * </pre>
	 * 
	 * @param element : The element to be clicked
	 */
	public static void click(WebElement element) {
		element.click();
	}

	/**
	 * Send char sequence to the element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.sendKeys(LoginUsernameTextbox, "user@test.in");
	 * }
	 * </pre>
	 * 
	 * @param element      : The supplier of the element to which char sequence is
	 *                     sent
	 * @param charSequence : The character sequence to be sent
	 */
	public static void sendKeys(Supplier<WebElement> element, CharSequence... charSequence) {
		element.get().sendKeys(charSequence);
	}

	/**
	 * Send char sequence to the element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.sendKeys(LoginUsernameTextbox, "user@test.in");
	 * }
	 * </pre>
	 * 
	 * @param element      : The supplier of the element to which char sequence is
	 *                     sent
	 * @param charSequence : The character sequence to be sent
	 */
	public static void sendKeys(WebElement element, CharSequence... charSequence) {
		element.sendKeys(charSequence);
	}

	/**
	 * Clear the text value in the element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.clearText(LoginUsernameTextbox);
	 * }
	 * </pre>
	 * 
	 * @param element : The supplier of the element to be cleared
	 */
	public static void clearText(Supplier<WebElement> element) {
		element.get().clear();
	}

	/**
	 * Clear the text value in the element.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.clearText(LoginUsernameTextbox);
	 * }
	 * </pre>
	 * 
	 * @param element : The element to be cleared
	 */
	public static void clearText(WebElement element) {
		element.clear();
	}

	/**
	 * Clear text using backspace.
	 * 
	 * <pre>
	 * How to use :
	 * {@code
	 * ElementExtensions.clearInputTextUsingBackSpace(LoginUsernameTextbox);
	 * }
	 * </pre>
	 * 
	 * @param element : The element to be cleared
	 */
	public static void clearInputTextUsingBackSpace(WebElement element) {
		int numberOfCharacters = element.getAttribute("value").length();
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
	 * ElementExtensions.clearInputTextUsingBackSpace(LoginUsernameTextbox);
	 * }
	 * </pre>
	 * 
	 * @param element : The supplier of the element to be cleared
	 */
	public static void clearInputTextUsingBackSpace(Supplier<WebElement> element) {
		int numberOfCharacters = element.get().getAttribute("value").length();
		for (int count = 1; count <= numberOfCharacters; count++) {
			element.get().sendKeys(Keys.BACK_SPACE);
		}
	}
}