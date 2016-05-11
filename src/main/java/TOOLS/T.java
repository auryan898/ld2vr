// $Id: T.java 1.11 1999/10/23 20:02:01 parisjp Exp $

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

package TOOLS;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.StringTokenizer;
import java.util.PropertyResourceBundle;
import java.util.Locale;

import VRML2.VRML2Node;
import VRML2.VRML2String;
import VRML2.PROTO;
import VRML2.FIELDS.ExposedField;
import VRML2.VALUES.SFNode;
import VRML2.VALUES.SFInt32;

import PARTS.*;

/** An abstract class to gather tools flying around:
 *  - rounding double
 *  - file naming
 *  - ...
 *
 * @author <a href="mailto:paris.Jean-Pierre@wanadoo.fr">Jean-Pierre Paris</a>
 */
public abstract class T {
   /** Returns a String representation of double keeping only some
    * digits after the dot.
    * 
    * @param  d   double value to be conveter
    * @return     a String
    */
   public static String rounds(double d) {
      String sign = "";
      if (d < 0) { 
         sign = "-";
      }
      double dR = (int)(Math.abs(d) * round_ + 0.5) / round_;
      if (dR == 0) {
         return "0";
      }
      String s = sign + dR;
      if (-1 != s.indexOf(".")) {
         while (s.endsWith("0")) {
            s = s.substring(0, s.length() - 1);
         }
         if (s.endsWith(".")) {
            return s.substring(0, s.length() - 1);
         } else {
            return s;
         }
      } else {
         return s;
      }
   };

   public static String rounds(double d, double prec) {
      String sign = "";
      if (d < 0) { 
         sign = "-";
      }
      double dR = (int)(Math.abs(d) * prec + 0.5) / prec;
      if (dR == 0) {
         return "0";
      }
      String s = sign + dR;
      if (s.endsWith(".0")) {
         return s.substring(0, s.length() - 2);
      } else if (s.startsWith("0.")) {
         return s.substring(1);
      } else if (s.startsWith("-0.")) {
         return "-" + s.substring(2);
      } else {
         return s;
      }
   };

   /** Indicates the number of digits to keep after dot.
    * @see   #rounds(double)
    */
   private static final double round_ = 10e4;

   /** Tests equality with tolerance.
    *
    * @param  v1   one of the value to be comapred to
    * @param  v2   one of the value to be comapred to
    * @param  eps  the tolerance value
    * @return      a boolean indicating if arguments are equal
    * @see #eps_equals(double, double)
    * @see #eps_equals(double, double)
    * @see #eps_zero(double)
    */
   public static boolean eps_equals(double v1, double v2, double eps) {
      return Math.abs(v1 - v2) < eps;
   };
   /** Tests equality with tolerance.
    *
    * @param  v1   one of the value to be comapred to
    * @param  v2   one of the value to be comapred to
    * @param  eps  the tolerance value
    * @return      a boolean indicating if arguments are equal
    * @see #eps_equals(double, double, double)
    * @see #eps_equals(double, double)
    * @see #eps_zero(double)
    */
   public static boolean eps_equals(double v1, double v2) {
      return Math.abs(v1 - v2) < Eps_;
   };
   /** Tests zero equality with tolerance. Shortcut for
    * <code>T.eps_equals(v, 0.0);</code>.
    *
    * @param  v1   one of the value to be comapred to zero
    * @return      a boolean indicating if arguments are equal
    * @see #eps_equals(double, double, double)
    * @see #eps_equals(double, double)
    */
   public static boolean eps_zero(double v1) {
      return Math.abs(v1) < Eps_;
   };
   /** The tolerance value for equlity tests.
    * @see #eps_equals(double, double, double)
    * @see #eps_equals(double, double)
    * @see #eps_zero(double)
    */
   private static final double Eps_ = 10e-10;
   
   /** String value for LDraw application directory.
    * Read from the Config.properties ressource bundle.
    */
   public static String LdrawDir_;
   /** String value for the directory where VRML files are produced.
    * Read from the Config.properties ressource bundle.
    */
   public static String WrlOutputDir_;
   /** String value for the directory where VRML data files are stored.
    * This includes color specs, native VRML code replacing common
    * parts (i.e. studs...)
    * Read from the Config.properties ressource bundle.
    */
   public static String WrlDataDir_;
   /** String value for the directory where Ldraw files are produced.
    * Read from the Config.properties ressource bundle.
    */
   public static String LdrawOutputDir_;

   /** Returns the VRML file name corresponding to a .dat LDraw file.
    * In the VRML file name, one keeps the parent directory (either 'p',
    * 'parts' or 'models'. This way, VRML files are stored the same manner
    * as LDraw files.
    * @param   filename   the LDraw file name
    * @return             the corresponding VRML file name
    */
   public static String getWRLFile(String filename) {
      int index = filename.lastIndexOf('.');
      File f = new File(filename.substring(0, index) + ".wrl");
      String parent = f.getParent();
      return WrlOutputDir_ + new File(parent).getName() +
         f.separator + f.getName();
   };

   /** Returns the Ldraw output file name corresponding to a .dat LDraw file.
    * In the Ldraw file name, one keeps the parent directory (either 'p',
    * 'parts' or 'models'. This way, new Ldraw files are stored the same manner
    * as original ones.
    * @param   filename   the LDraw file name
    * @return             the corresponding Ldraw output file name
    */
   public static String getLdrawOutFile(String filename) {
      int index = filename.lastIndexOf('.');
      File f = new File(filename.substring(0, index) + ".dat");
      String parent = f.getParent();
      return LdrawOutputDir_ + new File(parent).getName() +
         f.separator + f.getName();
   };
   public static String getLdrawOutFile(String filename, String subdir) {
      int index = filename.lastIndexOf('.');
      File f = new File(filename.substring(0, index) + ".dat");
      String parent = f.getParent();
      String dir = "";
      if (null != subdir) {
         dir = subdir + f.separator;
      }
      return LdrawOutputDir_ + new File(parent).getName() +
         f.separator + dir + f.getName();
   };

   /** Returns a new String where 'from' char is replaced
    * by 'to' char.
    * @param String       the string in which replacements are done
    * @param char         the replaced char
    * @param char         the replacement char
    * @return             a new String
    */
   static String replace(String s, char from, char to) {
      StringBuffer sb = new StringBuffer(s);
      int index = 0;
      while (-1 != (index = s.indexOf(from, index))) {
         sb.setCharAt(index, to);
         index++;
      }
      return sb.toString();
   }

   /** Returns the VRML file name for an external PROTO.
    * @param String       the name of the EXTERN_PROTO
    * @param String       the Ldraw dir (p, parts, models)
    * @return             the corresponding VRML file name
    */
   public static String getWRLExternalFile(String protoname, 
                                           String ldraw_dir) {
      return replace(WrlOutputDir_ + ldraw_dir + "_proto" +
                     File.separator + protoname + ".wrl",
                     '\\', '/');
   };

   /** Returns the VRML file name for an Inline PROTO.
    * @param String       the name of the EXTERN_PROTO
    * @param String       the Ldraw dir (p, parts, models)
    * @return             the corresponding VRML file name
    */
   public static String getWRLInlineFile(String protoname, 
                                         String ldraw_dir) {
      return WrlOutputDir_ + ldraw_dir + "_inline" + File.separator +
         protoname + ".wrl";
   };

   /** Returns the relative VRML file name for an external PROTO.
    * @param              the name of the EXTERN_PROTO
    * @param String       the Ldraw dir (p, parts, models)
    * @return             the corresponding VRML file name
    */
   public static String getWRLRelativeExternalFile(String protoname,
                                                   String ldraw_dir) {
      return replace(".." + File.separator + ldraw_dir +
                     "_proto" + File.separator + protoname + ".wrl",
                     '\\', '/');
   };

   /** Returns the relative VRML file name for an Inline PROTO.
    * @param              the name of the EXTERN_PROTO
    * @param String       the Ldraw dir (p, parts, models)
    * @return             the corresponding VRML file name
    */
   public static String getWRLRelativeInlineFile(String protoname,
                                                 String ldraw_dir) {
      return ".." + File.separator +
         ldraw_dir + "_inline" + File.separator +
         protoname + ".wrl";
   };

   /** Returns a PROTO node used for LDraw sub-parts.
    * This PROTO is used for .dat files that appear in a '1' line.
    * @param   name   the sub-part name (i.e. the .dat file basename)
    * @return         a PROTO node
    * @see    VRML2.PROTO
    */
   public static PROTO getPROTO(String name) {
      return new PROTO(name)
	.add(new ExposedField("SFNode", "app", new SFNode()))
	.add(new ExposedField("SFInt32", "sTop", new SFInt32(0)))
	.add(new ExposedField("SFInt32", "sBot", new SFInt32(0)));
   };

   /** Makes a VRML2String from the VRML97 code found in a file.
    * @param   name     a label String to name the returned VRML2String
    * @param   filename the file name where the code should be found
    * @return           a VRML2String
    */
   public static VRML2Node getWRLCode(String name, String filename) {
      VRML2String vs = new VRML2String();
      return getWRLData(vs, name, filename);
   };
   /** Returns a PROTO whose nodes are found in a file.
    * @param   name     a label String to name the returned PROTO
    * @param   filename the file name where the nodes' code should be
    *                   found
    * @return           a VRML2String
    */
   public static PROTO getWRLProto(String name, String filename) {
     VRML2String vs = new VRML2String();
     vs = (VRML2String)getWRLData(vs, name, filename);
     if (null == vs) {
       return null;
     } else {
       PROTO p = getPROTO(name);
       p.setText(vs);
       return p;
     }
   };
   /** Returns a VRML2String code from the VRML97 code found in a file.
    * WARNING: side-effect on the VRML2String argument.
    * @param   vs       the returned VRML2String
    * @param   name     a label String used for trace message
    * @param   filename the file name where the code should be found
    * @return           a VRML2String
    */
   private static VRML2Node getWRLData(VRML2String vs, String name,
				       String filename) {
      String fileName = getWRLDataFile(filename);
      if (null == fileName) {
         return null;
      } else {
         String s;
         try {
            LineNumberReader lnr 
               = new LineNumberReader(new FileReader(fileName));
            while (null != (s = lnr.readLine())) {
               vs.add_string(s);
            }
         } catch (java.io.FileNotFoundException e) {
            System.out.println("File " + fileName + " not found.");
            return null;
         } catch (java.io.IOException e) {
            System.out.println("File " + fileName + " error.");
            return null;
         }
         return vs;
      }
   };

   private static String[] getDatFilenames(String filename) {
      String[] result = new String[2];
      String base = filename.substring(0, filename.lastIndexOf('.'));
      result[0] = base + ".dat";
      result[1] = base + ".DAT";
      return result;
   };

   /** Return an absolute LDraw file name including 'p', 'parts', or
    * 'models' directory. If this file does not exists, returns its 
    * argument. File extension must be correct (i.e. .dat).
    * @param  filename  the name of the LDraw file
    * @return           the full LDraw file name, or the argument itself
    * if the full name has not been found.
    */
   public static String getLdrawFile(String filename) {
      String[] fns = getDatFilenames(filename);
      for (int i = 0; i < fns.length; i++) {
         String fn = getFile(fns[i], LdrawDir_);
         if (null != fn) {
            return fn;
         }
      }
      return filename;
   };

   /** Return an directory name (p, parts, model) where the LDraw file
    * is. If this file does not exists, returns 'null'
    * @param  filename  the name of the LDraw file
    * @return           the full LDraw file name, or the argument itself
    * if the full name has not been found.
    */
   public static String getLdrawDir(String filename) {
      String fn = getParentDir(filename, LdrawDir_);
      if (null == fn) {
         return null;
      } else {
         return new File(fn).getName();
      }
   };

   /** Return a complete VRML data file name including the correct path
    * prefix and 'p', 'parts', or 'models' directory. File extension is
    * ignored and replaced by '.wrl'.
    * 
    * @param  filename  the name of the VRML data file
    * @return           the full LDraw file name, or the <code>null</code>
    * if the file name has not been found.
    */
   public static String getWRLDataFile(String filename) {
      int index = filename.lastIndexOf('.');
      return getFile(filename.substring(0, index) + ".wrl", WrlDataDir_);
   };
   /** Builds and returns a PROTO from a Java class. The Java class
    * is dynamiclly loaded and it replaces the LDraw sub-part of the same
    * name.
    * @param  name      the name of the returned PROTO
    * @param  partName  the name of the LDraw sub-part
    * @param  remaining the transformation matrix to be applied to 
    * the sub-part
    * @return a PROTO node
    */
   public static VRML2Node getJavaWRLProto(String name, String partName,
                                           Matrix3 remaining) {
      Class partClass;
      try {
         partClass = Class.forName(makeClassName(partName));
      } catch (ClassNotFoundException e) {
         return null;
      }
      Object part;
      try {
         part = partClass.newInstance();
      } catch (InstantiationException e) {
         throw new RuntimeException(e.toString());
      } catch (IllegalAccessException e) {
         throw new RuntimeException(e.toString());
      }
      System.out.println("Expanding class " + partName);

      PROTO p = getPROTO(name);
      p.setNode(((Part)part).toVRML(remaining));
      return p;
   };

   /** An array with all the standard LDraw directories
    * @see #getFile(String, String)
    * @see #getParentDir(String, String)
    */
   private static String[] dirs = {"p" + File.separator, 
                                   "parts" + File.separator,
                                   "models" + File.separator};
   /** Finds and returns a file name searched in the 'dirs' array. If 
    * the can not be found returns 'null'.
    * @param filename  the file base name
    * @param dir       the base directory
    * @return          the String: dir/("p", "parts", "models")/filename
    * @see #getParentDir(String, String)
    * @see #dirs
    */
   private static String getFile(String filename, String dir) {
      File file = (File)PartToFile_.get(filename);
      if (null != file) {
         return file.toString();
      } else {
         for (int i = 0; i < 3; i++) {
            file = new File(dir, dirs[i] + filename);
            if (file.isFile() && file.canRead()) {
               PartToFile_.put(filename, file);
               return file.toString();
            } 
         }
         return null;
      }
   };
   private static java.util.Hashtable PartToFile_ = new java.util.Hashtable();

   /** Finds a file name searched in the 'dirs' array. If it
    * can not be found returns 'null', otherwise retruns the
    * directory name
    * @param filename  the file base name
    * @param dir       the base directory
    * @return          the String: "p"|"parts"|"models"
    * @see #getFile(String, String)
    * @see #dirs
    */
   private static String getParentDir(String filename, String dir) {
      File file = (File)PartToFile_.get(filename);
      if (null != file) {
         return file.getParent();
      } else {
         for (int i = 0; i < 3; i++) {
            file = new File(dir, dirs[i] + filename);
            if (file.isFile() && file.canRead()) {
               PartToFile_.put(filename, file);
               return file.getParent();
            } 
         }
         return null;
      }
   };

   /** Makes and returns a class name from a part name. It replaces all
    * '-' chars by '_'.
    * @param  name  LDraw part name
    * @return   a String with '-' replaced by '_'
    */
   private static String makeClassName(String name) {
      StringBuffer newName = new StringBuffer(name);
      int index = 0;
      while (-1 != (index = name.indexOf('-', index))) {
         newName.setCharAt(index, '_');
         index++;
      }
      return "PARTS." + newName.toString();
   };

   /** No instanciation, please!
    */
   private T() {
   };
   
   /** For testing purpose only.
    * @param  args  the arguments array
    */
   public static void main(String[] args) {
      System.err.println(rounds(1));
      System.err.println(rounds(21.1));
      System.err.println(rounds(321.123456789));
      System.err.println(rounds(321.000000089));
   };
};
