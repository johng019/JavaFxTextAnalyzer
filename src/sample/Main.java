package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * This Javafx Project is to present the user the opportunity to access to the poem
 * "The Raven" by Edgar Allen Poe and also show the 20 most frequently occurring words
 * in the poem, in descending order.
 *
 */
public class Main extends Application {
    WebView view;
    Stage window;
    Scene scene1;

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox vBox = new VBox();
        window = primaryStage;

        //Label, link, and event handler to access the poem
        Label label1  = new Label("Click the link to see Edgar Allen Poe's poem 'TheRaven'");
        Hyperlink link = new Hyperlink("The Raven");
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ReadTheRaven rtr = new ReadTheRaven();
                try {
                    rtr.start(primaryStage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Label, button, and event handler to show the top 20 word occurrences in the poem.
        Label label2  = new Label("Print out the most frequently appearing words in Edgar Allen Poe's 'TheRaven'");
        Button button1 = new Button("Get top 20 words");
        button1.setOnAction(e -> {
                TopWordsUI gui = new TopWordsUI();
            try {
                gui.start(primaryStage);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        //Set up the view

        VBox vbLeft = new VBox(20);
        vbLeft.setPadding(new Insets(10,10,10,30));
        vbLeft.getChildren().addAll(label1,link,label2,button1,vBox);
        scene1 = new Scene(vbLeft,500,200);

        //Display the content
        vbLeft.getStylesheets().add("main.css");
        window.setTitle("Text Analyzer");
        window.setScene(scene1);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
