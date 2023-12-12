Feature: feature to Validate Iphone

@test3
	Scenario: Validate Iphone in Cart
    Given user is on Home page
    When user searches Iphone
    And user add iphone to cart
    Then validate Iphone in cart

