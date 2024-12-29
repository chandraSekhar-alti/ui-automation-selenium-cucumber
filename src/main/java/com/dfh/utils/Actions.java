package com.dfh.utils;

import com.dfh.driver.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;


public class Actions {

    private WebDriver driver;
    private final long DEFAULT_TIMEOUT = 10;
    private final long SMALL_TIMEOUT = 5;
    private static Logger log;

    public Actions(WebDriver driver) {
        this.driver = driver != null ? driver : DriverManager.getDriver();
        log = LogManager.getLogger(Actions.class);
    }

    /**
     * Creates a WebDriverWait instance with a custom timeout.
     *
     * @param driver           WebDriver instance
     * @param timeOutInSeconds Timeout in seconds
     * @return WebDriverWait instance
     */
    public WebDriverWait webDriverWaitInstance(WebDriver driver, long timeOutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
    }

    /**
     * Waits for an element to be clickable, with a custom timeout.
     *
     * @param by      Locator of the element (By object)
     * @param timeOut Timeout in seconds
     * @return WebElement once it is clickable, or null if there is an error
     */
    public WebElement waitForElementClickable(By by, long timeOut) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            log.error(String.format("❌ Error waiting for element clickable: %s (Timeout: %d seconds)", by.toString(), timeOut), e);
            Assert.fail("❌ Timeout waiting for the element ready to click. " + by.toString());
        }
        return null;
    }

    /**
     * Waits for a link text element to be visible.
     *
     * @param linkText The visible text of the link
     * @return WebElement of the link text, or null if there is an error
     */
    public WebElement waitForLinkTextElement(String linkText) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
        } catch (Exception e) {
            log.error("❌ Error waiting for the linkText element", e);
            return null;
        }
    }

    /**
     * Waits for an element to be clickable using the default timeout.
     *
     * @param by Locator of the element (By object)
     * @return WebElement once it is clickable, or null if there is an error
     */
    public WebElement waitForElementClickable(By by) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            log.error(String.format("❌ Error waiting for element clickable: %s (Timeout: %d seconds)", by.toString(), DEFAULT_TIMEOUT), e);
        }
        return null;
    }

    /**
     * Waits for a specific WebElement to be clickable, with a custom timeout.
     *
     * @param element The WebElement to wait for
     * @param timeOut Timeout in seconds
     * @return WebElement once it is clickable, or null if there is an error
     */
    public WebElement waitForElementClickable(WebElement element, long timeOut) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeOut))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            log.error(String.format("❌ Error waiting for element clickable: %s (Timeout: %d seconds)", element, timeOut), e);
            return null;
        }
    }

    /**
     * Waits for a specific WebElement to be clickable using the default timeout.
     *
     * @param element The WebElement to wait for
     * @return WebElement once it is clickable, or null if there is an error
     */
    public WebElement waitForElementClickable(WebElement element) {
        return waitForElementClickable(element, DEFAULT_TIMEOUT);
    }

    /**
     * Waits for an element to be present in the DOM.
     *
     * @param by Locator of the element (By object)
     * @return WebElement once it is present, or null if there is an error
     */
    public WebElement waitForElementPresent(By by) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            log.error("❌ Error waiting for element present: " + by.toString(), e);
            Assert.fail("❌ Error waiting for element present: " + by.toString());
            return null;
        }
    }

    /**
     * Waits for an element to be visible and displayed on the page.
     *
     * @param by Locator of the element (By object)
     * @return WebElement once it is visible and displayed, or null if there is an error
     */
    public WebElement isElementDisplayed(By by) {
        WebElement element = waitForElementPresent(by);
        if (element != null && element.isDisplayed()) {
            highlightElementByGreen(by);
            return element;
        } else {
            log.error("❌ Element not visible: " + by.toString());
            Assert.fail("❌ Element not visible: " + by.toString());
            return null;
        }
    }

    /**
     * Highlights a single web element by adding a green border.
     *
     * @param element The web element to highlight.
     */
    public void highlightElementByGreen(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border = '3px solid green';", element);
    }

    /**
     * Highlights a web element located by the specified locator by adding a green border.
     *
     * @param locator The locator of the web element to highlight.
     */
    public void highlightElementByGreen(By locator) {
        WebElement element = driver.findElement(locator);
        highlightElementByGreen(element);
    }


    /**
     * Convert the By object to the WebElement
     *
     * @param by is an element of type By
     * @return Returns a WebElement object
     */
    public WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public WebElement waitForElementVisible(By by) {
        waitForElementPresent(by);
        try {
            if (isElementVisible(by, (int) DEFAULT_TIMEOUT)) {
                return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(by));
            } else {
                scrollToElementAtBottom(by);
                return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(by));
            }
        } catch (Exception e) {
            log.error("❌ Timeout waiting for element to be visible: " + by.toString(), e);
            Assert.fail("❌ Timeout waiting for element to be visible: " + by.toString());
            return null;
        }
    }

    //@Step("Check if element is visible ")
    public boolean isElementVisible(By by, int timeout) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Check if element is visible ")
    public boolean isElementVisible(By by) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //@Step("Scroll to element ")
    public void scrollToElementAtBottom(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(by));
        log.info("Scrolled to element: " + by.toString());
    }

    public boolean waitForAlertPresent() {
        return waitForAlertPresent((int) DEFAULT_TIMEOUT);
    }

    public boolean waitForAlertPresent(int timeOut) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            log.error("❌ Alert not present", e);
            Assert.fail("❌ Alert not present");
            return false;
        }
    }

    public boolean waitForElementHasAttribute(By by, String attributeName) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                    .until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(by), attributeName));
        } catch (Exception e) {
            log.error("❌ Timeout for element " + by.toString() + " to have attribute: " + attributeName, e);
            Assert.fail("❌ Timeout for element " + by.toString() + " to have attribute: " + attributeName);
            return false;
        }
    }

    public WebElement fluentWaitForElement(By by, long timeOut, long pollingTime) {
        try {
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeOut))
                    .pollingEvery(Duration.ofMillis(pollingTime))
                    .ignoring(NoSuchElementException.class);

            return fluentWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            log.error(String.format("❌ Error during fluent wait for element: %s (Timeout: %d seconds)", by.toString(), timeOut), e);
            return null;
        }
    }

    public void clickElement(By by) {
        isElementVisible(by);
        WebElement element = waitForElementClickable(by);
        if (element != null) {
            element.click();
            log.info("Clicked on Element: " + by.toString());
        } else {
            log.error("❌ Element not found or not clickable: " + by.toString());
        }
    }

    public void clickElement(By by, long timeOut) {
        WebElement element = waitForElementClickable(by, timeOut);
        if (element != null) {
            element.click();
            log.info("Clicked on Element: " + by.toString());
        } else {
            log.error("❌ Element not found or not clickable: " + by.toString());
        }
    }

    /**
     * Click on a WebElement.
     *
     * @param element The locator of the element to click.
     */
    //@Step("Click on the WebElement: {element}")
    public void clickElement(WebElement element) {
        if (element != null && waitForElementClickable(element) != null) {
            element.click();
            log.info("Clicked on WebElement: " + element);
        } else {
            log.error("❌ Element not found or not clickable: " + element);
        }
    }

    /**
     * Click on a WebElement with timeout.
     *
     * @param element The WebElement to click
     * @param timeOut time in seconds
     */
    //@Step("Click on the WebElement: {element} with timeout: {timeOut} seconds")
    public void clickElement(WebElement element, long timeOut) {
        if (element != null && waitForElementClickable(element, timeOut) != null) {
            element.click();
            log.info("Clicked on WebElement: " + element);
        } else {
            log.error("❌ Element not found or not clickable: " + element);
        }
    }

    /**
     *
     */
    //@Step("Click using js")
    public void clickElementUsingJS(By by) {
        WebElement element = waitForElementClickable(by);
        try {
            if (element != null) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
                log.info("✅ Clicked on element using JavaScript: " + by.toString());
            } else {
                log.error("❌ Element is not clickable or not found : " + by.toString());
            }
        } catch (JavascriptException e) {
            log.error("❌ Element JavaScript click failed for element: " + by.toString(), e);
        }
    }


    /**
     * Click on the link on website with text
     *
     * @param linkText the visible text of a link
     */
    //@Step("Click on link text")
    public void clickOnLinkText(String linkText) {
        WebElement element = waitForLinkTextElement(linkText);
        if (element != null) {
            element.click();
            log.info("✅ clicked on the linkText element : " + element.toString());
        } else {
            log.error("❌ element is not visible");
        }
    }

    /**
     * Right-click on the Element object on the web
     *
     * @param by an element of object type By
     */
    //@Step("Right click on element ")
    public void rightClickOnElement(By by) {
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.contextClick(waitForElementVisible(by)).build().perform();
        log.info("Right click on element " + by);
    }


    /**
     * Set the value of an input field
     *
     * @param by    an element of object type By
     * @param value the value to fill in the text box
     */
    //@Step("Set text on text box")
    public void setText(By by, String value) {
        waitForElementVisible(by).sendKeys(value);
        log.info("Set text " + value + " on " + by.toString());
    }

    /**
     * Set the value of an input field and press the key on the keyboard
     *
     * @param by    an element of object type By
     * @param value the value to fill in the text box
     * @param keys  key on the keyboard to press
     */
    //@Step("Set text on text box and press key")
    public void setText(By by, String value, Keys keys) {
        waitForElementVisible(by).sendKeys(value, keys);
        log.info("Set text " + value + " on " + by + " and press key " + keys.name());
    }

    /**
     * Simulates keystroke events on the specified element, as though you typed the value key-by-key.
     *
     * @param by   an element of object type By
     * @param keys key on the keyboard to press
     */
    //@Step("Set text on text box and press key")
    public void sendKeys(By by, Keys keys) {
        waitForElementVisible(by).sendKeys(keys);
        log.info("Press key " + keys.name() + " on element " + by);
    }

    /**
     * Simulates keystroke events at the current position, as though you typed the value key-by-key.
     *
     * @param keys key on the keyboard to press
     */
    //@Step("Press key on keyboard")
    public void sendKeys(Keys keys) {
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.sendKeys(keys);
        log.info("Press key " + keys.name() + " on keyboard");
    }

    /**
     * Clear all text of the element with press Ctrl A > Delete
     *
     * @param by an element of object type By
     */
    //@Step("Clear text in text box with Ctrl A")
    public void clearTextCtrlA(By by) {
        waitForElementVisible(by);
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(driver);
        actions.click(getWebElement(by)).build().perform();
        //actions.moveToElement(getWebElement(by)).click().build();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.sendKeys(Keys.DELETE).build().perform();
        log.info("Clear text in textbox " + by.toString());
    }

    /**
     * Clear all text of the element then set the text on that element.
     *
     * @param by    an element of object type By
     * @param value the value to fill in the text box
     */
    //@Step("Clear and Fill text on text box")
    public void clearAndFillText(By by, String value) {
        waitForElementVisible(by);
        getWebElement(by).clear();
        getWebElement(by).sendKeys(value);
        log.info("Clear and Fill " + value + " on " + by.toString());
    }

    /**
     * Get text of an element
     *
     * @param by an element of object type By
     * @return text of a element
     */
    //@Step("Get text of element ")
    public String getElementText(By by) {
        return waitForElementVisible(by).getText().trim();
    }

    /**
     * Get the value from the element's attribute
     *
     * @param by            an element of object type By
     * @param attributeName attribute name
     * @return element's attribute value
     */
    //@Step("Get attribute {1} of element ")
    public String getAttributeElement(By by, String attributeName) {
        return waitForElementVisible(by).getAttribute(attributeName);
    }

    /**
     * Get CSS value of an element
     *
     * @param by      Represent a web element as the By object
     * @param cssName is CSS attribute name
     * @return value of CSS attribute
     */
    //@Step("Get CSS value {1} of element ")
    public String getCssValueElement(By by, String cssName) {
        return waitForElementVisible(by).getCssValue(cssName);
    }

    /**
     * Get size of specified element
     *
     * @param by Represent a web element as the By object
     * @return Dimension
     */
    //@Step("Get Size of element ")
    public Dimension getSizeElement(By by) {
        return waitForElementVisible(by).getSize();
    }

    /**
     * Get location of specified element
     *
     * @param by Represent a web element as the By object
     * @return Point
     */
    //@Step("Get Location of element ")
    public Point getLocationElement(By by) {
        return waitForElementVisible(by).getLocation();
    }

    /**
     * Get tag name (HTML tag) of specified element
     *
     * @param by Represent a web element as the By object
     * @return Tag name as String
     */
    //@Step("Get Tag Name of element ")
    public String getTagNameElement(By by) {
        return waitForElementVisible(by).getTagName();
    }

    /**
     * Scroll an element into the visible area of the browser window. (at TOP)
     *
     * @param by Represent a web element as the By object
     */
    //@Step("Scroll to element ")
    public void scrollToElementAtTop(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
        log.info("Scroll to element " + by);
    }

    /**
     * Verify if the web element has an attribute with the specified name.
     *
     * @param by            Represent a web element.
     * @param attributeName The name of the attribute to wait for.
     * @param timeOut       System will wait at most timeout (seconds) to return result
     * @return true/false
     */
    //@Step("Verify element  has attribute {1} with timeout {2} second")
    public boolean verifyElementHasAttribute(By by, String attributeName, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.attributeToBeNotEmpty(waitForElementPresent(by), attributeName));
            return true;
        } catch (Throwable error) {
            log.error("Not found Attribute " + attributeName + " of element " + by.toString());
            Assert.fail("Not found Attribute " + attributeName + " of element " + by.toString());
            return false;
        }
    }

    /**
     * Wait for a page to load with the default time from the config
     */
    public void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            log.info("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                log.error("Timeout waiting for page load. (" + DEFAULT_TIMEOUT + "s)");
                Assert.fail("Timeout waiting for page load. (" + DEFAULT_TIMEOUT + "s)");
            }
        }
    }


    /**
     * Wait for a page to load within the given time (in seconds)
     */
    public void waitForPageLoaded(int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            log.info("Javascript in NOT Ready!");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                log.error("Timeout waiting for page load. (" + DEFAULT_TIMEOUT + "s)");
                Assert.fail("Timeout waiting for page load. (" + DEFAULT_TIMEOUT + "s)");
            }
        }
    }

    /**
     * Get current URL from current drivers
     *
     * @return the current URL as String
     */
    @Step("Get Current URL")
    public String getCurrentUrl() {
        log.info("Get Current URL: " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    /**
     * Get current web page's title
     *
     * @return the current URL as String
     */
    //@Step("Get Page Title")
    public String getPageTitle() {
        String title = driver.getTitle();
        log.info("Get Page Title: " + driver.getTitle());
        return title;
    }

    /**
     * Verify the web page's title equals with the specified title
     *
     * @param pageTitle The title of the web page that needs verifying
     * @return the current URL as String
     */
    //@Step("Verify Page Title equals ")
    public boolean VerifyPageTitle(String pageTitle) {
        return getPageTitle().equals(pageTitle);
    }

    /**
     * Verify if the given web element is checked.
     *
     * @param by Represent a web element as the By object
     * @return true if the element is checked, otherwise false.
     */
    //@Step("Verify Element Checked ")
    public boolean verifyElementChecked(By by) {

        boolean checked = getWebElement(by).isSelected();
        if (checked) {
            return true;
        } else {
            Assert.assertTrue(false, "❌ The element NOT checked.");
            return false;
        }
    }

    /**
     * Verify if the given web element is checked.
     *
     * @param by      Represent a web element as the By object
     * @param message the custom message if false
     * @return true if the element is checked, otherwise false.
     */
    //@Step("Verify Element Checked ")
    public boolean verifyElementChecked(By by, String message) {
        waitForElementVisible(by);

        boolean checked = getWebElement(by).isSelected();

        if (checked) {
            return true;
        } else {
            Assert.assertTrue(false, message);
            return false;
        }
    }

    /**
     * Select the options with the given label (displayed text).
     *
     * @param by   Represent a web element as the By object
     * @param text the specified text of option
     */
    //@Step("Select Option by Text ")
    public void selectOptionByText(By by, String text) {
        Select select = new Select(getWebElement(by));
        select.selectByVisibleText(text);
        log.info("Select Option " + by + "by text " + text);
    }

    /**
     * Select the options with the given value.
     *
     * @param by    Represent a web element as the By object
     * @param value the specified value of option
     */
    //@Step("Select Option by Value ")
    public void selectOptionByValue(By by, String value) {
        Select select = new Select(getWebElement(by));
        select.selectByValue(value);
        log.info("Select Option " + by + "by value " + value);
    }

    /**
     * Select the options with the given index.
     *
     * @param by    Represent a web element as the By object
     * @param index the specified index of option
     */
    //@Step("Select Option by Index ")
    public void selectOptionByIndex(By by, int index) {
        Select select = new Select(getWebElement(by));
        select.selectByIndex(index);
        log.info("Select Option " + by + "by index " + index);
    }


    //WINDOWS Handles functions

    /**
     * Switch to iframe by index of iframe tag
     *
     * @param index index of iframe tag
     */
    //@Step("Switch to Frame by Index: ")
    public void switchToFrameByIndex(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT), Duration.ofMillis(500));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
        //driver.switchTo().frame(Index);
        log.info("Switch to Frame by Index. " + index);
    }

    /**
     * Switch to iframe by ID or Name of iframe tag
     *
     * @param IdOrName ID or Name of iframe tag
     */
    //@Step("Switch to Frame by ID or Name: ")
    public void switchToFrameByIdOrName(String IdOrName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT), Duration.ofMillis(500));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IdOrName));
        log.info("Switch to Frame by ID or Name. " + IdOrName);
    }

    /**
     * Switch to iframe by Element is this iframe tag
     *
     * @param by iframe tag
     */
    //@Step("Switch to Frame by Element ")
    public void switchToFrameByElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT), Duration.ofMillis(500));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
        log.info("Switch to Frame by Element. " + by);
    }

    /**
     * Switch to Default Content
     */
    //@Step("Switch to Default Content")
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        log.info("Switch to Default Content");
    }

    /**
     * Switch to iframe by position of iframe tag
     *
     * @param position index of iframe tag
     */
    //@Step("Switch to Window or Tab by Position: ")
    public void switchToWindowOrTabByPosition(int position) {

        driver.switchTo().window(driver.getWindowHandles().toArray()[position].toString());
        log.info("Switch to Window or Tab by Position: " + position);
    }

    /**
     * Switch to popup window by title
     *
     * @param title title of popup window
     */
    //@Step("Switch to Window or Tab by Title: ")
    public void switchToWindowOrTabByTitle(String title) {
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT), Duration.ofMillis(500));
        //Wait for the new window or tab
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                if (driver.getTitle().equals(title)) {
                    break;
                }
            }
        }
    }

    /**
     * Switch to popup window by URL
     *
     * @param url url of popup window
     */
    //@Step("Switch to Window or Tab by Url: ")
    public void switchToWindowOrTabByUrl(String url) {
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT), Duration.ofMillis(500));
        //Wait for the new window or tab
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                if (driver.getCurrentUrl().equals(url)) {
                    break;
                }
            }
        }
    }

    /**
     * Close current Window
     */
    //@Step("Close current Window")
    public void closeCurrentWindow() {
        log.info("Close current Window: " + getCurrentUrl());
        driver.close();
        log.info("Closed current Window");
    }

    /**
     * Get the total number of popup windows the given web page.
     *
     * @param number the specified number
     * @return true/false
     */
    //@Step("Verify total of Windows or Tab")
    public boolean verifyTotalOfWindowsOrTab(int number) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT)).until(ExpectedConditions.numberOfWindowsToBe(number));
    }

    /**
     * Open new Tab
     */
    //@Step("Open new Tab")
    public void openAndSwitchNewTab() {
        // Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);
        log.info("Open new Tab");
    }

    /**
     * @param url url to be launch
     */
    public void launchURL(String url) {
        driver.navigate().to(url);
        log.info("Navigated to URL : " + url);
    }

    /**
     * Open new Window
     */
    //@Step("Open new Window")
    public void openAndSwitchNewWindow() {
        // Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        log.info("Open new Window");
    }

    /**
     * Switch to Main Window
     */
    //@Step("Switch to Main Window")
    public void switchToMainWindow() {
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        log.info("Switch to Main Window." + driver);
    }

    /**
     * Switch to Main Window by ID
     *
     * @param originalWindow ID of main window
     */
    //@Step("Switch to Main Window by ID ")
    public void switchToMainWindow(String originalWindow) {
        driver.switchTo().window(originalWindow);
        log.info("Switch to Main Window." + originalWindow);
    }

    /**
     * Switch to Last Window
     */
    //@Step("Switch to Last Window")
    public void switchToLastWindow() {
        Set<String> windowHandles = driver.getWindowHandles();
        WebDriver newDriver = driver.switchTo().window(driver.getWindowHandles().toArray()[windowHandles.size() - 1].toString());
        log.info("Switch to Last Window." + newDriver.getCurrentUrl());
    }


    /**
     * Forced wait with unit of Seconds
     *
     * @param second is a positive integer corresponding to the number of Seconds
     */
    public void sleep(double second) {
        try {
            Thread.sleep((long) (second * 1000));
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    // ALERTS Functions

    /**
     * Click Accept on Alert
     */
    //@Step("Click Accept on Alert")
    public void acceptAlert() {
        sleep(SMALL_TIMEOUT);
        driver.switchTo().alert().accept();
        log.info("Click Accept on Alert.");
    }


    /**
     * Click Dismiss on Alert
     */
    //@Step("Click Dismiss on Alert")
    public void dismissAlert() {
        sleep(SMALL_TIMEOUT);
        driver.switchTo().alert().dismiss();
        log.info("Click Dismiss on Alert.");
    }

    /**
     * Get text on Alert
     */
    //@Step("Get text on Alert")
    public String getTextAlert() {
        sleep(SMALL_TIMEOUT);
        log.info("Get text ion alert: " + driver.switchTo().alert().getText());
        return driver.switchTo().alert().getText();
    }

    /**
     * Set text on Alert
     */
    //@Step("Set text on Alert ")
    public void setTextAlert(String text) {
        sleep(SMALL_TIMEOUT);
        driver.switchTo().alert().sendKeys(text);
        log.info("Set " + text + " on Alert.");
    }

}
