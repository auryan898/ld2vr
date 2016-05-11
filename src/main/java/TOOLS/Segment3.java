// $Id: Segment3.java 1.3 1999/06/22 19:43:33 parisjp Exp $

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

public class Segment3 {
   public Segment3(Point3 p1, Point3 p2) {
      p1_ = p1;
      p2_ = p2;
      line_ = new Line3(p1_, p2_);
   };

   public Point3 getIntersection(Segment3 s) throws
   ColinearException, ParallelException, NoIntersectException {
      Point2 lambdaMu = line_.computeLambdaMu(s.line_);

      if ((0.0 <= lambdaMu.x) && (lambdaMu.x <= 1.0) 
          && (0.0 <= lambdaMu.y) && (lambdaMu.y <= 1.0)) {
         return p1_.add(new Vector3(p1_, p2_).mult(lambdaMu.x));
      } else {
         throw new NoIntersectException();
      }
   };

   public Segment3 getSegmentIntersection(Segment3 s) {
      if (directV().crossMult(s.directV()).eps_zero()) {
         if (line_.contains(s.p1_)) {
            if (p1_ == s.p1_) {
               if (contains(s.p2_)) {
                  return new Segment3(p1_, s.p2_);
               } else if (s.contains(p2_)) {
                  return new Segment3(p1_, p2_);
               } else {
                  return null;
               }
            } else if (p1_ == s.p2_) {
               if (contains(s.p1_)) {
                  return new Segment3(p1_, s.p1_);
               } else if (s.contains(p2_)) {
                  return new Segment3(p1_, p2_);
               } else {
                  return null;
               }
            } else if (p2_ == s.p1_) {
               if (contains(s.p2_)) {
                  return new Segment3(p2_, s.p2_);
               } else if (s.contains(p1_)) {
                  return new Segment3(p1_, p2_);
               } else {
                  return null;
               }
            } else if (p2_ == s.p2_) {
               if (contains(s.p1_)) {
                  return new Segment3(p2_, s.p1_);
               } else if (s.contains(p1_)) {
                  return new Segment3(p1_, p2_);
               } else {
                  return null;
               }
            } else if (contains(s.p1_)) {
               if (contains(s.p2_)) {
                  return new Segment3(s.p1_, s.p2_);
               } else {
                  if (s.contains(p1_)) {
                     return new Segment3(p1_, s.p1_);
                  } else if (s.contains(p2_)) {
                     return new Segment3(p2_, s.p1_);
                  }
               }
            } else if (contains(s.p2_)) {
               if (s.contains(p1_)) {
                  return new Segment3(p1_, s.p2_);
               } else if (s.contains(p2_)) {
                  return new Segment3(p2_, s.p2_);
               }
            } else if (s.contains(p1_)) {
               if (s.contains(p2_)) {
                  return new Segment3(p1_, p2_);
               }
            }
         }
      }
      return null;
   };

   private final Segment3 makeSegment3(Point3 p1, Point3 p2) {
      if (p1 == p2) {
         return null;
      } else {
         return new Segment3(p1, p2);
      }
   };

   public boolean contains(Point3 p) {
      Vector3 dir = directV();
      if (0 == dir.x) {
         if (p1_.x != p.x) {
            return false;
         } else {
            if (0 == dir.y) {
               if (p1_.y != p.y) {
                  return false;
               } else {
                  double lambda = (p.z - p1_.z) / dir.z;
                  return (0 <= lambda) && (lambda <= 1);
               }
            } else {
               double lambda = (p.y - p1_.y) / dir.y;
               return (0 <= lambda) && (lambda <= 1) &&
                  T.eps_equals(p1_.z + lambda * dir.z, p.z);
            }
         }
      } else {
         double lambda = (p.x - p1_.x) / dir.x;
         return (0 <= lambda) && (lambda <= 1) &&
            T.eps_equals(p1_.y + lambda * dir.y, p.y) &&
            T.eps_equals(p1_.z + lambda * dir.z, p.z);
      }
   };

   public Segment3 addEqEq(Segment3 s) {
      if (p1_ == s.p1_) {
         if (p2_ == s.p2_) {
            return this;
         }
         return new Segment3(p2_, s.p2_);
      } else if (p1_ == s.p2_) {
         if (p2_ == s.p1_) {
            return this;
         }
         return new Segment3(p2_, s.p1_);
      } else if (p2_ == s.p1_) {
         return new Segment3(p1_, s.p2_);
      } else if (p2_ == s.p2_) {
         return new Segment3(p1_, s.p1_);
      } else {
         return null;
      }
   };

   public Vector3 directV() {
      return new Vector3(p1_, p2_);
   };

   public final Point3 p1() {
      return p1_;
   };
   public final Point3 p2() {
      return p2_;
   };

   public String toString() {
      return "S[" + p1_ + ", " + p2_ + "] " + line_;
   };

   /** For debuging purpose */
   public static void main(String[] args) {
      Point3 p0 = new Point3(0, 4, 0);
      Point3 p1 = new Point3(0, 44, 0);
      Point3 p2 = new Point3(0, 88, 0);

      System.err.println(new Segment3(p0, p1)
                         .getSegmentIntersection(new Segment3(p2, p0)));

      Point3 p10 = new Point3(0, 0, -2);
      Point3 p11 = new Point3(0, 0, 2);
      Point3 p12 = new Point3(0, 0, -3);
      Point3 p13 = new Point3(0, 0, 3);
      System.err.println(new Segment3(p10, p11)
                         .getSegmentIntersection(new Segment3(p12, p13)));
   };

   
   protected Point3 p1_, p2_;
   protected Line3 line_;
};
