package com.parsly.pages;

import org.openqa.selenium.By;

public class DashboardPage {

    public final By transactionFormValue = By.xpath( "//div[@class='ui right labeled input']//input" );
    public final By buttonForm = By.xpath( "//button[@class='ui fluid primary button']" );

    public By transactionTypeForm( String text ) {
        return By.xpath( "//*[@class='ui top attached two item menu']//*[contains(text(),'" + text + "')]" );
    }
}
