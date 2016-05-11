// $Id: Multiple.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

import java.util.Vector;

public abstract class Multiple extends Value {
   protected Multiple() {
      vect_ = new Vector();
   }
   
   public Multiple add(Single val) {
      vect_.addElement(val);
      return this;
   }
   
   public String codeString(int l) {
      int size = vect_.size();
      if (0 == size) {
         return "[]";
      }
      StringBuffer sb = new StringBuffer("[\n" + i(l + 1));
      int i = 0;
      for (; i < size - 1; i++) {
         sb.append(((Value)(vect_.elementAt(i))).codeString(l + 1) +
                   ",\n" + i(l + 1));
      }
      return sb.append(((Value)(vect_.elementAt(i))).codeString(l + 1) +
                       "\n" + i(l) +"]").toString();
   }

   public String javaNewTypeString() {
      int size = vect_.size();
      if (0 == size) {
         return "new " + getClass().getName() + "()";
      }
      StringBuffer sb = new StringBuffer("new " + getClass().getName() + "()");
      for (int i = 0; i < size; i++) {
         sb.append(".add(" + 
                   ((Value)(vect_.elementAt(i))).javaNewTypeString()
                   + ")");
      }
      return sb.toString();
   }

   public boolean equals(Value v) {
      try {
         Multiple mv = (Multiple)v;
         int size = mv.vect_.size();
         if (size != vect_.size()) {
            return false;
         }
         for (int i = 0; i < mv.vect_.size(); i++) {
            if (! ((Value)(mv.vect_.elementAt(i)))
                .equals(((Value)(vect_.elementAt(i))))) {
               return false;
            }
         }
         return true;
      } catch (ClassCastException e) {
         return false;
      }
   }

   protected Vector vect_;
}
