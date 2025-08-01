import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class WeightedController {
    private int addWeightCategoryRow;
    
    private Double calcualtedGrade = 0.0;

    @FXML
    private Text finaleGrade;

    @FXML
    private GridPane weightedCategoryGride;
    
    @FXML
    private VBox weightPointsInput;
    
    @FXML
    private Button addWeightCategoryButton;

    @FXML
    private Button weightCategoriesButton;

    @FXML
    public void initialize() {
        addWeightCategoryRow = GridPane.getRowIndex(addWeightCategoryButton);
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
    private void addWeightCategoryPress(ActionEvent event) {       
        TextField newWeightCategoryName = new TextField();
        newWeightCategoryName.setPromptText("e.g. Test, Homework, Quiz");
        newWeightCategoryName.getStyleClass().add("input-field");
        newWeightCategoryName.setPrefWidth(250.0);
        newWeightCategoryName.setId("enterWeightCategory-" + (addWeightCategoryRow - 1));
        weightedCategoryGride.add(newWeightCategoryName, 0, addWeightCategoryRow);

        TextField newCategoryPointsName = new TextField();
        newCategoryPointsName.setPromptText("e.g., 2.0, 23.5, 78, 100");
        newCategoryPointsName.getStyleClass().add("input-field");
        newCategoryPointsName.setPrefWidth(250.0);
        newCategoryPointsName.setId("enterPointsEarned-" + (addWeightCategoryRow - 1));
        weightedCategoryGride.add(newCategoryPointsName, 1, addWeightCategoryRow);

        TextField newWeight = new TextField();
        newWeight.setPromptText("e.g., 2.0, 23.5, 78, 100");
        newWeight.getStyleClass().add("input-field");
        newWeight.setPrefWidth(250.0);
        newWeight.setId("enterWeightPercentage-" + (addWeightCategoryRow - 1));
        weightedCategoryGride.add(newWeight, 2, addWeightCategoryRow);

        Text newPercentageText = new Text("%");
        newPercentageText.getStyleClass().add("subtitle-text");
        weightedCategoryGride.add(newPercentageText, 3, addWeightCategoryRow);


        addWeightCategoryRow++;
        GridPane.setRowIndex(addWeightCategoryButton, addWeightCategoryRow);
    }


    @FXML
    private void calculateButtonPress(ActionEvent event) {
        loadGradesIntoArray();
        finaleGrade.setText(String.format("%.2f%%", calcualtedGrade));
    }

    private void loadGradesIntoArray() {
        Double earnedPoints;
        Double weight;

        System.out.println("\n--- Collected Weight Categories ---");
        for (int i = 0; i < addWeightCategoryRow - 1; i++) {
            TextField categoryName = (TextField) weightedCategoryGride.lookup("#enterWeightCategory-" + i);
            TextField categoryPoints = (TextField) weightedCategoryGride.lookup("#enterPointsEarned-" + i);
            TextField categoryWeight = (TextField) weightedCategoryGride.lookup("#enterWeightPercentage-" + i);

            String name = (categoryName != null) ? categoryName.getText() : "";
            String earnedText = (categoryPoints != null) ? categoryPoints.getText() : "";
            String weightText = (categoryWeight != null) ? categoryWeight.getText() : "";

            try {
                earnedPoints = Double.parseDouble(earnedText);
                weight = Double.parseDouble(weightText);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format for assignment in row " + i + ": " + e.getMessage());
                earnedPoints = 0.0; 
                weight = 0.0; 
            }   
        
            System.out.println("Weight Category: " + name +
                               ", Points Earned Earned: " + earnedPoints +
                               ", Weight Percentage: " + weight);
            calculateGrade(earnedPoints, weight);
        }
        System.out.println("------------------------\n");
    }

    private void calculateGrade(double pointsEarned, double weight) {
        calcualtedGrade += (pointsEarned * (weight / 100));
    }
}
