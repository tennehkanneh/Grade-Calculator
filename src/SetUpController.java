import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class SetUpController {
    private String studentName;
    private String studentClassCode;
    private String selectedGradingStyleString;
    private Boolean selectedGradingStyle = null;

    @FXML
    private TextField enterStudentName;

    @FXML
    private TextField enterClassCode;

    @FXML
    private ToggleGroup gradingMethod;

    @FXML
    private RadioButton cumulativePoints;

    @FXML
    private RadioButton weightedCategories;

    @FXML
    private Button continueButton;


    public SetUpController() { }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentClassCode() {
        return studentClassCode;
    }

    public Boolean getSelectedGradingStyle() {
        return selectedGradingStyle;
    }

    public void setStudentName() {
        studentName = enterStudentName.getText().isEmpty() ? "Student" : enterStudentName.getText();
    }

    public void setStudentClassCode() {
        studentClassCode = enterClassCode.getText().isEmpty() ? "No Class Code" : enterClassCode.getText();
    }


    public void setSelectedGradingStyle() {
        if (cumulativePoints.isSelected()) {
            selectedGradingStyle = true;
            selectedGradingStyleString = "Cumlative Points";
        }
        
        if (weightedCategories.isSelected()) {
            selectedGradingStyle = false;
            selectedGradingStyleString = "Weighted Categories";
        }
    }

    @FXML
    private void continueButtonPress(ActionEvent event) {
        System.out.println("\nClass Info Start Button Pressed!\n");

        setStudentName();
        System.out.println("Name: " + studentName);

        setStudentClassCode();
        System.out.println("Class Code: " + studentClassCode);

        setSelectedGradingStyle();
        System.out.println("Grading Style: " + (selectedGradingStyleString != null ? selectedGradingStyleString : "None Selected") + "\n");

        if (selectedGradingStyle != null) {
            try {
                Main.setRoot(selectedGradingStyle ? "gradeinput_scene" : "weightcategory_scene" );
            } catch (IOException e) { 
                e.printStackTrace();
                System.err.println("Failed to switch to scene for " + selectedGradingStyleString + e.getMessage());
            }

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Selection Required");
            alert.setHeaderText("Please Choose a Grading Method");
            alert.setContentText(
                    "You must select either 'Cumulative Points' or 'Weighted Categories' to proceed with calculating your grade.\n\n"
                            + "If you're not sure which one to choose, read their associated descriptions and pick whichever one fits best with your class syllabus.\n"
                            + "\nCumulative Points - Total points earned divided by total points possible across all assignments.\n"
                            + "\nWeighted Categories - Calculated by assigning different percentages of your final grade to various assignment categories (e.g., exams, homework).");
            alert.showAndWait();
        }
    }
}