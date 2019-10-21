package LabFive;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LabFive extends Application {
    public void start(Stage stage) {

        //creation of all components within the stage
        GridPane top = new GridPane();
        GridPane inner = new GridPane();
        Pane pane = new Pane();
        LifeGrid grid = new LifeGrid(pane,700,600);


        //contents of inner pane
        Button randomizeCells = new Button("Randomized Placement");
        Button oneTimeThrough = new Button("One Period");
        Button clear = new Button("Clear");
        Label aliveLabel = new Label("Alive Cells: " + grid.getAliveCounter());
        Label deadLabel = new Label("Dead Cells: "+ grid.getDeadCounter());
        HBox buttonBox = new HBox(40,aliveLabel,deadLabel,randomizeCells,oneTimeThrough,clear);

        ///adjustment of inner pane
        inner.add(buttonBox,0,0);
        inner.setAlignment(Pos.BOTTOM_CENTER);
        inner.setPadding(new Insets(40,0,0,0));

        //adjustment of top pane
        top.add(inner,0,2,2,1);
        top.add(pane,0,0);
        top.setAlignment(Pos.TOP_CENTER);
        top.setPadding(new Insets(100,0,0,0));

        //creation of scene
        Scene scene = new Scene(top,1000, 900);
        scene.getStylesheets().add("styling/style.css");

        stage.setScene(scene);
        stage.setTitle("The Game of Life");

        //set-up of game
        randomizeCells.setOnAction(e -> {
            grid.randomize();
            stage.show();
            grid.cellCounter();
            aliveLabel.setText("Alive Cells: " + grid.getAliveCounter());
            deadLabel.setText("Dead Cells: " + grid.getDeadCounter());

        });
        oneTimeThrough.setOnAction(e -> {
            grid.iterate();
            stage.show();
            grid.cellCounter();
            aliveLabel.setText("Alive Cells: " + grid.getAliveCounter());
            deadLabel.setText("Dead Cells: " + grid.getDeadCounter());
        });
        pane.setOnMouseClicked(e -> {
            grid.switchLife();
            grid.cellCounter();
            aliveLabel.setText("Alive Cells: " + grid.getAliveCounter());
            deadLabel.setText("Dead Cells: " + grid.getDeadCounter());
        });
        clear.setOnAction(e -> {
            grid.clear();
            stage.show();
            grid.cellCounter();
            aliveLabel.setText("Alive Cells: " + grid.getAliveCounter());
            deadLabel.setText("Dead Cells: " + grid.getDeadCounter());
        });




        stage.show();
    }
}
