import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;


public class WeightCategoryController {
    @FXML
    private Button backButton;

    @FXML
    private ComboBox<GradeWeight> weightCategoryComboBox;

    @FXML
    public void initialize() {
       
    }

    @FXML
    private void backButtonPress(ActionEvent event) {
         try {
            Main.setRoot("class_info"); 
        } catch (Exception e) {
            e.printStackTrace();
            
            System.err.println("Failed to switch to Class Info Scene.");
        }
    }

    private static void gradeWeightCategories() {
        
    }
}
