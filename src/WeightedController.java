import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class WeightedController {
    private static final String WEIGHT_CATEGORY_FILE = "category-weight.csv";
    private static final String ASSIGNMENTS_FILE = "assignment-grades.csv";
    private static final String DELIMITER = ",";
    private static final String PATTERN = "#.00";

    private String[] categoryList = new String[100];
    private Double[] weightList = new Double[100];
    private Double[] totalEarnedInCategory = new Double[100];
    private Double[] totalPossibleInCategory = new Double[100];

    private double weightedGrade = 0.0;
    private double extraCredit = 0.0;

    private final DecimalFormat format = new DecimalFormat(PATTERN);

    @FXML
    private Text finaleGradeText;

    public void initialize() {
        loadWeightCategoryCSV();
        loadAssignments();
        calculateFinalGrade();
    }

    @FXML
    private void backButtonPress(ActionEvent event) {
        switchScene("menu_scene", "Failed to switch to Menu Scene.");
    }

    @FXML
    private void reloadButtonPress(ActionEvent event) {
        switchScene("weighted_scene", "Failed to reload Weighted Scene.");
    }

    private void switchScene(String sceneName, String errorMessage) {
        try {
            Main.setRoot(sceneName);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(errorMessage);
        }
    }

    private void loadWeightCategoryCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(WEIGHT_CATEGORY_FILE))) {
            String header = br.readLine();

            int index = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMITER);

                if (data.length >= 2) {
                    categoryList[index] = data[0].trim();
                    weightList[index] = Double.parseDouble(data[1].trim());

                    totalEarnedInCategory[index] = 0.0;
                    totalPossibleInCategory[index] = 0.0;

                    System.out.println("Category: " + categoryList[index] +
                                       " Weight: " + weightList[index]);
                    index++;
                } else {
                    System.err.println("Skipping malformed row: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Unable to read Weight Category CSV.");
        }
    }

    private void loadAssignments() {
        try (BufferedReader br = new BufferedReader(new FileReader(ASSIGNMENTS_FILE))) {
            String header = br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMITER);

                if (data.length >= 4) {
                    String name = data[0].trim();
                    String category = data[1].trim();
                    double earned = Double.parseDouble(data[2].trim());
                    double possible = Double.parseDouble(data[3].trim());

                    System.out.println("Assignment: " + name +
                                       ", Category: " + category +
                                       ", Earned: " + earned +
                                       ", Possible: " + possible);

                    addGradeToCategory(category, earned, possible);
                } else {
                    System.err.println("Skipping malformed row: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Unable to read Assignment CSV.");
        }
    }

    private void addGradeToCategory(String categoryName, double earned, double possible) {
        if (categoryName == null || categoryName.isEmpty()) {
            extraCredit += earned;
            return;
        }

        for (int i = 0; i < categoryList.length && categoryList[i] != null; i++) {
            if (categoryName.equals(categoryList[i])) {
                totalEarnedInCategory[i] += earned;
                totalPossibleInCategory[i] += possible;
                return;
            }
        }

        System.err.println("Category not found for: " + categoryName);
    }

    private void calculateFinalGrade() {
        weightedGrade = 0.0;

        for (int i = 0; i < categoryList.length && categoryList[i] != null; i++) {
            if (totalPossibleInCategory[i] > 0) {
                double categoryAverage = totalEarnedInCategory[i] / totalPossibleInCategory[i];
                weightedGrade += weightList[i] * categoryAverage;
            }
        }

        double finalGradePercent = (weightedGrade * 100.0) + extraCredit;

        finaleGradeText.setText(format.format(finalGradePercent));
    }
}
