import java.util.List;
import java.util.Scanner;

public class Main {
    //@TODO to creat a recipe program with a menu to add new recipe, display all recipes, and remove a recipe.

private static RecipesManager<OrientalKitchenRecipes> recipeMenu = new RecipesManager();
private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {


        System.out.println("*********************************************");
        System.out.println("***** Welcome to the Oriental Kitchen! *****");
        System.out.println("*********************************************\n");


        while (true) {
        System.out.println("----------------------------------------------");
        System.out.println("Let's start our oriental recipes!\n");
        System.out.println("1.Add a new recipe.");
        System.out.println("2.Search a recipe.");
        System.out.println("3.Remove a recipe.");
        System.out.println("4.Display all recipes.");
        System.out.println("5.Exit");
        System.out.println("*********************************************");
        System.out.print("Please enter your choice: ");

        if (!scanner.hasNextInt()) {
           System.out.println("Invalid input! Enter a number between 1 and 5.");
           scanner.nextLine();// Clear buffer
           continue;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: //Add a recipe
                addRecipe();
                break;

            case 2://Search a recipe
                searchRecipe();
                break;

            case 3://Remove a recipe
                removeRecipe();
                break;

            case 4://Display all recipes
                recipeMenu.displayRecipes();
                break;
            case 5:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice!");
        }

     }
  }
//Method to add recipes
//@TODO the recipe should contain title, list, ingredients, instructions.
public static void addRecipe(){


    System.out.println("Enter the recipe name: ");
    String recipeToAddName = scanner.nextLine();
    System.out.println("Enter the recipe description: ");
    String recipeToAddDescription = scanner.nextLine();
    System.out.println("Enter the recipe ingredients(comma-separated): ");
    String ingredientsInput = scanner.nextLine();
    List<String> recipeToAddIngredients=List.of(ingredientsInput.split(",\\*s "));
    System.out.println("Enter the recipe instructions: ");
    String recipeToAddInstructions = scanner.nextLine();
    System.out.println("Enter category:");
    System.out.println("1.Appetizers And Snacks ");
    System.out.println("2.Main Dish");
    System.out.println("3.Soup");
    System.out.println("4.Dessert");
    System.out.println("Please enter your category number(1-4): ");

    if (!scanner.hasNextInt()) {
        System.out.println("Invalid input! Category must be a number between 1 and 4.");
        scanner.nextLine();
        return;
    }
    int category = scanner.nextInt();
    scanner.nextLine();

    OrientalKitchenRecipes recipe;

        switch (category){
            case 1:
               recipe=new OrientalKitchenRecipes.AppetizersAndSnacks(recipeToAddName, recipeToAddDescription, recipeToAddIngredients, recipeToAddInstructions);
               break;
            case 2:
               recipe=new OrientalKitchenRecipes.MainDishRecipes(recipeToAddName, recipeToAddDescription, recipeToAddIngredients, recipeToAddInstructions);
               break;
            case 3:
               recipe=new OrientalKitchenRecipes.SoupRecipes(recipeToAddName, recipeToAddDescription, recipeToAddIngredients, recipeToAddInstructions);
               break;
            case 4:
               recipe=new OrientalKitchenRecipes.DessertRecipes(recipeToAddName, recipeToAddDescription, recipeToAddIngredients, recipeToAddInstructions);
               break;
            default:
               System.out.println("Invalid category number!");
              return;
    }

    recipeMenu.addRecipe(recipe);
    System.out.println("Recipe added successfully.");
}

//Method to search the recipe
public static void searchRecipe() {
    System.out.println("Enter the recipe name to search: ");
    String recipeToSearchName = scanner.nextLine();

    if(recipeMenu.searchRecipe(recipeToSearchName)){
        System.out.println("Recipe found!");
        OrientalKitchenRecipes recipe = recipeMenu.getRecipeByName(recipeToSearchName);
        recipe.displayRecipeDetails();
    }else {
            System.out.println("Recipe not found!");
        }
      }

//Method to remove a recipe
 public static void removeRecipe () {
    System.out.println("Enter the recipe name to remove: ");
    String recipeToRemoveName = scanner.nextLine();
    recipeMenu.removeRecipe(recipeToRemoveName);
    System.out.println("Recipe removed successfully.");
        }

    }



