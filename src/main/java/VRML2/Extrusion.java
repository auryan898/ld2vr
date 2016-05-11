package VRML2;

import VRML2.VALUES.*;

public class Extrusion extends NamedNode {
   public Extrusion( ) {
      super();
   }
   public Extrusion(String val) {
      super(val);
   }
   public Extrusion(boolean val) {
      super(val);
   }

   public final Extrusion set_beginCap(SFBool val) {
      beginCap_ = val;
      return this;
   };
   public final Extrusion set_beginCap(boolean val0) {
      beginCap_ = new SFBool(val0);
      return this;
   };
   public final Extrusion set_beginCap(String alias) {
      beginCap_ = new Alias(alias);
      return this;
   };
   public final Extrusion set_ccw(SFBool val) {
      ccw_ = val;
      return this;
   };
   public final Extrusion set_ccw(boolean val0) {
      ccw_ = new SFBool(val0);
      return this;
   };
   public final Extrusion set_ccw(String alias) {
      ccw_ = new Alias(alias);
      return this;
   };
   public final Extrusion set_convex(SFBool val) {
      convex_ = val;
      return this;
   };
   public final Extrusion set_convex(boolean val0) {
      convex_ = new SFBool(val0);
      return this;
   };
   public final Extrusion set_convex(String alias) {
      convex_ = new Alias(alias);
      return this;
   };
   public final Extrusion set_creaseAngle(SFFloat val) {
      creaseAngle_ = val;
      return this;
   };
   public final Extrusion set_creaseAngle(double val0) {
      creaseAngle_ = new SFFloat(val0);
      return this;
   };
   public final Extrusion set_creaseAngle(String alias) {
      creaseAngle_ = new Alias(alias);
      return this;
   };
   public final MFVec2f add_crossSection(SFVec2f val) {
      return ((MFVec2f)crossSection_).add(val);
   };
   public final MFVec2f add_crossSection(double val0,double val1) {
      return ((MFVec2f)crossSection_).add(val0,val1);
   };
   public final Extrusion set_crossSection(MFVec2f val) {
      crossSection_ = val;
      return this;
   };
   public final Extrusion set_crossSection(String alias) {
      crossSection_ = new Alias(alias);
      return this;
   };
   public final Extrusion set_endCap(SFBool val) {
      endCap_ = val;
      return this;
   };
   public final Extrusion set_endCap(boolean val0) {
      endCap_ = new SFBool(val0);
      return this;
   };
   public final Extrusion set_endCap(String alias) {
      endCap_ = new Alias(alias);
      return this;
   };
   public final MFRotation add_orientation(SFRotation val) {
      return ((MFRotation)orientation_).add(val);
   };
   public final MFRotation add_orientation(double val0,double val1,double val2,double val3) {
      return ((MFRotation)orientation_).add(val0,val1,val2,val3);
   };
   public final Extrusion set_orientation(MFRotation val) {
      orientation_ = val;
      return this;
   };
   public final Extrusion set_orientation(String alias) {
      orientation_ = new Alias(alias);
      return this;
   };
   public final MFVec2f add_scale(SFVec2f val) {
      return ((MFVec2f)scale_).add(val);
   };
   public final MFVec2f add_scale(double val0,double val1) {
      return ((MFVec2f)scale_).add(val0,val1);
   };
   public final Extrusion set_scale(MFVec2f val) {
      scale_ = val;
      return this;
   };
   public final Extrusion set_scale(String alias) {
      scale_ = new Alias(alias);
      return this;
   };
   public final Extrusion set_solid(SFBool val) {
      solid_ = val;
      return this;
   };
   public final Extrusion set_solid(boolean val0) {
      solid_ = new SFBool(val0);
      return this;
   };
   public final Extrusion set_solid(String alias) {
      solid_ = new Alias(alias);
      return this;
   };
   public final MFVec3f add_spine(SFVec3f val) {
      return ((MFVec3f)spine_).add(val);
   };
   public final MFVec3f add_spine(double val0,double val1,double val2) {
      return ((MFVec3f)spine_).add(val0,val1,val2);
   };
   public final Extrusion set_spine(MFVec3f val) {
      spine_ = val;
      return this;
   };
   public final Extrusion set_spine(String alias) {
      spine_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Extrusion {\n");

      if (null != beginCap_ &&
          ! beginCap_.equals(beginCapDefault_)) {
         sb.append(i(l + 1) + "beginCap " + beginCap_.codeString(l + 1) + "\n");
      }
      if (null != ccw_ &&
          ! ccw_.equals(ccwDefault_)) {
         sb.append(i(l + 1) + "ccw " + ccw_.codeString(l + 1) + "\n");
      }
      if (null != convex_ &&
          ! convex_.equals(convexDefault_)) {
         sb.append(i(l + 1) + "convex " + convex_.codeString(l + 1) + "\n");
      }
      if (null != creaseAngle_ &&
          ! creaseAngle_.equals(creaseAngleDefault_)) {
         sb.append(i(l + 1) + "creaseAngle " + creaseAngle_.codeString(l + 1) + "\n");
      }
      if (null != crossSection_ &&
          ! crossSection_.equals(crossSectionDefault_)) {
         sb.append(i(l + 1) + "crossSection " + crossSection_.codeString(l + 1) + "\n");
      }
      if (null != endCap_ &&
          ! endCap_.equals(endCapDefault_)) {
         sb.append(i(l + 1) + "endCap " + endCap_.codeString(l + 1) + "\n");
      }
      if (null != orientation_ &&
          ! orientation_.equals(orientationDefault_)) {
         sb.append(i(l + 1) + "orientation " + orientation_.codeString(l + 1) + "\n");
      }
      if (null != scale_ &&
          ! scale_.equals(scaleDefault_)) {
         sb.append(i(l + 1) + "scale " + scale_.codeString(l + 1) + "\n");
      }
      if (null != solid_ &&
          ! solid_.equals(solidDefault_)) {
         sb.append(i(l + 1) + "solid " + solid_.codeString(l + 1) + "\n");
      }
      if (null != spine_ &&
          ! spine_.equals(spineDefault_)) {
         sb.append(i(l + 1) + "spine " + spine_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value beginCap_ = null;
   protected static final SFBool beginCapDefault_ = new SFBool(true);
   protected Value ccw_ = null;
   protected static final SFBool ccwDefault_ = new SFBool(true);
   protected Value convex_ = null;
   protected static final SFBool convexDefault_ = new SFBool(true);
   protected Value creaseAngle_ = null;
   protected static final SFFloat creaseAngleDefault_ = new SFFloat(0.0);
   protected Value crossSection_ = new MFVec2f();
   protected static final MFVec2f crossSectionDefault_ = new VRML2.VALUES.MFVec2f().add(new SFVec2f(1.0, 1.0)).add(new SFVec2f(1.0, -1.0)).add(new SFVec2f(-1.0, -1.0)).add(new SFVec2f(-1.0, 1.0)).add(new SFVec2f(1.0, 1.0));
   protected Value endCap_ = null;
   protected static final SFBool endCapDefault_ = new SFBool(true);
   protected Value orientation_ = new MFRotation();
   protected static final MFRotation orientationDefault_ = new VRML2.VALUES.MFRotation().add(new SFRotation(0.0, 0.0, 1.0, 0.0));
   protected Value scale_ = new MFVec2f();
   protected static final MFVec2f scaleDefault_ = new VRML2.VALUES.MFVec2f().add(new SFVec2f(1.0, 1.0));
   protected Value solid_ = null;
   protected static final SFBool solidDefault_ = new SFBool(true);
   protected Value spine_ = new MFVec3f();
   protected static final MFVec3f spineDefault_ = new VRML2.VALUES.MFVec3f().add(new SFVec3f(0.0, 0.0, 0.0)).add(new SFVec3f(0.0, 1.0, 0.0));
}
