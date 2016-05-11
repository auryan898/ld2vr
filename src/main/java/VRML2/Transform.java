package VRML2;

import VRML2.VALUES.*;

public class Transform extends NamedNode {
   public Transform( ) {
      super();
   }
   public Transform(String val) {
      super(val);
   }
   public Transform(boolean val) {
      super(val);
   }

   public final Transform set_center(SFVec3f val) {
      center_ = val;
      return this;
   };
   public final Transform set_center(double val0,double val1,double val2) {
      center_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Transform set_center(String alias) {
      center_ = new Alias(alias);
      return this;
   };
   public final MFNode add_children(SFNode val) {
      return ((MFNode)children_).add(val);
   };
   public final MFNode add_children(VRML2.VRML2Node val0) {
      return ((MFNode)children_).add(val0);
   };
   public final Transform set_children(MFNode val) {
      children_ = val;
      return this;
   };
   public final Transform set_children(String alias) {
      children_ = new Alias(alias);
      return this;
   };
   public final Transform set_rotation(SFRotation val) {
      rotation_ = val;
      return this;
   };
   public final Transform set_rotation(double val0,double val1,double val2,double val3) {
      rotation_ = new SFRotation(val0,val1,val2,val3);
      return this;
   };
   public final Transform set_rotation(String alias) {
      rotation_ = new Alias(alias);
      return this;
   };
   public final Transform set_scale(SFVec3f val) {
      scale_ = val;
      return this;
   };
   public final Transform set_scale(double val0,double val1,double val2) {
      scale_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Transform set_scale(String alias) {
      scale_ = new Alias(alias);
      return this;
   };
   public final Transform set_scaleOrientation(SFRotation val) {
      scaleOrientation_ = val;
      return this;
   };
   public final Transform set_scaleOrientation(double val0,double val1,double val2,double val3) {
      scaleOrientation_ = new SFRotation(val0,val1,val2,val3);
      return this;
   };
   public final Transform set_scaleOrientation(String alias) {
      scaleOrientation_ = new Alias(alias);
      return this;
   };
   public final Transform set_translation(SFVec3f val) {
      translation_ = val;
      return this;
   };
   public final Transform set_translation(double val0,double val1,double val2) {
      translation_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Transform set_translation(String alias) {
      translation_ = new Alias(alias);
      return this;
   };
   public final Transform set_bboxCenter(SFVec3f val) {
      bboxCenter_ = val;
      return this;
   };
   public final Transform set_bboxCenter(double val0,double val1,double val2) {
      bboxCenter_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Transform set_bboxCenter(String alias) {
      bboxCenter_ = new Alias(alias);
      return this;
   };
   public final Transform set_bboxSize(SFVec3f val) {
      bboxSize_ = val;
      return this;
   };
   public final Transform set_bboxSize(double val0,double val1,double val2) {
      bboxSize_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Transform set_bboxSize(String alias) {
      bboxSize_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Transform {\n");

      if (null != center_ &&
          ! center_.equals(centerDefault_)) {
         sb.append(i(l + 1) + "center " + center_.codeString(l + 1) + "\n");
      }
      if (null != children_ &&
          ! children_.equals(childrenDefault_)) {
         sb.append(i(l + 1) + "children " + children_.codeString(l + 1) + "\n");
      }
      if (null != rotation_ &&
          ! rotation_.equals(rotationDefault_)) {
         sb.append(i(l + 1) + "rotation " + rotation_.codeString(l + 1) + "\n");
      }
      if (null != scale_ &&
          ! scale_.equals(scaleDefault_)) {
         sb.append(i(l + 1) + "scale " + scale_.codeString(l + 1) + "\n");
      }
      if (null != scaleOrientation_ &&
          ! scaleOrientation_.equals(scaleOrientationDefault_)) {
         sb.append(i(l + 1) + "scaleOrientation " + scaleOrientation_.codeString(l + 1) + "\n");
      }
      if (null != translation_ &&
          ! translation_.equals(translationDefault_)) {
         sb.append(i(l + 1) + "translation " + translation_.codeString(l + 1) + "\n");
      }
      if (null != bboxCenter_ &&
          ! bboxCenter_.equals(bboxCenterDefault_)) {
         sb.append(i(l + 1) + "bboxCenter " + bboxCenter_.codeString(l + 1) + "\n");
      }
      if (null != bboxSize_ &&
          ! bboxSize_.equals(bboxSizeDefault_)) {
         sb.append(i(l + 1) + "bboxSize " + bboxSize_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value center_ = null;
   protected static final SFVec3f centerDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value children_ = new MFNode();
   protected static final MFNode childrenDefault_ = new VRML2.VALUES.MFNode();
   protected Value rotation_ = null;
   protected static final SFRotation rotationDefault_ = new SFRotation(0.0, 0.0, 1.0, 0.0);
   protected Value scale_ = null;
   protected static final SFVec3f scaleDefault_ = new SFVec3f(1.0, 1.0, 1.0);
   protected Value scaleOrientation_ = null;
   protected static final SFRotation scaleOrientationDefault_ = new SFRotation(0.0, 0.0, 1.0, 0.0);
   protected Value translation_ = null;
   protected static final SFVec3f translationDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value bboxCenter_ = null;
   protected static final SFVec3f bboxCenterDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value bboxSize_ = null;
   protected static final SFVec3f bboxSizeDefault_ = new SFVec3f(-1.0, -1.0, -1.0);
}
