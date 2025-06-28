import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class StartController {

    @FXML
    private Button startButton; 

    @FXML
    private void startButtonPress(ActionEvent event) {
      
        try {
            Main.setRoot("class_info"); 
        } catch (Exception e) {
            e.printStackTrace();
            
            System.err.println("Failed to switch to Class Info Scene.");
        }
    }

   
    @FXML
    public void initialize() {
        
    }
}