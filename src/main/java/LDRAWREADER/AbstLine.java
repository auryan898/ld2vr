// $Id: AbstLine.java 1.3 1999/05/19 20:23:10 parisjp Exp $

//		 This file is part of LDRAWOPT
//		Author: Paris.Jean-Pierre@wanadoo.fr
//
// LDRAWOPT is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2, or (at your option)
// any later version.
//
// LDRAWOPT is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with for example GNU Emacs; see the file COPYING.  If not,
// write to the Free Software Foundation, 675 Mass Ave, Cambridge, MA
// 02139, USA.

package LDRAWREADER;

import TOOLS.Assert;

public class AbstLine {
   public AbstLine() {
   };
   public String toStringReverted() {
      return "";
   };
   protected double t_ = 1e4;
};
