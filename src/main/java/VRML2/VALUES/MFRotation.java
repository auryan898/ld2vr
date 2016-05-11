// $Id: MFRotation.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class MFRotation extends Multiple {
   public MFRotation add(SFRotation val) {
      return (MFRotation)super.add(val);
   }
   public MFRotation add(double x, double y, double z, double angle) {
      return (MFRotation)super.add(new SFRotation(x, y, z, angle));
   }

   public static void main(String[] args) {
      System.out.println("== MFRotation ==========");
      MFRotation c1 = new MFRotation().add(new SFRotation(1, 2, 3, 0.123));
      System.out.println(c1);

      MFRotation c2 = new MFRotation()
         .add(new SFRotation(1, 2, 3, .546))
         .add(new SFRotation(4, 5, 6, .123));
      System.out.println(c2);
      
      MFRotation c3 = new MFRotation().add(new SFRotation(1, 2, 3, .123));
      System.out.println("c1c2 " + c1.equals(c2));
      System.out.println("c1c3 " + c1.equals(c3));
   }
}
