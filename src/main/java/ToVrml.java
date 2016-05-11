// $Id: ToVrml.java 1.4 1998/12/15 21:51:33 parisjp Exp $

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

import java.util.Vector;

import TOOLS.Matrix3;

import VRML2.File;
import VRML2.VRML2Node;

import VRML2.VALUES.Value;

interface ToVrml {
   public VRML2Node toVRML(PartRef part_ref, Value color,
                           Matrix3 remaining, Options options);
}; 
