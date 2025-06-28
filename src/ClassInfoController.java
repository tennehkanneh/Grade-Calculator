/**
 * @tennehkanneh
 * 06/21/2025 17:02:54
 * 
 * Description: In order to customize certain content in the Grade Calculator this Controller works with the 
 * class_info.fxml to get certian info about the student, the class, and how the class is grades so that
 * the Calculator can work properly.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ClassInfoController {
    private static String name, classCode, className;

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
    private ToggleGroup gradingMethodToggleGroup;

    @FXML
    public void initialize() {

    }

    /**
     * When the start Button is Pressed this method gets the inputs and the grading system is saved in order to 
     * customize the experince. If the grading system is not chose the user can not continue.
     * 
     * @param event     Button Press
     */
    @FXML
    private void startButtonPress(ActionEvent event) {
        System.out.println("\nClass Info Start Button Pressed!\n");
        
        name = nameInput.getText().isEmpty() ? "Unnamed Student" : nameInput.getText();
        System.out.println("Name: " + name);

        classCode = classCodeInput.getText().isEmpty(

        ) ? "No Code Provided" : classCodeInput.getText();
        System.out.println("Class Code: " + classCode);

        className = classNameInput.getText().isEmpty() ? "Unnamed Class" : classNameInput.getText();
        System.out.println("Class Name: " + className);

        if (cumulativePoints.isSelected()) {
            try {
                Main.setRoot("grade_input");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Failed to switch to Grade Input Scene.");
            }

            System.out.println("Grading Style: Cumulative Points\n");

        } else if (weightedGrade.isSelected()) {
            try {
                Main.setRoot("weight_category");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Failed to switch to Weight Category Scene.");
            }

            System.out.println("Grading Style: Weighted Categories\n"); 

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Selection Required");
            alert.setHeaderText("Please Choose a Grading Method");

    
            alert.setContentText("You must select either 'Cumulative Points' or 'Weighted Categories' to proceed with calculating your grade.\n\n"
                                    + "If you're not sure which one to choose, read their associated descriptions and pick whichever one fits best with your class syllabus.\n"
                                    + "\t- Cumulative Points: Total points earned divided by total points possible across all assignments.\n"
                                    + "\t- Weighted Categories: Calculated by assigning different percentages of your final grade to various assignment categories (e.g., exams, homework).");
            alert.showAndWait();
        }
    }
}