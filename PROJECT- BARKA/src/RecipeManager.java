import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RecipeManager extends JFrame {
    private Recipe2 recipe2;
    private JTextField recipeName;
    private JTextField reipeDescription;
    private JTextField recipeImage;
    private JTextField recipePrice;
    private JTextArea displayArea;

    public RecipeManager() {
        super("Recipe Manager");

        Recipe2 = new Recipe2

         setTitle("Recipe Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new Jscrollpane(displayArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        inputPanel.add(new JLabel("Recipe Name:"));
        recipeName = new JTextField();
        inputPanel.add(recipeName);

        inputPanel.add(new JLabel("Recipe Description:"));
        reipeDescription = new JTextField();
        inputPanel.add(reipeDescription);

        inputPanel.add(new JLabel("Image:"));
        recipeImage= new JTextField();
        inputPanel.add(recipeImage);

        inputPanel.add(new JLabel("Price:"));
        recipePrice= new JTextField();
        inputPanel.add(recipePrice);

        JButton addButton = new JButton("Add Recipe");
        addButton.addActionListener(new AddButtonListener());
        inputPanel.add(addButton);

        JButton saveButton = new JButton("Save to File");
        saveButton.addActionListener(new SaveButtonListener());
        inputPanel.add(saveButton);

        add(inputPanel, BorderLayout.SOUTH);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String recipe = recipeName.getText();
                String description = reipeDescription.getText();
                String image = recipeImage.getText();
                String price = recipePrice.gerText();
                Food food = new Food(recipeName, reipeDescription,recipeImage, recipePrice);
                Recipe2.addFood(food);
                displayArea.append(food.toString() + "\n");
                titleField.setText("");
                authorField.setText("");
                isbnField.setText("");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(LibraryApp.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {recipe2.saveFile("recipe.txt");
                JOptionPane.showMessageDialog(LibraryApp.this, "recipe saved to file.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(LibraryApp.this, "Error saving to file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RecipeManager.setVisible(true);
            }
        });
    }
}

}