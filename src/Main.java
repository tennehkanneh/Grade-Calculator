import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        GradeCalculatorPane pane = new GradeCalculatorPane();

        Scene scene = new Scene(pane, 900, 650);
        

        primaryStage.setTitle("Grade Calculator");
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
