import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class WeightedController {
    private int addWeightCategoryRow;
    private boolean readyToCalcualteGrade = false;
    private String[][] weightInfoAsStrings;
    FXCollections weights;

    @FXML
    private GridPane weightedCategoryGride;

    @FXML
    private GridPane gradePointsGrid;
    
    @FXML
    private VBox weightPointsInput;
    
    @FXML
    private Button addWeightCategoryButton;

    @FXML
    private Button weightCategoriesButton;

    @FXML
    public void initialize() {
        addWeightCategoryRow = GridPane.getRowIndex(addWeightCategoryButton);
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
    private void toggleOnWeightCategoriesInputs(ActionEvent event) {
        if (weightCategoriesButton.getText().equals("Set Weighted Categories")) {
            setWeightCategoriesPress();

            Alert explainHowToUse = new Alert(AlertType.CONFIRMATION);
            explainHowToUse.setHeaderText(null);
            explainHowToUse.setContentText("For Weighted Grade Categories:\n"
                                                    + "•  Possible Points: Enter the TOTAL points available for ALL assignments in this category.\n"
                                                    + "•  Points Earned: Enter your TOTAL points earned for ALL assignments in this category.\n"
                                                    + "If you're having trouble calculating these totals, use the Cumulative Calculator for this specific category.");
            explainHowToUse.showAndWait(); 
        } else if (weightCategoriesButton.getText().equals("Change Weight Categories")) {
            unsetWeightCategoriesPress();
        } else {
            System.err.println("Unable to inpute weighted categories\n Button text: " + weightCategoriesButton.getText());
        }
    }

    private void setWeightCategoriesPress() {
        weightInfoAsStrings = new String[2][addWeightCategoryRow];

        for (int i = 0; i < addWeightCategoryRow - 1; i++) {
            TextField categoryName = (TextField) weightedCategoryGride.lookup("#enterWeightCategory-" + i);

            String name = (categoryName != null) ? categoryName.getText() : "";

            weightInfoAsStrings[0][i] = name;
            System.out.print(weightInfoAsStrings[0][i] + " ");
            categoryName.setDisable(true);
        }

        System.out.println();

        for (int i = 0; i < addWeightCategoryRow - 1; i++) {
            TextField categoryWeight = (TextField) weightedCategoryGride.lookup("#enterWeight-" + i);

            String earnedText = (categoryWeight != null) ? categoryWeight.getText() : "";

            weightInfoAsStrings[1][i] = earnedText;
            System.out.print(weightInfoAsStrings[1][i] + " ");
            categoryWeight.setDisable(true);
        }

        addWeightCategoryButton.setDisable(true);
        createAssignmentInputGrid();
        weightPointsInput.setVisible(true);
        weightPointsInput.setManaged(true);

        weightCategoriesButton.setText("Change Weight Categories");
    }

    private void unsetWeightCategoriesPress() {
        for (int i = 0; i < addWeightCategoryRow - 1; i++) {
            TextField categoryName = (TextField) weightedCategoryGride.lookup("#enterWeightCategory-" + i);
            categoryName.setDisable(false);

            TextField categoryWeight = (TextField) weightedCategoryGride.lookup("#enterWeight-" + i);
            categoryWeight.setDisable(false);
        } 
        addWeightCategoryButton.setDisable(false);
        weightPointsInput.setVisible(false);
        weightPointsInput.setManaged(false);
        weightCategoriesButton.setText("Set Weighted Categories");
    }

    private void createAssignmentInputGrid() {
        for (int i = 2; i <= addWeightCategoryRow - 1; i++) {

            // ComboBox newWeightCategoryBox = new ComboBox<>();
           
            TextField newAssignmentNameTextField = new TextField();
            newAssignmentNameTextField.setPromptText("e.g. Test 1, Global Project");
            newAssignmentNameTextField.getStyleClass().add("input-field");
            newAssignmentNameTextField.setPrefWidth(250.0);
            newAssignmentNameTextField.setId("enterAssignmentName-" + (i - 1));
            gradePointsGrid.add(newAssignmentNameTextField, 0, i);

            TextField newEarnedPointsTextField = new TextField();
            newEarnedPointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
            newEarnedPointsTextField.getStyleClass().add("input-field");
            newEarnedPointsTextField.setPrefWidth(250.0);
            newEarnedPointsTextField.setId("enterPointsEarned-" +  (i - 1));
            gradePointsGrid.add(newEarnedPointsTextField, 1, i);

            Text newDivisionText = new Text("/");
            newDivisionText.getStyleClass().add("subtitle-text");
            gradePointsGrid.add(newDivisionText, 2, i);

            TextField newPossiblePointsTextField = new TextField();
            newPossiblePointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
            newPossiblePointsTextField.getStyleClass().add("input-field");
            newPossiblePointsTextField.setPrefWidth(250.0);
            newPossiblePointsTextField.setId("enterPossiblePoints-" +  (i - 1));
            gradePointsGrid.add(newPossiblePointsTextField, 3, i);
        }
    }

    @FXML
    private void addAnotherAssignmentButtonPress(ActionEvent event) {
        // TextField newAssignmentNameTextField = new TextField();
        // newAssignmentNameTextField.setPromptText("e.g. Test 1, Global Project");
        // newAssignmentNameTextField.getStyleClass().add("input-field");
        // newAssignmentNameTextField.setPrefWidth(250.0);
        // newAssignmentNameTextField.setId("enterAssignmentName-" + (addAnotherAssignmentRow - 1));
        // cumlativePointsInput.add(newAssignmentNameTextField, 0, addAnotherAssignmentRow);

        // TextField newEarnedPointsTextField = new TextField();
        // newEarnedPointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
        // newEarnedPointsTextField.getStyleClass().add("input-field");
        // newEarnedPointsTextField.setPrefWidth(250.0);
        // newEarnedPointsTextField.setId("enterPointsEarned-" + (addAnotherAssignmentRow - 1));
        // cumlativePointsInput.add(newEarnedPointsTextField, 1, addAnotherAssignmentRow);

        // Text newPercentageText = new Text("/");
        // newPercentageText.getStyleClass().add("subtitle-text");
        // cumlativePointsInput.add(newPercentageText, 2, addAnotherAssignmentRow);

        // TextField newPossiblePointsTextField = new TextField();
        // newPossiblePointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
        // newPossiblePointsTextField.getStyleClass().add("input-field");
        // newPossiblePointsTextField.setPrefWidth(250.0);
        // newPossiblePointsTextField.setId("enterPossiblePoints-" + (addAnotherAssignmentRow - 1));
        // cumlativePointsInput.add(newPossiblePointsTextField, 3, addAnotherAssignmentRow);


        // addAnotherAssignmentRow++;
        // GridPane.setRowIndex(addAnotherAssignmentButton, addAnotherAssignmentRow);
    }

    @FXML
    private void calculateButtonPress(ActionEvent event) {
        if (!readyToCalcualteGrade) { return; }
        // loadGradesIntoArray();
        // calculateAndDisplayGrade();
    }
}
