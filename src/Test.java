import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


//@TODO at least 3 JUnit tests
class RecipesManagerTest {
    private RecipesManager<OrientalKitchenRecipes> recipesManager;

    @BeforeEach
    void setUp() {
        recipesManager = new RecipesManager<>();
    }

    @Test
    void testAddRecipe() {
        OrientalKitchenRecipes recipes=new OrientalKitchenRecipes.MainDishRecipes(
                "Chicken Karaage",
                "Japanese style crispy chicken",
                Arrays.asList("Chicken thigh fillet cut into large bite-size pieces","Potato flour","Oil for deep-frying"),
                "Marinate chicken med soy sauce and Mirin for 1 hour , coat the chicken with potato flour then deep-fry 5 minutes.");
        recipesManager.addRecipe(recipes);
        assertTrue(recipesManager.searchRecipe("Chicken Karaage"));
    }

    @Test
    void testRemoveRecipe() {
        OrientalKitchenRecipes recipes=new OrientalKitchenRecipes.MainDishRecipes(
                "Chicken Karaage",
                "Japanese style crispy chicken",
                Arrays.asList("Chicken thigh fillet cut into large bite-size pieces","Potato flour","Oil for deep-frying"),
                "Marinate chicken med soy sauce and Mirin for 1 hour , coat the chicken with potato flour then deep-fry 5 minutes.");
        recipesManager.addRecipe(recipes);
        recipesManager.removeRecipe("Chicken Karaage");
        assertFalse(recipesManager.searchRecipe("Chicken Karaage"));
    }

    @Test
    void testSearchRecipe() {
        OrientalKitchenRecipes recipes=new OrientalKitchenRecipes.MainDishRecipes(
                "Chicken Karaage",
                "Japanese style crispy chicken",
                Arrays.asList("Chicken thigh fillet cut into large bite-size pieces","Potato flour","Oil for deep-frying"),
                "Marinate chicken med soy sauce and Mirin for 1 hour , coat the chicken with potato flour then deep-fry 5 minutes.");
        recipesManager.addRecipe(recipes);
        assertTrue(recipesManager.searchRecipe("Chicken Karaage"));
        assertFalse(recipesManager.searchRecipe("Sukiyaki"));
    }

    @Test
    void testGetRecipeByName() {
        OrientalKitchenRecipes recipes=new OrientalKitchenRecipes.MainDishRecipes(
                "Chicken Karaage",
                "Japanese style crispy chicken",
                Arrays.asList("Chicken thigh fillet cut into large bite-size pieces","Potato flour","Oil for deep-frying"),
                "Marinate chicken med soy sauce and Mirin for 1 hour , coat the chicken with potato flour then deep-fry 5 minutes.");
        recipesManager.addRecipe(recipes);
        OrientalKitchenRecipes foundRecipe=recipesManager.getRecipeByName("Chicken Karaage");
        assertNotNull(foundRecipe);
        assertEquals("Chicken Karaage", foundRecipe.getName());
        assertEquals("Japanese style crispy chicken", foundRecipe.getDescription());
    }

}