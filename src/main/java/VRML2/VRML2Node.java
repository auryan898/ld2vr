// $Id: VRML2Node.java 1.1 1998/06/17 20:11:39 parisjp Exp $

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

/** This class is the root of all the VRML2 nodes hierarchy.
 * Each class associated with a VRML97 node is generated using the
 * GENERATOR package. These classes map all the fields of the associated
 * node to a 'set_...' method. For example, you can write:
 * <pre>
 * Viewpoint v = new Viewpoint()
 *    .set_description(new SFString("Front"))
 *    .set_position(0, 0, .1));
 * </pre>
 * Then, to print the VRML code:
 * <pre>
 * System.out.println(v);
 * </pre>
 * 
 * @see VRML2.GENERATOR
 */
public abstract class VRML2Node {
   /** Not used. Just in case...
    */
   protected VRML2Node() {}

   /** Returns a string representation of a node.
    * @return  a String
    * @see #codeString(int)
    */
   public String toString() {
      return codeString(0);
   }
  
   /** Returns a string representation of a node according to an 
    * indentation level.
    * @param   level   the indentation level.
    * @return  a String
    * @see #toString()
    */
   public abstract String codeString(int level); 
   // public: used in VALUES/SFNode

   protected String codeStringAux(int l) {
      throw new Error("VRML2Node::codeStringAux should not be called");
   }

   /** The number of charaters added for one indentation level.
    * May be set to zero to get no indentation at all.
    */
   public static int indentationLevel_ = 0;

   protected String i(int level) {
      return WsString_.substring(0, indentationLevel_ * level);
   }

   private static final String WsString_ = new String("                     "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   "
                                                      + "                   ");

}
