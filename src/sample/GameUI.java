package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * GameUI Reads from "TheRaven by Edgar Allen Poe and
 * displays the 20 most frequently occurring words in descending order.
 */
public class GameUI extends Application {
    Stage window;
    Scene scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        StackPane layout2 = new StackPane();
        TextArea textField = new TextArea();

        //Open and read a file.
        FileInputStream reader = new FileInputStream("TextAnalyzer.txt");
        Scanner file = new Scanner(reader);

        //Create 2 ArrayLists for the words and count of frequency of each word.
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> frequency = new ArrayList<>();

        /**
         * Sets up the reading of the file and then performs word identification and frequency of the word tasks.
         * Then adds the word to the words ArrayList & count to the frequency ArrayList.
         */

        while(file.hasNext()){
            String next = file.next().toLowerCase().replaceAll("[^a-zA-Z0-9]","") ;
            if(words.contains(next)){
                int indexer = words.indexOf(next);
                frequency.set(indexer,frequency.get(indexer) + 1);
            }else{
                words.add(next);
                frequency.add(1);
            }
        }

        //Close file open/read tools.
        file.close();
        reader.close();

        //Linked Hash Map of words(key) and count(value).
        LinkedHashMap<String, Integer> myMap = new LinkedHashMap<>();
        for(int i = 0; i < words.size(); i++) {
            myMap.put(words.get(i), frequency.get(i));
        }

        //Use Entry.comparingByValue to sort entries.
        LinkedHashMap<String, Integer> mySortedMap = new LinkedHashMap<>();
        myMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> mySortedMap.put(x.getKey(),x.getValue()));

        //Use Comparator.reverseOrder() for reverse ordering.
        LinkedHashMap <String,Integer> myReverseSortedMap = new LinkedHashMap<>();
        mySortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> myReverseSortedMap.put(x.getKey(),x.getValue()));

        //Get the highest 20 words and their count.
        int i = 0;
        for(String  item: myReverseSortedMap.keySet()){
            if(i < 20) {
                textField.appendText(item + " = " + myReverseSortedMap.get(item) + "\n");
                i++;
            }
        }

        //Display content
        layout2.getChildren().add(textField);
        scene2 = new Scene(layout2,600,380);
        window.setTitle("MOST FREQUENTLY APPEARING WORDS IN DESCENDING ORDER");
        window.setScene(scene2);
        window.show();

    }
}
