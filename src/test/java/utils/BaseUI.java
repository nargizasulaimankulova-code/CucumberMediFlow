package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BaseUI {

    public void waitAndClick(WebElement element) {
        waitUntilClickable(20, element);
        element.click();
    }

    public void waitAndSendKeys(WebElement element, String keys) {
        waitUntilVisible(20, element);
        element.sendKeys(keys);
    }

    /**
     * This method will wait for element to become visible
     * then it clears existing value and sends new keys
     *
     * @param element - the input field
     * @param keys    - the data to be sent
     */
    public void clearAndSendKeys(WebElement element, String keys) {
        waitUntilVisible(20, element);
        element.clear();
        element.sendKeys(keys);
    }

    public void jsClick(WebElement element) {
        waitUntilClickable(20, element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void jsSendKeys(WebElement element, String value) {
        waitUntilVisible(20, element);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='';", element);
        js.executeScript("arguments[0].value=arguments[1];", element, value);
    }

    public WebDriverWait explicitWait(int seconds) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));
    }

    public void waitUntilClickable(int seconds, WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(int seconds, WebElement element) {
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void selectRandomOptionFromDropdown(WebElement dropdown, By optionsLocator) {
        waitAndClick(dropdown);
        // explicitly waits for dropdown options to have more than 1 option
        explicitWait(20).until(ExpectedConditions.numberOfElementsToBeMoreThan(optionsLocator, 1));
        int randomIndex = new Random().nextInt(0, Driver.getDriver().findElements(optionsLocator).size());
        waitAndClick(Driver.getDriver().findElements(optionsLocator).get(randomIndex));
    }

    /**
     * This method clicks on the given element, switches to the newly opened tab
     * and prints its url.
     *
     * @param element - is clicked to open new tab
     */
    public static void switchToNewTab(WebElement element) {
        WebDriver driver = Driver.getDriver();
        String mainWindow = driver.getWindowHandle();

        element.click();

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

        System.out.println("Currently, the driver is on: " + driver.getCurrentUrl());
    }


    /**
     * Attempts to click an element using JavascriptExecutor with a retry mechanism.
     *
     * @param element    The WebElement to click
     * @param maxRetries The maximum number of attempts
     * @return true if clicked successfully, false otherwise
     */
    public static boolean safeJSClick(WebElement element, int maxRetries) {

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        for (int i = 1; i <= maxRetries; i++) {
            try {
                js.executeScript("arguments[0].click();", element);
                System.out.println("Successfully clicked element on attempt #" + i);
                return true; // Exit loop and method on success
            } catch (Exception e) {
                System.err.println("Attempt #" + i + " failed to click element: " + e.getMessage());
                // Optional: Add a short Thread.sleep(500) here if the page is mid-render
            }
        }

        System.err.println("Failed to click element after " + maxRetries + " attempts.");
        return false;
    }

    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                element
        );
    }

    public WebElement waitUntilVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void hoverOver(By locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

        for (int i = 0; i < 5; i++) {
            try {
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                scrollIntoViewJS(element);
                new Actions(Driver.getDriver())
                        .moveToElement(element, 1, 1)
                        .pause(Duration.ofMillis(500))
                        .perform();
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retry hover because chart was re-rendered...");
            }
        }

        throw new RuntimeException("Unable to hover over dynamic element: " + locator);
    }

    public void hoverOverWithOffset(By locator, int xOffset, int yOffset) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        scrollIntoViewJS(element);

        new Actions(Driver.getDriver())
                .moveToElement(element, xOffset, yOffset)
                .pause(Duration.ofSeconds(1))
                .perform();
    }

    public WebElement waitUntilAnyElementVisible(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(seconds));

        return wait.until(driver -> {
            List<WebElement> elements = driver.findElements(locator);

            for (WebElement element : elements) {
                try {
                    if (element.isDisplayed()) {
                        return element;
                    }
                } catch (StaleElementReferenceException e) {
                    // ignore stale and continue
                }
            }
            return null;
        });
    }

    public boolean hoverUntilTooltipVisible(By chartLocator, By tooltipLocator) {
        int[] xOffsets = {90, 120, 150, 180, 210};
        int yOffset = 120;

        for (int xOffset : xOffsets) {
            hoverOverWithOffset(chartLocator, xOffset, yOffset);

            List<WebElement> tooltips = Driver.getDriver().findElements(tooltipLocator);
            for (WebElement tooltip : tooltips) {
                try {
                    if (tooltip.isDisplayed()) {
                        return true;
                    }
                } catch (StaleElementReferenceException ignored) {
                }
            }
        }
        return false;
    }
}