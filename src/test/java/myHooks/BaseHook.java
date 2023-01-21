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
        driver = driverFactory.getDriver("chrome");

    }

    @Before("@firefox")
    public void launchBrowserAsFirefox() {
        driver = driverFactory.getDriver("firefox");

    }

    @After()
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            //take screenshot
            String screenshotName = scenario.getName().replaceAll(" ", "_");

            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

            scenario.attach(sourcePath, "image/png", screenshotName);

        }
        driver.quit();
    }

}
