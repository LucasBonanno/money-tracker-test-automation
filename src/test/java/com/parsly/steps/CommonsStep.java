package com.parsly.steps;

import com.parsly.functions.CommonsFunction;
import io.cucumber.java.en.And;

public class CommonsStep {

    CommonsFunction commonsFunction = new CommonsFunction();

    @And( "validate the account data" )
    public void validateTheAccountData() {
        commonsFunction.validateTheAccountData();
    }

    @And( "navigate to menu {string}" )
    public void navigateToMenu( String menuName) {
        commonsFunction.navigateToMenu(menuName);
    }

    @And( "validate if total match with transaction" )
    public void validateIfTotalMatchWithTransaction() {
        commonsFunction.validateTotalMatchWithTransaction();
    }
}
