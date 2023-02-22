package com.parsly.configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static WebDriver driver;
    private static WebDriverWait waitDriver;

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        if( driver == null ) {
            WebDriverManager.chromedriver().version( "110.0" ).setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments( "start-maximized" );
            options.addArguments( "--incognito" );
            options.addArguments( "--no-sandbox" );
            options.addArguments( "disable-infobars" );
            options.addArguments( "--disable-notifications" );
            options.addArguments( "--disable-dev-shm-usage" );
            options.addArguments( "--disable-browser-side-navigation" );
            options.addArguments( "--disable-gpu" );
            options.setExperimentalOption( "useAutomationExtension", false );
            options.setExperimentalOption( "excludeSwitches", Collections.singletonList( "enable-automation" ) );
            Map< String, Object > prefs = new HashMap<>();
            prefs.put( "profile.default_content_setting_values.notifications", 2 );
            prefs.put( "credentials_enable_service", false );
            prefs.put( "profile.password_manager_enabled", false );
            options.setExperimentalOption( "prefs", prefs );
            driver = new ChromeDriver( options );
            driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 60 ) );
        }
        return driver;
    }

    public static WebDriverWait getWaitDriver() {
        waitDriver = new WebDriverWait( driver, Duration.ofSeconds( 60 ) );
        return waitDriver;
    }

    public static void killDriver() {
        if( driver != null ) {
            driver.quit();
            driver = null;
        }
    }
}
