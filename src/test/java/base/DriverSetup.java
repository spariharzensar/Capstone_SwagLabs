package base;

import configReader.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.*;

public class DriverSetup {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static String expectedBrowser = ConfigReader.getProperty("browser");

    public static WebDriver getDriver() {
        if (driver.get() == null) {

            switch (expectedBrowser.toLowerCase()) {

                case "chrome":
                    ChromeOptions options = new ChromeOptions();

                    Map<String, Object> map = new HashMap<>();
                    map.put("credentials_enable_service", false);
                    map.put("profile.password_manager_enabled", false);
                    options.setExperimentalOption("prefs", map);

                    options.addArguments("--disable-notifications");
                    options.addArguments("--incognito");

                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver(options));
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;

                default:
                    throw new RuntimeException("Invalid browser: " + expectedBrowser);
            }

            driver.get().manage().window().maximize();
            driver.get().manage().deleteAllCookies();
        }

        return driver.get();
    }
    }