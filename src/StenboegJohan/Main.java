package StenboegJohan;
//Importing the differet javafx classes.
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.layout.*;

//Making the main class.
public class Main extends Application {
    //Declareing the controlls.
    TextField txtnum1, txtnum2;
    Button btnadd, btnsub, btndiv, btnmul, btnclear, btnEuro, btnDkk;
    Label lblanswer;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        StackPane holder = new StackPane();
        Canvas canvas = new Canvas(400,  400);
        holder.getChildren().add(canvas);
        pane.getChildren().add(holder);
        holder.setStyle("-fx-background-color: #FF0000");
        //Making the different controls.
        btnDkk = new Button("Dkk");
        btnDkk.setStyle("-fx-border-color: #0000FF; -fx-padding: 10px; -fx-background-color: aqua; -fx-font-size: 15px");
        btnEuro = new Button("Euro");
        btnEuro.setStyle("-fx-border-color: #0000FF; -fx-padding: 10px; -fx-background-color: aqua; -fx-font-size: 15px");
        txtnum1 = new TextField();
        txtnum2 = new TextField();
        btnadd = new Button("+");
        btnadd.setStyle("-fx-border-color: #0000FF; -fx-padding: 10px; -fx-background-color: aqua; -fx-font-size: 15px");
        btnsub = new Button("-");
        btnsub.setStyle("-fx-border-color: #0000FF; -fx-padding: 10px; -fx-background-color: aqua; -fx-font-size: 15px");
        btnmul = new Button("*");
        btnmul.setStyle("-fx-border-color: #0000FF; -fx-padding: 10px; -fx-background-color: aqua; -fx-font-size: 15px");
        btndiv = new Button("/");
        btndiv.setStyle("-fx-border-color: #0000FF; -fx-padding: 10px; -fx-background-color: aqua; -fx-font-size: 15px");
        btnclear = new Button("Clear");
        lblanswer = new Label("-Answer-");
        lblanswer.setAlignment(Pos.CENTER);
        lblanswer.setStyle("-fx-border-color: #0000FF; -fx-padding: 10px; -fx-background-color: aquamarine;-fx-font-size: 15px");

        //Making the container for the app
        GridPane root = new GridPane();
        //Put container in middle of scene
        root.setAlignment(Pos.CENTER);
        //Setting spacing between controls in grid.
        root.setHgap(20);
        root.setVgap(20);
        //Add to grid, cell by cell
        root.add(btnadd, 0, 0);
        root.add(btnsub, 1, 0);
        root.add(btnmul, 0, 1);
        root.add(btndiv, 1, 1);
        root.add(txtnum1, 0, 2);
        root.add(txtnum2, 1, 2);
        root.add(btnDkk, 2, 1);
        root.add(btnEuro, 2, 0);
        //Last 2 rows span across 2 columns
        //Col, rol, colspan, rowspan.
        root.add(lblanswer, 0, 3, 2, 1);
        root.add(btnclear, 0, 4, 2, 1);
        //Set widths of all controls in separate method.
        setWidths();
        setHeights();
        //Making the textfield everything is going to be showed in.
        attachingTheCode();
        Scene scene = new Scene(root, 400, 400); //300 pixels in height, 250 in width.
        primaryStage.setTitle("Lommeregner 2.0"); //Giving the window a name.
        primaryStage.setScene(scene);
        primaryStage.show(); //Setting the window to actually show.
    }
    public void setWidths() {
        //Setting the preferred width of the buttons and labels in pixels.
        txtnum1.setPrefWidth(70);
        txtnum2.setPrefWidth(70);
        btnadd.setPrefWidth(70);
        btnsub.setPrefWidth(70);
        btnmul.setPrefWidth(70);
        btndiv.setPrefWidth(70);
        btnDkk.setPrefWidth(70);
        btnEuro.setPrefWidth(70);
        btnclear.setPrefWidth(160);
        lblanswer.setPrefWidth(160);
    }
    public void setHeights(){
        btnDkk.setPrefHeight(5);
        btnEuro.setPrefHeight(5);
    }
    public void attachingTheCode(){
        btnadd.setOnAction(e -> btncode(e));
        btnsub.setOnAction(e -> btncode(e));
        btnmul.setOnAction(e -> btncode(e));
        btndiv.setOnAction(e -> btncode(e));
        btnclear.setOnAction(e -> btncode(e));
        btnDkk.setOnAction(e -> btncode(e));
        btnEuro.setOnAction(e -> btncode(e));

    }
    //Making the action event, aka when i press the different buttons diffrent actions are going to happen.
    public void btncode(ActionEvent e) {
        //e tells us which button was clicked
        if (e.getSource() == btnclear) {
            txtnum1.setText("");
            txtnum2.setText("");
            lblanswer.setText(" ");
            txtnum1.requestFocus();
            return;
        }
        //Read numbers in from the textfields and doing actions made with if else statements.
        char symbol = 0;
        String kurs = " ";
        int num1, num2, answer = 0;
        num1 = Integer.parseInt(txtnum1.getText());
        num2 = Integer.parseInt(txtnum2.getText());

        if (e.getSource() == btnadd) { //if btnadd is clicked, its supposed to add the numbers ect.
                symbol = '+';
                answer = num1 + num2;
            }
        else if (e.getSource() == btnsub) {
            symbol = '-';
            answer = num1 - num2;
        }
        else if(e.getSource()==btnmul) {
            symbol = '*';
            answer = num1 * num2;
        }
        else if(e.getSource()==btndiv) {
            symbol = '/';
            answer = num1 / num2;
        }



            /*
            if(e.getSource()==btnDkk){
                kurs = "Dkk";
                symbol = '+';
                answer = num1 + num2;
            }
            else if (e.getSource()==btnEuro) {
                kurs = "Euro";
                symbol = '+';
                answer = num1 + num2;
            }
        } else if (e.getSource() == btnsub) {
            if(e.getSource()==btnDkk){
                kurs = "Dkk";
                symbol = '-';
                answer = num1 - num2;
            }
                else if (e.getSource()==btnEuro){
                kurs = "Euro";
                symbol = '-';
                answer = num1 - num2;
            }
        } else if (e.getSource() == btnmul) {
            if(e.getSource()==btnDkk){
                kurs = "Dkk";
                symbol = '*';
                answer = num1 * num2;
            }
            else if (e.getSource()==btnEuro) {
                kurs = "Euro";
                symbol = '*';
                answer = num1 * num2;
            }
        } else if (e.getSource() == btndiv) {
            if(e.getSource()==btnDkk){
                kurs = "Dkk";
                symbol = '/';
                answer = num1 / num2;
            }
            else if (e.getSource()==btnEuro) {
                kurs = "Euro";
                symbol = '/';
                answer = num1 / num2;
                */


        //Displaying the answer
        lblanswer.setText("" + num1 + " " + symbol + " " + num2 + " = " + answer + " " + kurs);
    }
    public static void main(String[] args) {
        launch(args);
    }
}

