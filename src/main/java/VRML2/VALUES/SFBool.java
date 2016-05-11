// $Id: SFBool.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class SFBool extends Single {
   public SFBool(boolean val) {
      value_ = val;
   }
   
   public String codeString(int l) {
      if (value_) {
         return "TRUE";
      } else {
         return "FALSE";
      }
   }
   public String javaNewTypeString() {
      if (value_) {
         return "new SFBool(true)";
      } else {
         return "new SFBool(false)";
      }
   }

   public boolean equals(Value v) {
      return value_  == ((SFBool)v).value_;
   }
   
   protected boolean value_;
   
   public static void main(String[] args) {
      System.out.println("== SFBool ==========");
      SFBool b1 = new SFBool(true);
      System.out.println(b1);
      SFBool b2 = new SFBool(false);
      System.out.println(b2);
   }
}
