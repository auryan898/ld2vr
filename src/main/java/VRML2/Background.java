package VRML2;

import VRML2.VALUES.*;

public class Background extends NamedNode {
   public Background( ) {
      super();
   }
   public Background(String val) {
      super(val);
   }
   public Background(boolean val) {
      super(val);
   }

   public final MFFloat add_groundAngle(SFFloat val) {
      return ((MFFloat)groundAngle_).add(val);
   };
   public final MFFloat add_groundAngle(double val0) {
      return ((MFFloat)groundAngle_).add(val0);
   };
   public final Background set_groundAngle(MFFloat val) {
      groundAngle_ = val;
      return this;
   };
   public final Background set_groundAngle(String alias) {
      groundAngle_ = new Alias(alias);
      return this;
   };
   public final MFColor add_groundColor(SFColor val) {
      return ((MFColor)groundColor_).add(val);
   };
   public final MFColor add_groundColor(double val0,double val1,double val2) {
      return ((MFColor)groundColor_).add(val0,val1,val2);
   };
   public final Background set_groundColor(MFColor val) {
      groundColor_ = val;
      return this;
   };
   public final Background set_groundColor(String alias) {
      groundColor_ = new Alias(alias);
      return this;
   };
   public final MFString add_backUrl(SFString val) {
      return ((MFString)backUrl_).add(val);
   };
   public final MFString add_backUrl(java.lang.String val0) {
      return ((MFString)backUrl_).add(val0);
   };
   public final Background set_backUrl(MFString val) {
      backUrl_ = val;
      return this;
   };
   public final Background set_backUrl(String alias) {
      backUrl_ = new Alias(alias);
      return this;
   };
   public final MFString add_bottomUrl(SFString val) {
      return ((MFString)bottomUrl_).add(val);
   };
   public final MFString add_bottomUrl(java.lang.String val0) {
      return ((MFString)bottomUrl_).add(val0);
   };
   public final Background set_bottomUrl(MFString val) {
      bottomUrl_ = val;
      return this;
   };
   public final Background set_bottomUrl(String alias) {
      bottomUrl_ = new Alias(alias);
      return this;
   };
   public final MFString add_frontUrl(SFString val) {
      return ((MFString)frontUrl_).add(val);
   };
   public final MFString add_frontUrl(java.lang.String val0) {
      return ((MFString)frontUrl_).add(val0);
   };
   public final Background set_frontUrl(MFString val) {
      frontUrl_ = val;
      return this;
   };
   public final Background set_frontUrl(String alias) {
      frontUrl_ = new Alias(alias);
      return this;
   };
   public final MFString add_leftUrl(SFString val) {
      return ((MFString)leftUrl_).add(val);
   };
   public final MFString add_leftUrl(java.lang.String val0) {
      return ((MFString)leftUrl_).add(val0);
   };
   public final Background set_leftUrl(MFString val) {
      leftUrl_ = val;
      return this;
   };
   public final Background set_leftUrl(String alias) {
      leftUrl_ = new Alias(alias);
      return this;
   };
   public final MFString add_rightUrl(SFString val) {
      return ((MFString)rightUrl_).add(val);
   };
   public final MFString add_rightUrl(java.lang.String val0) {
      return ((MFString)rightUrl_).add(val0);
   };
   public final Background set_rightUrl(MFString val) {
      rightUrl_ = val;
      return this;
   };
   public final Background set_rightUrl(String alias) {
      rightUrl_ = new Alias(alias);
      return this;
   };
   public final MFString add_topUrl(SFString val) {
      return ((MFString)topUrl_).add(val);
   };
   public final MFString add_topUrl(java.lang.String val0) {
      return ((MFString)topUrl_).add(val0);
   };
   public final Background set_topUrl(MFString val) {
      topUrl_ = val;
      return this;
   };
   public final Background set_topUrl(String alias) {
      topUrl_ = new Alias(alias);
      return this;
   };
   public final MFFloat add_skyAngle(SFFloat val) {
      return ((MFFloat)skyAngle_).add(val);
   };
   public final MFFloat add_skyAngle(double val0) {
      return ((MFFloat)skyAngle_).add(val0);
   };
   public final Background set_skyAngle(MFFloat val) {
      skyAngle_ = val;
      return this;
   };
   public final Background set_skyAngle(String alias) {
      skyAngle_ = new Alias(alias);
      return this;
   };
   public final MFColor add_skyColor(SFColor val) {
      return ((MFColor)skyColor_).add(val);
   };
   public final MFColor add_skyColor(double val0,double val1,double val2) {
      return ((MFColor)skyColor_).add(val0,val1,val2);
   };
   public final Background set_skyColor(MFColor val) {
      skyColor_ = val;
      return this;
   };
   public final Background set_skyColor(String alias) {
      skyColor_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Background {\n");

      if (null != groundAngle_ &&
          ! groundAngle_.equals(groundAngleDefault_)) {
         sb.append(i(l + 1) + "groundAngle " + groundAngle_.codeString(l + 1) + "\n");
      }
      if (null != groundColor_ &&
          ! groundColor_.equals(groundColorDefault_)) {
         sb.append(i(l + 1) + "groundColor " + groundColor_.codeString(l + 1) + "\n");
      }
      if (null != backUrl_ &&
          ! backUrl_.equals(backUrlDefault_)) {
         sb.append(i(l + 1) + "backUrl " + backUrl_.codeString(l + 1) + "\n");
      }
      if (null != bottomUrl_ &&
          ! bottomUrl_.equals(bottomUrlDefault_)) {
         sb.append(i(l + 1) + "bottomUrl " + bottomUrl_.codeString(l + 1) + "\n");
      }
      if (null != frontUrl_ &&
          ! frontUrl_.equals(frontUrlDefault_)) {
         sb.append(i(l + 1) + "frontUrl " + frontUrl_.codeString(l + 1) + "\n");
      }
      if (null != leftUrl_ &&
          ! leftUrl_.equals(leftUrlDefault_)) {
         sb.append(i(l + 1) + "leftUrl " + leftUrl_.codeString(l + 1) + "\n");
      }
      if (null != rightUrl_ &&
          ! rightUrl_.equals(rightUrlDefault_)) {
         sb.append(i(l + 1) + "rightUrl " + rightUrl_.codeString(l + 1) + "\n");
      }
      if (null != topUrl_ &&
          ! topUrl_.equals(topUrlDefault_)) {
         sb.append(i(l + 1) + "topUrl " + topUrl_.codeString(l + 1) + "\n");
      }
      if (null != skyAngle_ &&
          ! skyAngle_.equals(skyAngleDefault_)) {
         sb.append(i(l + 1) + "skyAngle " + skyAngle_.codeString(l + 1) + "\n");
      }
      if (null != skyColor_ &&
          ! skyColor_.equals(skyColorDefault_)) {
         sb.append(i(l + 1) + "skyColor " + skyColor_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value groundAngle_ = new MFFloat();
   protected static final MFFloat groundAngleDefault_ = new VRML2.VALUES.MFFloat();
   protected Value groundColor_ = new MFColor();
   protected static final MFColor groundColorDefault_ = new VRML2.VALUES.MFColor();
   protected Value backUrl_ = new MFString();
   protected static final MFString backUrlDefault_ = new VRML2.VALUES.MFString();
   protected Value bottomUrl_ = new MFString();
   protected static final MFString bottomUrlDefault_ = new VRML2.VALUES.MFString();
   protected Value frontUrl_ = new MFString();
   protected static final MFString frontUrlDefault_ = new VRML2.VALUES.MFString();
   protected Value leftUrl_ = new MFString();
   protected static final MFString leftUrlDefault_ = new VRML2.VALUES.MFString();
   protected Value rightUrl_ = new MFString();
   protected static final MFString rightUrlDefault_ = new VRML2.VALUES.MFString();
   protected Value topUrl_ = new MFString();
   protected static final MFString topUrlDefault_ = new VRML2.VALUES.MFString();
   protected Value skyAngle_ = new MFFloat();
   protected static final MFFloat skyAngleDefault_ = new VRML2.VALUES.MFFloat();
   protected Value skyColor_ = new MFColor();
   protected static final MFColor skyColorDefault_ = new VRML2.VALUES.MFColor().add(new SFColor(0.0, 0.0, 0.0));
}
