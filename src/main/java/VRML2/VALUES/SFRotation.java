// $Id: SFRotation.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class SFRotation extends Single {
   public SFRotation(double x, double y, double z, double angle) {
      x_     = x;
      y_     = y;
      z_     = z;
      angle_ = angle;
   }
   
   public String codeString(int l) {
      return T.rounds(x_) + " " + T.rounds(y_) + " " + T.rounds(z_) + " " +
         T.rounds(angle_);
   }
   public String javaNewTypeString() {
      return "new SFRotation(" + x_ + ", " + y_ + ", " + z_ + ", " +
         angle_ + ")";
   }
   
   public boolean equals(Value v) {
      try {
         SFRotation val = (SFRotation)v;
         return x_    == val.x_ && y_ == val.y_ && z_ == val.z_
            && angle_ == val.angle_;
      } catch (ClassCastException e) {
         return false;
      }
   }
   
   protected double x_;
   protected double y_;
   protected double z_;
   protected double angle_;
   
   public static void main(String[] args) {
      System.out.println("== SFRotation ==========");
      SFRotation c1 = new SFRotation(1, 2, 3, .123);
      System.out.println(c1);
      SFRotation c2 = new SFRotation(.0, 1, 123.01, 3.14);
      System.out.println(c2);
   }
}
