package com.parsly.functions;

import com.parsly.configurations.SeleniumInteraction;
import com.parsly.pages.CommonsPage;
import com.parsly.pages.DashboardPage;
import com.parsly.pages.HomePage;
import org.junit.Assert;

public class DashboardFunction extends SeleniumInteraction {

    private static int result = 0;
    HomePage homePage = new HomePage();
    CommonsPage commonsPage = new CommonsPage();
    DashboardPage dashboardPage = new DashboardPage();

    public void navigateToDashboard() {
        click( commonsPage.button( "Finish" ) );
        locatorIsVisivel( commonsPage.logo );
        locatorIsVisivel( commonsPage.header( "Dashboard" ) );

    }

    public void makeTransaction( String transactionType, int value ) {
        click( dashboardPage.transactionTypeForm( transactionType ) );
        write( dashboardPage.transactionFormValue, String.valueOf( value ) );
        click( dashboardPage.buttonForm );
        calculateTransaction( transactionType, value );
    }

    private void calculateTransaction( String transactionType, int value ) {
        if( transactionType.equals( "Expense" ) ) {
            result = Integer.parseInt( HomeFunction.getBalanceAccount() ) - value;
        } else if( transactionType.equals( "Income" ) ) {
            result = Integer.parseInt( HomeFunction.getBalanceAccount() ) + value;
        } else {
            Assert.fail( "AUTOMATION MSG: [Transaction type not recognized or does not exist]" );
        }
    }

    public void validateTransaction() {
        locatorIsVisivel( commonsPage.transactionItem( "1" ) );
        locatorIsVisivel( commonsPage.transactionAmount( "1" ) );
    }

    public void validateCalculation() {
        Assert.assertTrue( "AUTOMATION MSG: [validates if balanceAccount is correct]",
                getText( commonsPage.accountBalanceList( "1" ) ).contains( String.valueOf( result ) ) );

    }
}
