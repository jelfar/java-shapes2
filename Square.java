/**
  * Definition for a Square. Extends Rectangle.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;
public class Square extends Rectangle {

    /**
      * Constructor.
      *
      * @param sideLength           The length of the sides of the square.
      * @param pos                  The position of the square- lower left corner.
      * @param c                    The color of the rectangle.
      * @param f                    Whether or not the rectangle is filled
      */
    public Square(int sideLength, Point pos, Color c, boolean f) {
        super(sideLength, sideLength, pos, c, f);
    }

    /**
      * Gets the sideLength of the square.
      *
      * @return                     Length of one side of square.
      */
    public int getSize(){
        return getHeight();
    }

    /**
      * Sets the sideLength of the square.
      *
      * @param sideLength           The length to change the square's sides to.
      */
    public void setSize(int sideLength){
        setWidth(sideLength);
        setHeight(sideLength);
    }

    /**
      * Sets the width of the square. Will change all of the sides
      * to keep the properties of a square in tact.
      *
      * @param w                    The width to set the rectangle to.
      */
    public void setWidth(int w) {
        super.setWidth(w);
        super.setHeight(w);
    }

    /**
      * Sets the height of the square. Will change all of the sides
      * to keep the properties of a square in tact.
      *
      * @param h                    The height to set the rectangle to.
      */
    public void setHeight(int h) {
        super.setWidth(h);
        super.setHeight(h);
    }
    
}
