// $Id: Quadrilateral.java 1.4 1999/05/19 20:23:45 parisjp Exp $
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

import TOOLS.T;

public class Quadrilateral extends AbstLine {

    public Quadrilateral() {
    }

    public Quadrilateral(Quadrilateral v) {
        colorValue_ = v.colorValue_;
        x1_ = v.x1_;
        y1_ = v.y1_;
        z1_ = v.z1_;
        x2_ = v.x2_;
        y2_ = v.y2_;
        z2_ = v.z2_;
        x3_ = v.x3_;
        y3_ = v.y3_;
        z3_ = v.z3_;
        x4_ = v.x4_;
        y4_ = v.y4_;
        z4_ = v.z4_;
    }

    public Quadrilateral parse(LdrawReader r) throws java.io.IOException {
        colorValue_ = r.readInt();
        x1_ = r.readDouble();
        y1_ = r.readDouble();
        z1_ = r.readDouble();
        x2_ = r.readDouble();
        y2_ = r.readDouble();
        z2_ = r.readDouble();
        x3_ = r.readDouble();
        y3_ = r.readDouble();
        z3_ = r.readDouble();
        x4_ = r.readDouble();
        y4_ = r.readDouble();
        z4_ = r.readDouble();
        r.readEol();

        return this;
    }

    public String toString() {
        return "4 " + colorValue_ + " "
                + T.rounds(x1_, t_) + " " + T.rounds(y1_, t_) + " " + T.rounds(z1_, t_)
                + " "
                + T.rounds(x2_, t_) + " " + T.rounds(y2_, t_) + " " + T.rounds(z2_, t_)
                + " "
                + T.rounds(x3_, t_) + " " + T.rounds(y3_, t_) + " " + T.rounds(z3_, t_)
                + " "
                + T.rounds(x4_, t_) + " " + T.rounds(y4_, t_) + " " + T.rounds(z4_, t_);
    }

    public String toStringReverted() {
        return "4 " + colorValue_ + " "
                + T.rounds(x1_, t_) + " " + T.rounds(y1_, t_) + " " + T.rounds(z1_, t_)
                + " "
                + T.rounds(x4_, t_) + " " + T.rounds(y4_, t_) + " " + T.rounds(z4_, t_)
                + " "
                + T.rounds(x3_, t_) + " " + T.rounds(y3_, t_) + " " + T.rounds(z3_, t_)
                + " "
                + T.rounds(x2_, t_) + " " + T.rounds(y2_, t_) + " " + T.rounds(z2_, t_);
    }

    public String toString(String p1, String p2, String p3, String p4) {
        return "4 " + colorValue_ + " " + p1 + " " + p2 + " " + p3 + " " + p4;
    }

    public String toString(String p1, String p2, String p3) {
        return "3 " + colorValue_ + " " + p1 + " " + p2 + " " + p3;
    }

    public void swap23() {
        double tmp = x2_;
        x2_ = x3_;
        x3_ = tmp;
        tmp = y2_;
        y2_ = y3_;
        y3_ = tmp;
        tmp = z2_;
        z2_ = z3_;
        z3_ = tmp;
    }

    ;
   public void swap34() {
        double tmp = x3_;
        x3_ = x4_;
        x4_ = tmp;
        tmp = y3_;
        y3_ = y4_;
        y4_ = tmp;
        tmp = z3_;
        z3_ = z4_;
        z4_ = tmp;
    }

    public final double x1() {
        return x1_;
    }

    ;
   public final double y1() {
        return y1_;
    }

    ;
   public final double z1() {
        return z1_;
    }

    ;
   public final double x2() {
        return x2_;
    }

    public final double y2() {
        return y2_;
    }

    public final double z2() {
        return z2_;
    }

    public final double x3() {
        return x3_;
    }

    public final double y3() {
        return y3_;
    }

    public final double z3() {
        return z3_;
    }

    public final double x4() {
        return x4_;
    }

    public final double y4() {
        return y4_;
    }

    public final double z4() {
        return z4_;
    }

    public final int getColor() {
        return colorValue_;
    }

    protected int colorValue_;

    protected double x1_, y1_, z1_;
    protected double x2_, y2_, z2_;
    protected double x3_, y3_, z3_;
    protected double x4_, y4_, z4_;
}
