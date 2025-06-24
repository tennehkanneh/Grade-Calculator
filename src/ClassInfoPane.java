import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;


public class ClassInfoPane extends GridPane {
    Text title;
    Text inputIntroText, nameText, classCodeText, classNameText, gradeStyleText;
    TextField nameInput, classCodeInput, classNameInput;
    RadioButton cumlativePoints, weightedGrade;
    Button startButton;


    public ClassInfoPane() {
        ColumnConstraints oneColumn = new ColumnConstraints();
        oneColumn.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().add(oneColumn);

        RowConstraints rowZero = new RowConstraints();
        rowZero.setVgrow(Priority.ALWAYS);
        rowZero.setValignment(VPos.TOP);

        RowConstraints rowOne = new RowConstraints();
        rowOne.setVgrow(Priority.ALWAYS);
        rowOne.setValignment(VPos.CENTER);


        this.getRowConstraints().addAll(rowZero, rowOne);
        title = new Text("Grade Calculator");
        title.setFont(Font.font("American Typewriter", FontWeight.BOLD, 60));

        this.add(title, 0, 0);
        GridPane.setHalignment(title, HPos.CENTER);


        inputIntroText = new Text("let's get some basic info about the you and the class");
        inputIntroText.setFont(Font.font("Courier New", 20));
        inputIntroText.setFill(Color.color(0.0, 0.0, 0.0, 0.4));

        nameText = new Text("Name:");
        nameText.setFont(Font.font("American Typewriter", FontWeight.NORMAL, 25));

        nameInput = new TextField();

        HBox name = new HBox();
        name.getChildren().addAll(nameText, nameInput);
        name.setSpacing(10);

        classCodeText = new Text("Class Code:");
        classCodeText.setFont(Font.font("American Typewriter", FontWeight.NORMAL, 25));

        classCodeInput = new TextField();

        HBox classCode = new HBox();
        classCode.getChildren().addAll(classCodeText, classCodeInput);
        classCode.setSpacing(10);


        classNameText = new Text("Class Name:");
        classNameText.setFont(Font.font("American Typewriter", FontWeight.NORMAL, 25));

        classNameInput = new TextField();
        
        HBox className = new HBox();
        className.getChildren().addAll(classNameText, classNameInput);
        className.setSpacing(10);



        VBox inputSection = new VBox();
        inputSection.getChildren().addAll(inputIntroText, name, classCode, className);

        gradeStyleText = new Text("To calcualte you grade correct I need to know how your class is graded");
        gradeStyleText.setFont(Font.font("Courier New", 20));
        gradeStyleText.setFill(Color.color(0.0, 0.0, 0.0, 0.4));

        cumlativePoints = new RadioButton("Cumlative Points");
        weightedGrade = new RadioButton("Weighted Points");

        this.add(inputSection, 0, 1);

        VBox gradingStyleSection = new VBox();
        gradingStyleSection.getChildren().addAll(gradeStyleText, cumlativePoints, weightedGrade);

        this.add(gradingStyleSection, 0, 2);
        

       
        GridPane.setHalignment(inputSection, HPos.CENTER);

        startButton = new Button("Start Calculating Your Grade");
        startButton.setFont(new Font("American Typewriter", 16));
        startButton.getStyleClass().add("button");

        this.add(startButton, 0,3);
        


        setGridLinesVisible(true);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
    }
}