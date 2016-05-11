package VRML2;

import VRML2.VALUES.*;

public class Billboard extends NamedNode {
   public Billboard( ) {
      super();
   }
   public Billboard(String val) {
      super(val);
   }
   public Billboard(boolean val) {
      super(val);
   }

   public final Billboard set_axisOfRotation(SFVec3f val) {
      axisOfRotation_ = val;
      return this;
   };
   public final Billboard set_axisOfRotation(double val0,double val1,double val2) {
      axisOfRotation_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Billboard set_axisOfRotation(String alias) {
      axisOfRotation_ = new Alias(alias);
      return this;
   };
   public final MFNode add_children(SFNode val) {
      return ((MFNode)children_).add(val);
   };
   public final MFNode add_children(VRML2.VRML2Node val0) {
      return ((MFNode)children_).add(val0);
   };
   public final Billboard set_children(MFNode val) {
      children_ = val;
      return this;
   };
   public final Billboard set_children(String alias) {
      children_ = new Alias(alias);
      return this;
   };
   public final Billboard set_bboxCenter(SFVec3f val) {
      bboxCenter_ = val;
      return this;
   };
   public final Billboard set_bboxCenter(double val0,double val1,double val2) {
      bboxCenter_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Billboard set_bboxCenter(String alias) {
      bboxCenter_ = new Alias(alias);
      return this;
   };
   public final Billboard set_bboxSize(SFVec3f val) {
      bboxSize_ = val;
      return this;
   };
   public final Billboard set_bboxSize(double val0,double val1,double val2) {
      bboxSize_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Billboard set_bboxSize(String alias) {
      bboxSize_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Billboard {\n");

      if (null != axisOfRotation_ &&
          ! axisOfRotation_.equals(axisOfRotationDefault_)) {
         sb.append(i(l + 1) + "axisOfRotation " + axisOfRotation_.codeString(l + 1) + "\n");
      }
      if (null != children_ &&
          ! children_.equals(childrenDefault_)) {
         sb.append(i(l + 1) + "children " + children_.codeString(l + 1) + "\n");
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

   protected Value axisOfRotation_ = null;
   protected static final SFVec3f axisOfRotationDefault_ = new SFVec3f(0.0, 1.0, 0.0);
   protected Value children_ = new MFNode();
   protected static final MFNode childrenDefault_ = new VRML2.VALUES.MFNode();
   protected Value bboxCenter_ = null;
   protected static final SFVec3f bboxCenterDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value bboxSize_ = null;
   protected static final SFVec3f bboxSizeDefault_ = new SFVec3f(-1.0, -1.0, -1.0);
}
