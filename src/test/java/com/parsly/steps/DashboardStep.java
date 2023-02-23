package com.parsly.steps;

import com.parsly.functions.DashboardFunction;
import com.parsly.functions.HomeFunction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardStep {

    DashboardFunction dashboardFunction = new DashboardFunction();
    @And( "navigate to Dashboard" )
    public void navigateToDashboard( ) {
        dashboardFunction.navigateToDashboard();
    }

    @When( "make an {string} transaction with value {int}" )
    public void makeAnTransactionWithValue( String transactionType, int value ) {
        dashboardFunction.makeTransaction(transactionType, value);

    }

    @Then( "validate transaction" )
    public void validateTransaction() {
        dashboardFunction.validateTransaction();
    }

    @And( "the calculation done" )
    public void theCalculationDone() {
        dashboardFunction.validateCalculation();
    }
}
