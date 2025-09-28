package utiles.commonHelper;

import org.openqa.selenium.By;

public class LocatorHelper {
    public enum LocatorType {
        ID,
        NAME,
        CLASS_NAME,
        TAG_NAME,
        LINK_TEXT,
        PARTIAL_LINK_TEXT,
        CSS,
        XPATH
    }
    public static By getLocator(LocatorType type, String value) {
        return switch (type) {
            case ID -> By.id(value);
            case NAME -> By.name(value);
            case CLASS_NAME -> By.className(value);
            case TAG_NAME -> By.tagName(value);
            case LINK_TEXT -> By.linkText(value);
            case PARTIAL_LINK_TEXT -> By.partialLinkText(value);
            case CSS -> By.cssSelector(value);
            case XPATH -> By.xpath(value);
            default -> throw new IllegalArgumentException("Invalid locator type: " + type);
        };

    }
}
