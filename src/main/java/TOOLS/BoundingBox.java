// $Id: BoundingBox.java 1.3 1999/06/23 21:49:31 parisjp Exp $

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

import java.util.Vector;

import TOOLS.T;
import TOOLS.Assert;
import TOOLS.Vector3;
import TOOLS.Segment3;

public class BoundingBox {
   public BoundingBox() {
      pMin_ = new Point3(1e100, 1e100, 1e100);
      pMax_ = new Point3(-1e100, -1e100, -1e100);
   };

   /** WARNING: if less than 2 points are added to a bounding box,
    * result is incorrect */
   public void add(Point3 p) {
      if (p.x < pMin_.x) {
         pMin_.x = p.x;
      } else if (p.x > pMax_.x) {
         pMax_.x = p.x;
      }
      if (p.y < pMin_.y) {
         pMin_.y = p.y;
      } else if (p.y > pMax_.y) {
         pMax_.y = p.y;
      }
      if (p.z < pMin_.z) {
         pMin_.z = p.z;
      } else if (p.z > pMax_.z) {
         pMax_.z = p.z;
      }
   };

   public void add(BoundingBox bb) {
      add(bb.pMin_);
      add(bb.pMax_);
   };

   public void scale(double d) {
      if (1 < d) {
         Vector3 v = new Vector3(pMin_, pMax_).mult((d - 1) / 2);
         pMin_ = pMin_.sub(v);
         pMax_ = pMax_.add(v);
      }
   };

   public boolean isInside(BoundingBox bb) {
      return isInside(bb.pMin_) && isInside(bb.pMax_);
   };

   public boolean isInside(Point3 p) {
      return ( (pMin_.x <= p.x) && (p.x <= pMax_.x) &&
               (pMin_.y <= p.y) && (p.y <= pMax_.y) &&
               (pMin_.z <= p.z) && (p.z <= pMax_.z) );
   };

   public Point3[] getIntersection(Line3 l) {
      Point3[] result = new Point3[2];
      int resultIndex = 0;
      if (null == planes_) {
         initPlanes();
      }
      for (int i = 0; i < 6; i++) {
         Plane p = planes_[i];
         try {
            result[resultIndex] = p.getIntersection(l);
            resultIndex++;
            if (1 < resultIndex) {
               return result;
            }
         } catch (CoplanarException e) {
         } catch (ParallelException e) {
         }
      }
      return null;
   };

   public Point3 getPoint(int index) {
      if (0 > index) {
         return null;
      }
      if (null == points_) {
         initPoints();
      }
      if (points_.length <= index) {
         return null;
      }
      return points_[index];
   };

   private void initPoints() {
      points_ = new Point3[26];
      int i = 0;

      double rightX  = pMax_.x;
      double leftX   = pMin_.x;
      double topY    = pMax_.y;
      double bottomY = pMin_.y;
      double frontZ  = pMax_.z;
      double backZ   = pMin_.z;
      double midX    = (rightX + leftX)   / 2.0;
      double midY    = (topY   + bottomY) / 2.0;
      double midZ    = (frontZ + backZ)   / 2.0;

      // middle of faces: 6 points
      points_[i++] = new Point3(rightX, midY,    midZ); // right
      points_[i++] = new Point3(leftX,  midY,    midZ); // left
      points_[i++] = new Point3(midX,   topY,    midZ); // top
      points_[i++] = new Point3(midX,   bottomY, midZ); // bottom
      points_[i++] = new Point3(midX,   midY,    frontZ); // front
      points_[i++] = new Point3(midX,   midY,    backZ);  // back
      
      // middle of edges: 12 points
      points_[i++] = new Point3(rightX,  midY,    pMax_.z); // right
      points_[i++] = new Point3(rightX,  midY,    pMin_.z); // right
      points_[i++] = new Point3(leftX,   midY,    pMax_.z); // left
      points_[i++] = new Point3(leftX,   midY,    pMin_.z); // left
      points_[i++] = new Point3(pMax_.x, topY,    midZ);    // top
      points_[i++] = new Point3(pMin_.x, topY,    midZ);    // top
      points_[i++] = new Point3(pMax_.x, bottomY, midZ);    // bottom
      points_[i++] = new Point3(pMin_.x, bottomY, midZ);    // bottom
      points_[i++] = new Point3(midX,    pMax_.y, frontZ);  // front
      points_[i++] = new Point3(midX,    pMin_.y, frontZ);  // front
      points_[i++] = new Point3(midX,    pMax_.y, backZ);   // back
      points_[i++] = new Point3(midX,    pMin_.y, backZ);   // back

      // the 8 trivial points
      points_[i++] = new Point3(rightX, topY,    frontZ); // pMax_ itself
      points_[i++] = new Point3(rightX, topY,    backZ);
      points_[i++] = new Point3(rightX, bottomY, frontZ);
      points_[i++] = new Point3(rightX, bottomY, backZ);
      points_[i++] = new Point3(leftX,  topY,    frontZ);
      points_[i++] = new Point3(leftX,  topY,    backZ);
      points_[i++] = new Point3(leftX,  bottomY, frontZ);
      points_[i++] = new Point3(leftX,  bottomY, backZ);  // pMin_ itself
   };

   private void initPlanes() {
      planes_ = new Plane[6];
      Vector3 vx = new Vector3(1, 0, 0);
      Vector3 vy = new Vector3(0, 1, 0);
      Vector3 vz = new Vector3(0, 0, 1);
      int i = 0;
      planes_[i++] = new Plane(pMax_, vx); // right
      planes_[i++] = new Plane(pMax_, vy); // top
      planes_[i++] = new Plane(pMax_, vz); // front

      planes_[i++] = new Plane(pMin_, vx); // left
      planes_[i++] = new Plane(pMin_, vy); // bottom
      planes_[i++] = new Plane(pMin_, vz); // back
   };

   public String toString() {
      return "BB[" + pMin_ + ", " + pMax_ + "]";
   };

   /** For debugging purpose */
   public static void main(String[] args) {
      BoundingBox bb = new BoundingBox();
      System.err.println(bb);
      System.err.println(bb.isInside(new Point3(1, 0, 0)));
      bb.add(new Point3(0, 0, 0));
      System.err.println(bb);
      System.err.println(bb.isInside(new Point3(1, 0, 0)));
      bb.add(new Point3(1, 0, 0));
      System.err.println(bb);
      System.err.println(bb.isInside(new Point3(1, 0, 0)));
      bb.add(new Point3(2, 1, 0));
      System.err.println(bb);
      System.err.println(bb.isInside(new Point3(1, 0, 0)));
      System.err.println(bb.isInside(new Point3(1, -1, 0)));
      bb.add(new Point3(1, 0, 1));
      System.err.println(bb);
      bb.add(new Point3(-1, 4, 1));
      System.err.println(bb);
   };

   private Point3 pMin_;
   private Point3 pMax_;
   private Plane[] planes_ = null;
   private Point3[] points_ = null;
};

