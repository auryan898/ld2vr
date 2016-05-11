// $Id: PROTO.java 1.1 1998/11/24 21:03:56 parisjp Exp $

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
import java.util.Vector;
import java.util.Enumeration;

import VRML2.FIELDS.*;
import VRML2.VALUES.*;

/** This class implements VRML97 PROTO definition. A PROTO is defined
 * by its name, its interface (i.e. a list of fields -- type and name)
 * and its 'look' (i.e. a VRML97 node).
 * @see PROTO_USE
 */
public class PROTO extends VRML2Node {
   /** Builds a PROTO's definition.
    * @param  name  the name of the PROTO
    */
   public PROTO(String name) {
      name_   = name;
      fields_ = new Hashtable();
      node_   = null;
   };

   /** Builds a PROTO's definition.
    * @param  name  the name of the PROTO
    */
   public PROTO(PROTO p) {
      name_   = p.name_;
      fields_ = (Hashtable)p.fields_.clone();
      node_   = null;
   };
   
   /** Adds a field in a PROTO's definition.
    * @param   f  a field's definition
    * @return the PROTO itself
    */
   public PROTO add(AbstractField f) {
      fields_.put(f.getName(), f);
      return this;
   }
   /** Sets the node of the PROTO's definition.
    * @param  n  the VRML97 node
    * @return the PROTO itself
    */
   public PROTO setNode(VRML2Node n) {
      node_ = n;
      return this;
   }
   /** Sets the whole text of the definition. This text overrides
    * fields and node settings. Use with extreme care!
    * @param  s  the PROTO text as VRML2String
    * @return the PROTO itself
    */
   public PROTO setText(VRML2String s) {
      text_ = s;
      return this;
   }

   public String getName() {
      return name_;
   }
   public Hashtable getFields() {
      return fields_;
   }
   public VRML2Node getNode() {
      return node_;
   }

   //----------------------------------------------------------------------
   // to String
   public String codeString(int l) {
      if (null != text_) {
         return text_.codeString(l);
      }

      StringBuffer sb = new StringBuffer(i(l) + "PROTO " + name_ + " [\n");
      if (0 < fields_.size()) {
         for (Enumeration e = fields_.elements(); e.hasMoreElements(); ) {
            sb.append(i(l + 1) + e.nextElement() + "\n");
         }
      }
      sb.append(i(l) + "]\n" + i(l) + "{\n");
      if (null != node_) {
	sb.append(node_.codeString(l + 1) + "\n");
      }

      return sb.append(i(l) + "}").toString();
   }

   //----------------------------------------------------------------------
   // main
   public static void main(String[] args) {
      PROTO p1 = new PROTO("empty");
      System.out.println(p1);

      PROTO p2 = new PROTO("test")
         .add(new Field("aColor", new SFColor(1, 2, 3)))
         .add(new ExposedField("aBool", new SFBool(true)));
      //.addNode(new Material().set_emissiveColor("abc"))
      //.addNode(new Material());
         
      System.out.println(p2);
   }

   protected String      name_;
   protected Hashtable   fields_;
   protected VRML2Node   node_;
   protected VRML2String text_ = null;
}
