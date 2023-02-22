package com.parsly.pages;

import org.openqa.selenium.By;

public class HomePage {

    public final By moneyTrackerSetup = By.xpath( "//div[contains(text(),'Money Tracker Setup')]" );
    public final By accountsBalance = By.xpath( "//input[@placeholder='Balance']" );

    public By labelComponentBox( String title ) {
        return By.xpath( "//label[contains(text(),'" + title + "')]/..//input" );
    }

    public By accountsGroupListOption( String text ) {
        return By.xpath( "//*[contains(text(),'" + text + "')]" );
    }

}
