// $Id: Value.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public abstract class Value {
   public String toString() {
      return codeString(0);
   }

   public String javaNewTypeString() {
      throw(new RuntimeException("javaNewTypeString not allowed on " +
                                 getClass().getName()));
   }

   public abstract boolean equals(Value v); // does not override Object.equals

   public abstract String codeString(int l);
   // public: used in VRML2

   protected String i(int level) {
      return WsString_.substring(0, 0 * level);
   }

   private static final String WsString_ = new String("                     "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   ");

}
