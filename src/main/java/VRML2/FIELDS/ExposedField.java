// $Id: ExposedField.java 1.2 1998/11/04 23:49:55 parisjp Exp $

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

import VRML2.VALUES.*;

public class ExposedField extends ValuedField {
   public ExposedField(String type, String id, Value default_value) {
      super(type, id, default_value);
   }

   public ExposedField(String id, Value default_value) {
      super(id, default_value);
   }

   protected String codeString(int l) {
      return "exposedField " + super.codeString(l) + " " + defaultValue_;
   };
   protected String codeStringNoValue(int l) {
      return "exposedField " + super.codeString(l);
   }

   public static void main(String[] args) {
      ExposedField f1 = new ExposedField("SFColor", "aColor", new SFColor(1, 2, 3));
      System.out.println(f1);
   }
}
