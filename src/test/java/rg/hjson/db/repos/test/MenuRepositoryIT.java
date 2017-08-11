package rg.hjson.db.repos.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import rg.hjson.Application;
import rg.hjson.db.repos.MenuRepository;
import rg.hjson.entities.Dish;
import rg.hjson.entities.Ingredient;
import rg.hjson.entities.Menu;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Application.class)
@TestPropertySource(locations = "classpath:test.properties")
public class MenuRepositoryIT {

    @Autowired
    private MenuRepository menuRepository;

    private Ingredient getIngredient(String ingredientName) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientName);
        ingredient.setCalories(42);
        return ingredient;
    }

    private List<Ingredient> getIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(getIngredient("First test ingredient"));
        ingredients.add(getIngredient("Second test ingredient"));
        return ingredients;
    }

    private Dish getDishWithIngredients() {
        Dish dish = new Dish();
        dish.setName("Test dish with ingredients");
        dish.setIngredients(getIngredients());
        return dish;
    }

    private Menu getMenu() {
        Menu menu = new Menu();
        menu.setDish(getDishWithIngredients());
        return menu;
    }

    @Test
    public void shouldSaveMenuWithDish() {
        menuRepository.save(getMenu());
    }

    @Test
    public void shouldRetrieveAlreadySavedMenus() {
        menuRepository.findAll().forEach(menu ->
                System.out.println(menu.getMenuId())
        );
    }
}
