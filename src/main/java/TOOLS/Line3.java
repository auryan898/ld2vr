// $Id: Line3.java 1.2 1999/06/22 19:43:40 parisjp Exp $

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

public class Line3 {
   public Line3(Point3 p1, Point3 p2) {
      orig_ = p1;
      dir_ = new Vector3(p1, p2);
      if ((0 == dir_.x) && (0 == dir_.y) && (0 == dir_.z)) {
         throw new RuntimeException("Degenerated line3");
      }
   };
   public Line3(Point3 p, Vector3 vd) {
      orig_ = p;
      dir_ = vd;
      if ((0 == dir_.x) && (0 == dir_.y) && (0 == dir_.z)) {
         throw new RuntimeException("Degenerated line3");
      }
   };

   public boolean contains(Point3 p) {
      if (0 == dir_.x) {
         if (orig_.x != p.x) {
            return false;
         } else {
            if (0 == dir_.y) {
               if (orig_.y != p.y) {
                  return false;
               } else {
                  return true;
               }
            } else {
               double lambda = (p.y - orig_.y) / dir_.y;
               return T.eps_equals(orig_.z + lambda * dir_.z, p.z);
            }
         }
      } else {
         double lambda = (p.x - orig_.x) / dir_.x;
         return T.eps_equals(orig_.y + lambda * dir_.y, p.y) &&
            T.eps_equals(orig_.z + lambda * dir_.z, p.z);
      }
   };

   Point2 computeLambdaMu(Line3 l) throws ColinearException, 
      ParallelException, NoIntersectException {
      // searching solution of
      //      orig_ + lambda dir_ = l.orig_ + mu l.dir_
      // lambda is x and mu is y of returned Point2
      
      // Trying with X,Y coordinates
      double detxy = dir_.y * l.dir_.x - dir_.x * l.dir_.y;
      
      if (0 == detxy) {
         // The 2 projections on the X,Y are parallel
         double mu_detxy = ((l.orig_.y - orig_.y) * dir_.x - 
                            (l.orig_.x - orig_.x) * dir_.y);
         double lambda_detxy = ((l.orig_.y - orig_.y) * l.dir_.x - 
                                (l.orig_.x - orig_.x) * l.dir_.y);
         if (T.eps_equals(mu_detxy, 0) && T.eps_equals(lambda_detxy, 0)) {
            // X,Y projections are equal. Lines are in the same plane.
            // Trying with X,Z coordinates
            double detxz = dir_.z * l.dir_.x - dir_.x * l.dir_.z;
            if (0 == detxz) {
               // case 1.1.1
               // The 2 projections on the X,Z are parallel
               // As they are coplanar already, they don't intersect
               // or they are equal.
               if (this.contains(l.orig_)) {
                  throw new ColinearException();
               } else {
                  throw new ParallelException();
               }
            } else {
               // (lambda, mu) exists for X,Z
               double mu = ((l.orig_.z - orig_.z) * dir_.x - 
                            (l.orig_.x - orig_.x) * dir_.z) / detxz;
               double lambda = ((l.orig_.z - orig_.z) * l.dir_.x - 
                                (l.orig_.x - orig_.x) * l.dir_.z) / detxz;

               if (T.eps_equals(  orig_.y + lambda *   dir_.y,
                                l.orig_.y + mu     * l.dir_.y)) {
                  // case 1.1.2.1
                  // (lambda, mu) exists for X,Z, and is OK for Y too
                  return new Point2(lambda, mu);
               } else {
                  // Because lines are coplanar they should intersect!
                  throw new RuntimeException("detxy=" + detxy + 
                                             ",detxz=" + detxz + 
                                             ",l=" + lambda + 
                                             ",m=" + mu);
               }
            }
         } else {
            // case 1.2
            // X,Y projections are parallel but not equal
            if (dir_.parallel(l.dir_)) {
               throw new ParallelException();
            } else {
               throw new NoIntersectException();
            }
         }
      } else {
         // (lambda, mu) exists for X,Y
         double mu = ((l.orig_.y - orig_.y) * dir_.x - 
                      (l.orig_.x - orig_.x) * dir_.y) / detxy;
         double lambda = ((l.orig_.y - orig_.y) * l.dir_.x - 
                          (l.orig_.x - orig_.x) * l.dir_.y) / detxy;

         if (T.eps_equals(  orig_.z + lambda *   dir_.z,
                          l.orig_.z + mu     * l.dir_.z)) {
            // case 2.1
            // (lambda, mu) exists for X,Y, and is OK for Z too
            return new Point2(lambda, mu);
         } else {
            // case 2.2
            // (lambda, mu) exists for X,Y, but doesn't verify equation on Z
            throw new NoIntersectException();
         }
      }
   };
   
   public Point3 inter(Line3 l) throws ColinearException, 
      ParallelException, NoIntersectException {
         Point2 lambdaMu = computeLambdaMu(l);
   
         return orig_.add(dir_.mult(lambdaMu.x));
   };

   
   public String toString() {
      return "" + orig_ + " + K * " + dir_;
   };

   public final Vector3 getDirV() {
      return dir_;
   };
   public final Point3 getOrig() {
      return orig_;
   };
   
   private Point3 orig_;
   private Vector3 dir_;
};

