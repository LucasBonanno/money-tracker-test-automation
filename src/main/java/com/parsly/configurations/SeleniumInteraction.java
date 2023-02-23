package com.parsly.configurations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    public void selectCombobox( By by, String text ) {
        WebElement element = getDriver().findElement( by );
        Select combo = new Select( element );
        combo.selectByVisibleText( text );
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

    public String getList( By list ) {
        WebElement table = getDriver().findElement( list );
        String body = table.findElement( By.xpath( "./tbody" ) ).getText();
        return body;
    }

    public void locatorIsVisivel( By by ) {
        getWaitDriver().until( ExpectedConditions.visibilityOfElementLocated( by ) );
    }

    public void scrollIntoView() {
        JavascriptExecutor js = ( JavascriptExecutor ) getDriver();
//        js.executeScript( "arguments[0].scrollIntoView(true);", getDriver().findElement( by ) );
        js.executeScript( "window.scrollBy(0,document.body.scrollHeight)" );
    }

    public boolean isVisible( By locator ) {
        try {
            locatorIsVisivel( locator );
            return true;
        } catch( Exception e ) {
            return false;
        }
    }

    public void changeBrowser() {
        String winHandleBefore = getDriver().getWindowHandle();
        getDriver().switchTo().window( winHandleBefore );
        getDriver().close();
        for( String winHandle : getDriver().getWindowHandles() ) {
            getDriver().switchTo().window( winHandle );
        }
    }

}
