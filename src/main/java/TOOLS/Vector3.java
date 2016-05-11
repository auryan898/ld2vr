// $Id: Vector3.java 1.3 1999/06/17 20:30:59 parisjp Exp $

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

/** A general 3D vector class. It implements classical operations on
 * vectors. For example: cross product, dot product... 
 *
 * @author <a href="mailto:paris.Jean-Pierre@wanadoo.fr">Jean-Pierre Paris</a>
 * @see    TOOLS.Matrix3
 * @see    TOOLS.Point3
 */
public class Vector3 {
   /** Builds up a <code>Vector3</code> from 3 <code>double</code>
    * values. 
    *
    * @param  x_  x coordinate
    * @param  y_  y coordinate
    * @param  z_  z coordinate */
   public Vector3(double x_, double y_, double z_) {
      x = x_; y = y_; z = z_;
   }
   /** Builds up a <code>Vector3</code> from 2 3D points.
    * @param  p1  first point
    * @param  p1  second point */
   public Vector3(Point3 p1, Point3 p2) {
      x = p2.x - p1.x;
      y = p2.y - p1.y;
      z = p2.z - p1.z;
   }
   /** Tests 3D vector equality.
    * @param   o  the object to be compared to
    * @return  a <code>boolean</code> value */  
   public boolean equals(Object o) {
      try {
         Vector3 v = (Vector3)o;
         return (x == v.x) && (y == v.y) && (z == v.z);
      } catch (ClassCastException e) {
         return false;
      }
   }
   /** Tests 3D vector equality with tolerance.
    * @param   v  the vector to be compared to
    * @return  a <code>boolean</code> value
    * @see     T#eps_equals(double, double) */
   public boolean eps_equals(Vector3 v) {
      return (T.eps_equals(x, v.x) &&
              T.eps_equals(y, v.y) &&
              T.eps_equals(z, v.z));
   }
   /** Tests zero vector equality with tolerance.
    * @return  a <code>boolean</code> value
    * @see     T#eps_zero(double) */
   public boolean eps_zero() {
      return (T.eps_zero(x) &&
              T.eps_zero(y) &&
              T.eps_zero(z));
   }
   /** Tests I (X unit vector) equality with tolerance.
    * @return  a <code>boolean</code> value
    * @see     T#eps_zero(double) */
   public boolean eps_eqI() {
      return (T.eps_equals(x, 1) &&
              T.eps_zero(y) &&
              T.eps_zero(z));
   }
   
   /** Tests if two colinear vector point in the same direction.
    * @return  a <code>boolean</code> value
    */
   public boolean hasSameSign(Vector3 v) {
      if (eps_zero()) {
         return true;
      }
      if (v.eps_zero()) {
         return true;
      }
      return normalize().eps_equals(v.normalize());
   };

   /** Tests if two 3D vectors are parallel.
    * @param   v  the second vector to be tested
    * @return  a <code>boolean</code> value */
   public boolean parallel(Vector3 v) {
      Vector3 v1 = normalize();
      Vector3 v2 = v.normalize();
      return ((v1.x == v2.x) && (v1.y == v2.y) && (v1.z == v2.z))
         || ((v1.x == -v2.x) && (v1.y == -v2.y) && (v1.z == -v2.z));
   }

   /** Adds two 3D vectors without side-effect.
    *
    * @param    v  the added vector
    * @return   a newly constructed vector
    */
   public Vector3 add(Vector3 v) {
      return new Vector3(x + v.x, y + v.y, z + v.z);
   }

   /** Adds a vector to a point with side-effect
    *
    * @param    p    the point to be added
    * @param result  the resulting point with side-effect
    */
   public void add(Point3 p, Point3 result) {
      result.x = x + p.x;
      result.y = y + p.y;
      result.z = z + p.z;
   }

   /** Substracts a 3D vector to another without side-effect.
    *
    * @param    v  the substracted vector
    * @return   a newly constructed vector
    */
   public Vector3 sub(Vector3 v) {
      return new Vector3(x - v.x, y - v.y, z - v.z);
   }
   /** Multiplies a 3D vector with a scalar without side-effect.
    * @param    d  the scalar
    * @return   a newly constructed vector
    */
   public Vector3 mult(double d) {
      return new Vector3(x * d, y * d, z * d);
   }
   /** Multiplies a 3D vector with a scalar without side-effect.
    * @param    d  the scalar
    * @param    v  the mutiplied vector
    * @return   a newly constructed vector
    */
   public static Vector3 mult(double d, Vector3 v) {
      return v.mult(d);
   }
   /** Returns the dot product of two 3D vectors.
    * @param    v  the second vector
    * @return   the dot product value as double
    */
   public double dotMult(Vector3 v) {
      return x * v.x + y * v.y + z * v.z;
   }
   /** Returns the cross product of two 3D vectors without side-effect.
    * @param    v  the second vector
    * @return   the cross product vector
    */
   public Vector3 crossMult(Vector3 v) {
      return new Vector3(y * v.z - z * v.y,
                         z * v.x - x * v.z,
                         x * v.y - y * v.x);
   }
   /** Returns the length of a 3D vector.
    * @return   the length as a double
    */
   public final double length() {
      return Math.sqrt(x * x + y * y + z * z);
   }
   /** Returns the square of length of a 3D vector.
    * @return   the square of the length as a double
    */
   public final double length2() {
      return x * x + y * y + z * z;
   }

   /** Normalizes (length == 1) a 3D vector without side-effect.
    * @return a newly constructed 3D vector
    */
   public Vector3 normalize() {
      if ((0 == x) && (0 == y) && (0 == z)) {
         throw new RuntimeException("Degenerated vector3");
      }
      double length = length();
      return new Vector3(x / length,
                         y / length,
                         z / length);
   }
   
   /** Returns a String representation of a 3D vector. This
    * representation includes the three coordinates and the length inside
    * square brakets.
    * @return  a String
    * @see     #toString(String)
    */
   public String toString() {
      return "V(" + x + ", " + y + ", " + z + ")[" +
         Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)) + "]";
   }
   /** Returns a String representation of a 3D vector. This
    * representation includes only the three coordinates.
    * @param   a separator string used between coordinates
    * @return  a String
    * @see     #toString()
    */
   public String toString(String sep) {
      return "" + x + sep + y + sep + z;
   }

   /** For testing purpose.
    */
   static public void main(String args[]) {
      Vector3 v = new Vector3(2, 3, 4);
      System.out.println(Vector3.mult(4, v));
      System.out.println(v.mult(2));
      System.out.println(v.normalize());
      v = new Vector3(new Point3(1, 1, 1), new Point3(3, 4, 5));
      System.out.println(Vector3.mult(4, v));
      System.out.println(v.mult(2));
      System.out.println(v.normalize());
   }

   /** The X coordinate.
    */     
   public double x;
   /** The Y coordinate.
    */     
   public double y;
   /** The Z coordinate.
    */     
   public double z;
}
