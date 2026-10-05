import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.event.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 05.09.2022
 * @author 
 */

public class GUI extends Application {
    // Anfang Attribute
    private Label lPOP3Server1 = new Label();
    private Label lNutzername1 = new Label();
    private Label lNachricht1 = new Label();
    private Label lVon = new Label();
    private Label lEMail = new Label();
    private TextField tfServer = new TextField();
    private TextField tfName = new TextField();
    private TextField tfNummer = new TextField();
    private Label lKennwort = new Label();
    private PasswordField pfKennwort = new PasswordField();
    private Button bAnmelden = new Button();
    private Button bMailholen = new Button();
    private Button bVorige = new Button();
    private Button bNaechste = new Button();
    private TextArea taAusgabe = new TextArea();
    private Button bAbmelden = new Button();

    private POP3client pop;
    // Ende Attribute

    public void start(Stage primaryStage) { 
        Pane root = new Pane();
        Scene scene = new Scene(root, 621, 562);
        // Anfang Komponenten

        lPOP3Server1.setLayoutX(16);
        lPOP3Server1.setLayoutY(16);
        lPOP3Server1.setPrefHeight(20);
        lPOP3Server1.setPrefWidth(86);
        lPOP3Server1.setText("POP3-Server:");
        root.getChildren().add(lPOP3Server1);
        lNutzername1.setLayoutX(16);
        lNutzername1.setLayoutY(48);
        lNutzername1.setPrefHeight(20);
        lNutzername1.setPrefWidth(86);
        lNutzername1.setText("Nutzername:");
        root.getChildren().add(lNutzername1);
        lNachricht1.setLayoutX(16);
        lNachricht1.setLayoutY(136);
        lNachricht1.setPrefHeight(20);
        lNachricht1.setPrefWidth(86);
        lNachricht1.setText("Nachricht:");
        root.getChildren().add(lNachricht1);
        lVon.setLayoutX(144);
        lVon.setLayoutY(136);
        lVon.setPrefHeight(20);
        lVon.setPrefWidth(46);
        lVon.setText("von 0");
        root.getChildren().add(lVon);
        lEMail.setLayoutX(16);
        lEMail.setLayoutY(200);
        lEMail.setPrefHeight(20);
        lEMail.setPrefWidth(78);
        lEMail.setText("E-Mail:");
        root.getChildren().add(lEMail);
        tfServer.setLayoutX(104);
        tfServer.setLayoutY(16);
        tfServer.setPrefHeight(25);
        tfServer.setPrefWidth(150);
        tfServer.setText("10.50.248.1");
        root.getChildren().add(tfServer);
        tfName.setLayoutX(104);
        tfName.setLayoutY(48);
        tfName.setPrefHeight(25);
        tfName.setPrefWidth(150);
        tfName.setText("vaut");
        root.getChildren().add(tfName);
        tfNummer.setLayoutX(104);
        tfNummer.setLayoutY(136);
        tfNummer.setPrefHeight(25);
        tfNummer.setPrefWidth(30);
        tfNummer.setText("0");
        tfNummer.setPromptText("Nr.");
        root.getChildren().add(tfNummer);
        lKennwort.setLayoutX(16);
        lKennwort.setLayoutY(80);
        lKennwort.setPrefHeight(20);
        lKennwort.setPrefWidth(86);
        lKennwort.setText("Kennwort:");
        root.getChildren().add(lKennwort);
        pfKennwort.setLayoutX(104);
        pfKennwort.setLayoutY(80);
        pfKennwort.setPrefHeight(25);
        pfKennwort.setPrefWidth(150);
        pfKennwort.setText("tuav");
        root.getChildren().add(pfKennwort);
        bAnmelden.setLayoutX(296);
        bAnmelden.setLayoutY(48);
        bAnmelden.setPrefHeight(25);
        bAnmelden.setPrefWidth(75);
        bAnmelden.setOnAction(
            (event) -> {bAnmelden_Action(event);} 
        );
        bAnmelden.setText("Anmelden");
        bAnmelden.setTextAlignment(TextAlignment.CENTER);
        bAnmelden.setAlignment(Pos.CENTER);
        root.getChildren().add(bAnmelden);
        bMailholen.setLayoutX(200);
        bMailholen.setLayoutY(136);
        bMailholen.setPrefHeight(25);
        bMailholen.setPrefWidth(75);
        bMailholen.setOnAction(
            (event) -> {bMailholen_Action(event);} 
        );
        bMailholen.setText("Mail holen");
        bMailholen.setContentDisplay(ContentDisplay.LEFT);
        bMailholen.setAlignment(Pos.CENTER);
        root.getChildren().add(bMailholen);
        bVorige.setLayoutX(104);
        bVorige.setLayoutY(168);
        bVorige.setPrefHeight(25);
        bVorige.setPrefWidth(59);
        bVorige.setOnAction(
            (event) -> {bVorige_Action(event);} 
        );
        bVorige.setText("vorige");
        bVorige.setContentDisplay(ContentDisplay.CENTER);
        root.getChildren().add(bVorige);
        bNaechste.setLayoutX(168);
        bNaechste.setLayoutY(168);
        bNaechste.setPrefHeight(25);
        bNaechste.setPrefWidth(67);
        bNaechste.setOnAction(
            (event) -> {bNaechste_Action(event);} 
        );
        bNaechste.setText("nächste");
        bNaechste.setAlignment(Pos.CENTER);
        root.getChildren().add(bNaechste);
        taAusgabe.setLayoutX(104);
        taAusgabe.setLayoutY(200);
        taAusgabe.setPrefHeight(340);
        taAusgabe.setPrefWidth(488);
        root.getChildren().add(taAusgabe);
        bAbmelden.setLayoutX(405);
        bAbmelden.setLayoutY(47);
        bAbmelden.setPrefHeight(25);
        bAbmelden.setPrefWidth(75);
        bAbmelden.setOnAction(
            (event) -> {bAbmelden_Action(event);} 
        );
        bAbmelden.setText("Abmelden");
        root.getChildren().add(bAbmelden);
        // Ende Komponenten

        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setTitle("GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end of public GUI

    // Anfang Methoden

    public static void main(String[] args)
    {
        launch(args);
    } // end of main

    public void bAnmelden_Action(Event evt)
    {
        pop = new POP3client(tfServer.getText(),110,this);
        pop.meldeAn(tfName.getText(), pfKennwort.getText());
    } // end of bAbmelden_Action

    public void bAbmelden_Action(Event evt)
    {
        pop.close();    
    } // end of bAbmelden_Action

    public void bMailholen_Action(Event evt)
    {
        pop.fetch();    
    } // end of bAbmelden_Action

    public void bVorige_Action(Event evt)
    {
        pop.prev();    
    } // end of bAbmelden_Action

    public void bNaechste_Action(Event evt)
    {
        pop.next();    
    } // end of bAbmelden_Action

    public void ausgabeAppend(String pText)
    {
        taAusgabe.appendText(pText + "\n");    
    } // end of bAbmelden_Action

    public void setVon(int pAnzahl)
    {
        lVon.setText("von " + String.valueOf(pAnzahl));
    } // end of bAbmelden_Action

    public void setNummer(int pNr)
    {
        tfNummer.setText(String.valueOf(pNr));    
    } // end of bAbmelden_Action
    public int getCurrentMessage(){
        int currentNumber;
        currentNumber = Integer.parseInt(tfNummer.getText());
        return currentNumber; 
    }
    // Ende Methoden
} // end of class GUI

