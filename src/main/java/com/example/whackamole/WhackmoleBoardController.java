package com.example.whackamole;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.util.*;

public class WhackmoleBoardController implements Initializable {
    Random rand = new Random(1929394890);
    String up = "file:/Users/bynx/IdeaProjects/Whack-a-Mole/src/main/resources/com/example/whackamole/MoleUp.PNG";
    String down = "file:/Users/bynx/IdeaProjects/Whack-a-Mole/src/main/resources/com/example/whackamole/MoleDown.PNG";
    String whack = "file:/Users/bynx/IdeaProjects/Whack-a-Mole/src/main/resources/com/example/whackamole/MoleWhack.jpg";


    boolean gameOver = false;


    @FXML
    private void setMoleUp(ImageView mole) throws FileNotFoundException {
        Image image = new Image(up);
        mole.setImage(image);
        mole.setId("moleUp");
    }

    @FXML
    private void setMoleDown(ImageView mole) throws FileNotFoundException {
        Image image = new Image(down);
        mole.setImage(image);
        mole.setId("moleDown");
    }

    @FXML
private void setMoleWhack(ImageView mole) throws FileNotFoundException, InterruptedException {
        Image image = new Image(whack);
        mole.setImage(image);
        mole.setId("moleWhack");
        //setMoleDown(mole);
    }

    int score = 0;

    @FXML
    private Text FinalScore;
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
    void image_Clicked(MouseEvent event) throws FileNotFoundException, InterruptedException {
        if (gameOver) {
            return;
        }
        ImageView image = (ImageView) event.getSource();
        if (image.getId().equals("moleUp")) {
            score++;
            setMoleWhack(image);
        }
    }


    @FXML
    void img00_Clicked(MouseEvent event) {
        System.out.println("img00 clicked");
        try {
            InputStream stream = new FileInputStream("src/main/resources/com/example/whackamole/moleUp.png");
            Image image = new Image(stream);
            img00.setImage(image);


            //int randomNum = rand.nextInt(3);
            System.out.println(event.getTarget());
            //img00.setId("Up");
            //System.out.println(img00.getId());
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
    void img02_Clicked(MouseEvent event) throws FileNotFoundException {
    }

    @FXML
    void img10_Clicked(MouseEvent event) throws FileNotFoundException {
    }

    @FXML
    void img11_Clicked(MouseEvent event) throws FileNotFoundException {
    }

    @FXML
    void img12_Clicked(MouseEvent event) throws FileNotFoundException {
    }

    @FXML
    void img20_Clicked(MouseEvent event) throws FileNotFoundException {
    }

    @FXML
    void img21_Clicked(MouseEvent event) throws FileNotFoundException {
    }

    @FXML
    void img22_Clicked(MouseEvent event) throws FileNotFoundException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Timer t = new Timer();
        ImageView[][] moles = { {this.img00, this.img01, this.img02}, {this.img10, this.img11, this.img12}, {this.img20, this.img21, this.img22} };
        TimerTask task = new TimerTask() {
            int time = 10;
            @Override
            public void run() {
                if (time == 0) {
                    t.cancel();
                    gameOver = true;
                    FinalScore.setText("Final Score: " + score);
                }
                else {
                    time--;
                    for (int i = 0; i < 4; i++) {
                        int randomRow = rand.nextInt(3);
                        int randomCol = rand.nextInt(3);
                        try {
                            setMoleUp(moles[randomRow][randomCol]);
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }


                }
            }
        };
        t.schedule(task, new Date(), 1000);
    }
}
