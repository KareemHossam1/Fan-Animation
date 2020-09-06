package fan.animation;
// Importing Packages
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class FanAnimation extends Application {
    Circle fanCircle = new Circle(200,200,160); // Create a circle to be the fan body
    // Create 4 fans using Fan class and writing angle as an argument
    Fan fan1 = new Fan(90);
    Fan fan2 = new Fan(180);
    Fan fan3 = new Fan(270);
    Fan fan4 = new Fan(360);
    
    // Create 2 rectangles to be the fan body and setting X, Y, width and height
    Rectangle fanRectangle = new Rectangle(150,350,100,350);
    Rectangle fanRectangle2 = new Rectangle(110,700,180,40);
    
    // Creating buttons and setting their text
    Button start = new Button("Start");
    Button stop = new Button("Stop");
    Button reverse = new Button("Reverse");
    
    Label speed = new Label("\n   Speed");  // Creating a label to identify speed
    // Creating 3 radio buttons to represent speed
    RadioButton level1 = new RadioButton("1");
    RadioButton level2 = new RadioButton("2");
    RadioButton level3 = new RadioButton("3");
    
    ToggleGroup radioButtons = new ToggleGroup();   // Create a toggle group to make the user choose only 1 speed
    ComboBox color = new ComboBox();    // Create a combo box to add colors
    VBox buttons = new VBox(10);    // Create a VBox to order buttons
    VBox reverseV = new VBox(); // Create a VBox to set reverse button position
    VBox radioButtonsV = new VBox(10);  // Create a VBox to order radio buttons
    VBox comboBoxV = new VBox();    // Create a VBox to set combo box position
    Pane fanPane = new Pane();  // Create a pane to add elements on the scene
    @Override
    public void start(Stage primaryStage) {
        fanCircle.setFill(Color.WHITE); // Set fan body color
        fanCircle.setStroke(Color.BLACK);   // Set fan body stroke
        fanRectangle.setFill(Color.WHITE);  // Set fan body color
        fanRectangle.setStroke(Color.BLACK);    // Set fan body stroke
        stop.setDisable(true);  // Disable stop button by default
        speed.setStyle("-fx-font-weight: bold");    // Set speed label text style to bold
        // Add radio buttons to the same toggle group
        level1.setToggleGroup(radioButtons);
        level2.setToggleGroup(radioButtons);
        level3.setToggleGroup(radioButtons);
        
        level1.setSelected(true);   // Set leve 1 radio button selected by default
        color.getItems().addAll("Black","Red","Green","Blue");  // Add colors to combo box
        color.setPrefWidth(93); // Set combo box width
        color.setPromptText("Black");   // Set combo box default text
        buttons.getChildren().addAll(start,stop);   // Order start and stop buttons vertically
        buttons.setPadding(new Insets(400,0,0,175));    // Set start and stop buttons position
        reverseV.getChildren().addAll(reverse,speed);   // Order reverse button and speed label vertically
        reverseV.setPadding(new Insets(480,0,0,165));   // Set reverse button and speed label position
        radioButtonsV.getChildren().addAll(level1,level2,level3);   // Order radio buttons vertically
        radioButtonsV.setPadding(new Insets(560,0,0,185));  // Set radio buttons position
        comboBoxV.getChildren().add(color); // Add combo box to VBox to set its padding
        comboBoxV.setPadding(new Insets(650,0,0,154));  // Set combo box position
        fanPane.getChildren().addAll(fanRectangle,fanRectangle2,fanCircle,fan1.getFan()
                ,fan2.getFan(),fan3.getFan(),fan4.getFan(),comboBoxV,radioButtonsV,
                reverseV,buttons);  // Add elements to a pane to put them on the scene
        // Handling some elements
        // Handling start button
        start.setOnAction(e->{
            // Start fans animation
            fan1.getAnimation().play();
            fan2.getAnimation().play();
            fan3.getAnimation().play();
            fan4.getAnimation().play();
            
            start.setDisable(true); // Disable start button
            stop.setDisable(false); // Enable start button
        });
        // Handling stop button
        stop.setOnAction(e->{
            // Stop fans animation
            fan1.getAnimation().stop();
            fan2.getAnimation().stop();
            fan3.getAnimation().stop();
            fan4.getAnimation().stop();
            
            start.setDisable(false);    // Enable start button
            stop.setDisable(true);  // Disable stop button
        });
        // Handling reverse button
        reverse.setOnAction(e->{
            // Reverse direction using reverse methodd from Fan class
            fan1.reverse();
            fan2.reverse();
            fan3.reverse();
            fan4.reverse();
        });
        // Handling radio buttons
        radioButtons.selectedToggleProperty().addListener(e ->{
           if(level1.isSelected()){
                // Set fan speed to level 1 using level1 method from Fan class
                fan1.level1();
                fan2.level1();
                fan3.level1();
                fan4.level1();
           } 
           else if(level2.isSelected()){
               // Set fan speed to level 2 using level2 method from Fan class
                fan1.level2();
                fan2.level2();
                fan3.level2();
                fan4.level2();
           } 
           else if(level3.isSelected()){
               // Set fan speed to level 3 using level3 method from Fan class
                fan1.level3();
                fan2.level3();
                fan3.level3();
                fan4.level3();
           }});
        // Handling combo box
        color.getSelectionModel().selectedItemProperty().addListener((x,y,z)->{
        if (color.getValue()=="Black"){
            // Change fan color to black when the user chooses it
            fan1.getFan().setFill(Color.BLACK); 
            fan2.getFan().setFill(Color.BLACK); 
            fan3.getFan().setFill(Color.BLACK); 
            fan4.getFan().setFill(Color.BLACK);
        }
        else if(color.getValue()=="Red") {
            // Change fan color to red when the user chooses it
            fan1.getFan().setFill(Color.RED);  
            fan2.getFan().setFill(Color.RED); 
            fan3.getFan().setFill(Color.RED); 
            fan4.getFan().setFill(Color.RED);
        }
        else if(color.getValue()=="Green"){
            // Change fan green to black when the user chooses it
            fan1.getFan().setFill(Color.LAWNGREEN); 
            fan2.getFan().setFill(Color.LAWNGREEN); 
            fan3.getFan().setFill(Color.LAWNGREEN); 
            fan4.getFan().setFill(Color.LAWNGREEN);
        }
        else if(color.getValue()=="Blue") { 
            // Change fan color to blue when the user chooses it
            fan1.getFan().setFill(Color.BLUE); 
            fan2.getFan().setFill(Color.BLUE); 
            fan3.getFan().setFill(Color.BLUE); 
            fan4.getFan().setFill(Color.BLUE);          
        }});
        Scene scene = new Scene(fanPane, 400, 725); // Create scene and set the size
        primaryStage.setResizable(false);   // Disable resizing stage option
        primaryStage.setTitle("Move Fan");  // Window title
        primaryStage.setScene(scene);   // Add scene
        primaryStage.show();    // Show window
    }
    public static void main(String[] args) {
        launch(args);
}}