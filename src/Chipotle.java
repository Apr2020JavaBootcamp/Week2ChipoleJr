import java.util.*;

public class Chipotle {
    public static void main (String[] args) {
        String[] rice = {"white rice", "brown rice", "no rice", "all rice"};
        String[] meat = {"chicken", "steak", "carnidas", "chorizo", "sofritas", "veggie meat", "no meat", "all meat"};
        String[] beans = {"pinto beans", "black beans", "no beans", "all beans"};
        String[] salsa = {"mild salsa", "medium salsa", "hot salsa", "no salsa", "all salsa"};
        String[] veggies = {"lettuce", "fajitas", "no veggies", "all veggies"};
        String[] cheese = {"cheese"};
        String[] guac = {"guac"};
        String[] queso = {"queso"};
        String[] sourCream = {"sour cream"};

        int five = 0, six = 0, seven = 0, eight = 0, nine = 0;


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

        Random random = new Random();
        double price = 3.00;
        ArrayList<String> burrito = new ArrayList<String>();

        /*  Used to make sure that the number of ingredients was truly random
        for (int i = 0; i < 1000; i++) {
            burrito = makeBurrito(random, ingredients);
            switch (burrito.size()) {
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
                case 7:
                    seven++;
                    break;
                case 8:
                    eight++;
                    break;
                case 9:
                    nine++;
                    break;
                default:
                    break;
            }
            //System.out.println("Burrito " + (i + 1) + " " + burrito);
        }
         */


        for (int i = 0; i < 25; i++) {
            burrito = makeBurrito(random, ingredients);
            price = calculatePrice(burrito);
            System.out.println("Burrito " + (i + 1) + " " + burrito + " \t$" + price + "0");
        }

    }

    public static ArrayList<String> makeBurrito(Random random, ArrayList<String[]> ingredients) {
        ArrayList<String> burrito = new ArrayList<String>();
        boolean enoughIngredients = false;
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
}
