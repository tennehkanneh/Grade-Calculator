import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class WeightedController {
    private final String WEIGHT_CATEGORY_FILE = "category-weight.csv";
    private final String ASSIGNMENTS_FILE = "assignment-grades.csv";
    private final String DELIMITER = ",";

    private String[] categoryList = new String[50];
    private Double[] weightList = new Double[50];

    @FXML
    GridPane weightedCategoryGride;

    @FXML
    HBox finalCalculationsBox;

    public void initialize() {
       
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
    private void reloadButtonPress(ActionEvent event) {
        try {
            Main.setRoot("weighted_scene");
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println("Failed to switch to Class Info Scene.");
        }
    }

    // private void loadWeightCategoryCSV() {
    //     String line;
    //     int index = 0;

    //     try (BufferedReader br = new BufferedReader(new FileReader(WEIGHT_CATEGORY_FILE))) {
    //         System.out.println("\n--- Collected Weighted Categories from CSV ---");

    //         line = br.readLine();
    //         String[] heading = line.split(DELIMITER);

    //         while ((line = br.readLine()) != null) {
    //             String[] data = line.split(DELIMITER);

    //             if (data.length >= 2) {
    //                 String category = data[0].trim();
    //                 categoryList[index] = category;

    //                 double weight = Double.parseDouble(data[1].trim());
    //                 weightList[index] = weight;

    //                 System.out.println(heading[0] + ": " + category + "\t\t " + heading[1] + ": " + weight);

    //                 HBox box = new HBox();

    //                 Label categoryLabel = new Label();
    //                 categoryLabel.setText(category + ": ");
    //                 categoryLabel.getStyleClass().add("subtitle-text");

    //                 Text weightText = new Text();
    //                 weightText.setText((weight * 100) + "%");

    //                 box.getChildren().addAll(categoryLabel, weightText);
    //                 weightedCategoryGride.add(box, 0, index + 1);
    //                 index++;
    //             } else {
    //                 System.err.println("Skipping malformed row: " + line);
    //             }
    //         }

    //     } catch (IOException e) {
    //         System.err.println("Unable to Read Weight Category CSV \n");
    //     }
    //     System.out.println("------------------------\n");
    // }

    // private void loadAssignments() {
    //     String line;
    //     int index = 0;

    //     try (BufferedReader br = new BufferedReader(new FileReader(ASSIGNMENTS_FILE))) {
    //         System.out.println("\n--- Collection of Assignments from CSV ---");

    //         line = br.readLine();
    //         String[] heading = line.split(DELIMITER);

    //         while ((line = br.readLine()) != null) {
    //             String[] data = line.split(DELIMITER);

    //             if (data.length >= 4) {
    //                 String name = data[0].trim();
                    
    //                 String category = data[1].trim();

    //                 int earned = Integer.parseInt(data[2].trim());

    //                 int possible = Integer.parseInt(data[3].trim());


    //                 System.out.println(heading[0] + ": " + name + ", " 
    //                                     + heading[1] + ": " + category + ", "
    //                                     + heading[2] + ": " + earned + ", "
    //                                     + heading[3] + ": " + possible);
            

    //                 index++;
    //             } else {
    //                 System.err.println("Skipping malformed row: " + line);
    //             }
    //         }

    //     } catch (IOException e) {
    //         System.err.println("Unable to Read Weight Category CSV \n");
    //     }
    //     System.out.println("------------------------\n");
    // }

    // private void calculateAndDisplay() {
    //     loadWeightCategoryCSV();
    //     loadAssignments();

    // }

    // @FXML
    // private void calculateButtonPress(ActionEvent event) {
    // String csvFile = "weighted_grades.csv";

    // loadWeightedGradesFromCsv(csvFile);
    // finaleGrade.setText(String.format("%.2f%%", calculatedGrade));
    // }

    // private void loadWeightedGradesFromCsv(String filePath) {
    // String line;
    // String cvsSplitBy = ",";

    // calculatedGrade = 0.0;

    // try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
    //
    // while ((line = br.readLine()) != null) {
    // String[] data = line.split(cvsSplitBy);
    // if (data.length >= 2) {
    //
    // }
    // }
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // System.err.println("Failed to read the CSV file.");
    // } catch (NumberFormatException e) {
    // System.err.println("Invalid number format in CSV file: " + e.getMessage());
    // }
    //
    // }

    // private void calculateGrade(double pointsEarned, double weight) {
    // calculatedGrade += (pointsEarned * (weight / 100));
    // }
}
