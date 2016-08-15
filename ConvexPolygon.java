/**
  * Definition for a ConvexPolygon. Extends Shape.
  *
  * @author Jonathon Elfar jelfar jonathon.elfar@gmail.com 
  */

import java.awt.Color;
import java.awt.Point;
public class ConvexPolygon extends Shape {

    private Point[] vertices;

    /**
      * Constructor.
      *
      * @precondition               The vertices be provided in counter-clockwise order. 
      *                             This precondion is required so that the area calculation will work correctly.
      * @precondition               The polygon is not closed. This means that the first and 
      *                             last point are not the same point (no duplicate points).
      *
      * @param points               The vertices in an array.
      * @param col                  The color of the ConvexPolygon.
      * @param f                    Whether or not the ConvexPolygon is filled
      */
    public ConvexPolygon(Point[] points, Color col, boolean f) {
        super(col, f);
        vertices = new Point[points.length];
        for(int i = 0; i < points.length; i++){
            vertices[i] = new Point((int)points[i].getX(), (int)points[i].getY());
        }
    }

    /**
      * Calculates and returns the area of the ConvexPolygon. Uses the matrix method.
      *
      * @return                 The area of the ConvexPolygon.
      */
    public double getArea(){
        double sum = 0;
        for(int i = 0; i < vertices.length; i++){
            if(i == vertices.length-1)
                sum += (vertices[i].getX() * vertices[0].getY()) - (vertices[i].getY() * vertices[0].getX());
            else
                sum += (vertices[i].getX() * vertices[i+1].getY()) - (vertices[i].getY() * vertices[i+1].getX());
        }
        
        return Math.abs(sum/2);
    }

    /**
      * Returns the currrent position of the ConvexPolygon.
      *
      * @return                 The current position of the ConvexPolygon.
      */
    public Point getPosition(){
        return new Point((int)vertices[0].getX(), (int)vertices[0].getY());
    }

    /**
      * Changes the position of the ConvexPolygon to the specfied Point.
      *
      * @param p                 The position to move the ConvexPolygon to.
      */
    public void setPosition(Point p){
       /** Finds the delta between the position point(first point of array) and the point p */
       Point delta = new Point((int)(p.getX() - vertices[0].getX()), (int)(p.getY() - vertices[0].getY()));
       this.move(delta);
    }

    /**
      * Moves the shape by the x and y amounts specified (in the Point delta).
      *
      * @param delta                   The x and y delta of the position to move the ConvexPolygon to. 
      */
    public void move(Point delta){
        for(int i = 0; i < vertices.length; i++){
            vertices[i] = new Point((int)(vertices[i].getX() + delta.getX()), (int)(vertices[i].getY() + delta.getY()));
        }
    }

    /**
      * Gets the vertex at the specified index.
      *
      * @param index                    The index to look up.
      *
      * @return                         The specified index.
      */
    public Point getVertex(int index) {
        return new Point((int)vertices[index].getX(), (int)vertices[index].getY());
    }

    /**
      * Sets the vertex at the specified index.
      *
      * @param index                The index to change.
      * @param vertex               The value to set.
      */
    public void setVertex(int index, Point vertex) {
        vertices[index] = new Point((int)vertex.getX(), (int)vertex.getY());
    }

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

        ConvexPolygon cp = (ConvexPolygon)o;
        
        for(int i = 0; i < vertices.length; i++){
            if(!vertices[i].equals(cp.getVertex(i)))
                return false;
        }

        return (this.getColor().equals(cp.getColor())) &&
               (this.getFilled() == cp.getFilled());
    }
    
}
