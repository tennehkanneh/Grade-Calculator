import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class CumulativeController {
    String pattern = "#.00";
    DecimalFormat format = new DecimalFormat(pattern);

    private final String ASSIGNMENTS_FILE = "assignment-grades.csv";
    private final String DELIMITER = ",";

    double totalEarned = 0.0;
    double totalPossible = 0.0;

    @FXML
    Text finaleGradeText;

    @FXML
    Text earnedPointsText;

    @FXML
    Text cumlativePointsText;

    public void initialize() {
        loadAssignments();

        finaleGradeText.setText("" + format.format((totalEarned / totalPossible) * 100.0));
        earnedPointsText.setText("" + totalEarned);
        cumlativePointsText.setText("" + totalPossible);
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
            Main.setRoot("cumulative_scene");
        } catch (Exception e) {

            e.printStackTrace();
            System.err.println("Failed to switch to Class Info Scene.");
        }
    }

    private void loadAssignments() {
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(ASSIGNMENTS_FILE))) {
            System.out.println("\n--- Collection of Assignments from CSV ---");

            line = br.readLine();
            String[] heading = line.split(DELIMITER);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMITER);

                if (data.length >= 4) {
                    String name = data[0].trim();

                    String category = data[1].trim();

                    double earned = Double.parseDouble(data[2].trim());

                    double possible = Double.parseDouble(data[3].trim());

                    System.out.println(heading[0] + ": " + name + ", "
                            + heading[1] + ": " + category + ", "
                            + heading[2] + ": " + earned + ", "
                            + heading[3] + ": " + possible);

                    calculateGrade(earned, possible);
                } else {
                    System.err.println("Skipping malformed row: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Unable to Read Weight Category CSV \n");
        }
        System.out.println("------------------------\n");
    }

    private void calculateGrade(double earned, double possible) {
        totalEarned += earned;
        totalPossible += possible;
    }

    // @FXML
    // private void calculateButtonPress(ActionEvent event) {
    // loadGradesIntoArray();
    // calculateAndDisplayGrade();
    // }

    // private void calculateAndDisplayGrade() {
    // double calculatedPossiblePoints, calculatedEarnedPoints, calcualtedGrade;
    // calculatedPossiblePoints = calculatedEarnedPoints = calcualtedGrade = 0;

    // for (int i = 0; i < addAnotherAssignmentRow - 1; i++) {
    // calculatedEarnedPoints += possibleEarned[i];
    // calculatedPossiblePoints += possiblePoints[i];
    // }

    // calcualtedGrade = calculatedEarnedPoints / calculatedPossiblePoints;

    // finaleGrade.setText(String.format("%.2f%%", calcualtedGrade));
    // totalPossiblePoints.setText(String.format("%.1f", calculatedPossiblePoints));
    // totalEarnedPoints.setText(String.format("%.1f", calculatedEarnedPoints));
    // }

}
