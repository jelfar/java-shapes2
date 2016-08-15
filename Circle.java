/**
  * Definition for a circle. Extends Ellipse.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;
public class Circle extends Ellipse {

    /**
      * Constructor.
      *
      * @param r                    The radius of the circle.
      * @param p                    The center of the circle.
      * @param c                    The color of the circle.
      * @param f                    Whether or not the circle is filled
      */
    public Circle(double r, Point p, Color c, boolean f){
        super(r, r, p, c ,f);
    }

    /**
      * Gets the radius of the circle.
      *
      * @return                 The radius of the circle.
      */
    public double getRadius() {
        return getSemiMajorAxis();
    }

    /**
      * Sets the radius of the circle.
      *
      * @param r                    The radius to set the circle to.
      */
    public void setRadius(double r) {
        super.setSemiMajorAxis(r);
        super.setSemiMinorAxis(r);
        super.setSemiMajorAxis(r);
    }

    /**
      * For a circle, this will just change the radius.
      *
      * @param val                  The value to set the axis.
      */
    @Override
    public void setSemiMajorAxis(double val){
        this.setRadius(val);
    }

    /**
      * For a circle, this will just change the radius.
      *
      * @param val                  The value to set the axis.
      */
    @Override
    public void setSemiMinorAxis(double val){
        this.setRadius(val);
    }
    
}
