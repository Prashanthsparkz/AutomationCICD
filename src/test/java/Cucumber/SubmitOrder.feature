
@tag
Feature: Purchase the order from Ecomm Website
  I want to use this template for my feature file

Background:
Given I land on the Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of submitting an order
    Given Logged in with username <name> and password <password>
    When I add the product <product> to cart
    And Checkout <product> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | name              | password       | product       |
      | sparkz1@gmail.com | Sparkz1234 |ADIDAS ORIGINAL|
      
