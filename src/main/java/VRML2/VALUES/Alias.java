// $Id: Alias.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class Alias extends Value {
   public Alias(String name) {
      name_ = name;
   }
   
   public String codeString(int l) {
      // Check it...
      return "IS " + name_;
   }

   public boolean equals(Value v) {
      try {
         return name_.equals(((Alias)v).name_);
      } catch (ClassCastException e) {
         return false;
      }
   }   
   
   protected String name_;
   
   public static void main(String[] args) {
      System.out.println("== Alias ==========");
      Alias c1 = new Alias("abc");
      System.out.println(c1);
   }
}
