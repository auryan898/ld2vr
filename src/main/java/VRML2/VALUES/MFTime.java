// $Id: MFTime.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class MFTime extends Multiple {
   public MFTime add(SFTime val) {
      return (MFTime)super.add(val);
   }
   public MFTime add(long val) {
      return (MFTime)super.add(new SFTime(val));
   }

   public static void main(String[] args) {
      System.out.println("== MFTime ==========");
      MFTime c1 = new MFTime().add(new SFTime(123));
      System.out.println(c1);

      MFTime c2 = new MFTime()
         .add(new SFTime(456))
         .add(new SFTime(789));
      System.out.println(c2);
      
      MFTime c3 = new MFTime().add(new SFTime(123));
      System.out.println("c1c2 " + c1.equals(c2));
      System.out.println("c1c3 " + c1.equals(c3));
   }
}
