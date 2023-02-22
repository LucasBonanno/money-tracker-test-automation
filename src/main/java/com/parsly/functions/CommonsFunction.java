package com.parsly.functions;

import com.parsly.configurations.SeleniumInteraction;
import com.parsly.pages.CommonsPage;
import org.junit.Assert;

public class CommonsFunction extends SeleniumInteraction {

    CommonsPage commonsPage = new CommonsPage();

    public void validateTheAccountData() {
        Assert.assertEquals( "AUTOMATION MSG: [validates if groupAccount is correct]", HomeFunction.getGroupAccount(), getText( commonsPage.accountGroupNameList( "1" ) ) );
        Assert.assertTrue( "AUTOMATION MSG: [validates if currencyAccount is correct]", getText( commonsPage.accountGroupTotalList( "1" ) ).contains( HomeFunction.getCurrencyAccount() ) );
        Assert.assertEquals( "AUTOMATION MSG: [validates if nameAccount is correct]", HomeFunction.getNameAccount(), getText( commonsPage.accountNameList( "1" ) ) );
        Assert.assertTrue( "AUTOMATION MSG: [validates if balanceAccount is correct]", getText( commonsPage.accountBalanceList( "1" ) ).contains( HomeFunction.getBalanceAccount() ) );
    }

    public void navigateToMenu( String menuName ) {
        locatorIsVisivel( commonsPage.verticalMenu( menuName ) );
        click( commonsPage.verticalMenu( menuName ) );
    }
}
