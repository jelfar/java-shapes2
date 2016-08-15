/**
  * Definition for a triangle. Implements shape.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;
public class Triangle extends ConvexPolygon {

    /**
      * Constructor.
      *
      * @param a                    The first point of the triangle. This represents position.
      * @param b                    The second point of the triangle.
      * @param c                    The third point of the triangle.
      * @param col                  The color of the triangle.
      * @param f                    Whether or not the triangle is filled
      */
    public Triangle(Point a, Point b, Point c, Color col, boolean f) {
        super(new Point[] {a, b, c}, col, f);
    }


    /**
      * Calculates and returns the area of the triangle.
      *
      * @return                 The area of the triangle.
      */
    public double getArea(){
        Point v1 = getVertexA();
        Point v2 = getVertexB();
        Point v3 = getVertexC();

        /** Finding all the lengths of the sides using the distance formula */
        double side1 = Math.sqrt(Math.pow(Math.abs(v1.getX() - v2.getX()), 2) + Math.pow(Math.abs(v1.getY() - v2.getY()), 2));
        double side2 = Math.sqrt(Math.pow(Math.abs(v2.getX() - v3.getX()), 2) + Math.pow(Math.abs(v2.getY() - v3.getY()), 2));
        double side3 = Math.sqrt(Math.pow(Math.abs(v1.getX() - v3.getX()), 2) + Math.pow(Math.abs(v1.getY() - v3.getY()), 2));

       /** Now using Heron's formula to find the area of a general rectangle */
       double semiperimeter = (side1 + side2 + side3) / 2;
       return Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3));
    }

    /**
      * Gets the vertex A.
      *
      * @return                 The first vertex Point.
      */
    public Point getVertexA() {
        return getVertex(0);
    }

    /**
      * Gets the vertex B.
      *
      * @return                 The second vertex Point.
      */
    public Point getVertexB() {
        return getVertex(1);
    }

    /**
      * Gets the vertex C.
      *
      * @return                 The third vertex Point.
      */
    public Point getVertexC() {
        return getVertex(2);
    }

    /**
      * Sets the vertex A.
      */
    public void setVertexA(Point p) {
        setVertex(0, p);
    }

    /**
      * Sets the vertex B.
      */
    public void setVertexB(Point p) {
        setVertex(1, p);
    }

    /**
      * Sets the vertex C.
      */
    public void setVertexC(Point p) {
        setVertex(2, p);
    }

}
