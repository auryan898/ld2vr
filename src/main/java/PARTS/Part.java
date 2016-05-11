// $Id: Part.java,v 1.1 1998/05/03 19:57:36 parisjp Exp $

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

package PARTS;

import TOOLS.Matrix3;

import VRML2.VRML2Node;
import VRML2.Transform;

public abstract class Part {
   // ZZZ: How to make singleton?
   
   public VRML2Node toVRML(Matrix3 remaining) {
      return null;
   }
}
