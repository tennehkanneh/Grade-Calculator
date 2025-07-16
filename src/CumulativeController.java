import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class CumulativeController {
    private String[] assignmentNames;
    private Double[] possibleEarned;
    private Double[] possiblePoints;

    private int addAnotherAssignmentRow;

    @FXML
    private GridPane cumlativePointsInput;

    @FXML
    private Button addAnotherAssignmentButton;

    public CumulativeController() {
        addAnotherAssignmentRow = GridPane.getRowIndex(addAnotherAssignmentButton);
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
    private void addAnotherAssignmentButtonPress(ActionEvent event) {
        TextField newAssignmentNameTextField = new TextField();
        newAssignmentNameTextField.setPromptText("e.g. Test 1, Global Project");
        newAssignmentNameTextField.getStyleClass().add("input-field");
        newAssignmentNameTextField.setPrefWidth(250.0);
        cumlativePointsInput.add(newAssignmentNameTextField, 0, addAnotherAssignmentRow);

        TextField newEarnedPointsTextField = new TextField();
        newEarnedPointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
        newEarnedPointsTextField.getStyleClass().add("input-field");
        newEarnedPointsTextField.setPrefWidth(250.0);
        cumlativePointsInput.add(newEarnedPointsTextField, 1, addAnotherAssignmentRow);

        Text newPercentageText = new Text("/");
        newPercentageText.getStyleClass().add("subtitle-text");
        cumlativePointsInput.add(newPercentageText, 2, addAnotherAssignmentRow);

        TextField newPossiblePointsTextField = new TextField();
        newPossiblePointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
        newPossiblePointsTextField.getStyleClass().add("input-field");
        newPossiblePointsTextField.setPrefWidth(250.0);
        cumlativePointsInput.add(newPossiblePointsTextField, 3, addAnotherAssignmentRow);


        GridPane.setRowIndex(addAnotherAssignmentButton, addAnotherAssignmentRow + 1);
    }

    @FXML
    private void calculateButtonPress(ActionEvent event) {
        loadIntoArray();
    }

    private void loadIntoArrays() {
        assignmentNames = new String[addAnotherAssignmentRow];
        possibleEarned = new Double[addAnotherAssignmentRow];
        possiblePoints = new Double[addAnotherAssignmentRow];

        for(int i = 0; i < addAnotherAssignmentRow; i++) {
            
        }

    }

}
