/**
  * This is the abstract class for shapes;
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;

public abstract class Shape implements Comparable<Shape> {

    private Color color;
    private boolean isFilled;

    /**
      * Constructor.
      *
      * @param c                    The color of the shape.
      * @param f                    Whether or not the shape is filled
      */
    public Shape(Color c, boolean f){
        color = new Color(c.getRed(), c.getGreen(), c.getBlue());
        isFilled = f;
    }

    /**
      * Calculates and returns the area of the shape.
      *
      * @return                     The area of the shape.
      */
    public abstract double getArea();

    /**
      * Returns the color of the shape.
      *
      * @return                     Returns the color of ths shape.
      */
    public Color getColor(){
        return new Color(color.getRed(), color.getGreen(), color.getBlue());
    }

    /**
      * Sets the color of the shape.
      *
      * @param color                The color of the shape.
      */
    public void setColor(Color c){
        color = c;
    }

    /**
      * Returns true if the shape is filled with color, otherwise false (shape is wire-framed).
      *
      * @return                     Whether the shape is filled or not.
      */
    public boolean getFilled(){
        return isFilled;
    }

    /**
      * Sets the filled state of the shape to the specified value.
      *
      * @param filled               Whether the shape is filled or not.
      */
    public void setFilled(boolean filled){
        isFilled = filled;
    }

    /**
      * Returns the currrent position of the shape.
      *
      * @return                     The position of the shape.
      */
    public abstract Point getPosition();

    /**
      * Changes the position of the shape to the specfied Point.
      *
      * @param position                 The position to move the shape to.
      */
    public abstract void setPosition(Point position);

    /**
      * Moves the shape by the x and y amounts specified (in the Point delta).
      *
      * @param delta                   The x and y delta of the position to move the shape to. 
      */
    public abstract void move(Point delta);

    /**
      * Testing equality between two ConvexPolygons.
      *
      * @return                 Returns whether this ConvexPolygon is equal to o.
      *                         Checks vertices, color, isFilled variables.
      */
    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Shape))
            return false;

        Shape sh = (Shape) o;

        return (this.getColor().equals(sh.getColor())) &&
               (this.getFilled() == sh.getFilled());
    }

    /**
      * Compares this object to the given object.
      *
      * Returns:
      *
      *     1) A negative value(-1) when a's class name is less that b's class name or, when the names 
      *             are equal, when a's area is less than b's area.
      *     2) Zero when a's class name equals b's class name and a's area is approximately equal
      *             to b's area (+/- 0.0001).
      *     3) A positive value(1) when a's class name is greater than b's class name or, whe the names 
      *             are equal, when a's area is greater than b's area.
      *
      * @param o                       The Shape to compare to.
      */
    @Override
    public int compareTo(Shape o){
        String myClassName = this.getClass().getName();
        String otherClassName = o.getClass().getName();

        int key;
        /** Compares class names */
        if((key = myClassName.compareTo(otherClassName)) < 0)
            return -1;
        else if(key > 0)
            return 1;
        /** Compares areas */
        else {
            if(this.getArea() < o.getArea())
                return -1;
            else if(this.getArea() > o.getArea())
                return 1;
            else
                return 0;
        }
    }

}
