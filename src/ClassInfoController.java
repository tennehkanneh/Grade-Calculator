import javafx.fxml.FXML;
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
    private VBox cumulativePointsForm;

    @FXML
    private RadioButton weightedGrade;

    @FXML
    private VBox weightedGradeForm;

    @FXML
    private Button continueButton;

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