/**
  * Definition for a Ellipse. Extends Shape.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;
public class Ellipse extends Shape {

    private double semiMajorAxis, semiMinorAxis;
    private Point position;

    /**
      * Constructor.
      *
      * @param semiMajorAxis        The distance from the center to its furthest edge.
      * @param semiMinorAxis        The distance from the center to its closest edge.
      * @param pos                  The position of the rectangle- lower left corner.
      * @param c                    The color of the rectangle.
      * @param f                    Whether or not the rectangle is filled
      */
    public Ellipse(double semiMajorAx, double semiMinorAx, Point pos, Color c, boolean f) {
        super(c, f);
        semiMajorAxis = semiMajorAx;
        semiMinorAxis = semiMinorAx;
        position = new Point((int)pos.getX(), (int)pos.getY());
    }

    /**
      * Gets the semi major axis of the ellipse.
      *
      * @return                     The semi major axis of the ellipse.
      */
    public double getSemiMajorAxis(){
        return semiMajorAxis;
    }

    /**
      * Sets the semi major axis of the ellipse. 
      * Accounts for conflicts with semi minor axis.
      *
      * @param val                  The value to set the axis.
      */
    public void setSemiMajorAxis(double val){
        if(val < semiMinorAxis){
            double temp = semiMinorAxis;
            semiMinorAxis = val;
            semiMajorAxis = temp;
        } else {
            semiMajorAxis = val;
        }
    }

    /**
      * Gets the semi minor axis of the ellipse.
      *
      * @return                     The semi major axis of the ellipse.
      */
    public double getSemiMinorAxis(){
        return semiMinorAxis;
    }

    /**
      * Sets the semi minor axis of the ellipse. 
      * Accounts for conflicts with semi major axis.
      *
      * @param val                  The value to set the axis.
      */
    public void setSemiMinorAxis(double val){
        if(val > semiMajorAxis){
            double temp = semiMajorAxis;
            semiMajorAxis = val;
            semiMinorAxis = temp;
        } else {
            semiMinorAxis = val;
        }
    }

    /**
      * Calculates and returns the area of the ellipse.
      *
      * @return                     The area of the ellipse.
      */
    public double getArea(){
        return semiMajorAxis * semiMinorAxis * Math.PI;
    }

    /**
      * Returns the currrent position of the ellipse.
      *
      * @return                     The center of the ellipse.
      */
    public Point getPosition(){
        return new Point((int)position.getX(), (int)position.getY());
    }

    /**
      * Changes the position of the ellipse to the specfied Point.
      *
      * @param pos                   The position to move the shape to.
      */
    public void setPosition(Point pos){
        position = new Point((int)pos.getX(), (int)pos.getY());
    }

    /**
      * Moves the shape by the x and y amounts specified (in the Point delta).
      *
      * @param delta                   The x and y delta of the position to move the shape to. 
      */
    public void move(Point delta){
        setPosition(new Point((int)(position.getX() + delta.getX()), (int)(position.getY() + delta.getY())));
    }

    /**
      * Testing equality between two Ellipses.
      *
      * @return                 Returns whether this ConvexPolygon is equal to o.
      *                         Checks vertices, color, isFilled variables.
      */
    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Shape))
            return false;

        Ellipse el = (Ellipse)o;
        
        return (this.getColor().equals(el.getColor())) &&
               (this.getFilled() == el.getFilled()) &&
               (this.semiMinorAxis == el.getSemiMinorAxis()) &&
               (this.semiMajorAxis == el.getSemiMajorAxis()) &&
               (this.position.equals(el.getPosition()));
    }
}
