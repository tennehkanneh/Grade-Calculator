import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ClassInfoController {

    @FXML
    private TextField nameInput;

    @FXML
    private TextField classCodeInput;

    @FXML
    private TextField classNameInput;

    @FXML
    private RadioButton cumlativePoints;

    @FXML
    private RadioButton weightedGrade;

    @FXML
    private Button startButton;

    @FXML
    public void initialize() {
        
    }

    @FXML
    public void processRadioButtonClic(Action Event) {
        
    }

    @FXML
    private void startButtonPress(ActionEvent event) {
       
        System.out.println("Class Info Start Button Pressed!");
        
        System.out.println("Name: " + nameInput.getText());
        System.out.println("Class Code: " + classCodeInput.getText());
        System.out.println("Class Name: " + classNameInput.getText());
        System.out.println("Grading Style: " + (cumlativePoints.isSelected() ? "Cumlative Points" : "Weighted Points"));

       
    }
}