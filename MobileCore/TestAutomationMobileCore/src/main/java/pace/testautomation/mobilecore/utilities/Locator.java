package pace.testautomation.mobilecore.utilities;

public class Locator {
	/**
	 * Enumerators for locator types.
	 */
	public static enum LocatorType {
		Id, AccessibilityId, Xpath, Name, CssSelector, ClassName, LinkText, PartialLinkText, TagName,
	}

	/**
	 * Enumerators for relative locator types.
	 */
	public static enum RelativeLocatorType {
		Above, Below, Near, RightOf, LeftOf, AboveAndBelow,
	}
}
