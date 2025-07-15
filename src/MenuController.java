import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button weightedButton;

    @FXML
    private Button cumulativeButton;


    @FXML
    private void weightedButtonPress(ActionEvent event) {

        try {
            Main.setRoot("weighted_scene");
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println("Failed to switch to Weighted Scene.");
        }
    }

    @FXML
    private void cumulativeButtonPress(ActionEvent event) {

        try {
            Main.setRoot("cumulative_scene");
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println("Failed to switch to Cumlative Scene.");
        }
    }
}