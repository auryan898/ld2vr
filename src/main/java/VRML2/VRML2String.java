// $Id: VRML2String.java 1.2 1998/11/04 22:35:27 parisjp Exp $

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

package VRML2;

import java.util.Vector;

public class VRML2String extends NamedNode {
   public VRML2String() {
      super();
      strings_ = new Vector();
   }
   public VRML2String(String name) {
      super(name);
      strings_ = new Vector();
   }
   public VRML2String(boolean namep) {
      super(namep);
      strings_ = new Vector();
   }

   public final VRML2String add_string(java.lang.String val) {
      strings_.addElement(val);
      return this;
   }
   
   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("");

      if (0 < strings_.size()) {
         int i;
         for (i = 0; i < strings_.size() - 1; i++) {
            sb.append((String)strings_.elementAt(i) + "\n" + i(l));
         }
         return sb.append(strings_.elementAt(i)).toString();
      } else {
         return "";
      }
   }
   
   protected Vector strings_; // String[]
}
