// $Id: Segment3Sum.java 1.1 1999/05/17 21:21:27 parisjp Exp $

//		 This file is part of Ldorient
//		Author: Paris.Jean-Pierre@wanadoo.fr
//
// Ldorient is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2, or (at your option)
// any later version.
//
// Ldorient is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with for example GNU Emacs; see the file COPYING.  If not,
// write to the Free Software Foundation, 675 Mass Ave, Cambridge, MA
// 02139, USA.

package TOOLS;

import java.util.Vector;

public class Segment3Sum {
   public Segment3Sum() {
      segments_ = new Vector();
   };

   public Segment3 get() {
      if (1 != segments_.size()) {
         return null;
      } else {
         return (Segment3)segments_.elementAt(0);
      }
   };

   public void addEqEq(Segment3 added) {
      Segment3 s;
      Segment3 sum = null;
      int i = 0;
      boolean breaked = false;

      for (; i < segments_.size(); i++) {
         s = (Segment3)segments_.elementAt(i);
         sum = s.addEqEq(added);
         if (null != sum) {
            segments_.setElementAt(sum, i);
            breaked = true;
            break;
         }
      }
      if (breaked) {
         Segment3 newSum = null;
         if (i < segments_.size() - 1) {
            Segment3 sAfter = (Segment3)segments_.elementAt(i + 1);
            newSum = sAfter.addEqEq(sum);
            if (null != newSum) {
               segments_.setElementAt(newSum, i);
               segments_.removeElementAt(i + 1);
            }
         }
         if (0 < i) {
            Segment3 sBefore = (Segment3)segments_.elementAt(i - 1);
            newSum = sBefore.addEqEq(sum);
            if (null != newSum) {
               segments_.setElementAt(newSum, i - 1);
               segments_.removeElementAt(i);
            }
         }
      } else {
         segments_.addElement(added);
      }
   };

   public String toString() {
      Segment3 s = get();
      if (null != s) {
         return s.toString();
      } else {
         StringBuffer sb = new StringBuffer("< ");
         for (int i = 0; i < segments_.size(); i++) {
            s = (Segment3)segments_.elementAt(i);
            if (0 != i) {
               sb.append("\n");
            }
            sb.append(s.toString());
         }
         sb.append(" >");
         return sb.toString();
      }
   };

   /** For debuging purpose */
   public static void main(String[] args) {
      Segment3Sum ss = new Segment3Sum();
      Point3 p000 = new Point3(0, 0, 0);
      Point3 p100 = new Point3(1, 0, 0);
      Point3 p200 = new Point3(2, 0, 0);
      Point3 p300 = new Point3(3, 0, 0);

      ss.addEqEq(new Segment3(p200, p300));
      System.err.println(ss);
      ss.addEqEq(new Segment3(p000, p100));
      System.err.println(ss);
      ss.addEqEq(new Segment3(p100, p200));
      System.err.println(ss);
   };

   private Vector segments_;
};
