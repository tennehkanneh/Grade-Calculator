/**
 * @tennehkanneh
 * 06/16/2025 21:21:34
 * 
 * Description: This class is the controller for the start.fxml file it handles the functionality of the start scene.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartController {

    @FXML
    private Button startButton;

    /**
     * When the start button is pressed this method calls the Main static setRoot() method and carries out
     * changing the start scene to the class_info.fxml scene.
     * 
     * @param event     The start button is pressed
     */
    @FXML
    private void startButtonPress(ActionEvent event) {

        try {
            Main.setRoot("class_info");
        } catch (Exception e) {
            e.printStackTrace();

            System.err.println("Failed to switch to Class Info Scene.");
        }
    }
}