// $Id: Assert.java 1.2 1998/11/04 22:41:34 parisjp Exp $

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

package TOOLS;

/** 
 * An exception thrown in case of applicative error a la Unix' assert.
 *
 * @author <a href="mailto:paris.Jean-Pierre@wanadoo.fr">Jean-Pierre Paris</a>
 * @see    RuntimeException
 */
class AssertionException extends RuntimeException {
   public AssertionException(String s) {
      super(s);
   }
}

/**
 * A class to host assertion related stuff
 *
 * @author <a href="mailto:paris.Jean-Pierre@wanadoo.fr">Jean-Pierre Paris</a>
 * @see    AssertionException
 */
public final class Assert {
   /** Assert should not be instanciated */
   private Assert() {
   };

   /** When <code>false</code>, <code>AssertionException</code> are
    * never thrown.
    *
    * @see AssertionException */
   public static boolean enabled = true;

   /** When the boolean parameter is <code>true</code>,
    * AssertionException are thrown.
    *
    * @param b  the asserted condition
    * @param s  an informative message printed when condition is
    * <code>false</code>
    * @see TOOLS.AssertionException */
   public static final void t(boolean b, String s) {
      if (enabled && !b) {
         throw new AssertionException(s);
      }
   };

   /** Throws AssertionException.
    *
    * @param s  an informative message
    * @see TOOLS.AssertionException */
   public static final void t(String s) {
      if (enabled) {
         throw new AssertionException(s);
      }
   };
}
