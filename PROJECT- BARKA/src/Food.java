public class Food{
    protected String recipeName;
    protected String recipeDescription;
    private String recipeImage;
    private double recipePrice;

    // creating a constructor
    public Food(String recipeName, String recipeDescription, String recipeImage, double recipePrice){
        if(recipeName == null || recipeDescription == null || recipeImage == null || recipePrice < 0){
            throw new IllegalArgumentException("The recipe name and description are required");
        }
        this.recipeName = recipeName;
        this.recipeDescription = recipeDescription;
        this.recipeImage = recipeImage;
        this.recipePrice = recipePrice;
    }

    public String getRecipeName(){
        return recipeName;
    }
    public String getRecipeDescription(){
        return recipeDescription;
    }
    public String getRecipeImage(){
        return recipeImage;
    }
    public double getRecipePrice(){
        return recipePrice;
    }

    public String toString(){
        return recipeName + "," + recipeDescription + "," + recipeImage + "," + recipePrice;
    }

}