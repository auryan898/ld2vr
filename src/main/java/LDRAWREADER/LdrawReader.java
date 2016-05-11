// $Id: LdrawReader.java 1.3 1999/05/19 20:23:20 parisjp Exp $

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

public class LdrawReader extends java.io.StreamTokenizer {
   public LdrawReader(java.io.Reader r) {
      super(r);
      resetSyntax();
      eolIsSignificant(true);
      wordChars(33, 256);

      whitespaceChars(0, 32);
   };

   //   public int nextToken() throws java.io.IOException {
   //      System.err.println(this);
   //      return super.nextToken();
   //   }

   public java.util.Vector parse() throws java.io.IOException {
      int tok;
      java.util.Vector lines = new java.util.Vector();

      while (TT_EOF != (tok = nextToken())) {
         switch (tok) {
         case TT_EOL:
            lines.addElement(new EmptyLine());
            break;
         case TT_WORD:
            int i = 0;
            try {
               i = Integer.parseInt(sval);
            } catch (NumberFormatException e) {
               Assert.t(this + ": integer number expected");
            }

            switch (i) {
            case 0:
               lines.addElement(new MetaCmd().parse(this));
               break;
            case 1:
               lines.addElement(new PartRef().parse(this));
               break;
            case 2:
               lines.addElement(new Line().parse(this));
               break;
            case 3:
               lines.addElement(new Triangle().parse(this));
               break;
            case 4:
               lines.addElement(new Quadrilateral().parse(this));
               break;
            case 5:
               lines.addElement(new OptLine().parse(this));
               break;
            default:
               Assert.t(this + ": 0-5 expected");
               break;
            }
            break;
         default:
            Assert.t("internal error");
            break;
         }
      }
      lines.trimToSize();
      return lines;
   };

   public int readInt() throws java.io.IOException {
      int tok = nextToken();
      try {
         return Integer.parseInt(sval);
      } catch (NumberFormatException e) {
         Assert.t(this + ": integer number expected");
      }
      return 0;
   };

   public double readDouble() throws java.io.IOException {
      int tok = nextToken();
      try {
         return new Double(sval).doubleValue();
      } catch (NumberFormatException e) {
         Assert.t(this + ": number expected");
      }
      return 0;
   };

   public String readString() throws java.io.IOException {
      int tok = nextToken();
      Assert.t(TT_WORD == tok,
               this + ": string expected");
      return sval;
   };

   public void readEol() throws java.io.IOException {
      int tok = nextToken();
      Assert.t(TT_EOL == tok || TT_EOF == tok,
               this + ": EOL expected");
   };

   public static void main(String[] args) {
      if (args.length == 1) {
         try {
            java.io.Reader r = 
               new java.io.FileReader(T.getLdrawFile(args[0]));
            LdrawReader lr = new LdrawReader(r);
            java.util.Vector lines = lr.parse();
            for (int i = 0; i < lines.size(); i++) {
               System.out.println(i + "	" + lines.elementAt(i));
            }
         } catch (java.io.IOException e) {
            e.printStackTrace();
            System.exit(1);
         }
      } else {
         System.out.println("Usage :");
         System.out.println("   java LdrawReader inputfile");
         return;
      }
   };
};
