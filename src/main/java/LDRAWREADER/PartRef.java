// $Id: PartRef.java 1.4 1999/05/19 20:23:40 parisjp Exp $

//		 This file is part of LDRAWOPT
//		Author: Paris.Jean-Pierre@wanadoo.fr
//
// LDRAWOPT is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2, or (at your option)
// any later version.
//
// LDRAWOPT is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with for example GNU Emacs; see the file COPYING.  If not,
// write to the Free Software Foundation, 675 Mass Ave, Cambridge, MA
// 02139, USA.

package LDRAWREADER;

import TOOLS.Assert;
import TOOLS.T;

public class PartRef extends AbstLine {
   public PartRef() {
   };

   public PartRef(int color,
                  double x, double y, double z,
                  double a, double b, double c,
                  double d, double e, double f,
                  double g, double h, double i,
                  String part) {
      colorValue_ = color;
      x_ = x; y_ = y; z_ = z;
      a_ = a; b_ = b; c_ = c;
      d_ = d; e_ = e; f_ = f;
      g_ = g; h_ = h; i_ = i;
      part_ = part;
   };

   public PartRef(PartRef v) {
      colorValue_ = v.colorValue_;
      x_ = v.x_; y_ = v.y_; z_ = v.z_;
      a_ = v.a_; b_ = v.b_; c_ = v.c_;
      d_ = v.d_; e_ = v.e_; f_ = v.f_;
      g_ = v.g_; h_ = v.h_; i_ = v.i_;
      part_ = v.part_;
   };

   public PartRef parse(LdrawReader r) throws java.io.IOException {
      colorValue_ = r.readInt();
      x_ = r.readDouble(); y_ = r.readDouble(); z_ = r.readDouble();
      a_ = r.readDouble(); b_ = r.readDouble(); c_ = r.readDouble();
      d_ = r.readDouble(); e_ = r.readDouble(); f_ = r.readDouble();
      g_ = r.readDouble(); h_ = r.readDouble(); i_ = r.readDouble();
      part_ = r.readString();
      r.readEol();

      return this;
   };

   public String toString() {
      return "1 " + colorValue_ + " " +
         T.rounds(x_, t_) + " " + T.rounds(y_, t_) + " " + T.rounds(z_, t_)
         + " " +
         T.rounds(a_, t_) + " " + T.rounds(b_, t_) + " " + T.rounds(c_, t_)
         + " " +
         T.rounds(d_, t_) + " " + T.rounds(e_, t_) + " " + T.rounds(f_, t_)
         + " " +
         T.rounds(g_, t_) + " " + T.rounds(h_, t_) + " " + T.rounds(i_, t_)
         + " " + part_;
   };      
   public String toString(String subdir) {
      return "1 " + colorValue_ + " " +
         T.rounds(x_, t_) + " " + T.rounds(y_, t_) + " " + T.rounds(z_, t_)
         + " " +
         T.rounds(a_, t_) + " " + T.rounds(b_, t_) + " " + T.rounds(c_, t_)
         + " " +
         T.rounds(d_, t_) + " " + T.rounds(e_, t_) + " " + T.rounds(f_, t_)
         + " " +
         T.rounds(g_, t_) + " " + T.rounds(h_, t_) + " " + T.rounds(i_, t_)
         + " " + subdir + part_;
   };      

   public final double x() { return x_; };
   public final double y() { return y_; };
   public final double z() { return z_; };
   public final double a() { return a_; };
   public final double b() { return b_; };
   public final double c() { return c_; };
   public final double d() { return d_; };
   public final double e() { return e_; };
   public final double f() { return f_; };
   public final double g() { return g_; };
   public final double h() { return h_; };
   public final double i() { return i_; };

   public final String part() { return part_; };

   public final int getColor() { return colorValue_; };

   protected int colorValue_;

   protected double x_, y_, z_;

   protected double a_, b_, c_;
   protected double d_, e_, f_;
   protected double g_, h_, i_;

   protected String part_;
};
