package myHooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseHook {

    public static WebDriver driver;
    DriverFactory driverFactory = new DriverFactory();

    @Before("@chrome")
    public void launchBrowserAsChrome() {
        /**
         * Launch the browser as Chrome
         */

        driver = driverFactory.getDriver("chrome");
    }

    @Before("@firefox")
    public void launchBrowserAsFirefox() {
        /**
         * Launch the browser as Firefox
         */

        driver = driverFactory.getDriver("firefox");
    }

    @After()
    public void afterScenario(Scenario scenario) {
        /**
         * Manage the scenario result after performed each step and quit the browser
         */

        if (scenario.isFailed()) {
            //take screenshot
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
        driver.quit();
    }

}
