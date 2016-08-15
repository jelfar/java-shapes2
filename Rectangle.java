/**
  * Definition for a rectangle. Extends ConvexPolygon.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;
public class Rectangle extends ConvexPolygon {

    /**
      * Constructor.
      *
      * @param w                    The width of the rectangle.
      * @param h                    The height of the rectangle.
      * @param p                    The position of the rectangle- lower left corner.
      * @param c                    The color of the rectangle.
      * @param f                    Whether or not the rectangle is filled
      */
    public Rectangle(int w, int h, Point p, Color c, boolean f) {
        super(new Point[] {p, new Point((int)(p.getX() + w), (int)p.getY()), new Point((int)(p.getX() + w), (int)(p.getY() - h)), new Point((int)p.getX(), (int)(p.getY() - h))} , c, f);
    }
    
    /**
      * Sets the vertex at the specified index.
      *
      * @param index                The index to change.
      * @param vertex               The value to set.
      */
    @Override
    public void setVertex(int index, Point vertex) {
        throw new UnsupportedOperationException("Cannot change vertex of Rectangle.");
    }

    /**
      * Gets the width of the rectangle.
      *
      * @return                 The width of the rectangle.
      */
    public int getWidth() {
        return (int)Math.abs((getVertex(1).getX() - getVertex(0).getX()));
    }

    /**
      * Gets the height of the rectangle.
      *
      * @return                 The height of the rectangle.
      */
    public int getHeight() {
        return (int)Math.abs((getVertex(2).getY() - getVertex(0).getY()));
    }

    /**
      * Sets the width of the rectangle.
      *
      * @param w                    The width to set the rectangle to.
      */
    public void setWidth(int w) {
        Point v0 = getVertex(0);
        Point v1 = getVertex(1);
        Point v2 = getVertex(2);
        Point v3 = getVertex(3);

        super.setVertex(1, new Point((int)(v0.getX() + w), (int) v0.getY()));
        super.setVertex(2, new Point((int)(v0.getX() + w), (int) v3.getY()));
    }

    /**
      * Sets the height of the rectangle.
      *
      * @param h                    The height to set the rectangle to.
      */
    public void setHeight(int h) {
        Point v0 = getVertex(0);
        Point v1 = getVertex(1);
        Point v2 = getVertex(2);
        Point v3 = getVertex(3);

        super.setVertex(3, new Point((int)v0.getX(), (int)(v0.getY() + h)));
        super.setVertex(2, new Point((int)v2.getX(), (int)(v0.getY() + h)));
    }
}
