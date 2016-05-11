package VRML2;

import VRML2.VALUES.*;

public class Collision extends NamedNode {
   public Collision( ) {
      super();
   }
   public Collision(String val) {
      super(val);
   }
   public Collision(boolean val) {
      super(val);
   }

   public final MFNode add_children(SFNode val) {
      return ((MFNode)children_).add(val);
   };
   public final MFNode add_children(VRML2.VRML2Node val0) {
      return ((MFNode)children_).add(val0);
   };
   public final Collision set_children(MFNode val) {
      children_ = val;
      return this;
   };
   public final Collision set_children(String alias) {
      children_ = new Alias(alias);
      return this;
   };
   public final Collision set_collide(SFBool val) {
      collide_ = val;
      return this;
   };
   public final Collision set_collide(boolean val0) {
      collide_ = new SFBool(val0);
      return this;
   };
   public final Collision set_collide(String alias) {
      collide_ = new Alias(alias);
      return this;
   };
   public final Collision set_bboxCenter(SFVec3f val) {
      bboxCenter_ = val;
      return this;
   };
   public final Collision set_bboxCenter(double val0,double val1,double val2) {
      bboxCenter_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Collision set_bboxCenter(String alias) {
      bboxCenter_ = new Alias(alias);
      return this;
   };
   public final Collision set_bboxSize(SFVec3f val) {
      bboxSize_ = val;
      return this;
   };
   public final Collision set_bboxSize(double val0,double val1,double val2) {
      bboxSize_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Collision set_bboxSize(String alias) {
      bboxSize_ = new Alias(alias);
      return this;
   };
   public final Collision set_proxy(SFNode val) {
      proxy_ = val;
      return this;
   };
   public final Collision set_proxy(VRML2.VRML2Node val0) {
      proxy_ = new SFNode(val0);
      return this;
   };
   public final Collision set_proxy(String alias) {
      proxy_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Collision {\n");

      if (null != children_ &&
          ! children_.equals(childrenDefault_)) {
         sb.append(i(l + 1) + "children " + children_.codeString(l + 1) + "\n");
      }
      if (null != collide_ &&
          ! collide_.equals(collideDefault_)) {
         sb.append(i(l + 1) + "collide " + collide_.codeString(l + 1) + "\n");
      }
      if (null != bboxCenter_ &&
          ! bboxCenter_.equals(bboxCenterDefault_)) {
         sb.append(i(l + 1) + "bboxCenter " + bboxCenter_.codeString(l + 1) + "\n");
      }
      if (null != bboxSize_ &&
          ! bboxSize_.equals(bboxSizeDefault_)) {
         sb.append(i(l + 1) + "bboxSize " + bboxSize_.codeString(l + 1) + "\n");
      }
      if (null != proxy_ &&
          ! proxy_.equals(proxyDefault_)) {
         sb.append(i(l + 1) + "proxy " + proxy_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value children_ = new MFNode();
   protected static final MFNode childrenDefault_ = new VRML2.VALUES.MFNode();
   protected Value collide_ = null;
   protected static final SFBool collideDefault_ = new SFBool(true);
   protected Value bboxCenter_ = null;
   protected static final SFVec3f bboxCenterDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value bboxSize_ = null;
   protected static final SFVec3f bboxSizeDefault_ = new SFVec3f(-1.0, -1.0, -1.0);
   protected Value proxy_ = null;
   protected static final SFNode proxyDefault_ = new SFNode();
}
