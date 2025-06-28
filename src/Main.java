/**
 * @tennehkanneh
 * 06/10/2025 14:33:33
 * 
 * Desciption: Driver class of the program, contains the the main, start, loadFXM and setRood methods.
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("start"), 900, 650);
        stage.setTitle("Grade Calculator");
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.show();
    }

    /**
     * Changes the scene contents of the JavaFX program by setting the root of the scene to a new fxml file.
     * 
     * @param fxml              String fxml file name
     * @throws IOException
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Loads a new fxml file so that they scene root can be changed with the change to the new fxml conent.
     * 
     * @param fxml              String fxml file name
     * @return                  The loaded fxml file
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}