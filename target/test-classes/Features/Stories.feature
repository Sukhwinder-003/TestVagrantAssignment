Feature: Automation Shopify 


Background: User is Logged In 
	Given User is on landing page"https://ecom-optimus.myshopify.com/" 
	When User login into application with password "idgad" 
	
	
Scenario: Search and add the same product to the cart 
	Then Search a product "Round Neck Shirt" 
	And Add "Round Neck Shirt" product into the cart 
	Then Quit the browser 
	
Scenario: Increase product quantity and validate the price 
	Then Search a product "Round Neck Shirt" 
	And Add "Round Neck Shirt" product into the cart 
	Then Go to View Cart screen 
	And Increase the quantity and verify price should get updated accordngly 
	Then Quit the browser 
	
	
Scenario: Add a product from the featured collection 

	Then Go to featured collection list 
	And Add a product "RoundNeck Shirt" from the featured collection in to a cart 
	Then Quit the browser 
	
	
Scenario: Add to cart, products with multiple sizes 

	Then Search a product "Round Neck Shirt" 
	And Add "Round Neck Shirt" product into the cart with multiple sizes 
	Then Quit the browser 
	
	
	
	
