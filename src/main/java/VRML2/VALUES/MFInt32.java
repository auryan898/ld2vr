// $Id: MFInt32.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class MFInt32 extends Multiple {
   public MFInt32 add(SFInt32 val) {
      return (MFInt32)super.add(val);
   }
   public MFInt32 add(int val) {
      return (MFInt32)super.add(new SFInt32(val));
   }

   public String codeString(int l) {
      SFInt32 eol = new SFInt32(-1);

      int size = vect_.size();
      if (0 == size) {
         return "[]";
      }
      StringBuffer sb = new StringBuffer("[ ");
      int i = 0;
      for (; i < size - 1; i++) {
         sb.append(vect_.elementAt(i) + ",");
         if (eol.equals((Value)vect_.elementAt(i))) {
            sb.append("\n" + i(l + 1));
         } else {
            sb.append(" ");
         }
      }
      return sb.append(vect_.elementAt(i) + " ]").toString();
   }

   public static void main(String[] args) {
      System.out.println("== MFInt32 ==========");
      MFInt32 c1 = new MFInt32().add(new SFInt32(1));
      System.out.println(c1);

      MFInt32 c2 = new MFInt32()
         .add(new SFInt32(3))
         .add(new SFInt32(6));
      System.out.println(c2);
      
      MFInt32 c3 = new MFInt32().add(new SFInt32(1));
      System.out.println("c1c2 " + c1.equals(c2));
      System.out.println("c1c3 " + c1.equals(c3));
   }
}
