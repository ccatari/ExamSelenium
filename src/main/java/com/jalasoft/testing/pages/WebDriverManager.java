package com.jalasoft.testing.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ccatari on 5/25/2016.
 */
public class WebDriverManager {
    private static final String MODE_LOCAL = "Local";
    private static final String USERNAME = "ccatari";
    private static final String ACCESS_KEY = "c9fb548a-ea61-4141-bdbd-fc238085b509";
    private static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
    private static final int TIMEOUT_NORMAL = 15;
    private static WebDriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    private String mode = "Local";

    private WebDriverManager() {
        if (MODE_LOCAL.equalsIgnoreCase(mode)) {
            driver = new FirefoxDriver();
        } else {
            DesiredCapabilities caps = DesiredCapabilities.safari();
            caps.setCapability("platform", "OS X 10.11");
            caps.setCapability("version", "9.0");
            caps.setCapability("browserName", "safari");
            try {
                driver = new RemoteWebDriver(new URL(URL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
        driver.manage().timeouts().implicitlyWait(TIMEOUT_NORMAL, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, TIMEOUT_NORMAL);
        driver.manage().window().maximize();
    }

    public static WebDriverManager getInstance() {
        if (instance == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setMode(String mode){
        this.mode = mode;
    }
}
