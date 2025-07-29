import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class WeightedController {

    private int addWeightCategoryRow;
    FXCollections weights;

    public enum Categories { 
        TEST, 
        HOMEWORK, 
        ASSIGNMENT, 
        QUIZ, 
        PROJECT, 
        GROUP_PROJECT, 
        OTHER1, 
        OTHER2, 
        OTHER3 
    }

    @FXML
    private GridPane weightedCategoryGride;

    @FXML
    private Button addWeightCategoryButton;

    @FXML
    private Button setWeightCategoriesButton;

    @FXML
    public void initialize() {
        addWeightCategoryRow = GridPane.getRowIndex(addWeightCategoryButton);
    }

    public double getWeight() {
        return 0.00;
    }

    @FXML 
    private void addWeightCategoryPress(ActionEvent event) {       
        TextField newAssignmentNameTextField = new TextField();
        newAssignmentNameTextField.setPromptText("e.g. Test, Homework, Quiz");
        newAssignmentNameTextField.getStyleClass().add("input-field");
        newAssignmentNameTextField.setPrefWidth(250.0);
        newAssignmentNameTextField.setId("enterWeightCategory-" + (addWeightCategoryRow - 1));
        weightedCategoryGride.add(newAssignmentNameTextField, 0, addWeightCategoryRow);

        TextField newEarnedPointsTextField = new TextField();
        newEarnedPointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
        newEarnedPointsTextField.getStyleClass().add("input-field");
        newEarnedPointsTextField.setPrefWidth(250.0);
        newEarnedPointsTextField.setId("enterWeight-" + (addWeightCategoryRow - 1));
        weightedCategoryGride.add(newEarnedPointsTextField, 1, addWeightCategoryRow);

        Text newPercentageText = new Text("%");
        newPercentageText.getStyleClass().add("subtitle-text");
        weightedCategoryGride.add(newPercentageText, 2, addWeightCategoryRow);


        addWeightCategoryRow++;
        GridPane.setRowIndex(addWeightCategoryButton, addWeightCategoryRow);
    }

    @FXML 
    private void setWeightCategoriesPress(ActionEvent event) {
        // assignmentNames = new String[addAnotherAssignmentRow];
        // possibleEarned = new Double[addAnotherAssignmentRow];
        // possiblePoints = new Double[addAnotherAssignmentRow];

        // System.out.println("\n--- Collected Grades ---");
        // for (int i = 0; i < addAnotherAssignmentRow - 1; i++) {
        //     TextField nameField = (TextField) cumlativePointsInput.lookup("#enterAssignmentName-" + i);
        //     TextField earnedField = (TextField) cumlativePointsInput.lookup("#enterPointsEarned-" + i);
        //     TextField possibleField = (TextField) cumlativePointsInput.lookup("#enterPossiblePoints-" + i);

        //     String name = (nameField != null) ? nameField.getText() : "";
        //     String earnedText = (earnedField != null) ? earnedField.getText() : "";
        //     String possibleText = (possibleField != null) ? possibleField.getText() : "";

        //     assignmentNames[i] = name;
        //     try {
        //         possibleEarned[i] = Double.parseDouble(earnedText);
        //         possiblePoints[i] = Double.parseDouble(possibleText);
        //     } catch (NumberFormatException e) {
        //         System.err.println("Invalid number format for assignment in row " + i + ": " + e.getMessage());
        //         possibleEarned[i] = 0.0; 
        //         possiblePoints[i] = 0.0; 
        //     }   
        
        //     System.out.println("Assignment: " + assignmentNames[i] +
        //                        ", Earned: " + possibleEarned[i] +
        //                        ", Possible: " + possiblePoints[i]);
        // }
        // System.out.println("------------------------\n");
    }

    @FXML    
    private void backButtonPress(ActionEvent event) {       
         try {
            Main.setRoot("menu_scene");
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println("Failed to switch to Class Info Scene.");
        }
    }
}
