// $Id: Ld2vr.java 1.6 1999/10/12 21:16:10 parisjp Exp $

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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.PropertyResourceBundle;

public class Ld2vr {

    static void loadConfig(String fileName) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(fileName);

        PropertyResourceBundle prb = new PropertyResourceBundle(fis);

        TOOLS.T.LdrawDir_ = prb.getString("LDRAW_DIR");
        TOOLS.T.WrlOutputDir_ = prb.getString("WRL_OUTPUT_DIR");
        TOOLS.T.WrlDataDir_ = prb.getString("INSTALL_DIR");

        if (!TOOLS.T.LdrawDir_.endsWith(File.separator)) {
            TOOLS.T.LdrawDir_ += File.separator;
        }
        if (!TOOLS.T.WrlOutputDir_.endsWith(File.separator)) {
            TOOLS.T.WrlOutputDir_ += File.separator;
        }
        if (!TOOLS.T.WrlDataDir_.endsWith(File.separator)) {
            TOOLS.T.WrlDataDir_ += File.separator;
        }
        TOOLS.T.WrlDataDir_ += "WRLData" + File.separator;
    }

    public static void main(String args[]) {
        Options options = new Options();

        switch (args.length) {
            case 0:
                usage();
                break;
            case 1:
                if (args[0].startsWith("-")) {
                    usage();
                }
                break;
        }

        for (int index = 0; index < args.length; index++) {
            if (args[index].startsWith("-")) {
                if (args[index].equals("-extern")) {
                    options.externProto_ = true;
                } else if (args[index].equals("-externTop")) {
                    options.externTop_ = true;
                } else if (args[index].equals("-noOver")) {
                    options.dontOverwrite_ = true;
                } else if (args[index].equals("-config") && index + 1 < args.length) {
                    try {
                        loadConfig(args[index + 1]);
                    } catch (IOException ex) {
                        System.err.printf("Could not load config file %s: %s", args[index + 1], ex.toString());
                        System.exit(1);
                    }
                    ++index;
                } else {
                    usage();
                }
            } else {
                PartRef top = new PartRef(16, 0, 0, 0,
                        1, 0, 0,
                        0, 1, 0,
                        0, 0, 1, args[index]);
                top.parseNprint(options);
            }
        }
    }

    private static void usage() {
        System.err.println("Usage :");
        System.err.println("   java Ld2vr [-extern] [-config config-file] inputfile1 ... inputfilen");
        System.exit(0);
    }

};
