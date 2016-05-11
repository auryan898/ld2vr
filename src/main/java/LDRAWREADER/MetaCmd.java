// $Id: MetaCmd.java 1.2 1998/11/04 22:40:21 parisjp Exp $

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

public class MetaCmd extends AbstLine {
   public MetaCmd() {
   };

   public MetaCmd(MetaCmd v) {
      value_ = v.value_;
   };

   public String toString() {
      return value_;
   };      

   public MetaCmd parse(LdrawReader r) throws java.io.IOException {
      int tok;
      while (LdrawReader.TT_EOF != (tok = r.nextToken())) {
         switch (tok) {
         case LdrawReader.TT_EOL:
            return this;
         case LdrawReader.TT_WORD:
            value_ = value_ + " " + r.sval;
            break;
         case LdrawReader.TT_NUMBER:
         default:
            Assert.t(r + " internal error");
            break;
         }
      }
      return this;
   };

   protected String value_ = "0";
};
