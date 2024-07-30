import java.io.*;
import java.util.*;

public class Recipe2 {
    private List<Food> foodList;

    public Recipe2() {
        foodList = new ArrayList<>();
    }

    public addFood(Food food){
        foodList.add(food);
    }

    //getters method for Food

    public List<Food> getFoodList() {
        return foodList;
    }

    public void saveToRecipeBook(String filename) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for(Food food:foodList){
                writer.write(food.toString());
                writer.newLine();
            }
        }
    }
}