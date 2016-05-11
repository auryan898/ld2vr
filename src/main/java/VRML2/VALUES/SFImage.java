// $Id: SFImage.java 1.1 1998/11/04 22:51:27 parisjp Exp $

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

public class SFImage extends Single {
   public SFImage(int width, int height, int num_components, int[] pixels) {
      width_         = width;
      height_        = height;
      numComponents_ = num_components;
      pixels_        = pixels;
   }
   public SFImage(int width, int height, int num_components) {
      width_         = width;
      height_        = height;
      numComponents_ = num_components;
      pixels_        = null;
   }
   
   public String codeString(int l) {
      String result = width_ + " " + height_ + " " + numComponents_;
      for (int i = 0; i < width_ * height_; i++) {
         result = result + " 0x" + Integer.toHexString(pixels_[i]);
      }
      return result;
   }
   public String javaNewTypeString() {
      if (null != pixels_) {
         throw new RuntimeException("pixel array not handled");
      }
      return "new SFImage(" +  width_ + ", " + height_ + ", " +
         numComponents_ + ")";
   }
   
   public boolean equals(Value v) {
      try {
         return width_  == ((SFImage)v).width_ 
            && height_ == ((SFImage)v).height_ 
            && numComponents_  == ((SFImage)v).numComponents_;
      } catch (ClassCastException e) {
         return false;
      }
   }
   
   protected int width_;
   protected int height_;
   protected int numComponents_;
   protected int[] pixels_;
   
   public static void main(String[] args) {
      System.out.println("== SFImage ==========");
      int[] pix1 = { 0xFF, 0x00 };
      SFImage c1 = new SFImage(1, 2, 1, pix1);
      System.out.println(c1);
      int[] pix2 = { 0xFF0000, 0xFF00, 0, 0, 0, 0, 0xFFFFFF, 0xFFFF00 };
      SFImage c2 = new SFImage(2, 4, 3, pix2);
      System.out.println(c2);
   }
}
