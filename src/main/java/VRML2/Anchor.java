package VRML2;

import VRML2.VALUES.*;

public class Anchor extends NamedNode {
   public Anchor( ) {
      super();
   }
   public Anchor(String val) {
      super(val);
   }
   public Anchor(boolean val) {
      super(val);
   }

   public final MFNode add_children(SFNode val) {
      return ((MFNode)children_).add(val);
   };
   public final MFNode add_children(VRML2.VRML2Node val0) {
      return ((MFNode)children_).add(val0);
   };
   public final Anchor set_children(MFNode val) {
      children_ = val;
      return this;
   };
   public final Anchor set_children(String alias) {
      children_ = new Alias(alias);
      return this;
   };
   public final Anchor set_description(SFString val) {
      description_ = val;
      return this;
   };
   public final Anchor set_description(String alias) {
      description_ = new Alias(alias);
      return this;
   };
   public final MFString add_parameter(SFString val) {
      return ((MFString)parameter_).add(val);
   };
   public final MFString add_parameter(java.lang.String val0) {
      return ((MFString)parameter_).add(val0);
   };
   public final Anchor set_parameter(MFString val) {
      parameter_ = val;
      return this;
   };
   public final Anchor set_parameter(String alias) {
      parameter_ = new Alias(alias);
      return this;
   };
   public final MFString add_url(SFString val) {
      return ((MFString)url_).add(val);
   };
   public final MFString add_url(java.lang.String val0) {
      return ((MFString)url_).add(val0);
   };
   public final Anchor set_url(MFString val) {
      url_ = val;
      return this;
   };
   public final Anchor set_url(String alias) {
      url_ = new Alias(alias);
      return this;
   };
   public final Anchor set_bboxCenter(SFVec3f val) {
      bboxCenter_ = val;
      return this;
   };
   public final Anchor set_bboxCenter(double val0,double val1,double val2) {
      bboxCenter_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Anchor set_bboxCenter(String alias) {
      bboxCenter_ = new Alias(alias);
      return this;
   };
   public final Anchor set_bboxSize(SFVec3f val) {
      bboxSize_ = val;
      return this;
   };
   public final Anchor set_bboxSize(double val0,double val1,double val2) {
      bboxSize_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Anchor set_bboxSize(String alias) {
      bboxSize_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Anchor {\n");

      if (null != children_ &&
          ! children_.equals(childrenDefault_)) {
         sb.append(i(l + 1) + "children " + children_.codeString(l + 1) + "\n");
      }
      if (null != description_ &&
          ! description_.equals(descriptionDefault_)) {
         sb.append(i(l + 1) + "description " + description_.codeString(l + 1) + "\n");
      }
      if (null != parameter_ &&
          ! parameter_.equals(parameterDefault_)) {
         sb.append(i(l + 1) + "parameter " + parameter_.codeString(l + 1) + "\n");
      }
      if (null != url_ &&
          ! url_.equals(urlDefault_)) {
         sb.append(i(l + 1) + "url " + url_.codeString(l + 1) + "\n");
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

   protected Value children_ = new MFNode();
   protected static final MFNode childrenDefault_ = new VRML2.VALUES.MFNode();
   protected Value description_ = null;
   protected static final SFString descriptionDefault_ = new SFString("");
   protected Value parameter_ = new MFString();
   protected static final MFString parameterDefault_ = new VRML2.VALUES.MFString();
   protected Value url_ = new MFString();
   protected static final MFString urlDefault_ = new VRML2.VALUES.MFString();
   protected Value bboxCenter_ = null;
   protected static final SFVec3f bboxCenterDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value bboxSize_ = null;
   protected static final SFVec3f bboxSizeDefault_ = new SFVec3f(-1.0, -1.0, -1.0);
}
