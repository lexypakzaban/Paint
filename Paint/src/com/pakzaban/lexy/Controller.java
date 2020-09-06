package com.pakzaban.lexy;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


public class Controller {
    private int num;
    public AnchorPane anchorPane;
    public Slider slider1;
    public Label numLabel;
    public Pane graphPane;
    public ColorPicker colorPicker;
    public ChoiceBox choiceBox;
    public Slider opacitySlider;
    private Color myColor;
    private double opacity;
    private int radius;
    private double startX;
    private double startY;
    private Star s;
    private Heart h;
    private double scaleFactor;

    public void initialize(){
        myColor = colorPicker.getValue();
        opacity = 0.2;
        radius = 5;
        slider1.adjustValue(5);
        opacitySlider.adjustValue(0.2);
        numLabel.setText("5");
        choiceBox.setItems(FXCollections.observableArrayList("Spray","Fan","Screen","Star","Heart"));
        choiceBox.setValue("Spray");
    }

    public void setColor(){
        myColor = colorPicker.getValue();
    }

    public void mouseUsed(MouseEvent me) {
        double xBorder = (anchorPane.getWidth() - graphPane.getWidth()) / 2;
        double yBorder = (anchorPane.getHeight() - graphPane.getHeight()) / 2;
        double x = me.getSceneX() - xBorder;
        double y = me.getSceneY() - yBorder;


        if(choiceBox.getValue().equals("Spray")) {
            Circle c = new Circle(x, y, 10);
            c.setFill(myColor);
            c.setOpacity(opacity);
            c.setRadius(radius);
            graphPane.getChildren().add(c);
        }

        else if (choiceBox.getValue().equals("Fan")){
            if(me.getEventType().equals(MouseEvent.MOUSE_PRESSED)){
                startX = x;
                startY = y;
            }
            else if(me.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
                Line l = new Line(startX,startY,x,y);
                l.setStroke(myColor);
                l.setOpacity(opacity);
                l.setStrokeWidth(radius);
                graphPane.getChildren().add(l);
            }
        }

        else if (choiceBox.getValue().equals("Screen")){
            if(me.getEventType().equals(MouseEvent.MOUSE_PRESSED)){
                startX = x;
                startY = y;
            }
            else if(me.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
                Rectangle r = new Rectangle(startX,startY,x-startX,y-startY);
                r.setStroke(myColor);
                r.setFill(null);
                r.setOpacity(opacity);
                graphPane.getChildren().add(r);
            }
        }

        else if (choiceBox.getValue().equals("Star")){
            if(me.getEventType().equals(MouseEvent.MOUSE_PRESSED)){
                s = new Star(x,y,opacity,myColor);
                startX = x;
                startY = y;
                graphPane.getChildren().add(s.getStar());
            }

            else if (me.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
                scaleFactor = (x - startX)/10;
                s.getStar().setScaleX(scaleFactor);
                s.getStar().setScaleY(scaleFactor);
            }

        }

        else if (choiceBox.getValue().equals("Heart")){
            if(me.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                h = new Heart(x, y, opacity, myColor);
                startX = x;
                startY = y;
                graphPane.getChildren().add(h.getHeart());
            }

            else if (me.getEventType().equals(MouseEvent.MOUSE_DRAGGED)){
                scaleFactor = (x - startX)/10;
                h.getHeart().setScaleX(scaleFactor);
                h.getHeart().setScaleY(scaleFactor);
            }
        }

    }

    public void setSlider(){
        slider1.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number newNumber) {
                numLabel.setText(String.valueOf(newNumber.intValue()));
                radius = newNumber.intValue();
            }
        });
    }

    public void setOpacitySlider(){
        opacitySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number newNumber) {
                opacity = newNumber.doubleValue();
            }
        });
    }

    public void clearPressed(){
        graphPane.getChildren().clear();
        initialize();
    }


}
