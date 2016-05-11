// $Id: SFString.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class SFString extends Single {
   public SFString(String value) {
      value_ = new String(value);
   }
   
   public String codeString(int l) {
      return "\"" + value_ + "\"";
   }
   public String javaNewTypeString() {
      return "new SFString(" + value_ + ")";
   }
   
   public boolean equals(Value v) {
      try {
         return value_.equals(((SFString)v).value_);
      } catch (ClassCastException e) {
         return false;
      }
   }
   
   protected String value_;

   public static void main(String[] args) {
      System.out.println("== SFString ==========");
      SFString c1 = new SFString("abc");
      System.out.println(c1);
      SFString c2 = new SFString("zzz");
      System.out.println(c2);
   }
}
