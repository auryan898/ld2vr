package VRML2;

import VRML2.VALUES.*;

public class Cylinder extends NamedNode {
   public Cylinder( ) {
      super();
   }
   public Cylinder(String val) {
      super(val);
   }
   public Cylinder(boolean val) {
      super(val);
   }

   public final Cylinder set_bottom(SFBool val) {
      bottom_ = val;
      return this;
   };
   public final Cylinder set_bottom(boolean val0) {
      bottom_ = new SFBool(val0);
      return this;
   };
   public final Cylinder set_bottom(String alias) {
      bottom_ = new Alias(alias);
      return this;
   };
   public final Cylinder set_height(SFFloat val) {
      height_ = val;
      return this;
   };
   public final Cylinder set_height(double val0) {
      height_ = new SFFloat(val0);
      return this;
   };
   public final Cylinder set_height(String alias) {
      height_ = new Alias(alias);
      return this;
   };
   public final Cylinder set_radius(SFFloat val) {
      radius_ = val;
      return this;
   };
   public final Cylinder set_radius(double val0) {
      radius_ = new SFFloat(val0);
      return this;
   };
   public final Cylinder set_radius(String alias) {
      radius_ = new Alias(alias);
      return this;
   };
   public final Cylinder set_side(SFBool val) {
      side_ = val;
      return this;
   };
   public final Cylinder set_side(boolean val0) {
      side_ = new SFBool(val0);
      return this;
   };
   public final Cylinder set_side(String alias) {
      side_ = new Alias(alias);
      return this;
   };
   public final Cylinder set_top(SFBool val) {
      top_ = val;
      return this;
   };
   public final Cylinder set_top(boolean val0) {
      top_ = new SFBool(val0);
      return this;
   };
   public final Cylinder set_top(String alias) {
      top_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Cylinder {\n");

      if (null != bottom_ &&
          ! bottom_.equals(bottomDefault_)) {
         sb.append(i(l + 1) + "bottom " + bottom_.codeString(l + 1) + "\n");
      }
      if (null != height_ &&
          ! height_.equals(heightDefault_)) {
         sb.append(i(l + 1) + "height " + height_.codeString(l + 1) + "\n");
      }
      if (null != radius_ &&
          ! radius_.equals(radiusDefault_)) {
         sb.append(i(l + 1) + "radius " + radius_.codeString(l + 1) + "\n");
      }
      if (null != side_ &&
          ! side_.equals(sideDefault_)) {
         sb.append(i(l + 1) + "side " + side_.codeString(l + 1) + "\n");
      }
      if (null != top_ &&
          ! top_.equals(topDefault_)) {
         sb.append(i(l + 1) + "top " + top_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value bottom_ = null;
   protected static final SFBool bottomDefault_ = new SFBool(true);
   protected Value height_ = null;
   protected static final SFFloat heightDefault_ = new SFFloat(2.0);
   protected Value radius_ = null;
   protected static final SFFloat radiusDefault_ = new SFFloat(1.0);
   protected Value side_ = null;
   protected static final SFBool sideDefault_ = new SFBool(true);
   protected Value top_ = null;
   protected static final SFBool topDefault_ = new SFBool(true);
}
