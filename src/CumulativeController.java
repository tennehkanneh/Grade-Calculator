import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CumulativeController {
    @FXML
    private GridPane cumlativePointsInput;

    @FXML
    private Button addAnotherAssignment;

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
    private void addAnotherAssignmentPress(ActionEvent event) {
        int buttonCurrentRow = GridPane.getRowIndex(addAnotherAssignment);

        TextField newAssignmentNameTextField = new TextField();
        newAssignmentNameTextField.setPromptText("e.g. Test 1, Global Project");
        newAssignmentNameTextField.getStyleClass().add("input-field");
        newAssignmentNameTextField.setPrefWidth(250.0);
        cumlativePointsInput.add(newAssignmentNameTextField, 0, buttonCurrentRow);

        TextField newEarnedPointsTextField = new TextField();
        newEarnedPointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
        newEarnedPointsTextField.getStyleClass().add("input-field");
        newEarnedPointsTextField.setPrefWidth(250.0);
        cumlativePointsInput.add(newEarnedPointsTextField, 1, buttonCurrentRow);

        Text newPercentageText = new Text("/");
        newPercentageText.getStyleClass().add("subtitle-text");
        cumlativePointsInput.add(newPercentageText, 2, buttonCurrentRow);

        TextField newPossiblePointsTextField = new TextField();
        newPossiblePointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
        newPossiblePointsTextField.getStyleClass().add("input-field");
        newPossiblePointsTextField.setPrefWidth(250.0);
        cumlativePointsInput.add(newPossiblePointsTextField, 3, buttonCurrentRow);


        GridPane.setRowIndex(addAnotherAssignment, buttonCurrentRow + 1);
    }

    @FXML
    private void calculateButtonPress(ActionEvent event) {
        
    }

}
