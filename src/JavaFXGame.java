/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author bruno
 */
public class JavaFXGame extends Application {
    Scene scene;
    Group root, gameBoard;
    StackPane uiLayout;
    VBox uiContainer;
    Insets uiPadding;
    ImageView boardGameBackPlate, logoLayer;
    TextFlow infoOverlay;
    Image splashScreen, helpLayer, legalLayer, creditLayer, scoreLayer, backPlate, alphaLogo;
    Button gameButton, helpButton, legalButton, creditButton, scoreButton;
    Text playText, moreText, helpText, cardText, copyText, riteText, credText, codeText;
    BackgroundImage uiBackgroundImage;
    Background uiBackground;
    
    @Override
    public void start(Stage primaryStage) {
        loadImageAssets();
        createTextAssets();
        createBoardGameNode();
        addNodesToSceneGraph();
        
        primaryStage.setTitle("iTVBoardGame (JavaFX 17 Game)");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        gameButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Starting Game");
            } 
        });
        
        helpButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Game Instructions");
            }   
        });
        
        scoreButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Game High Scores");
            } 
        });
        
        legalButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Legal Disclaimers");
            }
        });
        
        creditButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Production Credits");
            }
            
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    private void createBoardGameNode() {
        root = new Group();
        gameBoard = new Group();
        scene = new Scene(root, 1280, 640);
        scene.setFill(Color.TRANSPARENT);
        uiLayout = new StackPane();
        uiLayout.setBackground(uiBackground);
        boardGameBackPlate = new ImageView();
        boardGameBackPlate.setImage(splashScreen);
        logoLayer = new ImageView();
        logoLayer.setImage(alphaLogo);
        logoLayer.setScaleX(0.8);
        logoLayer.setScaleY(0.8);
        logoLayer.setTranslateX(-75);
        logoLayer.setTranslateY(-225);
        infoOverlay = new TextFlow();
        infoOverlay.setTranslateX(240);
        infoOverlay.setTranslateY(420);
        uiContainer = new VBox(10);
        uiContainer.setAlignment(Pos.TOP_RIGHT);
        uiPadding = new Insets(16);
        uiContainer.setPadding(uiPadding);
        gameButton = new Button();
        gameButton.setText("Start Game");
        gameButton.setMaxWidth(125);
        helpButton = new Button();
        helpButton.setText("Game Rules");
        helpButton.setMaxWidth(125);
        scoreButton = new Button();
        scoreButton.setText("High Scores");
        scoreButton.setMaxWidth(125);
        legalButton = new Button();
        legalButton.setText("Disclaimets");
        legalButton.setMaxWidth(125);
        creditButton = new Button();
        creditButton.setText("Game Credits");
        creditButton.setMaxWidth(125);
        
    }

    private void addNodesToSceneGraph() {
        root.getChildren().addAll(gameBoard, uiLayout);
        uiLayout.getChildren().addAll(boardGameBackPlate, logoLayer, infoOverlay, uiContainer);
        uiContainer.getChildren().addAll(gameButton, helpButton, legalButton, creditButton, scoreButton);
        infoOverlay.getChildren().addAll(playText, moreText);
    }

    private void loadImageAssets() {
        backPlate = new Image("file:src/imgs/backplate8.png", 1280, 640, true, false, true);
        alphaLogo = new Image("file:src/imgs/alphalogo.png");
        splashScreen = new Image("file:src/imgs/welcome.png", 1280, 640, true, false, true);
        helpLayer = new Image("file:src/imgs/copyrights.png", 1280, 640, true, false, true);
        legalLayer = new Image("file:src/imgs/copyrights.png", 1280, 640, true, false, true);
        creditLayer = new Image("file:src/imgs/credits.png", 1280, 640, true, false, true);
        scoreLayer = new Image("file:src/imgs/highsocres.png", 1280, 640, true, false, true);
        uiBackgroundImage = new BackgroundImage(backPlate, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                                                           BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        uiBackground = new Background(uiBackgroundImage);
    }

    private void createTextAssets() {
        playText = new Text("Press the Start Game Button to Start! \n");
        playText.setFill(Color.WHITE);
        playText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 50));
        
        moreText = new Text("Use other buttons for instructions,\ncopyright, credits and high scores.");
        moreText.setFill(Color.WHITE);
        moreText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 50));
        
        helpText = new Text("To play game roll dice, advance\ngame piece, follow gameboard\ninstruction.");
        helpText.setFill(Color.GREEN);
        helpText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 50));
        
        cardText = new Text("If you land on square\nthat requires card draw it will\nappear in UI area.");
        cardText.setFill(Color.GREEN);
        cardText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 50));
        
        copyText = new Text("Copyrught 2021 Bruno Barbosa,\nAll Rights Reserved.\n");
        copyText.setFill(Color.PURPLE);
        copyText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 50));
        
        riteText = new Text("Visit the bruno13plhano.com website");
        riteText.setFill(Color.PURPLE);
        riteText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 50));
        
        credText = new Text("Digital Imaging. 3D Modeling, 3D\nTexture Mapping, by Wallace Jackson.\n");
        credText.setFill(Color.BLUE);
        credText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 50));
        
        codeText = new Text("Game Design, User Interface Design,\nJava Programming by Wallace Jackson.");
        codeText.setFill(Color.BLUE);
        codeText.setFont(Font.font("Helvetica", FontPosture.REGULAR, 50));
        
    }
}
