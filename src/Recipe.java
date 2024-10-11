import java.util.ArrayList;
import java.util.List;

abstract class OrientalKitchen {
    private String name;
    private List<String> ingredients;
    private String instructions;
    private String category;


    public OrientalKitchen(String name, List<String> ingredients, String instructions, String category) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.category = category;

    }
//Getters
    public String getName() {

        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getCategory() {
        return category;
    }
    // Abstract method to display recipes
    public abstract void displayRecipeDetails();
}







class OrientalKitchenRecipes extends OrientalKitchen {

    private String description;

    //Constructor
    public OrientalKitchenRecipes(String name, String description, List<String> ingredients, String instructions, String category) {
        super(name, ingredients, instructions, category);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public void displayRecipeDetails() {
        System.out.println("Recipe Name: " + getName());
        System.out.println("Description: " + getDescription());
        System.out.println("Ingredients: " + String.join(", ", getIngredients()));
        System.out.println("Instructions: " + getInstructions());
        System.out.println("Category: " + getCategory());
    }

    @Override
    public String toString() {
        return "Recipe name: " + getName() +
                "\nDescription: " + getDescription() +
                "\nIngredients: " + String.join(", " + getIngredients()) +
                "\nInstructions:" + getInstructions();

    }


    public static class MainDishRecipes extends OrientalKitchenRecipes {
        public MainDishRecipes(String name, String description, List<String> ingredients, String instructions) {
            super(name, description, ingredients, instructions, "Main Dishes");
        }
    }

    public static class DessertRecipes extends OrientalKitchenRecipes {
        public DessertRecipes(String name, String description, List<String> ingredients, String instructions) {
            super(name, description, ingredients, instructions, "Desserts");
        }
    }

    public static class SoupRecipes extends OrientalKitchenRecipes {
        public SoupRecipes(String name, String description, List<String> ingredients, String instructions) {
            super(name, description, ingredients, instructions, "Soups");
        }
    }

    public static class AppetizersAndSnacks extends OrientalKitchenRecipes {
        public AppetizersAndSnacks(String name, String description, List<String> ingredients, String instructions) {
            super(name, description, ingredients, instructions, "Appetizers And Snacks");
        }
    }

}
//Modify RecipesManager to use generics
class RecipesManager<T extends OrientalKitchenRecipes> {
    private ArrayList<T> recipes;

    public RecipesManager() {

        recipes = new ArrayList<>();
    }


    //Method to add recipes
    public void addRecipe(T recipe) {

        recipes.add(recipe);
    }

    public void removeRecipe(String name) {
        boolean removed = recipes.removeIf(recipe -> recipe.getName().equals(name));
        if (removed) {
            System.out.println("Recipe " + name + " removed.");
        } else {
            System.out.println("Recipe " + name + " do not exist.");
        }
    }

    public boolean searchRecipe(String name) {
        String lowerCaseName = name.toLowerCase();
        for (T recipe : recipes) {
            if (recipe.getName().toLowerCase().equals(lowerCaseName)) {
                return true;
            }
        }
        return false;
    }

    public T getRecipeByName(String name) {
        String lowerCaseName = name.toLowerCase();
        for (T recipe : recipes) {
            if (recipe.getName().toLowerCase().equals(lowerCaseName)) {
                return recipe;
            }
        }
        return null;
    }


    public void displayRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
            return;
        }
        for (T recipe : recipes) {
            System.out.println("------------------------------------------------");
            recipe.displayRecipeDetails();
        }
        System.out.println("------------------------------------------------");

    }
}






