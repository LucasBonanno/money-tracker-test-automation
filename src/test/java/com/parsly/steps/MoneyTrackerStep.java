package com.parsly.steps;

import com.parsly.functions.CommonsFunction;
import com.parsly.functions.HomeFunction;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoneyTrackerStep {
    HomeFunction homeFunction = new HomeFunction();

    @Given("Given that the user has access to the system")
    public void userVerifiesVAPageIsDisplayed() {
        homeFunction.validateHomePageLoaded();
    }

    @When( "create account with data" )
    public void createAccountWithData( DataTable dt ) {
        homeFunction.createAccount( dt );
    }

    @Then( "validates that the account was created" )
    public void validatesThatTheAccountWasCreated() {
        homeFunction.validateAccountCreated();
    }

    @And( "select base currency {string}" )
    public void selectBaseCurrency( String currency ) {
        homeFunction.selectBaseCurrency(currency);
    }

    @Then( "edit account created" )
    public void editAccountCreated() {
        homeFunction.editAccount();
    }

}
