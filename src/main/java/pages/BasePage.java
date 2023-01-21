package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;


public class BasePage extends PageFactory {

    protected WebDriver driver;
    protected static int timeOut = 20;
    private final WebDriverWait jsWait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.jsWait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    protected String getBrowserTitle() {
        /**
         * Get title of current pages on the web application
         */

        return driver.getTitle();
    }

    protected String getCurrentUrl() {
        /**
         * Get URL of current pages on the web application
         */

        return driver.getCurrentUrl();
    }

    protected void navigateUrl(String url) {
        /**
         * Browse current window to requested url.
         * @param str url: Requested URL of the site to be redirected
         */

        driver.get(url);
    }

    protected void navigateBrowserBack() {
        /**
         * Go one pages back
         */

        driver.navigate().back();
    }

    protected void refreshBrowser() {
        /**
         * Refresh current pages on the web application
         */

        driver.navigate().refresh();
    }

    protected boolean isElementPresent(By locator) {
        /**
         * Return True if element present and False if element absent
         * @param By locator: locator of the element to find
         */

        try {
            driver.findElement(locator);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;

    }

    protected Wait<WebDriver> wait_for() {
        /**
         * Managing Fluent wait action each method
         */

        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(10)).ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }

    protected WebElement waitForElementClickable(WebElement element) {
        /**
         * Wait for element to be clickable
         * @param WebElement element: The element to find
         */

        return wait_for().until(ExpectedConditions.elementToBeClickable(element));

    }

    protected WebElement waitForElementVisible(WebElement element) {
        /**
         * Wait for element to be visible
         * @param WebElement element: The element to find
         */

        return wait_for().until(ExpectedConditions.visibilityOf(element));

    }

    protected Boolean waitForElementInvisible(WebElement element) {
        /**
         * Wait for element to be invisible
         * @param WebElement element: The element to find
         */

        return wait_for().until(ExpectedConditions.invisibilityOf(element));
    }

    protected Boolean visibilityOfAllElements(List<WebElement> element) {
        /**
         * Wait for elements to be invisible
         * @param List<WebElement> element: The elements to find
         */

        return wait_for().until(ExpectedConditions.invisibilityOfAllElements(element));
    }

    protected Boolean waitUntilElementIsDisplayed(WebElement element) {
        /**
         * Wait for element is displayed
         * @param WebElement element: The element to find
         */

        return wait_for().until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
    }

    public void waitForLoad() {
        /**
         * Wait the page is loaded
         */

        ExpectedCondition<Boolean> pageLoadCondition = driver -> {
            assert driver != null;
            return ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").equals("complete");
        };
        jsWait.until(pageLoadCondition);

    }

    protected void scrollElement(WebElement element) {
        /**
         * Scroll in the middle of the element
         * @param WebElement element: The element to find
         */

        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", element);
    }

    private String getCurrentTime() {
        /**
         * The method returns current time
         */

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        return simpleDateFormat.format(new Date());
    }

    private void takeScreenshot() {
        /**
         * Take a screenshot method and save to the screenshot folder
         */

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {

            String path = "src/test/java/screenshot/" + getCurrentTime() + ".png";
            FileUtils.copyFile(scrFile, new File(path));
        } catch (IOException e) {
            System.out.println("ScreenShot fail." + e.getMessage());
        }
    }

    public Boolean waitUntilUrlContains(String expectedValue) {
        /**
         * Wait until Url Contains with expected string
         * @param str expectedValue: expected text for the Url
         */

        return wait_for().until(ExpectedConditions.urlContains(expectedValue));
    }

    public void click(WebElement element) {
        /**
         * Action click to the element
         * @param WebElement element: The element to find
         */

        new Actions(driver).moveToElement(element).click().perform();
    }

    public void doubleClick(WebElement element) {
        /**
         * Double click to the element
         * @param WebElement element: The element to find
         */

        new Actions(driver).moveToElement(element).doubleClick();
    }

    public void scrollToElement(WebElement element) {
        /**
         * Scroll to the element
         * @param WebElement element: The element to find
         */

        new Actions(driver).moveToElement(element).scrollToElement(element);
    }

    public void sendKey(WebElement element, String text) {
        /**
         * Sendkeys value to the element
         * @param WebElement element: The element to find
         * @param str text: Text value for writing into the element
         */

        new Actions(driver).sendKeys(text).perform();
    }

    public void clickEnter() {
        /**
         * Clicks enter keyboard to the element
         */

        new Actions(driver).sendKeys(Keys.ENTER).perform();
    }
}
