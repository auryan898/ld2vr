// $Id: OrderedHashtable.java 1.1 1998/08/25 21:37:49 parisjp Exp $

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

class OrderedHashtable extends java.util.Hashtable {
   OrderedHashtable() {
      super();
      keys_ = new java.util.Vector();
   }
   
   public synchronized Object put(Object key, Object value)
        throws NullPointerException {
           if (-1 == keys_.indexOf(key)) {
              keys_.addElement(key);
              super.put(key, value);
              while (null == super.get(key)) {
                 // Is there a mysterious bug in Hashtable for the
                 // p_2-4edge000100001 key?`
                 super.put(key, value);
              }
           }
           return null;
   };

   public final synchronized Object elementAt(int index) 
        throws ArrayIndexOutOfBoundsException {
           return super.get(keys_.elementAt(index));
   };

   public synchronized String toString() {
      return super.toString() + "\n[" + keys_.toString() + "]";
   };

   private java.util.Vector keys_; 
}
