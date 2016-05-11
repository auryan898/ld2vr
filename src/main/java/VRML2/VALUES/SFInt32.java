// $Id: SFInt32.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class SFInt32 extends Single {
   public SFInt32(int value) {
      value_ = value;
   }
   
   public String codeString(int l) {
      return "" + value_;
   }
   public String javaNewTypeString() {
      return "new SFInt32(" + value_ + ")";
   }
   
   public boolean equals(Value v) {
      try {
         return value_  == ((SFInt32)v).value_;
      } catch (ClassCastException e) {
         return false;
      }
   }
   
   protected int value_;

   public static void main(String[] args) {
      System.out.println("== SFInt32 ==========");
      SFInt32 c1 = new SFInt32(1);
      System.out.println(c1);
      SFInt32 c2 = new SFInt32(123);
      System.out.println(c2);
   }
}
