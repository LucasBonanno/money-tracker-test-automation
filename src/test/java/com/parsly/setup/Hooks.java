package com.parsly.setup;

import com.parsly.configurations.DriverFactory;
import com.parsly.configurations.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static com.parsly.configurations.DriverFactory.getDriver;
import static com.parsly.configurations.DriverFactory.killDriver;

public class Hooks {

    @Rule
    public TestName name = new TestName();

    @Before
    public void beforeScenario( Scenario scenario ) {
        Thread.currentThread().setName( scenario.getName() );
        getDriver().get( PropertyReader.getProperty( "web.url" ) );
    }

    @After
    public void afterScenario( Scenario scenario ) throws IOException {
        TakesScreenshot ss = ( TakesScreenshot ) DriverFactory.getDriver();
        File arquivo = ss.getScreenshotAs( OutputType.FILE );
        String status = scenario.getStatus().toString();
        FileUtils.copyFile( arquivo, new File( "evidences" + File.separator + "screenshot_status_" + status
                + File.separator + scenario.getName() + ".jpg" ) );
        killDriver();

    }
}
