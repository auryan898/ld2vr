// $Id: SFVec2f.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class SFVec2f extends Single {
   public SFVec2f(double x, double y) {
      x_ = x;
      y_ = y;
   }
   
   public String codeString(int l) {
      return T.rounds(x_) + " " + T.rounds(y_);
   }
   public String javaNewTypeString() {
      return "new SFVec2f(" + x_ + ", " + y_ + ")";
   }
   
   public boolean equals(Value v) {
      try {
         SFVec2f val = (SFVec2f)v;
         return x_    == val.x_ && y_ == val.y_;
      } catch (ClassCastException e) {
         return false;
      }
   }
   
   protected double x_;
   protected double y_;
   
   public static void main(String[] args) {
      System.out.println("== SFVec2f ==========");
      SFVec2f c1 = new SFVec2f(1, 2);
      System.out.println(c1);
      SFVec2f c2 = new SFVec2f(.0, 1);
      System.out.println(c2);
   }
}
