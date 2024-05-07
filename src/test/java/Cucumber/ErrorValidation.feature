
@tag
Feature: Error Validation
  I want to use this template for my feature file

Background:
Given I land on the Ecommerce Page

  @Errorvalidation
  Scenario Outline: Positive Test of submitting an order
    Given Logged in with username <name> and password <password>
    Then "Incorrect email or password." message is displayed on login page

    Examples: 
      | name              | password       |
      | sparkz1@gmail.com | Sparkz12345    | 
      
