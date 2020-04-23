Feature: Automation Shopify

Scenario: Search and add the same product to the cart
Given User is on landing page"https://ecom-optimus.myshopify.com/"
When User login into application with password "idgad" 
Then Home Page screen populated
And Search a product
Then Add the same product into the cart