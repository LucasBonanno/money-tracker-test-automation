package com.parsly.functions;

import com.parsly.configurations.SeleniumInteraction;
import com.parsly.pages.CommonsPage;
import com.parsly.pages.HomePage;
import io.cucumber.datatable.DataTable;
import lombok.Getter;

import java.util.List;
import java.util.Map;

public class HomeFunction extends SeleniumInteraction {

    private static final String EMPTY = "EMPTY";
    @Getter
    private static String currencyAccount = null;
    @Getter
    private static String nameAccount = null;
    @Getter
    private static String groupAccount = null;
    @Getter
    private static String balanceAccount = null;
    HomePage homePage = new HomePage();
    CommonsPage commonsPage = new CommonsPage();

    public void validateHomePageLoaded() {
        locatorIsVisivel( homePage.moneyTrackerSetup );
        locatorIsVisivel( homePage.labelComponentBox( "Base Currency" ) );
        locatorIsVisivel( homePage.labelComponentBox( "Additional Currencies (optional)" ) );
        locatorIsVisivel( homePage.labelComponentBox( "Name" ) );
        locatorIsVisivel( commonsPage.listboxDropDown );
        locatorIsVisivel( homePage.accountsBalance );
        locatorIsVisivel( commonsPage.button( "Save Account" ) );
    }

    public void createAccount( DataTable dt ) {
        List< Map< String, String > > list = dt.asMaps( String.class, String.class );
        for( Map< String, String > item : list ) {
            this.nameAccount = item.get( "NAME" );
            this.groupAccount = item.get( "GROUP" ).equals( EMPTY ) ? "Cash" : item.get( "GROUP" );
            this.balanceAccount = item.get( "BALANCE" ).equals( EMPTY ) ? "0,00" : item.get( "BALANCE" );
        }

        write( homePage.labelComponentBox( "Name" ), nameAccount );
        click( commonsPage.listboxDropDown );
        locatorIsVisivel( homePage.accountsGroupListOption( groupAccount ) );
        click( homePage.accountsGroupListOption( groupAccount ) );
        write( homePage.accountsBalance, balanceAccount );
        click( commonsPage.button( "Save Account" ) );
    }

    public void validateAccountCreated() {
        scrollIntoView();
        locatorIsVisivel( commonsPage.button( "Finish" ) );
        locatorIsVisivel( commonsPage.accountGroupNameList( "1" ) );
        locatorIsVisivel( commonsPage.accountGroupTotalList( "1" ) );
        locatorIsVisivel( commonsPage.accountNameList( "1" ) );
        locatorIsVisivel( commonsPage.accountBalanceList( "1" ) );
        locatorIsVisivel( commonsPage.accountEditButtonList( "1" ) );
    }

    public void selectBaseCurrency( String currency ) {
        this.currencyAccount = currency;
        click( homePage.labelComponentBox( "Base Currency" ) );
        writeAndEnter( homePage.labelComponentBox( "Base Currency" ), currency );
    }

    public void editAccount() {
        click( commonsPage.accountEditButtonList( "1" ) );
        this.nameAccount = this.nameAccount + " edited";
        write( homePage.labelComponentBox( "Name" ), this.nameAccount );
        click( commonsPage.button( "Save Account" ) );
    }

}
