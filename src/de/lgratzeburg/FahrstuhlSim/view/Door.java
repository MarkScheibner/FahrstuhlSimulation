package de.lgratzeburg.FahrstuhlSim.view;


import java.awt.*;

public class Door extends Panel{

    private Panel leftPart;
    private Panel rightPart;
    public Door(Color c, int borderThickness, Point p, Dimension d){
        super(c, borderThickness, p, d);

        leftPart = new Panel(c, borderThickness, new Point(0, 0), new Dimension(this.getWidth() / 2, this.getHeight()));
        rightPart = new Panel(c, borderThickness, new Point(0 + leftPart.getWidth(), 0), new Dimension(this.getWidth() / 2, this.getHeight()));
        add(leftPart);
        add(rightPart);
    }
}
