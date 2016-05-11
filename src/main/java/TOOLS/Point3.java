// $Id: Point3.java 1.4 1999/06/22 19:44:27 parisjp Exp $

//		 This file is part of LD2VR
//		Author: Paris.Jean-Pierre@wanadoo.fr
//
// LD2VR is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2, or (at your option)
// any later version.
//
// LD2VR is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with for example GNU Emacs; see the file COPYING.  If not,
// write to the Free Software Foundation, 675 Mass Ave, Cambridge, MA
// 02139, USA.

package TOOLS;

/** A general 3d point class. It implements classical operations on
 * points.
 *
 * @author <a href="mailto:paris.Jean-Pierre@wanadoo.fr">Jean-Pierre Paris</a>
 * @see    TOOLS.Vector3
 * @see    TOOLS.Matrix3
 */
public class Point3 {
   /** Build up a <code>Point3</code> from 3 <code>double</code>
    * values. They represent X, Y, and Z coordinates in order.
    *
    * @param   x x-coordinate
    * @param   y y-coordinate
    * @param   z z-coordinate
    */
   public Point3(double x_, double y_, double z_) {
      x = x_; y = y_; z = z_;
   };

   public static Point3 mean(Point3 p1, Point3 p2, Point3 p3) {
      return new Point3 ((p1.x + p2.x + p3.x) / 3,
                         (p1.y + p2.y + p3.y) / 3,
                         (p1.z + p2.z + p3.z) / 3);
   };
   public static Point3 mean(Point3 p1, Point3 p2, Point3 p3, Point3 p4) {
      return new Point3 ((p1.x + p2.x + p3.x + p4.x) / 4,
                         (p1.y + p2.y + p3.y + p4.y) / 4,
                         (p1.z + p2.z + p3.z + p4.z) / 4);
   };


   /** Test point equality.
    *
    * @param   o   the object to be compared to.
    * @return  a <code>boolean</code> value
    */
   public boolean equals(Object o) {
      try {
         Point3 p = (Point3)o;
         return (x == p.x) && (y == p.y) && (z == p.z);
      } catch (ClassCastException e) {
         return false;
      }
   };

   /** Multiply a point by a array of 3 double values.
    *
    * @param   arr  the array containing 3 values
    * @return  a newly constructed point
    */
   public Point3 mult(int[] arr) {
      Point3 p = new Point3(x * arr[0], y * arr[1], z * arr[2]);
      return p;
   };

   /** Multiply a point by a scalar value.
    *
    * @param   d  the scalar value
    * @return  a newly constructed point
    */
   public Point3 mult(double d) {
      Point3 p = new Point3(x * d, y * d, z * d);
      return p;
   };

   /** Add a vector to a point.
    *
    * @param   v  the added <code>Vector3</code>
    * @return  a newly constructed point
    */
   public Point3 add(Vector3 v) {
      Point3 p = new Point3(x + v.x, y + v.y, z + v.z);
      return p;
   };

   /** Add a point to a point.
    *
    * @param   p  the added <code>Point3</code>
    * @return  a newly constructed point
    */
   public Point3 add(Point3 p) {
      Point3 res = new Point3(x + p.x, y + p.y, z + p.z);
      return res;
   };

   /** Substract a vector to a point.
    *
    * @param   v  the substracted <code>Vector3</code>
    * @return  a newly constructed point
    */
   public Point3 sub(Vector3 v) {
      Point3 p = new Point3(x - v.x, y - v.y, z - v.z);
      return p;
   };

   /** Return a hashcode value. <code>Point3</code> may be used
    * in an <code>Hastable</code>.
    *
    * @return  the hashcode value (sum of the 3 coordinates).
    * @see java.util.Hastable
    */
   public int hashCode() {
      return (int)(x + y + z);
   };

   /** Return a point which coordinates are the minimum of those of
    * both points.
    *
    * @param   the second <code>Point3</code>
    * @return  a newly constructed point
    */
   public Point3 min(Point3 p) {
      return new Point3( Math.min(x, p.x),
                         Math.min(y, p.y),
                         Math.min(z, p.z) );
   };
   /** Return a point which coordinates are the maximum of those of
    * both points.
    *
    * @param   p  the second <code>Point3</code>
    * @return  a newly constructed point
    */
   public Point3 max(Point3 p) {
      return new Point3( Math.max(x, p.x),
                         Math.max(y, p.y),
                         Math.max(z, p.z) );
   };

   /** Returns the square of the distance between both points.
    *
    * @param   the second <code>Point3</code>
    * @return  the square of the distance 
    */
   public double distance2(Point3 p) {
      return (x - p.x) * (x - p.x) +
         (y - p.y) * (y - p.y) +
         (z - p.z) * (z - p.z);
   };

   /** Returns a String representation of this <code>Point3</code>
    * object. Format is: <code>P(x, y, z)</code>
    *
    * @return  a String
    */
   public String toString() {
      return "P(" + x + ", " + y + ", " + z + ")";
   };
   
   /** The x-coordinate */
   public double x;
   /** The y-coordinate */
   public double y;
   /** The z-coordinate */
   public double z;
};
