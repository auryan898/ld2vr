// $Id: LdrawColor.java 1.2 1999/02/23 22:06:34 parisjp Exp $

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

import TOOLS.Assert;
import TOOLS.T;

import VRML2.VRML2Node;
import VRML2.VRML2String;
import VRML2.Appearance;
import VRML2.Material;

import VRML2.VALUES.Alias;
import VRML2.VALUES.SFNode;
import VRML2.VALUES.Value;

class LdrawColor {
   LdrawColor(int color) {
      color_ = color;
   }
   
   public int val() {
      return color_;
   }

   public String toString() {
      int colJ = color_;
      int colK;
      // FROM THE LDRAW FAQ
      //   http://fys.ku.dk/%7Esparre/LEGO/V%E6rkt%F8j/LDraw-FAQ.html
      // Also, colours 256 through 511 are dithered. So if you want to
      // combine colours J and K, figure your colour value as
      //                    colour = (J * 16) + K + 256
      // The complementary colour of J is used as the complementary
      // colour of the dithered value. So you can control the edge
      // colour (somewhat) by switching J and K.
      // Color ranges: 0-15, 16, 24, 32-47, 256-511

      if (256 <= colJ && colJ <= 511) {
         colK = colJ - 256;
         colJ = colK / 16;
         colK = colK - (16 * colJ);
         return getCol48(colJ) + "=" + getCol48(colK);
      } else {
         if (colJ == 16) {
            return "CurrentColor";
         } else if (colJ == 24) {
            return "%CurrentColor";
         } else {
            return getCol48(colJ);
         }
      }
   }

   public String toName() {
      if ((16 == color_) || (24 == color_)) {
         return "";
      } else {
         return toString();
      }
   };

   public Value toVRML(Value color) {
      if ((16 == color_) || (24 == color_)) {
	if (null == color) {
	    return new SFNode(new Appearance()
			      .set_material(new Material()
					    .set_diffuseColor(.6, 0, .6)));
	} else {
	    return new Alias("app");
	}
      } else {
         String colorName = toString();
         VRML2Node col = T.getWRLCode(colorName, colorName + ".wrl");
         if (null == col) {
            System.err.println("Warning: " + this + " not found.");
         }
         return new SFNode(col);
      }
   }

   private int color_;

   private String getCol48 (int col) {
      String bright = "";
      String colStr = "";
         
      if (col < 48) {
         if (col >= 32) {
            bright = "Clear_";
            col = col - 32;
         }
         switch (col) {
         case 0:  colStr = "Black"; break;
         case 1:  colStr = "Blue"; break;
         case 2:  colStr = "Green"; break;
         case 3:  colStr = "Dark_Cyan"; break;
         case 4:  colStr = "Red"; break;
         case 5:  colStr = "Magenta"; break;
         case 6:  colStr = "Brown"; break;
         case 7:  colStr = "Grey"; break;
         case 8:  colStr = "Dark_Grey"; break;
         case 9:  colStr = "Light_Blue"; break;
         case 10: colStr = "Light_Green"; break;
         case 11: colStr = "Cyan"; break;
         case 12: colStr = "Light_Red"; break;
         case 13: colStr = "Pink"; break;
         case 14: colStr = "Yellow"; break;
         case 15: colStr = "White"; break;
         default:
            Assert.t(false, "Unknown color: " + col + ".");
         }
      } else {
         Assert.t(false, "Color: " + col + " >= 48.");
      }
      return bright + colStr;
   }
}
