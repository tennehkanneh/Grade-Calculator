import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class GradeCalculatorPane extends GridPane {
    Text title;
    Text author;
    Button startButton;

    public GradeCalculatorPane() {

        ColumnConstraints oneColumn = new ColumnConstraints();
        oneColumn.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().add(oneColumn);

        RowConstraints rowZero = new RowConstraints();
        rowZero.setVgrow(Priority.ALWAYS);
        rowZero.setValignment(VPos.CENTER);

        RowConstraints rowOne = new RowConstraints();
        rowOne.setPrefHeight(110);
        rowOne.setValignment(VPos.BOTTOM);

        this.getRowConstraints().addAll(rowZero, rowOne);

        title = new Text("Grade Calculator");
        title.setFont(Font.font("American Typewriter", FontWeight.BOLD, 60));

        author = new Text("Created by Tenneh Kanneh");
        author.setFont(new Font("Courier New", 25));
        author.setFill(Color.color(0.0, 0.0, 0.0, 0.4));

        VBox titleAndAuthor = new VBox();
        titleAndAuthor.getChildren().addAll(title, author);
        titleAndAuthor.setAlignment(Pos.CENTER);

        this.add(titleAndAuthor, 0, 0);
        GridPane.setHalignment(titleAndAuthor, HPos.CENTER);

        startButton = new Button("Start Calculating Your Grade");
        startButton.setFont(new Font("American Typewriter", 16));
        startButton.getStyleClass().add("button");

        this.add(startButton, 0, 1);
        GridPane.setHalignment(startButton, HPos.CENTER);
        GridPane.setValignment(startButton, VPos.TOP);

        startButton.setOnAction(this::startButtonPress);

        // setGridLinesVisible(true);

        this.setPadding(new Insets(20));

        this.setAlignment(Pos.CENTER);
    }

    private void startButtonPress(ActionEvent event) {

    }

}
