import java.util.*;

public class Chipotle {
    public static void main (String[] args) {
        //Variables
        Random random = new Random();
        //These String arrays store the various ingredients in their own category
        String[] rice = {"white rice", "brown rice", "no rice", "all rice"};
        String[] meat = {"chicken", "steak", "carnidas", "chorizo", "sofritas", "veggie meat", "no meat", "all meat"};
        String[] beans = {"pinto beans", "black beans", "no beans", "all beans"};
        String[] salsa = {"mild salsa", "medium salsa", "hot salsa", "no salsa", "all salsa"};
        String[] veggies = {"lettuce", "fajitas", "no veggies", "all veggies"};
        String[] cheese = {"cheese"};
        String[] guac = {"guac"};
        String[] queso = {"queso"};
        String[] sourCream = {"sour cream"};

        double price = 3.00;            //base burrito costs $3.00 regardless of ingredients
        double totalPrice = 0;
        String orderCall = "";          //Store the type and number of ingredients used, and total cost
        //Stores specific ingredients used in each burrito so they can be totaled up later
        ArrayList<String> listOfIngredients = new ArrayList<String>();

        //Contains a random list of ingredients (5-9). The ingredients are non-repeating
        ArrayList<String> burrito = new ArrayList<String>();

        //2D ArrayList to store multiple "burritos"
        ArrayList<ArrayList<String>> order = new ArrayList<ArrayList<String>>();

        HashMap<String, Integer> ingredientList = new HashMap<String, Integer>();

        ArrayList<String[]> ingredients = new ArrayList<String[]>();
        ingredients.add(rice);
        ingredients.add(meat);
        ingredients.add(beans);
        ingredients.add(salsa);
        ingredients.add(veggies);
        ingredients.add(cheese);
        ingredients.add(guac);
        ingredients.add(queso);
        ingredients.add(sourCream);

        //creates 25 burritos and stores them in the "order" ArrayList and calculates total price
        for (int i = 0; i < 25; i++) {
            burrito = makeBurrito(random, ingredients);
            price = calculatePrice(burrito);
            totalPrice += price;
            order.add(burrito);
            System.out.println("Burrito " + (i + 1) + " " + burrito + " \t$" + price + "0");
        }

        //prints how many of each ingredient was used, as well as the total price
        listOfIngredients = getIngredientsList(order, ingredientList);
        orderCall += "This order has: ";
        for (int i = 0; i < listOfIngredients.size(); i++) {
            orderCall += listOfIngredients.get(i) + ", ";
        }
        orderCall += "and the sum is $" + totalPrice + "0";
        orderCall = wrap(orderCall, 50);
        System.out.println("\n" + orderCall);
    }

    public static ArrayList<String> makeBurrito(Random random, ArrayList<String[]> ingredients) {
        ArrayList<String> burrito = new ArrayList<String>();
        int numIngredients = 5 + random.nextInt(5);
        while (burrito.size() != numIngredients) {
            burrito = new ArrayList<String>();
            for (int i = 0; i < ingredients.size(); i++) {
                if (random.nextInt(2) == 1) {
                    burrito.add(ingredients.get(i)[random.nextInt(ingredients.get(i).length)]);
                }

            }

        }


        return burrito;
    }

    public static double calculatePrice (ArrayList<String> burrito) {
        double price = 3.00;
        for (int i = 0; i < burrito.size(); i++) {
            if (burrito.get(i).contains("no")) {
                continue;
            } else {
                price += 0.5;
            }
        }
        return price;
    }

    public static ArrayList<String> getIngredientsList (ArrayList<ArrayList<String>> order,
                                             HashMap<String, Integer> ingredientList) {
        ArrayList<String> ingredients = new ArrayList<String>();
        String ingredientName = "";         //Name of specific ingredient in the burrito, in the order
        for (int i = 0; i < order.size(); i++) {
            for (int j = 0; j < order.get(i).size(); j++) {
                ingredientName = order.get(i).get(j);        //Assigns name of specific ingredient in that loop cycle
                if (!ingredientList.containsKey(ingredientName) && !ingredientName.contains("no")) {
                    ingredientList.put(ingredientName, 1);
                } else if (ingredientList.containsKey(ingredientName)) {
                    ingredientList.replace(ingredientName, ingredientList.get(ingredientName) + 1);
                }
            }
        }

        for (String key: ingredientList.keySet()) {
            ingredients.add(ingredientList.get(key) + " " + key);
        }
        Collections.sort(ingredients);

        return ingredients;
    }

    public static String wrap (String str, int wrapLength) {
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while (i + wrapLength < sb.length() && (i = sb.lastIndexOf(" ", i + wrapLength)) != -1) {
            sb.replace(i, i + 1, "\n");
        }
        str = sb.toString();
        return str;
    }
}
