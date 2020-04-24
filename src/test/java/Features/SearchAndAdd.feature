Feature: Automation Shopify

#Scenario: Search and add the same product to the cart
#Given User is on landing page"https://ecom-optimus.myshopify.com/"
#When User login into application with password "idgad" 
#Then Search a product "Round Neck Shirt"
#And Add "Round Neck Shirt" product into the cart
#Then Quit the browser


Scenario: Increase product quantity and validate the price
Given User is on landing page"https://ecom-optimus.myshopify.com/"
When User login into application with password "idgad" 
Then Search a product "Round Neck Shirt"
And Add "Round Neck Shirt" product into the cart
Then Go to View Cart screen
And Check the price for the current item
Then Increase the quantity and verify price should get updated accordngly



#Scenario: Add a product from the featured collection
#Given User is on landing page"https://ecom-optimus.myshopify.com/"
#When User login into application with password "idgad" 
#Then Go to featured collection list
#And Add a product "RoundNeck Shirt" from the featured collection in to a cart
#Then Quit the browser


#Scenario: Add to cart, products with multiple sizes
#Given User is on landing page"https://ecom-optimus.myshopify.com/"
#When User login into application with password "idgad" 
#Then Search a product "Round Neck Shirt"
#And Add "Round Neck Shirt" product into the cart with multiple sizes
#Then Quit the browser