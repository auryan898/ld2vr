// $Id: EXT_PROTO.java 1.3 1999/02/23 22:33:14 parisjp Exp $

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

import TOOLS.Assert;

public class EXT_PROTO extends VRML2Node {
   public EXT_PROTO(PROTO proto) {
      name_        = proto.getName();
      fields_      = (Hashtable)(proto.getFields().clone());
      filename_    = "__NONE__";
   };
   
   //----------------------------------------------------------------------
   // accessors
   public EXT_PROTO setFilename(String filename) {
      Assert.t(null != filename, "null EXTERNPROTO filename");
      filename_ = filename;
      return this;
   };

   //----------------------------------------------------------------------
   // to String
   public String codeString(int l) {
      StringBuffer sb = new StringBuffer("EXTERNPROTO " + name_ + " [\n");

      if (0 < fields_.size()) {
         for (Enumeration e = fields_.keys(); e.hasMoreElements(); ) {
            Object key = e.nextElement();
            ValuedField field = (ValuedField)fields_.get(key);
            sb.append(i(l + 1) + field.toStringNoValue() + "\n");
         }
      }

      return sb.append(i(l) + "] \"" + filename_ + "\"").toString();
   }
   
   //----------------------------------------------------------------------
   // main
   public static void main(String[] args) {
      PROTO proto = new PROTO("test")
         .add(new Field("aColor", new SFColor(1, 2, 3)))
         .add(new ExposedField("aBool", new SFBool(true)));
      
      EXT_PROTO p1 = new EXT_PROTO(proto);
      System.out.println(p1);

      EXT_PROTO p2 = new EXT_PROTO(proto)
         .setFilename("zzz.wrl");
      
      System.out.println(p2);
   };

   protected String name_;
   protected Hashtable fields_;
   protected String filename_;
};
