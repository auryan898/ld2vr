// $Id: SFVec3f.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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


package VRML2.VALUES;

import TOOLS.T;

public class SFVec3f extends Single {
   public SFVec3f(double x, double y, double z) {
      x_ = x;
      y_ = y;
      z_ = z;
   }
   
   public String codeString(int l) {
      return T.rounds(x_) + " " + T.rounds(y_) + " " + T.rounds(z_);
   }
   public String javaNewTypeString() {
      return "new SFVec3f(" + x_ + ", " + y_ + ", " + z_ + ")";
   }
   
   public boolean equals(Value v) {
      try {
         SFVec3f val = (SFVec3f)v;
         return x_    == val.x_ && y_ == val.y_ && z_ == val.z_;
      } catch (ClassCastException e) {
         return false;
      }
   }
   
   protected double x_;
   protected double y_;
   protected double z_;
   
   public static void main(String[] args) {
      System.out.println("== SFVec3f ==========");
      SFVec3f c1 = new SFVec3f(1, 2, 3);
      System.out.println(c1);
      SFVec3f c2 = new SFVec3f(.0, 1, 123.01);
      System.out.println(c2);
   }
}
