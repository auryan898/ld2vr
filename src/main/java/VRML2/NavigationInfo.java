package VRML2;

import VRML2.VALUES.*;

public class NavigationInfo extends NamedNode {
   public NavigationInfo( ) {
      super();
   }
   public NavigationInfo(String val) {
      super(val);
   }
   public NavigationInfo(boolean val) {
      super(val);
   }

   public final MFFloat add_avatarSize(SFFloat val) {
      return ((MFFloat)avatarSize_).add(val);
   };
   public final MFFloat add_avatarSize(double val0) {
      return ((MFFloat)avatarSize_).add(val0);
   };
   public final NavigationInfo set_avatarSize(MFFloat val) {
      avatarSize_ = val;
      return this;
   };
   public final NavigationInfo set_avatarSize(String alias) {
      avatarSize_ = new Alias(alias);
      return this;
   };
   public final NavigationInfo set_headlight(SFBool val) {
      headlight_ = val;
      return this;
   };
   public final NavigationInfo set_headlight(boolean val0) {
      headlight_ = new SFBool(val0);
      return this;
   };
   public final NavigationInfo set_headlight(String alias) {
      headlight_ = new Alias(alias);
      return this;
   };
   public final NavigationInfo set_speed(SFFloat val) {
      speed_ = val;
      return this;
   };
   public final NavigationInfo set_speed(double val0) {
      speed_ = new SFFloat(val0);
      return this;
   };
   public final NavigationInfo set_speed(String alias) {
      speed_ = new Alias(alias);
      return this;
   };
   public final MFString add_type(SFString val) {
      return ((MFString)type_).add(val);
   };
   public final MFString add_type(java.lang.String val0) {
      return ((MFString)type_).add(val0);
   };
   public final NavigationInfo set_type(MFString val) {
      type_ = val;
      return this;
   };
   public final NavigationInfo set_type(String alias) {
      type_ = new Alias(alias);
      return this;
   };
   public final NavigationInfo set_visibilityLimit(SFFloat val) {
      visibilityLimit_ = val;
      return this;
   };
   public final NavigationInfo set_visibilityLimit(double val0) {
      visibilityLimit_ = new SFFloat(val0);
      return this;
   };
   public final NavigationInfo set_visibilityLimit(String alias) {
      visibilityLimit_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("NavigationInfo {\n");

      if (null != avatarSize_ &&
          ! avatarSize_.equals(avatarSizeDefault_)) {
         sb.append(i(l + 1) + "avatarSize " + avatarSize_.codeString(l + 1) + "\n");
      }
      if (null != headlight_ &&
          ! headlight_.equals(headlightDefault_)) {
         sb.append(i(l + 1) + "headlight " + headlight_.codeString(l + 1) + "\n");
      }
      if (null != speed_ &&
          ! speed_.equals(speedDefault_)) {
         sb.append(i(l + 1) + "speed " + speed_.codeString(l + 1) + "\n");
      }
      if (null != type_ &&
          ! type_.equals(typeDefault_)) {
         sb.append(i(l + 1) + "type " + type_.codeString(l + 1) + "\n");
      }
      if (null != visibilityLimit_ &&
          ! visibilityLimit_.equals(visibilityLimitDefault_)) {
         sb.append(i(l + 1) + "visibilityLimit " + visibilityLimit_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value avatarSize_ = new MFFloat();
   protected static final MFFloat avatarSizeDefault_ = new VRML2.VALUES.MFFloat().add(new SFFloat(0.25)).add(new SFFloat(1.6)).add(new SFFloat(0.75));
   protected Value headlight_ = null;
   protected static final SFBool headlightDefault_ = new SFBool(true);
   protected Value speed_ = null;
   protected static final SFFloat speedDefault_ = new SFFloat(1.0);
   protected Value type_ = new MFString();
   protected static final MFString typeDefault_ = new VRML2.VALUES.MFString().add(new SFString("WALK"));
   protected Value visibilityLimit_ = null;
   protected static final SFFloat visibilityLimitDefault_ = new SFFloat(0.0);
}
