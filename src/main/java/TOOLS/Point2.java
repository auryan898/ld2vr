// $Id: Point2.java 1.1 1999/06/22 19:43:21 parisjp Exp $

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

public class Point2 {
   public Point2(double a_x, double a_y) {
      x = a_x; y = a_y;
   };

   public Point2 min(Point2 p) {
      return new Point2( Math.min(x, p.x), Math.min(y, p.y) );
   };
   public Point2 max(Point2 p) {
      return new Point2( Math.max(x, p.x), Math.max(y, p.y) );
   };

   public String toString() {
      return "P(" + x + ", " + y + ")";
   };
   
   public double x, y;
};

