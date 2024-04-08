Feature: Placing an order online

Scenario: To validate if an order can be placed online and get the Order ID
When Click Shop now button
And Click Products under Hair Products section
And Click Hair Beauty Bath product
And Click Add to cart button
And Navigate to Cart 
And Check out the product
And Select Shipping Method as Worldwide - 5.00 USD
And Click Make payment
Then Verify if the order is placed and get the Order ID