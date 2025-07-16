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
        addAnotherAssignmentRow = GridPane.getRowIndex(addAnotherAssignmentButton);

        TextField newAssignmentNameTextField = new TextField();
        newAssignmentNameTextField.setPromptText("e.g. Test 1, Global Project");
        newAssignmentNameTextField.getStyleClass().add("input-field");
        newAssignmentNameTextField.setPrefWidth(250.0);
        newAssignmentNameTextField.setId("enterAssignmentName-" + (addAnotherAssignmentRow - 1));
        cumlativePointsInput.add(newAssignmentNameTextField, 0, addAnotherAssignmentRow);

        TextField newEarnedPointsTextField = new TextField();
        newEarnedPointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
        newEarnedPointsTextField.getStyleClass().add("input-field");
        newEarnedPointsTextField.setPrefWidth(250.0);
        newEarnedPointsTextField.setId("enterPointsEarned-" + (addAnotherAssignmentRow - 1));
        cumlativePointsInput.add(newEarnedPointsTextField, 1, addAnotherAssignmentRow);

        Text newPercentageText = new Text("/");
        newPercentageText.getStyleClass().add("subtitle-text");
        cumlativePointsInput.add(newPercentageText, 2, addAnotherAssignmentRow);

        TextField newPossiblePointsTextField = new TextField();
        newPossiblePointsTextField.setPromptText("e.g., 2.0, 23.5, 78, 100");
        newPossiblePointsTextField.getStyleClass().add("input-field");
        newPossiblePointsTextField.setPrefWidth(250.0);
        newPossiblePointsTextField.setId("enterPossiblePoints-" + (addAnotherAssignmentRow - 1));
        cumlativePointsInput.add(newPossiblePointsTextField, 3, addAnotherAssignmentRow);


        GridPane.setRowIndex(addAnotherAssignmentButton, addAnotherAssignmentRow + 1);
    }

    @FXML
    private void calculateButtonPress(ActionEvent event) {
        loadGradesIntoArray();

        System.out.println("\n--- Collected Grades ---");
        for (int j = 0; j < assignmentNames.length; j++) {
            System.out.println("Assignment: " + assignmentNames[j] +
                               ", Earned: " + possibleEarned[j] +
                               ", Possible: " + possiblePoints[j]);
        }
        System.out.println("------------------------\n");
    }

    private void loadGradesIntoArray() {
        assignmentNames = new String[addAnotherAssignmentRow];
        possibleEarned = new Double[addAnotherAssignmentRow];
        possiblePoints = new Double[addAnotherAssignmentRow];

        for (int i = 0; i < addAnotherAssignmentRow; i++) {
            TextField nameField = (TextField) cumlativePointsInput.lookup("#enterAssignmentName-" + i);
            TextField earnedField = (TextField) cumlativePointsInput.lookup("#enterPointsEarned-" + i);
            TextField possibleField = (TextField) cumlativePointsInput.lookup("#enterPossiblePoints-" + i);

            String name = (nameField != null) ? nameField.getText() : "";
            String earnedText = (earnedField != null) ? earnedField.getText() : "";
            String possibleText = (possibleField != null) ? possibleField.getText() : "";

            assignmentNames[i] = name;
            try {
                possibleEarned[i] = Double.parseDouble(earnedText);
                possiblePoints[i] = Double.parseDouble(possibleText);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format for assignment in row " + i + ": " + e.getMessage());
                possibleEarned[i] = 0.0; 
                possiblePoints[i] = 0.0; 
            }
        }
    }

}
