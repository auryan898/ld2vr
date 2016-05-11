// $Id: SFNode.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

import VRML2.VRML2Node;

public class SFNode extends Single {
   public SFNode() {
      node_ = null;
   }
   public SFNode(VRML2Node node) {
      node_ = node;
   }
   
   public String codeString(int l) {
      if (null != node_) {
         return "" + node_.codeString(l);
      } else {
         return "NULL";
      }
   }
   public String javaNewTypeString() {
      return "new SFNode()";
   }
   
   public boolean equals(Value v) {
      try {
         SFNode sfn = (SFNode)v;
         if ((null == node_)
             && (null == sfn.node_)) {
            return true;
         } else {
            // implement equal in VRML2Node
            //throw new RuntimeException("SFNode::equals");
            return false;
         }
      } catch (ClassCastException e) {
         return false;
      }
   }
   
   protected VRML2Node node_;
   
   public static void main(String[] args) {
      System.out.println("== SFNode ==========");
      SFNode c1 = new SFNode();
      System.out.println(c1);
      //SFNode c2 = new SFNode(.0, 1, 123.01);
      //System.out.println(c2);
   }
}
