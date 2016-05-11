// $Id: SFColor.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class SFColor extends Single {
   public SFColor(double red, double green, double blue) {
      red_   = red;
      green_ = green;
      blue_  = blue;
   }
   
   public String codeString(int l) {
      return T.rounds(red_) + " " + T.rounds(green_) + " " + T.rounds(blue_);
   }
   public String javaNewTypeString() {
      return "new SFColor(" + red_ + ", " + green_ + ", " + blue_ + ")";
   }
   
   public boolean equals(Value v) {
      try {
         return red_  == ((SFColor)v).red_ 
            && green_ == ((SFColor)v).green_ 
            && blue_  == ((SFColor)v).blue_;
      } catch (ClassCastException e) {
         return false;
      }
   }
   
   protected double red_;
   protected double green_;
   protected double blue_;
   
   public static void main(String[] args) {
      System.out.println("== SFColor ==========");
      SFColor c1 = new SFColor(1, 2, 3);
      System.out.println(c1);
      SFColor c2 = new SFColor(.0, 1, 123.01);
      System.out.println(c2);
   }
}
