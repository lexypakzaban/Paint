package com.pakzaban.lexy;

import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Heart {
    private double x;
    private double y;
    private double opacity;
    private Color myColor;
    private Path heart;

    public Heart(double x, double y, double opacity, Color myColor) {
        this.x = x;
        this.y = y;
        this.opacity = opacity;
        this.myColor = myColor;
        heart = new Path();

        MoveTo moveTo = new MoveTo(x,y);

        CubicCurveTo c1 = new CubicCurveTo();
        c1.setX(x);
        c1.setY(y-50);
        c1.setControlX1(x-40);
        c1.setControlY1(y-30);
        c1.setControlX2(x-30);
        c1.setControlY2(y-70);

        CubicCurveTo c2 = new CubicCurveTo();
        c2.setX(x);
        c2.setY(y);
        c2.setControlX1(x+30);
        c2.setControlY1(y-70);
        c2.setControlX2(x+40);
        c2.setControlY2(y-30);

        heart.getElements().addAll(moveTo,c1,c2);
        heart.setFill(myColor);
        heart.setOpacity(opacity);
        heart.setStroke(null);
    }

    public Path getHeart() {
        return heart;
    }
}
