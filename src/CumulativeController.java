import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class CumulativeController {
    private static final String ASSIGNMENTS_FILE = "assignment-grades.csv";
    private static final String DELIMITER = ",";
    private static final String PATTERN = "#.00";

    private double totalEarned = 0.0;
    private double totalPossible = 0.0;
    private final DecimalFormat format = new DecimalFormat(PATTERN);

    @FXML
    private Text finaleGradeText;

    @FXML
    private Text earnedPointsText;

    @FXML
    private Text cumlativePointsText;

    public void initialize() {
        loadAssignments();

        if (totalPossible > 0) {
            double gradePercent = (totalEarned / totalPossible) * 100.0;
            finaleGradeText.setText(format.format(gradePercent));
        } else {
            finaleGradeText.setText("N/A");
        }

        earnedPointsText.setText(format.format(totalEarned));
        cumlativePointsText.setText(format.format(totalPossible));
    }

    @FXML
    private void backButtonPress(ActionEvent event) {
        switchScene("menu_scene", "Failed to switch to Menu Scene.");
    }

    @FXML
    private void reloadButtonPress(ActionEvent event) {
        switchScene("cumulative_scene", "Failed to reload Cumulative Scene.");
    }

    private void switchScene(String sceneName, String errorMessage) {
        try {
            Main.setRoot(sceneName);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(errorMessage);
        }
    }

    private void loadAssignments() {
        try (BufferedReader br = new BufferedReader(new FileReader(ASSIGNMENTS_FILE))) {
            String headerLine = br.readLine();
            if (headerLine == null) {
                System.err.println("CSV file is empty.");
                return;
            }

            String[] headings = headerLine.split(DELIMITER);
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(DELIMITER);

                if (data.length < 4) {
                    System.err.println("Skipping malformed row: " + line);
                    continue;
                }

                String name = data[0].trim();
                String category = data[1].trim();

                try {
                    double earned = Double.parseDouble(data[2].trim());
                    double possible = Double.parseDouble(data[3].trim());

                    System.out.println(
                        headings[0] + ": " + name + ", " +
                        headings[1] + ": " + category + ", " +
                        headings[2] + ": " + earned + ", " +
                        headings[3] + ": " + possible
                    );

                    addToTotals(earned, possible);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number in row: " + line);
                }
            }

        } catch (IOException e) {
            System.err.println("Unable to read assignment CSV.");
        }
    }

    private void addToTotals(double earned, double possible) {
        totalEarned += earned;
        totalPossible += possible;
    }
}