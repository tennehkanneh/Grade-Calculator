import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ClassInfoController {

    @FXML
    private TextField nameInput;

    @FXML
    private TextField classCodeInput;

    @FXML
    private TextField classNameInput;

    @FXML
    private RadioButton cumulativePoints;

    @FXML
    private RadioButton weightedGrade;

    @FXML
    private Button startButton;

    @FXML
    public void initialize() {
        ToggleGroup gradingMethodToggleGroup = new ToggleGroup();
        cumulativePoints.setToggleGroup(gradingMethodToggleGroup);
        weightedGrade.setToggleGroup(gradingMethodToggleGroup);
    }

    @FXML
    private void startButtonPress(ActionEvent event) {
         System.out.println("Class Info Start Button Pressed!");
        System.out.println("Name: " + nameInput.getText());
        System.out.println("Class Code: " + classCodeInput.getText());
        System.out.println("Class Name: " + classNameInput.getText());

        if (cumulativePoints.isSelected()) {
            try {
                Main.setRoot("weight_category");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Failed to switch to Weight Category Scence.");
            }

            System.out.println("Grading Style: Cumlative Points");

        } else if (weightedGrade.isSelected()) {
            try {
                Main.setRoot("grade_input");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Failed to switch to Grade Input Scene.");
            }

            System.out.println("Grading Style: Weighted Points");

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Selection Required");
            alert.setHeaderText("Please Choose a Grading Method");
            alert.setContentText("You must select either 'Cumulative Points' or 'Weighted Categories' to proceed with calculating your grade.");
            alert.setContentText("If you're not sure which one to choose, read their associated descriptions and pick whichever one fits best to your class syllabus.\n\n"
                                    + "Cumlative Points -- Total points earned divided by total points possible across all assignments.\n\n"
                                    + "Weighted Categories: -- Calculated by assigning different percentages of your final grade to various assignment categories (e.g., exams, homework).");
            alert.showAndWait();
        }
    }
}