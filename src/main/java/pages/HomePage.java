package pages;

import org.openqa.selenium.WebDriver;
import utils.Constant;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void visitWebPage() {
        navigateUrl(Constant.BASE_URL);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Constant.IMPLICIT_WAIT_DURATION)));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(Long.parseLong(Constant.PAGE_LOAD_TIMEOUT)));
    }
}
