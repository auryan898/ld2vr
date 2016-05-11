// $Id: PartRef.java 1.10 1999/10/12 21:15:57 parisjp Exp $

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

import java.util.Vector;

import TOOLS.T;
import TOOLS.Assert;
import TOOLS.Point3;
import TOOLS.Vector3;
import TOOLS.Matrix3;

import VRML2.VRML2Node;
import VRML2.File;
import VRML2.Group;
import VRML2.Transform;
import VRML2.IndexedFaceSet;
import VRML2.Shape;
import VRML2.NavigationInfo;
import VRML2.Viewpoint;
import VRML2.DirectionalLight;
import VRML2.Background;
import VRML2.PROTO;
import VRML2.PROTO_USE;
import VRML2.EXT_PROTO;

import VRML2.VALUES.Value;
import VRML2.VALUES.SFString;
import VRML2.VALUES.SFNode;
import VRML2.VALUES.MFFloat;
import VRML2.VALUES.MFString;
import VRML2.VALUES.Alias;
import VRML2.FIELDS.ExposedField;

import LDRAWREADER.AbstLine;

public class PartRef extends LDRAWREADER.PartRef implements ToVrml {
   public PartRef(int color,
                  double x, double y, double z,
                  double a, double b, double c,
                  double d, double e, double f,
                  double g, double h, double i,
                  String part) {
      super(color, x, y, z, a, b, c, d, e, f, g, h, i, part);
      init();
   };

   public PartRef(LDRAWREADER.PartRef v) {
      super(v);
      init();
   };

   private void init() {
      int index = part_.lastIndexOf('.');
      Assert.t(index != -1, "Bad part file name: " + part_);
      partName_ = "p_" + part_.substring(0, index);
      if (-1 != (index = partName_.indexOf('\\'))) {
         partName_ = partName_.substring(0, index) + "_" +
            partName_.substring(index + 1);
      }
      if (-1 != (index = partName_.indexOf('#'))) {
         partName_ = partName_.substring(0, index) + "_" +
            partName_.substring(index + 1);
      }

      color_ = new LdrawColor(colorValue_);
      p_ = new Point3(x_, y_, z_);

      m_ = new Matrix3(a_, b_, c_, d_, e_, f_, g_, h_, i_);
      localParts_ = new OrderedHashtable(); 
      localProtoUse_ = new OrderedHashtable(); 
      ifsArray_ = new java.util.Vector(16);
      group_ = new Group();
   };

   public void parseNprint(Options options) {
      PROTO p = getPartProto(partName_ + Matrix3.id().concat(),
                             new Alias("app"), Matrix3.id(), options);

      if (options.externProto_) {
         printSubFileProto(p, options);
      }

      if (ifsArray_.size() >= 16) {
         IndexedSet ifs = (IndexedSet)ifsArray_.elementAt(16);
         if (null != ifs) {
            System.out.println("Points: " + ifs.pointCount() + ", Faces: " +
                               ifs.faceCount());
         } else {
            System.out.println("Points: 0, Faces: 0.");
         }
      } else {
         System.out.println("Points: 0, Faces: 0, no color.");
      }

      VRML2.File f = new VRML2.File(T.getWRLFile(T.getLdrawFile(part_)));

      fileDecoration(f);

      if (options.externProto_ || options.externTop_) {
         String ldrawDir = T.getLdrawDir(part_);
         String filename = T.getWRLRelativeExternalFile(p.getName(),
                                                        ldrawDir);
         f.add(new EXT_PROTO(p).setFilename(filename + "#" + p.getName()));
      } else {
         OrderedHashtable protos = getPROTOS();
         if (null != protos) {
            for (int i = 0; i < protos.size(); i++) {
               f.add((PROTO)protos.elementAt(i));
            }
         }
         f.add(p);
      }

      PROTO_USE pUse = new PROTO_USE(p);
      pUse.setField("app", color_.toVRML(null));
      Transform t = new Transform();
      transformDecoration(t);

      t.add_children(pUse);
      t.set_rotation(1, 0, 0, Math.PI);
      t.set_scale(1.0/2500, 1.0/2500, 1.0/2500);
      f.add(t);
      
      f.print();

      if (options.externTop_) {
         String ldrawDir = T.getLdrawDir(part_);
         String filename = T.getWRLExternalFile(p.getName(), ldrawDir);

         f = new VRML2.File(filename);

         OrderedHashtable protos = getPROTOS();
         if (null != protos) {
            for (int i = 0; i < protos.size(); i++) {
               f.add((PROTO)protos.elementAt(i));
            }
         }
         f.add(p);
         f.print();
      }
   };

   private PROTO getPartProto(String protoname, 
                              Value color, Matrix3 remaining, 
                              Options options) {
      java.util.Vector lines = parseFile();
      boolean somethingDone = false;
      for (int i = 0; i < lines.size(); i++) {
         VRML2Node v = ((ToVrml)lines.elementAt(i)).toVRML(this, color,
                                                           remaining,
                                                           options);
         if (null != v) {
            somethingDone = true;
            group_.add_children(v);
         }
      }
      if (!somethingDone) {
         group_ = null;
      }

      PROTO result = T.getPROTO(protoname);

      somethingDone = false;
      if (ifsArray_.size() != 0) {
         for (int i = 0; i < ifsArray_.size(); i++) {
            IndexedSet ifs = (IndexedSet)ifsArray_.elementAt(i);
            if (null != ifs && ifs.size() != 0) {
               IndexedFaceSet vrml2Ifs = ifs.toVRML();
               vrml2Ifs.set_solid(false);
               vrml2Ifs.set_creaseAngle(0.4);
               Shape s = new Shape();
               s.set_geometry(vrml2Ifs);

               if (16 == i) {
                  s.set_appearance("app");
               } else {
                  s.set_appearance((SFNode)new LdrawColor(i).toVRML(null));
               }

               if (group_ == null) {
                  if (1 == ifsArray_.size()) {
                     result.setNode(s);
                     somethingDone = true;
                  } else {
                     group_ = new Group();
                     group_.add_children(s);
                  }
               } else {
                  group_.add_children(s);
               }
            }
         }
      }
      if (group_ != null) {
         result.setNode(group_);
      } else if (! somethingDone) {
         // Avoid empty PROTO
         result.setNode(new Group());
      }

      return result;
   };

   private void printSubFileProto(PROTO p, Options options) {
      String ldrawDir = T.getLdrawDir(part_);
      String filename = T.getWRLExternalFile(p.getName(), ldrawDir);

      java.io.File file = new java.io.File(filename);
      if (options.dontOverwrite_ && file.isFile() && file.canRead()) {
         return;
      } else {
         VRML2.File f = new VRML2.File(filename);

         if (null != localParts_) {
            for (int i = 0; i < localParts_.size(); i++) {
               PROTO pp = (PROTO)localParts_.elementAt(i);
               f.add(new EXT_PROTO(pp)
                     .setFilename((String)fileNames_.get(pp.getName()) +
                                  "#" + pp.getName()));
            }
         }
         f.add(p);
         f.print();
      }
   };

   private java.util.Vector parseFile() {
      try {
         String filename = T.getLdrawFile(part_);
         if (null == filename) {
            System.out.println("No " + part_ + " Ldraw file found.");
            System.exit(1);
         }
         java.io.FileReader fr     = new java.io.FileReader(filename);
         LDRAWREADER.LdrawReader r = new LDRAWREADER.LdrawReader(fr);
         java.util.Vector lines = r.parse();
         fr.close();
         return convertLines(lines);
      } catch (java.io.IOException e) {
         System.out.println("File " + part_ + " not found.");
         System.exit(1);
      }
      // not reached, but needed because
      // javac does not stop control on System.exit
      return null;
   };

   private java.util.Vector convertLines(java.util.Vector lines) {
      java.util.Vector newLines = new java.util.Vector();

      for (java.util.Enumeration e = lines.elements(); e.hasMoreElements();) {
         AbstLine oldL = (AbstLine)e.nextElement();
         AbstLine newL = null;
         if (oldL instanceof LDRAWREADER.MetaCmd) {
            newL = new MetaCmd((LDRAWREADER.MetaCmd)oldL);
         } else if (oldL instanceof LDRAWREADER.PartRef) {
            newL = new PartRef((LDRAWREADER.PartRef)oldL);
         } else if (oldL instanceof LDRAWREADER.Triangle) {
            newL = new Triangle((LDRAWREADER.Triangle)oldL);
         } else if (oldL instanceof LDRAWREADER.Quadrilateral) {
            newL = new Quadrilateral((LDRAWREADER.Quadrilateral)oldL);
         }
         if (null != newL) {
            newLines.addElement(newL);
         }
      }
      return newLines;
   };

   public VRML2Node toVRML(PartRef parent, Value color, Matrix3 remaining,
                           Options options) {
      if (part_.toLowerCase().endsWith("edge.dat")) {
         return null;
      }

      Transform t = new Transform();
      Matrix3 newRemaining = computeTransform(new Matrix3(remaining), t);
      String name = partName_ + newRemaining.concat();

      // Search part
      PROTO proto = (PROTO)buildParts_.get(name);
      if (null == proto) {
         // Try associated JavaVRML data (give symetry info)
         proto = (PROTO)T.getJavaWRLProto(name, partName_, newRemaining);
         if (null == proto) {
            // Try associated VRML data with symetry already applied
            proto = (PROTO)T.getWRLProto(name, name + ".dat");
            if (null == proto) {
               // Try associated VRML data without symetry
               proto = (PROTO)T.getWRLProto(partName_, part_);
               if (null == proto) {
                  // Then defaults to Ldraw data
                  System.out.println("Expanding " + partName_ + 
                                     newRemaining.concat());

                  proto = getPartProto(name, 
                                       color_.toVRML(color), newRemaining, 
                                       options);
               } else {
                  //System.err.println("Symetry not applied on WRL proto: " + name);
                  //System.out.println("Got WRL " + partName_);
                  name = partName_;
               }
            } else {
               //System.out.println("Got WRL " + partName_ + 
               //                   newRemaining.concat());
            }
         } else {
            //System.out.println("Got JavaWRL " + partName_ + 
            //                   newRemaining.concat());
         }

         if (options.externProto_) {
            printSubFileProto(proto, options);
         }

         putInHashtable(buildParts_, name, proto);
      }

      putInHashtable(parent.localParts_, name, proto);
      putInHashtable(fileNames_, name,
                     T.getWRLRelativeExternalFile(name,
                                                  T.getLdrawDir(part_)));

      // Use PROTO
      String instanceName = name + color_.toName();
      PROTO_USE pUse = (PROTO_USE)parent.localProtoUse_.get(instanceName);
      if (null == pUse) {
         pUse = new PROTO_USE(instanceName, proto);
         pUse.setField("app", color_.toVRML(color));
         pUse.setField("sTop", new Alias("sTop"));
         pUse.setField("sBot", new Alias("sBot"));
         putInHashtable(parent.localProtoUse_, instanceName, pUse);
      }
      t.add_children(pUse);
      return t;
   };

   private void transformDecoration(Transform t) {
      t.add_children(new DirectionalLight()
                     .set_color(1, 1, 1)
                     .set_intensity(.4)
                     .set_ambientIntensity(1)
                     .set_direction(0, 1, 0));
      t.add_children(new DirectionalLight()
                     .set_color(0, 1, 0)
                     .set_intensity(.5)
                     .set_direction(-1, -1, -1));
      t.add_children(new DirectionalLight()
                     .set_color(0, 1, 0)
                     .set_intensity(.5)
                     .set_direction(-1, 1, 1));
      t.add_children(new DirectionalLight()
                     .set_color(.7, 0, 0)
                     .set_intensity(.6)
                     .set_direction(-.7, 1, 0));
      t.add_children(new DirectionalLight()
                     .set_color(.7, 0, 0)
                     .set_intensity(.6)
                     .set_direction(.7, 1, 0));
   };
   private void fileDecoration(File f) {
      f.add(new NavigationInfo()
            .set_avatarSize(new MFFloat().add(.0001).add(.00064).add(.0003))
            .set_type(new MFString().add("WALK"))
            .set_speed(.01));

      f.add(new Viewpoint()
            .set_description(new SFString("Front"))
            .set_position(0, 0, .1))
         .add(new Viewpoint()
              .set_description(new SFString("Top"))
              .set_orientation(1, 0, 0, - Math.PI / 2)
              .set_position(0, .1, 0))
         .add(new Viewpoint()
              .set_description(new SFString("Bottom"))
              .set_orientation(1, 0, 0, Math.PI / 2)
              .set_position(0, -.1, 0))
         .add(new Viewpoint()
              .set_description(new SFString("Back"))
              .set_orientation(0, 1, 0, Math.PI)
              .set_position(0, 0, -.1))
         .add(new Viewpoint()
              .set_description(new SFString("Left"))
              .set_orientation(0, 1, 0, - Math.PI / 2)
              .set_position(-.1, 0, 0))
         .add(new Viewpoint()
              .set_description(new SFString("Right"))
              .set_orientation(0, 1, 0, Math.PI / 2)
              .set_position(.1, 0, 0));
      
      Background b = new Background();
      b.add_skyColor(.3, .5, 1.);
      b.add_skyColor(0, .2, 1.);
      b.add_skyColor(0, 0., 1.);
      b.add_skyAngle(1.3);
      b.add_skyAngle(1.6);
      b.add_groundColor(.1, .1, 0);
      b.add_groundColor(.4, .2, .2);
      b.add_groundColor(.6, .6, .6);
      b.add_groundAngle(1.3);
      b.add_groundAngle(1.6);
      f.add(b);      
   };

   private static void putInHashtable(OrderedHashtable h,
                                      Object key, Object val) {
      // There is a bug in Hashtable!
      h.put(key, val);
      while(null == h.get(key)) {
         System.err.print("#");
         h.put(key, val);
      }
   };
         

   private Matrix3 computeTransform(Matrix3 remaining, Transform t) {
      //ZZZ
      Point3 p = remaining.mult(p_);
      t.set_translation(p.x, p.y, p.z);

      Matrix3 m = remaining.mult(m_);
      //zzz System.out.println(m + "\n--");
      return m.toVRML2(t);
   };

   static public OrderedHashtable getPROTOS() {
     return buildParts_;
   };

   public OrderedHashtable getLocalPROTOS() {
     return localParts_;
   };

   java.util.Vector ifsArray_;
   //PROTO[String]
   static private OrderedHashtable buildParts_ = new OrderedHashtable();
   static private OrderedHashtable fileNames_ = new OrderedHashtable(); 
   private OrderedHashtable localParts_;
   private OrderedHashtable localProtoUse_;

   private String partName_;
   private LdrawColor color_;
   private Point3 p_;

   private Matrix3 m_;
   private Group group_;
}
