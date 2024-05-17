package org.tp_recipes.DAO.impl;

import org.tp_recipes.DAO.AbstractDAO;
import org.tp_recipes.entity.IngredientRecipe;
import org.tp_recipes.entity.Recipe;
import org.tp_recipes.entity.Step;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO extends AbstractDAO<Recipe> {

    private final CategoryDAO categoryDAO;
    private final IngredientRecipeDAO ingredientDAO;
    private final StepDAO stepDAO;

    public RecipeDAO() throws SQLException {
        categoryDAO = new CategoryDAO();
        ingredientDAO = new IngredientRecipeDAO();
        stepDAO = new StepDAO();
    }

    @Override
    public Recipe save(Recipe element) throws SQLException {
        try {
            connect();
            statement = connection.prepareStatement("""
                    INSERT INTO recipe (title, preparation_time, cooking_time, difficulty, id_category)
                    VALUES (?, ?, ?, ?, ?)
                    """,
                    Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, element.getTitle());
            statement.setInt(2, element.getPreparationTime());
            statement.setInt(3, element.getCookingTime());
            statement.setInt(4, element.getDifficulty());
            statement.setInt(5, element.getCategory().getId());
            if (statement.executeUpdate() != 1) {
                throw new SQLException();
            }
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                element.setId(resultSet.getInt(1));
            }
            connection.commit();
            if (element.getIngredients() != null) {
                List<IngredientRecipe> ingredients = new ArrayList<>();
                element.getIngredients().forEach(ingredient ->
                    ingredients.add(IngredientRecipe.builder()
                            .idRecipe(element.getId())
                            .idIngredient(ingredient.getId())
                            .quantity(ingredient.getQuantity())
                            .build())
                );
                ingredientDAO.saveMultiple(ingredients);
            }
            if (element.getSteps() != null) {
                element.getSteps().forEach(step -> step.setIdRecipe(element.getId()));
                stepDAO.saveMultiple(element.getSteps());
            }
            return element;
        } catch (SQLException e) {
            connection.rollback();
            return null;
        } finally {
            close();
        }
    }

    @Override
    public Recipe update(Recipe element) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Recipe element) throws SQLException {
        return false;
    }

    @Override
    public Recipe get(int id) throws SQLException {
        Recipe recipe = null;
        connect();
        statement = connection.prepareStatement("""
                SELECT r.*, c.* FROM recipe as r
                    INNER JOIN category as c ON r.id_category = c.id
                    WHERE r.id = ? ;
                """
        );
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        if (resultSet.next()) {
            recipe = Recipe.builder()
                    .id(resultSet.getInt("id"))
                    .title(resultSet.getString("title"))
                    .preparationTime(resultSet.getInt("preparation_time"))
                    .cookingTime(resultSet.getInt("cooking_time"))
                    .difficulty(resultSet.getInt("difficulty"))
                    .ingredients(
                            ingredientDAO.getAllIngredientByIdRecipe(
                                    resultSet.getInt("id")
                            )
                    )
                    .steps(stepDAO.getAllByIdRecipe(resultSet.getInt("id")))
                    .build();
        }
        close();
        return recipe;
    }

    @Override
    public List<Recipe> getAll() throws SQLException {
        List<Recipe> recipes = new ArrayList<>();
        connect();
        statement = connection.prepareStatement("SELECT * FROM recipe");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            recipes.add(
                    Recipe.builder()
                            .id(resultSet.getInt("id"))
                            .title(resultSet.getString("title"))
                            .preparationTime(resultSet.getInt("preparation_time"))
                            .cookingTime(resultSet.getInt("cooking_time"))
                            .difficulty(resultSet.getInt("difficulty"))
                            .category(categoryDAO.get(resultSet.getInt("id_category")))
                            .ingredients(
                                    ingredientDAO.getAllIngredientByIdRecipe(
                                            resultSet.getInt("id")
                                    )
                            )
                            .steps(stepDAO.getAllByIdRecipe(resultSet.getInt("id")))
                            .build()
            );
        }
        return recipes;
    }

}
