// $Id: MetaCmd.java 1.4 1998/12/15 21:51:41 parisjp Exp $

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
import TOOLS.Matrix3;

import VRML2.VRML2Node;
import VRML2.VRML2String;
import VRML2.WorldInfo;

import VRML2.VALUES.Value;
import VRML2.VALUES.SFString;

public class MetaCmd extends LDRAWREADER.MetaCmd implements ToVrml {

    MetaCmd(LDRAWREADER.MetaCmd v) {
        super(v);
    }

    @Override
    public VRML2Node toVRML(PartRef unused1, Value unused2, Matrix3 unused4,
            Options unused5) {
        if (once_) {
            WorldInfo w = new WorldInfo();
            w.set_title(new SFString(value_));
            w.add_info("VRML2 file generated from James Jessiman's LDRAW files")
                    .add("              by Jean-Pierre Paris");
            once_ = false;
            return new VRML2String().add_string(w.toString());
        } else {
            return new VRML2String().add_string("# " + value_);
        }
    }

    static private boolean once_ = true;
}
