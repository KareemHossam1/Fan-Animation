package fan.animation;
// Importing packages
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;
public class Fan {
    Arc fan = new Arc();    // Create an arc to make the fan
    Timeline moveFan;   // Create a timeline to move the fan
    int newAngle;   // Variable to change angle
    boolean CCW = true; // Boolean variable to reverse direction to be clock wise or counter clock wise
    // Create a constructor
    public Fan(int angle){  // enter angle as an argument
        fan.setCenterX(200);    // Set center x position
        fan.setCenterY(200);    // Set center y position
        fan.setRadiusX(150);    // set radius
        fan.setRadiusY(150);    // set radius
        fan.setStartAngle(angle);   // set angle
        fan.setLength(40);  // set arc lenght
        fan.setType(ArcType.ROUND); // set arc type
        fan.setStroke(Color.BLACK); // make a stroke line
        newAngle = angle;   // store angle value in a variable
        moveFan= new Timeline(new KeyFrame(Duration.millis(50),e->{ // timeline to move the fan every 50 milli seconds
            if (CCW){   
            newAngle+=10;   // Change angle CCW
            fan.setStartAngle(newAngle);    // Set the new angle
            }
            else{
                newAngle-=10;   // Change angle CW
                fan.setStartAngle(newAngle);   // Set the new angle 
            }}));   
        moveFan.setCycleCount(Timeline.INDEFINITE); // Set Cycle count to indefinite
    }
    // Creating methods
    // A method to return the fan
    public Arc getFan(){
        return fan;
    }
    // A method to reverse direction
    public void reverse(){
        if (CCW)
            CCW = false;
        else
            CCW = true;
    }
    // A method to return timeline
    public Timeline getAnimation(){
        return moveFan;
    }
    // 3 Methods to change animation speed
    public void level1(){
        moveFan.setRate(1);
    }
    public void level2(){
        moveFan.setRate(2.5);
    }
    public void level3(){
        moveFan.setRate(5);
    }}