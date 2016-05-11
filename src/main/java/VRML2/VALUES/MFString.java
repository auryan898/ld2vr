// $Id: MFString.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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


package VRML2.VALUES;

public class MFString extends Multiple {
   public MFString add(SFString val) {
      return (MFString)super.add(val);
   }
   public MFString add(String val) {
      return (MFString)super.add(new SFString(val));
   }

   public static void main(String[] args) {
      System.out.println("== MFString ==========");
      MFString c1 = new MFString().add(new SFString("abc"));
      System.out.println(c1);

      MFString c2 = new MFString()
         .add(new SFString("def"))
         .add(new SFString("ghi"));
      System.out.println(c2);
      
      MFString c3 = new MFString().add(new SFString("abc"));
      System.out.println("c1c2 " + c1.equals(c2));
      System.out.println("c1c3 " + c1.equals(c3));
   }
}
