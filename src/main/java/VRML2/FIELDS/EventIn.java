// $Id: EventIn.java 1.2 1998/11/04 23:51:16 parisjp Exp $

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


package VRML2.FIELDS;

public class EventIn extends AbstractField {
   public EventIn(String type, String id) {
      super(type, id);
   }

   protected String codeString(int l) {
      return "eventIn " + super.codeString(l);
   };
   protected String codeStringNoValue(int l) {
      return "eventIn " + super.codeString(l);
   }


   public static void main(String[] args) {
      EventIn f1 = new EventIn("SFColor", "aColor");
      System.out.println(f1);
   }
}
