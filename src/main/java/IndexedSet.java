// $Id: IndexedSet.java 1.1 1998/08/25 21:36:19 parisjp Exp $

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

import TOOLS.Assert;
import TOOLS.Point3;

import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;

public class IndexedSet {
   public IndexedSet() {
      currentIndex_ = 0;
      indexArrays_  = new Vector();
      points_       = new Hashtable();
   }
   
   public int getIndex(Point3 p) {
      Object i = points_.get(p);
      if (i == null) {
         return -1;
      } else {
         return ((Integer)i).intValue();
      }
   }
   
   public void put(Point3 p) {
      points_.put(p, new Integer(currentIndex_++));
   }
   public int size() {
      return points_.size();
   }
   public int pointCount() {
      return points_.size();
   }
   public int faceCount() {
      return indexArrays_.size();
   }

   public IndexedSet add(IndexedSet ifs) {
      Hashtable points = ifs.points_;
      int size = points.size();
      int[] newIndexes = new int[size];

      for (Enumeration e = points.keys(); e.hasMoreElements(); ) { 
         Point3 p = (Point3)e.nextElement();
         int value = getIndex(p);
         if (value == -1) {
            newIndexes[ifs.getIndex(p)] = currentIndex_;
            put(p);
         } else {
            newIndexes[ifs.getIndex(p)] = value;
         }
      }
      Vector indexArrays = ifs.indexArrays_;
      int[] indexArray;
      for (Enumeration e = indexArrays.elements(); e.hasMoreElements(); ) {
         int[] indexes = (int[])e.nextElement();
         indexArray = new int[indexes.length];
         for (int i = 0; i < indexes.length; i++) {
            indexArray[i] = newIndexes[indexes[i]];
         }
         addIndexes(indexArray);
      }
      return this;
   }

   public void set(Point3 p[]) {
      int[] indexes = new int[p.length];
      Point3 currentPoint;
      for (int i = 0; i < p.length; i++) {
         currentPoint = p[i];
         int value = getIndex(currentPoint);
         if (value == -1) {
            put(currentPoint);
            indexes[i] = i;
         } else {
            Assert.t(false, currentPoint + " appears more than once");
         }
      }
      addIndexes(indexes);
   }

   public void set(Point3 p0, Point3 p1, Point3 p2) {
      Point3[] p = new Point3[3];
      p[0] = p0;
      p[1] = p1;
      p[2] = p2;
      set(p);
   }

   public void set(Point3 p0, Point3 p1, Point3 p2, Point3 p3) {
      Point3[] p = new Point3[4];
      p[0] = p0;
      p[1] = p1;
      p[2] = p2;
      p[3] = p3;
      set(p);
   }

   public void addIndexes(int[] i) {
      indexArrays_.addElement(i);
   }

   public VRML2.IndexedFaceSet toVRML() {
      int currentPointIndex = 0;
      VRML2.IndexedFaceSet ifs = new VRML2.IndexedFaceSet();
      VRML2.Coordinate coord = new VRML2.Coordinate();

      Vector allPoints = new Vector();
      allPoints.setSize((points_.size()));

      for (Enumeration key = points_.keys(); key.hasMoreElements() ;) { 
         Point3 p = (Point3)(key.nextElement());
         allPoints.setElementAt(p, ((Integer)points_.get(p)).intValue());
      }
      for (int i = 0; i < allPoints.size(); i++) {
         Point3 p = (Point3)(allPoints.elementAt(i));
         coord.add_point(p.x, p.y, p.z);
      }
      for (int i = 0; i < indexArrays_.size(); i++) {
         int[] indexes = (int[])indexArrays_.elementAt(i);
         for (int j = 0; j < indexes.length; j++) {
            ifs.add_coordIndex(indexes[j]);
         }
         ifs.add_coordIndex(-1);
      }

      ifs.set_coord(coord);
      return ifs;
   }

   public String toString() {
      int currentPointIndex = 0;
      Vector allPoints = new Vector();
      allPoints.setSize((points_.size()));
      StringBuffer sb = new StringBuffer("[\n");
      
      for (Enumeration key = points_.keys(); key.hasMoreElements() ;) { 
         Point3 p = (Point3)(key.nextElement());
         allPoints.setElementAt(p, ((Integer)points_.get(p)).intValue());
      }
      for (int i = 0; i < allPoints.size(); i++) {
         Point3 p = (Point3)(allPoints.elementAt(i));
         sb.append(" [" + i + "] " + p + "\n");
      }
      for (int i = 0; i < indexArrays_.size(); i++) {
         sb.append(" [");
         int[] indexes = (int[])indexArrays_.elementAt(i);
         for (int j = 0; j < indexes.length; j++) {
            sb.append(indexes[j] + " ");
         }
         sb.append("]\n");
      }
      return sb.append("]").toString();
   }

   protected int currentIndex_;
   protected Vector indexArrays_; // int[]
   protected Hashtable points_; // Point3
}
