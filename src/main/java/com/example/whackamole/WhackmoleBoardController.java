package com.example.whackamole;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

public class WhackmoleBoardController implements Initializable {
    Random rand = new Random();
    @FXML
    private ImageView img00;

    @FXML
    private ImageView img01;

    @FXML
    private ImageView img02;

    @FXML
    private ImageView img10;

    @FXML
    private ImageView img11;

    @FXML
    private ImageView img12;

    @FXML
    private ImageView img20;

    @FXML
    private ImageView img21;

    @FXML
    private ImageView img22;

    @FXML
    void img00_Clicked(MouseEvent event) {
        System.out.println("img00 clicked");
        try {
            InputStream stream = new FileInputStream("src/main/resources/com/example/whackamole/moleUp.png");
            Image image = new Image(stream);
            img00.setImage(image);


            int randomNum = rand.nextInt(3);
            System.out.println("randomNum: " + randomNum);
            System.out.println(event.getTarget());
            img00.setId("Up");
            System.out.println(img00.getId());
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void img01_Clicked(MouseEvent event) {

    }

    @FXML
    void img02_Clicked(MouseEvent event) {

    }

    @FXML
    void img10_Clicked(MouseEvent event) {

    }

    @FXML
    void img11_Clicked(MouseEvent event) {

    }

    @FXML
    void img12_Clicked(MouseEvent event) {

    }

    @FXML
    void img20_Clicked(MouseEvent event) {

    }

    @FXML
    void img21_Clicked(MouseEvent event) {

    }

    @FXML
    void img22_Clicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("TimerTask Ticked" + new Date());
            }
        };
        t.schedule(task, new Date(), 2000);
    }
}
