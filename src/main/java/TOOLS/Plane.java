// $Id: Plane.java 1.4 1999/10/23 20:01:21 parisjp Exp $

//		 This file is part of Ldorient
//		Author: Paris.Jean-Pierre@wanadoo.fr
//
// Ldorient is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2, or (at your option)
// any later version.
//
// Ldorient is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with for example GNU Emacs; see the file COPYING.  If not,
// write to the Free Software Foundation, 675 Mass Ave, Cambridge, MA
// 02139, USA.

package TOOLS;

public class Plane {
   public Plane(Point3 p1, Point3 p2, Point3 p3) {
      Vector3 v1 = new Vector3(p1, p2);
      Vector3 v2 = new Vector3(p1, p3);
      normal_ = v1.crossMult(v2).normalize();
      cst_ = - scalarProduct(p1);
      // TIME CONSUMING ASSERTION
      //Assert.t(T.eps_equals(cst_,- scalarProduct(p2)) &&
      //T.eps_equals(cst_, - scalarProduct(p3)),
      //"[" + p1 + " " + p2 + " " + p3 + "]\n" +
      //cst_ + "\n" +
      //(cst_ + scalarProduct(p1)) + "\n" +
      //(cst_ + scalarProduct(p2)) + "\n" +
      //(cst_ + scalarProduct(p3)) + "\n");
      Assert.t(T.eps_equals(cst_,- scalarProduct(p2)) &&
               T.eps_equals(cst_, - scalarProduct(p3)), "Bad plane. SNO");
   };

   public Plane(Point3 p1, Point3 p2, Point3 p3, Point3 p4) {
      this(p1, p2, p3, p4, 0);
   }
   public Plane(Point3 p1, Point3 p2, Point3 p3, Point3 p4, double tolerance) {
      Vector3 v1 = new Vector3(p1, p2);
      Vector3 v2 = new Vector3(p1, p3);
      normal_ = v1.crossMult(v2).normalize();
      cst_ = - scalarProduct(p1);
      // TIME CONSUMING ASSERTION
      //Assert.t(T.eps_equals(cst_, - scalarProduct(p2)) &&
      //T.eps_equals(cst_, - scalarProduct(p3)) &&              
      //T.eps_equals(cst_, - scalarProduct(p4), tolerance),
      //"[" + p1 + " " + p2 + " " + p3 + " " + p4 + "]\n" +
      //cst_ + "\n" +
      //(cst_ + scalarProduct(p1)) + "\n" +
      //(cst_ + scalarProduct(p2)) + "\n" +
      //(cst_ + scalarProduct(p3)) + "\n" +
      //(cst_ + scalarProduct(p4)) + "\n");
      Assert.t(T.eps_equals(cst_, - scalarProduct(p2)) &&
               T.eps_equals(cst_, - scalarProduct(p3)) &&              
               T.eps_equals(cst_, - scalarProduct(p4), tolerance),
               cst_ + scalarProduct(p4) + " Bad plane. SNO2");
   };

   public Plane(Point3 p1, Vector3 normal) {
      normal_ = normal;
      cst_ = - scalarProduct(p1);
   };

   public void reverse() {
      normal_.x = - normal_.x;
      normal_.y = - normal_.y;
      normal_.z = - normal_.z;
      cst_      = - cst_;
   };

   public boolean contains(Point3 p) {
      return T.eps_zero(scalarProduct(p) + cst_);
   };

   public Point3 getIntersection(Line3 l) 
        throws
   ParallelException, CoplanarException {
      Vector3 lineDirV = l.getDirV();
      Point3 lineOrig = l.getOrig();
      double denom = scalarProduct(lineDirV);
      if (T.eps_zero(denom)) {
         if (T.eps_zero(scalarProduct(lineOrig) + cst_)) {
            throw new CoplanarException();
         } else {
            throw new ParallelException();
         }
      } else {
         double lambda = (- cst_ - scalarProduct(lineOrig)) / denom;
         return new Point3(lineOrig.x + lambda * lineDirV.x,
                           lineOrig.y + lambda * lineDirV.y,
                           lineOrig.z + lambda * lineDirV.z);
      }
   };

   public final double valueOf(Point3 p) {
      return scalarProduct(p) + cst_;
   };
   public final double scalarProduct(Point3 p) {
      return normal_.x * p.x + normal_.y * p.y + normal_.z * p.z;
   };
   public final double scalarProduct(Vector3 v) {
      return normal_.x * v.x + normal_.y * v.y + normal_.z * v.z;
   };

   public String toString() {
      return "P[" +
         T.rounds(normal_.x, 1e6) + "x + " +
         T.rounds(normal_.y, 1e6) + "y + " +
         T.rounds(normal_.z, 1e6) + "z + " + T.rounds(cst_, 1e6) + " = 0]";
   };

   /** For debuging purpose */
   public static void main(String[] args) {
      try {
         Point3 p0 = new Point3(1, 0, 0);
         Point3 p1 = new Point3(0, 1, 0);
         Point3 p2 = new Point3(0, 0, 1);
         Plane p = new Plane(p0, p1, p2);
         System.err.println(p);
         System.err.println(p.contains(new Point3(1.0/3, 1.0/3, 1.0/3)));

         Point3 p10 = new Point3(0, 0, 0);
         Point3 p11 = new Point3(1, 1, 1);
         Line3 l = new Line3(p10, p11);
         System.err.println(p.getIntersection(l));

         Point3 p12 = new Point3(0, 0, -3);
         Point3 p13 = new Point3(0, 2, 3);
         Line3 l1 = new Line3(p12, p13);
         System.err.println(p.getIntersection(l1));

         Point3 p14 = new Point3(1, 0, 0);
         Point3 p15 = new Point3(0, 1, 0);
         Line3 l2 = new Line3(p14, p15);
         System.err.println(p.getIntersection(l2));
      } catch (Exception e) {
         System.err.println(e.getMessage());
      }
   };

   
   protected Vector3 normal_;
   protected double cst_;
};
