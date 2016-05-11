// $Id: Quadrilateral.java 1.5 1998/12/30 22:31:08 parisjp Exp $

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

import java.util.Vector;

import TOOLS.Point3;
import TOOLS.Vector3;
import TOOLS.Matrix3;

import VRML2.VRML2Node;
import VRML2.File;

import VRML2.VALUES.Value;

import TOOLS.Assert;

public
class Quadrilateral extends LDRAWREADER.Quadrilateral implements ToVrml {
   Quadrilateral(LDRAWREADER.Quadrilateral v) {
      super(v);

      color_ = new LdrawColor(colorValue_);
      p1_ = new Point3(x1_, y1_, z1_);
      p2_ = new Point3(x2_, y2_, z2_);
      p3_ = new Point3(x3_, y3_, z3_);
      p4_ = new Point3(x4_, y4_, z4_);
   };

   public VRML2Node toVRML(PartRef part_ref, Value unused1, Matrix3 remaining,
                           Options unused3) {
      IndexedSet face = new IndexedSet();
      Point3 p1 = p1_, p2 = p2_, p3 = p3_, p4 = p4_;

      if (null != remaining) {
         p1 = remaining.mult(p1_);
         p2 = remaining.mult(p2_);
         p3 = remaining.mult(p3_);
         p4 = remaining.mult(p4_);
      }
      
      if (p1.equals(p2)) {
         if (p1.equals(p3) || p1.equals(p4) ||
             p2.equals(p3) || p2.equals(p4) ||
             p3.equals(p4)) {
            System.err.println("Warning: ignored Quadrilateral\n"+
                               color_ + " " + p1 + p2 + p3 + p4);
         } else {
            System.err.println("Warning: degenerated Quadrilateral1-2\n" +
                               color_ + " " + p1 + p2 + p3 + p4);
            face.set(p1, p3, p4);
         }
      } else if (p1.equals(p3)) { // p1!=p2
         if (p1.equals(p4) ||
             p2.equals(p3) || p2.equals(p4) ||
             p3.equals(p4)) {
            System.err.println("Warning: ignored Quadrilateral\n"+
                               color_ + " " + p1 + p2 + p3 + p4);
         } else {
            System.err.println("Warning: degenerated Quadrilateral1-3\n" +
                               color_ + " " + p1 + p2 + p3 + p4);
            face.set(p1, p2, p4);
         }
      } else if (p1.equals(p4)) { // p1!=p2 && p1!=p3
         if (p2.equals(p3) || p2.equals(p4) ||
             p3.equals(p4)) {
            System.err.println("Warning: ignored Quadrilateral\n"+
                               color_ + " " + p1 + p2 + p3 + p4);
         } else {
            System.err.println("Warning: degenerated Quadrilateral1-4\n" +
                               color_ + " " + p1 + p2 + p3 + p4);
            face.set(p1, p2, p3);
         }
      } else if (p2.equals(p3)) { // p1!=p2 && p1!=p3 && p1!=p4
         if (p2.equals(p4) || 
             p3.equals(p4)) {
            System.err.println("Warning: ignored Quadrilateral\n"+
                               color_ + " " + p1 + p2 + p3 + p4);
         } else {
            System.err.println("Warning: degenerated Quadrilateral2-3\n" +
                               color_ + " " + p1 + p2 + p3 + p4);
            face.set(p1, p2, p4);
         }
      } else if (p2.equals(p4)) { // p1!=p2 && p1!=p3 && p1!=p4 && p2!=p3
         if (p3.equals(p4)) {
            System.err.println("Warning: ignored Quadrilateral\n"+
                               color_ + " " + p1 + p2 + p3 + p4);
         } else {
            System.err.println("Warning: degenerated Quadrilateral2-4\n" +
                               color_ + " " + p1 + p2 + p3 + p4);
            face.set(p1, p2, p3);
         }
      } else if (p3.equals(p4)) { // p1!=p2 && p1!=p3 && p1!=p4 && p2!=p3 && p2!=p4
         System.err.println("Warning: degenerated Quadrilateral3-4\n" +
                            color_ + " " + p1 + p2 + p3 + p4);
         face.set(p1, p2, p3);
      } else {
         Vector3 v12 = new Vector3(p1, p2);
         Vector3 v14 = new Vector3(p1, p4);
         Vector3 v34 = new Vector3(p3, p4);
         Vector3 v32 = new Vector3(p3, p2);

         if (v12.crossMult(v14).dotMult(v34.crossMult(v32)) < 0) {
            System.err.println("Warning: intersecting quadrilateral:\n" + 
                               color_ + " " + p1 + p2 + p3 + p4);

            Vector3 v13 = new Vector3(p1, p3);
            Vector3 v43 = new Vector3(p4, p3);
            Vector3 v42 = new Vector3(p4, p2);

            if (v12.crossMult(v13).dotMult(v43.crossMult(v42)) < 0) {
               face.set(p1, p3, p2, p4);
            } else {
               face.set(p1, p2, p4, p3);
            }
         } else {
            face.set(p1, p2, p3, p4);
         }
      }

      int col = color_.val();
      IndexedSet ifs = null;
      if (part_ref.ifsArray_.size() <= col) {
         part_ref.ifsArray_.setSize(col + 1);
      }

      ifs = (IndexedSet)part_ref.ifsArray_.elementAt(col);
      if (null == ifs) {
         ifs = new IndexedSet();
         part_ref.ifsArray_.setElementAt(ifs, col);
      }

      ifs.add(face);
      return null;
   };
   
   private LdrawColor color_;
   private Point3 p1_;
   private Point3 p2_;
   private Point3 p3_;
   private Point3 p4_;
}
