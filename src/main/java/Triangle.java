// $Id: Triangle.java 1.5 1999/04/16 21:33:40 parisjp Exp $

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

public class Triangle extends LDRAWREADER.Triangle implements ToVrml {
   Triangle(LDRAWREADER.Triangle v) {
      super(v);

      color_ = new LdrawColor(colorValue_);
      p1_ = new Point3(x1_, y1_, z1_);
      p2_ = new Point3(x2_, y2_, z2_);
      p3_ = new Point3(x3_, y3_, z3_);
   };

   public VRML2Node toVRML(PartRef part_ref, Value unused1, Matrix3 remaining,
                           Options unused3) {
      IndexedSet face = new IndexedSet();
      Point3 p1 = p1_, p2 = p2_, p3 = p3_;

      if (null != remaining) {
         p1 = remaining.mult(p1_);
         p2 = remaining.mult(p2_);
         p3 = remaining.mult(p3_);
      }

      if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) {
         System.err.println("Warning: ignored Triangle\n"+
                            color_ + " " + p1 + p2 + p3);
      } else {
         face.set(p1, p2, p3);
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
}
