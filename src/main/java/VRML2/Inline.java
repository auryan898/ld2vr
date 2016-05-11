package VRML2;

import VRML2.VALUES.*;

public class Inline extends NamedNode {
   public Inline( ) {
      super();
   }
   public Inline(String val) {
      super(val);
   }
   public Inline(boolean val) {
      super(val);
   }

   public final MFString add_url(SFString val) {
      return ((MFString)url_).add(val);
   };
   public final MFString add_url(java.lang.String val0) {
      return ((MFString)url_).add(val0);
   };
   public final Inline set_url(MFString val) {
      url_ = val;
      return this;
   };
   public final Inline set_url(String alias) {
      url_ = new Alias(alias);
      return this;
   };
   public final Inline set_bboxCenter(SFVec3f val) {
      bboxCenter_ = val;
      return this;
   };
   public final Inline set_bboxCenter(double val0,double val1,double val2) {
      bboxCenter_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Inline set_bboxCenter(String alias) {
      bboxCenter_ = new Alias(alias);
      return this;
   };
   public final Inline set_bboxSize(SFVec3f val) {
      bboxSize_ = val;
      return this;
   };
   public final Inline set_bboxSize(double val0,double val1,double val2) {
      bboxSize_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Inline set_bboxSize(String alias) {
      bboxSize_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Inline {\n");

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

   protected Value url_ = new MFString();
   protected static final MFString urlDefault_ = new VRML2.VALUES.MFString();
   protected Value bboxCenter_ = null;
   protected static final SFVec3f bboxCenterDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value bboxSize_ = null;
   protected static final SFVec3f bboxSizeDefault_ = new SFVec3f(-1.0, -1.0, -1.0);
}
