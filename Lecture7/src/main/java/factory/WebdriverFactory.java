package factory;

import constant.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverFactory {
    private WebdriverFactory() {
    }

    public static WebDriver createWebdriver(Browser browser) {
        switch (browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver.exe");
                return new FirefoxDriver();
            default:
                throw new RuntimeException("Unknown browser");
        }
    }
}