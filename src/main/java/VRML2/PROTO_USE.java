// $Id: PROTO_USE.java 1.2 1998/12/16 21:04:33 parisjp Exp $

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

import java.util.Hashtable;
import java.util.Enumeration;

import VRML2.FIELDS.*;
import VRML2.VALUES.*;

public class PROTO_USE extends NamedNode {
   public PROTO_USE(PROTO proto) {
      super();
      name_        = proto.getName();
      fields_      = (Hashtable)(proto.getFields().clone());
      fieldValues_ = new Hashtable();
   };

   public PROTO_USE(String def_name, PROTO proto) {
      super(def_name);
      name_        = proto.getName();
      fields_      = (Hashtable)(proto.getFields().clone());
      fieldValues_ = new Hashtable();
   };


   
   //----------------------------------------------------------------------
   // accessors
   public PROTO_USE setField(String name, Value value) {
      ValuedField field =  (ValuedField)fields_.get(name);
      if (null != field) {
         if (field.accepts(value)) {
            fieldValues_.put(name, value);
            return this;
         } else {
            throw new RuntimeException("setField: wrong type for " +
                                       name + ": " + field.getType() +
                                       " expected");
         }
      } else {
         throw new RuntimeException("setField: " + name +
                                    " does not exist in " + name_ + 
                                    " prototype");
      }
   }

   //----------------------------------------------------------------------
   // to String
   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer(name_ + " {\n");

      if (0 < fieldValues_.size()) {
         for (Enumeration e = fieldValues_.keys(); e.hasMoreElements(); ) {
            Object key = e.nextElement();
            Value value = (Value)fieldValues_.get(key);
            ValuedField field = (ValuedField)fields_.get(key);
            if (! field.defaultsTo(value)) {
               sb.append(i(l + 1) + key + " " + 
                         value.codeString(l + 1) + "\n");
            }
         }
      }

      return sb.append(i(l) + "}").toString();
   }
   
   //----------------------------------------------------------------------
   // main
   public static void main(String[] args) {
      PROTO proto = new PROTO("test")
         .add(new Field("aColor", new SFColor(1, 2, 3)))
         .add(new Field("aBool", new SFBool(true)));
      
      PROTO_USE p1 = new PROTO_USE(proto);
      System.out.println(p1);

      PROTO_USE p2 = new PROTO_USE(proto)
         .setField("aBool", new SFBool(false))
         .setField("aColor", new SFColor(1, 0, 3))
         .setField("aColor", new SFColor(1, 2, 3));
      //.setField("aColor1", new SFColor(1, 2, 3));
      //.setField("aColor", new SFBool(true));
      
      System.out.println(p2);
   }

   protected String name_;
   protected Hashtable fields_;
   protected Hashtable fieldValues_;
}
