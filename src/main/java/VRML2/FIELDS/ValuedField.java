// $Id: ValuedField.java 1.1 1998/11/04 22:51:01 parisjp Exp $

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

public abstract class ValuedField extends AbstractField {
   public ValuedField(String type, String id, Value default_value) {
      super(type, id);
      defaultValue_ = default_value;
   }

   public ValuedField(String id, Value default_value) {
      super(default_value.getClass(), id);
      defaultValue_ = default_value;
   }

   public Value getDefaultValue() {
      return defaultValue_;
   }

   public boolean accepts(Value value) {
      String valueType = value.getClass().getName();
      valueType = valueType.substring(valueType.lastIndexOf('.') + 1);

      return valueType.equals(getType()) || valueType.equals("Alias");
   }

   public boolean defaultsTo(Value value) {
      String valueType = value.getClass().getName();
      valueType = valueType.substring(valueType.lastIndexOf('.') + 1);

      return !valueType.equals("Alias") && value.equals(defaultValue_);
   }

   protected Value defaultValue_;
}

