// $Id: VRML2File.java 1.1 1998/06/17 20:21:49 parisjp Exp $

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

import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


/** This class represents a file containing VRML97 nodes. A VRML file
 * can be named or not. If named, nodes are printed in the named file.
 * If not named, nodes are printed on the standard output.
 */
public class VRML2File {
   /** Build an unnamed VRML file.
    */
   public VRML2File() {
      name_ = null;
      nodes_ = new ArrayList<>();
   }
   /** Builds a named VRML file.
    * @param  filename  the name of the file where nodes will be printed.
    */
   public VRML2File(String filename) {
      name_ = filename;
      nodes_ = new ArrayList<>();
   }
   /** Adds a VRML node in the file. The return value allows chaining
    * <code>add</code> calls in the same statement.
    * @param  node the added VRML node
    * @return      the VRML2File instance itself
    */
   public VRML2File add(VRML2Node node) {
      nodes_.add(node);
      return this;
   }
   /** Returns a VRML97 comment line. That is a String starting with '#'
    * and ending with a '\n'.
    * @param  s  the comment String
    * @return    the complete comment line
    */
   public String comment(String s) {
      return "#" + s + "\n";
   }
   /** Returns a VRML97 header.
    * @return    the header String
    */
   public String header() {
      return "#VRML V2.0 utf8";
   }
   /** Prints all the nodes in a file, or on the standard output.
    * If the file is named, nodes are printed in the named file.
    * If not named, nodes are printed on the standard output.
    * Each node is preceded by a simple comment indicating his index
    * in the file.
    */
   public void print() {
      if (name_ != null) {
         try {
            java.io.File parent = new java.io.File(name_).getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            PrintWriter pw = new PrintWriter(new FileOutputStream(name_));
            pw.println(header());
            for (int i = 0; i < nodes_.size(); i++) {
               pw.println(comment("node " + i) + nodes_.get(i));
            }
            pw.close();
         } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Exiting...");
            System.exit(-1);
         }
      } else {
         System.out.println(header());
         for (int i = 0; i < nodes_.size(); i++) {
            System.out.println(comment("node " + i) + nodes_.get(i));
         }
      }
   }

   /** The name of the file. May be null to indicate stdout.
    */
   protected String name_;
   /** The node's vector.
    */
   protected ArrayList<VRML2Node> nodes_;
}
