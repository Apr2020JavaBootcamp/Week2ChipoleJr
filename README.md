###Chipotle Jr. weekly challenge on Canvas 
This program will do the following:
1. Randomly generate a list of ingredients and combine them to make a burrito
2. Create 25 burritos and get the cost for each burrito
3. Output the price and ingredients used in each burrito, as well as the total number each ingredient used

#####Process:
<ol>
<li>
Variables
<ol>
<li>"Random random" to randomly generate ingredients</li>
<li>Multiple String arrays to store the various ingredients used in the burritos</li>
<li>"double price" to store the price of the burrito, starting at $3.00</li>
<li>"double totalPrice" to store the sum of the price of all the burritos</li>
<li>"String orderCall" to output the type of ingredients used, how many, and the total cost</li>
<li>"ArrayList String listOfIngredients" to store a list of specific ingredients used in each burrito</li>
<li>"ArrayList String burrito" contains a random list of five to nine ingredients, stored as String values. The ingredients are non-repeating</li>
<li>ArrayList(ArrayList(String)) order" contains all the burritos generated over the course of the program</li>
<li>HashMap(String, Integer) ingredientList" to count the number of ingredients used in the burritos</li>
<li>ArrayList(String[]) ingredients" stores all the String arrays in one ArrayList so they can be added to the burrito</li>
</ol>
</li>
FOR int i =0 to 25, exclusive

- Set burrito to a String ArrayList using the makeBurrito method
- Set price equal to a double using the calculatePrice method
- add price to totalPrice
- Add the burrito String ArrayList to the "order" ArrayList(String(ArrayList))
- Print out the contents of the burrito ArrayList and the price

<li>Set listOfIngredients to a ArrayList(String) using the getIngredientsList method</li>
<li>
FOR int i = 0 to the size of listOfIngredients

- Concatenate listOfIngredients.get(i) to the "orderCall" variable 
</li>
<li>Concatenate the totalPrice to the "orderCall" String and use the "wrap" method to make sure the String wraps around at the 50 character mark</li>
<li>Print out orderCall, which should now include the total number of ingredients and the total price</li>

</ol>

#####Methods
<ol>
<li>
ArrayList(String) makeBurrito

- This method takes the parameters (Random random, ArrayList(String[]) ingredients)
</li>
</ol>
