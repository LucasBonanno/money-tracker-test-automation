package com.parsly.pages;

import org.openqa.selenium.By;

public class CommonsPage {

    public final By logo = By.xpath( "//*[@class='logo']" );
    public final By listboxDropDown = By.xpath(" //label[contains(text(),'Group')]//following-sibling::div");

    public By button( String text ) {
        return By.xpath( "//button[contains(text(),'" + text + "')]" );
    }

    public By header( String text ) {
        return By.xpath( "//*[@class='ui header']//*[contains(text(),'" + text + "')]" );
    }

    public By verticalMenu( String text ) {
        return By.xpath( "//nav[@class='open']//a[contains(text(),'" + text + "')] " );
    }

    public By accountGroupNameList( String position ) {
        return By.xpath( "(//*[@class='account-widget-group__name'])[" + position + "]" );
    }

    public By accountGroupTotalList( String position ) {
        return By.xpath( "(//*[@class='account-widget-group__total']//span)[" + position + "]" );
    }

    public By accountNameList( String position ) {
        return By.xpath( "(//*[@class='account-widget-account__name']//a)[" + position + "]" );
    }

    public By accountBalanceList( String position ) {
        return By.xpath( "(//*[@class='account-widget-account__balance']//span)[" + position + "]" );
    }

    public By accountEditButtonList( String position ) {
        return By.xpath( "(//*[@class='account-widget-account__edit']//button)[" + position + "]" );
    }

    public By transactionItem( String position ) {
        return By.xpath( "(//*[@class='transaction-item__info'])[" + position + "]" );
    }

    public By transactionAmount( String position ) {
        return By.xpath( "(//*[@class='transaction-item__amount'])[" + position + "]" );
    }

    public By total( String transactionType ) {
        return By.xpath( "//td[contains(text(),'" + transactionType + "')]/following-sibling::td" );

    }

}
