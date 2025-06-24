import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static Scene scene;
  
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        StartPane initialPane = new StartPane();
        scene = new Scene(initialPane, 900, 650);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Grade Calculator");
        stage.setScene(scene);
        stage.show();

    }

    public static void setRoot(String paneType) {

        try {
            Parent newRoot = null;
            switch (paneType.toLowerCase()) {
                case "start":
                    newRoot = new StartPane();
                    break;

                case "class info":
                    newRoot = new ClassInfoPane();
                    break;

                default:
                    System.err.println("Unknown pane type: " + paneType);
                    return;
            }

            if (newRoot != null) {
                scene.setRoot(newRoot);
                System.out.println("New Scene: " + newRoot);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Unable to Set New Scene");
        }
    }
}
