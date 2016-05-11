// $Id: NamedNode.java 1.2 1998/11/04 22:43:37 parisjp Exp $

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

/** This class is the common root for all VRML nodes that can be 
 * DEFed. That's all nodes but the PROTO.
 * This class offers very simple DEF/USE mechanism that is totally
 * under the programer control: nothing here will DEF a node 
 * automagically if the programer did not request it previously.
 * <em>Moreover, if an already DEFed node is modified, these 
 * MODIFICATIONS will be LOST!</em>
 */
class NamedNode extends VRML2Node {
   /** Builds an unamed node.
    */
   NamedNode() {
      name_ = null;
      namep_ = false;
      printedp_ = false;
   }
   /** Builds a named node. The name is given by the user.
    * @param  name  the DEF/USE name
    */
   NamedNode(String name) {
      name_ = name;
      namep_ = true;
      printedp_ = false;
   }
   /** Builds a named node. The name is generated using a constant prefix
    * then an index, and a constant suffix.
    * @param  namep  a boolean indicating if the node should be
    *                named or not
    */
   NamedNode(boolean namep) {
      if (namep) {
         name_ = generateUniqueName();
      } else {
         name_ = null;
      }
      namep_ = namep;
      printedp_ = false;
   }
   /** Returns a String represenation of a named node. If the node is 
    * unamed, it is always printed as is. If the node is named and
    * has not been printed yet, return the String represenation of 
    * the node preceded by "DEF <name>". If the node has been printed
    * simply returns "USE <name>".
    * @param   int  the indentation level
    * @return       a String represenation
    */
   public String codeString(int l) {
      if (namep_) {
         if (printedp_) {
            return "USE " + name_;
         } else {
            printedp_ = true;
            return "DEF " + name_ + " " + codeStringAux(l);
         }
      } else {
         return codeStringAux(l);
      }
   }

   /** Prefix for the generated names
    * @see #generateUniqueName()
    */
   public String prefix_ = "ZzZ";
   /** Suffix for the generated names
    * @see #generateUniqueName()
    */
   public String suffix_ = "";
   /** The index used for name generation.
    * @see #generateUniqueName()
    */
   private static int Index_ = 0;

   /** Returns a unique name made with a constant prefix
    * then an index, and a constant suffix.
    * @return an unique name String
    * @see #prefix_
    * @see #suffix_
    * @see #Index_
    */
   private String generateUniqueName() {
      return prefix_ + Index_++ + suffix_ + " ";
   }

   /** For testing purpose
    */
   public static void main(String[] args) {
      NamedNode nm = new NamedNode(true);
      System.err.println(nm);
      System.err.println(nm);
   }

   /** The node name.
    */
   protected String name_;
   /** Indicates if the node is named or not.
    */
   protected boolean namep_;
   /** Indicates if the node has been printed yet.
    */
   protected boolean printedp_;
}
