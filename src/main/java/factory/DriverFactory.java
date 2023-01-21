package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.Constant;

public class DriverFactory {

    WebDriver driver;

    public WebDriver getDriver(String browserName) {
        /**
         * Create and Return browser options
         */

        if ("firefox".equals(browserName)) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(Constant.DRIVER_OPTIONS);
            driver = new FirefoxDriver(options);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(Constant.DRIVER_OPTIONS);
            driver = new ChromeDriver(options);
        }

        return driver;
    }
}
