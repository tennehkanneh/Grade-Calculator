import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class WeightCategoryController {
    private SetUpController studentInfo = new SetUpController();

    @FXML
    private Button continueButton;

    @FXML
    private ComboBox<String> myComboBox;

    @FXML
    private TextField enterWeightPercentage;

    @FXML
    private Button addWeightCategoryButton;

    @FXML
    private GridPane weightedGradeForm;

    

    @FXML    
    private void backButtonPress(ActionEvent event) {       
         try {
            Main.setRoot("setup_scene");
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println("Failed to switch to Class Info Scene.");
        }
    }

    @FXML 
    private void addWeightCategoryPress(ActionEvent event) {       
        // int buttonCurrentRow = GridPane.getRowIndex(addWeightCategoryButton);     
        // if (buttonCurrentRow == -1) {
        //     buttonCurrentRow = 2;        
        // }        
        
        // ComboBox<String> newComboBox = new ComboBox<>();        
              
        // newComboBox.setItems(FXCollections.observableArrayList("Item 1", "Item 2", "Item 3", "New Category"));        
        // newComboBox.getStyleClass().add("combo-box");        
        // newComboBox.setPrefWidth(250.0);
        // TextField newTextField = new TextField();       
        // newTextField.setPromptText("e.g., 2, 5, 20, 33, 45, 100");    
        // newTextField.getStyleClass().add("input-field");   
        // newTextField.setPrefWidth(250.0);      
       
        // Text newPercentageText = new Text("%");     
        // newPercentageText.getStyleClass().add("subtitle-text");     
        
         
        // weightedGradeForm.addRow(buttonCurrentRow, newComboBox, newTextField, newPercentageText);           
           
        // GridPane.setRowIndex(addWeightCategoryButton, buttonCurrentRow + 1);
    }

    @FXML    
    private void continueButtonPress(ActionEvent event) {       
         try {
            Main.setRoot("gradeinput_scene");
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println("Failed to switch to Class Info Scene.");
        }
    }
    
}
