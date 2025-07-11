import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.IOException; // Required for FXMLLoader

public class ClassInfoController {
    private String studentName;
    private String studentClassCode;

    @FXML
    private TextField enterStudentName;

    @FXML
    private TextField enterClassCode;

    @FXML
    private ToggleGroup gradingMethod;

    @FXML
    private RadioButton cumulativePoints;

    @FXML
    private GridPane cumulativePointsForm;

    @FXML
    private RadioButton weightedGrade;

    @FXML
    private GridPane weightedGradeForm;

    @FXML
    private Button continueButton;

    // FXML elements for the *first* row in weightedGradeForm, already in FXML
    @FXML
    private ComboBox<String> myComboBox; // The initial ComboBox
    @FXML
    private TextField enterWeightPercentage; // The initial TextField
    @FXML
    private Button addWeightCategoryButton; // The button that triggers adding new rows

    public String getStudentName() {
        return studentName;
    }

    public String getStudentClassCode() {
        return studentClassCode;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentClassCode(String studentClassCode) {
        this.studentClassCode = studentClassCode;
    }

    @FXML
    private void createCumulativePointsForm() {
        weightedGradeForm.setVisible(false);
        weightedGradeForm.setManaged(false);

        cumulativePointsForm.setVisible(true);
        cumulativePointsForm.setManaged(true);
    }

    @FXML
    private void createGradingWeightForm() {
        cumulativePointsForm.setVisible(false);
        cumulativePointsForm.setManaged(false);

        weightedGradeForm.setVisible(true);
        weightedGradeForm.setManaged(true);
    }

    @FXML
    private void addWeightCategoryPress(ActionEvent event) {
        // Get the current row index of the "Add Another Category" button.
        // New rows will be inserted immediately before this button.
        int buttonCurrentRow = GridPane.getRowIndex(addWeightCategoryButton);

        // If for some reason the row index isn't set (shouldn't happen with FXML),
        // default to 2 as that's the row after the initial input row.
        if (buttonCurrentRow == -1) {
            buttonCurrentRow = 2;
        }

        // 1. Create a new ComboBox
        ComboBox<String> newComboBox = new ComboBox<>();
        // Populate with example items (you can replace with your actual categories)
        newComboBox.setItems(FXCollections.observableArrayList("Item 1", "Item 2", "Item 3", "New Category"));
        newComboBox.getStyleClass().add("combo-box"); // Apply your custom CSS style
        newComboBox.setPrefWidth(250.0); // Match the preferred width from FXML

        // 2. Create a new TextField for weight percentage
        TextField newTextField = new TextField();
        newTextField.setPromptText("e.g., 2, 5, 20, 33, 45, 100");
        newTextField.getStyleClass().add("input-field"); // Apply your custom CSS style
        newTextField.setPrefWidth(250.0); // Match the preferred width from FXML

        // 3. Create the "%%" Text element for the new row
        Text newPercentageText = new Text("%");
        newPercentageText.getStyleClass().add("subtitle-text");

        // 4. Add the new elements to the GridPane.
        // `weightedGradeForm.addRow` inserts a new row at `buttonCurrentRow`
        // and pushes all existing elements from that row downwards.
        weightedGradeForm.addRow(buttonCurrentRow, newComboBox, newTextField, newPercentageText);
        

        // 5. Update the row index of the "Add Another Category" button
        // to move it to the row immediately after the newly added row.
        GridPane.setRowIndex(addWeightCategoryButton, buttonCurrentRow + 1);

        // Optional: If you need to store references to these dynamically created elements,
        // you could add them to a List<ComboBox<String>> and List<TextField>.
    }


    @FXML
    private void continueButtonPress(ActionEvent event) {
        System.out.println("\nClass Info Start Button Pressed!\n");

        studentName = enterStudentName.getText().isEmpty() ? "Unnamed Student" : enterStudentName.getText();
        System.out.println("Name: " + studentName);

        studentClassCode = enterClassCode.getText().isEmpty() ? "No Code Provided" : enterClassCode.getText();
        System.out.println("Class Code: " + studentClassCode);

        // Determine selected grading style
        String selectedGradingStyle = null;
        if (cumulativePoints.isSelected()) {
            selectedGradingStyle = "Cumulative Points";
        } else if (weightedGrade.isSelected()) {
            selectedGradingStyle = "Weighted Categories";
        }

        System.out.println(
                "Grading Style: " + (selectedGradingStyle != null ? selectedGradingStyle : "None Selected") + "\n");

        if (selectedGradingStyle != null) {
            try {
                // If you need to pass data to the next controller (e.g., student name, class
                // code, grading style),
                // you must load the FXML manually, get its controller, set the data, then set
                // the scene root.
                // Example for 'weight_category' scene:
              
                // If WeightCategoryController has a setUserData method:
                // WeightCategoryController nextController = loader.getController();
                // nextController.setUserData(studentName, studentClassCode,
                // selectedGradingStyle);
                Main.setRoot("/fxml/weight_category.fxml");

            } catch (IOException e) { // Catch IOException specifically for FXML loading issues
                e.printStackTrace();
                System.err.println(
                        "Failed to switch to scene for " + selectedGradingStyle + " grading: " + e.getMessage());
            }

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Selection Required");
            alert.setHeaderText("Please Choose a Grading Method");
            alert.setContentText(
                    "You must select either 'Cumulative Points' or 'Weighted Categories' to proceed with calculating your grade.\n\n"
                            + "If you're not sure which one to choose, read their associated descriptions and pick whichever one fits best with your class syllabus.\n"
                            + "\nCumulative Points - Total points earned divided by total points possible across all assignments.\n"
                            + "\n Weighted Categories - Calculated by assigning different percentages of your final grade to various assignment categories (e.g., exams, homework).");
            alert.showAndWait();
        }
    }
}