package com.parsly.configurations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.parsly.configurations.DriverFactory.getDriver;
import static com.parsly.configurations.DriverFactory.getWaitDriver;

public class SeleniumInteraction {
    public void write( By by, String text ) {
        getDriver().findElement( by ).clear();
        getDriver().findElement( by ).sendKeys( text );
    }

    public void writeAndEnter( By by, String text ) {
        write( by, text );
        getDriver().findElement( by ).sendKeys( Keys.ENTER );
    }

    public void click( By by ) {
        getWaitDriver().until(
                ExpectedConditions.elementToBeClickable( getDriver().findElement( by ) ) ).click();
    }

    public String getText( By by ) {
        return getDriver().findElement( by ).getText();
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public void locatorIsVisivel( By by ) {
        getWaitDriver().until( ExpectedConditions.visibilityOfElementLocated( by ) );
    }

    public void scrollIntoView() {
        JavascriptExecutor js = ( JavascriptExecutor ) getDriver();
        js.executeScript( "window.scrollBy(0,document.body.scrollHeight)" );
    }

}
