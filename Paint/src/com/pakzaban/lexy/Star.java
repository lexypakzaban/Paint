package com.pakzaban.lexy;

import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Star {
    private double x;
    private double y;
    private double opacity;
    private Color myColor;
    private Path star;

    public Star(double x, double y, double opacity, Color myColor) {
        this.x = x;
        this.y = y;
        this.opacity = opacity;
        this.myColor = myColor;
        star = new Path();
        MoveTo moveTo = new MoveTo(x,y);
        LineTo l1 = new LineTo(x-20,y-50);
        LineTo l2 = new LineTo(x+30,y-20);
        LineTo l3 = new LineTo(x-30,y-20);
        LineTo l4 = new LineTo(x+20,y-50);
        LineTo l5 = new LineTo(x,y);
        star.getElements().addAll(moveTo,l1,l2,l3,l4,l5);
        star.setFill(myColor);
        star.setOpacity(opacity);
        star.setStroke(null);
    }

    public Path getStar() {
        return star;
    }
}
