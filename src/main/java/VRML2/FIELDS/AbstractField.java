// $Id: AbstractField.java 1.2 1998/11/04 23:50:20 parisjp Exp $

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


package VRML2.FIELDS;

import VRML2.VALUES.Value;

public abstract class AbstractField {
   protected AbstractField(String type, String id) {
      type_ = type;
      id_   = id;
   }
   protected AbstractField(Class c, String id) {
      String type = c.getName();
      type_ = type.substring(type.lastIndexOf('.') + 1);
      id_   = id;
   }
   
   public final String getName() {
      return id_;
   }

   public final String getType() {
      return type_;
   }

   public final String toString() {
      return codeString(0);
   };
   public final String toStringNoValue() {
      return codeStringNoValue(0);
   };
   
   protected String codeString(int l) {
      return type_ + " " + id_;
   };
   protected String codeStringNoValue(int l) {
      return type_ + " " + id_;
   };

   protected String type_;
   protected String id_;

   protected String i(int level) {
      return WsString_.substring(0, 2 * level);
   }

   private static final String WsString_ = new String("                     "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   ");

}

