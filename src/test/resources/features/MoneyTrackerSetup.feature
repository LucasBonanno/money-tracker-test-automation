# language: en

@RegressionTests
Feature: Money Tracker Setup

  Background:
    Given Given that the user has access to the system

  @CreateAccount
  Scenario: Should Create Account
    And select base currency "BRL"
    When create account with data
      | NAME         | GROUP        | BALANCE |
      | Account Name | Bank Account | 100     |
    Then validates that the account was created
    And validate the account data
    And navigate to Dashboard
    And validate the account data
    And navigate to menu "Accounts"
    And validate the account data

  @EditAccount
  Scenario: Should Edit Account
    And select base currency "USD"
    When create account with data
      | NAME         | GROUP | BALANCE |
      | Account Name | EMPTY | EMPTY   |
    And validates that the account was created
    Then edit account created
    And validate the account data
    And navigate to Dashboard
    And validate the account data
    And navigate to menu "Accounts"
    And validate the account data

  @TransactionAccount
  Scenario Outline: Should Make a Expense Transaction
    And select base currency "<CURENCY>"
    And create account with data
      | NAME   | GROUP   | BALANCE   |
      | <NAME> | <GROUP> | <BALANCE> |
    And validates that the account was created
    And validate the account data
    And navigate to Dashboard
    When make an "Expense" transaction with value 30
    Then validate transaction
    And the calculation done
    And navigate to menu "Transactions"
    And validate transaction
    And validate if total match with transaction

    Examples:
      | CURENCY | NAME         | GROUP        | BALANCE |
      | USD     | Account Name | Bank Account | 20000   |
      | USD     | Account Name | Bank Account | 100     |
      | BRL     | Account Name | Bank Account | 100     |
