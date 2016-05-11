package VRML2;

import VRML2.VALUES.*;

public class Viewpoint extends NamedNode {
   public Viewpoint( ) {
      super();
   }
   public Viewpoint(String val) {
      super(val);
   }
   public Viewpoint(boolean val) {
      super(val);
   }

   public final Viewpoint set_fieldOfView(SFFloat val) {
      fieldOfView_ = val;
      return this;
   };
   public final Viewpoint set_fieldOfView(double val0) {
      fieldOfView_ = new SFFloat(val0);
      return this;
   };
   public final Viewpoint set_fieldOfView(String alias) {
      fieldOfView_ = new Alias(alias);
      return this;
   };
   public final Viewpoint set_jump(SFBool val) {
      jump_ = val;
      return this;
   };
   public final Viewpoint set_jump(boolean val0) {
      jump_ = new SFBool(val0);
      return this;
   };
   public final Viewpoint set_jump(String alias) {
      jump_ = new Alias(alias);
      return this;
   };
   public final Viewpoint set_orientation(SFRotation val) {
      orientation_ = val;
      return this;
   };
   public final Viewpoint set_orientation(double val0,double val1,double val2,double val3) {
      orientation_ = new SFRotation(val0,val1,val2,val3);
      return this;
   };
   public final Viewpoint set_orientation(String alias) {
      orientation_ = new Alias(alias);
      return this;
   };
   public final Viewpoint set_position(SFVec3f val) {
      position_ = val;
      return this;
   };
   public final Viewpoint set_position(double val0,double val1,double val2) {
      position_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Viewpoint set_position(String alias) {
      position_ = new Alias(alias);
      return this;
   };
   public final Viewpoint set_description(SFString val) {
      description_ = val;
      return this;
   };
   public final Viewpoint set_description(String alias) {
      description_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Viewpoint {\n");

      if (null != fieldOfView_ &&
          ! fieldOfView_.equals(fieldOfViewDefault_)) {
         sb.append(i(l + 1) + "fieldOfView " + fieldOfView_.codeString(l + 1) + "\n");
      }
      if (null != jump_ &&
          ! jump_.equals(jumpDefault_)) {
         sb.append(i(l + 1) + "jump " + jump_.codeString(l + 1) + "\n");
      }
      if (null != orientation_ &&
          ! orientation_.equals(orientationDefault_)) {
         sb.append(i(l + 1) + "orientation " + orientation_.codeString(l + 1) + "\n");
      }
      if (null != position_ &&
          ! position_.equals(positionDefault_)) {
         sb.append(i(l + 1) + "position " + position_.codeString(l + 1) + "\n");
      }
      if (null != description_ &&
          ! description_.equals(descriptionDefault_)) {
         sb.append(i(l + 1) + "description " + description_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value fieldOfView_ = null;
   protected static final SFFloat fieldOfViewDefault_ = new SFFloat(0.785398);
   protected Value jump_ = null;
   protected static final SFBool jumpDefault_ = new SFBool(true);
   protected Value orientation_ = null;
   protected static final SFRotation orientationDefault_ = new SFRotation(0.0, 0.0, 1.0, 0.0);
   protected Value position_ = null;
   protected static final SFVec3f positionDefault_ = new SFVec3f(0.0, 0.0, 10.0);
   protected Value description_ = null;
   protected static final SFString descriptionDefault_ = new SFString("");
}
