package VRML2;

import VRML2.VALUES.*;

public class MovieTexture extends NamedNode {
   public MovieTexture( ) {
      super();
   }
   public MovieTexture(String val) {
      super(val);
   }
   public MovieTexture(boolean val) {
      super(val);
   }

   public final MovieTexture set_loop(SFBool val) {
      loop_ = val;
      return this;
   };
   public final MovieTexture set_loop(boolean val0) {
      loop_ = new SFBool(val0);
      return this;
   };
   public final MovieTexture set_loop(String alias) {
      loop_ = new Alias(alias);
      return this;
   };
   public final MovieTexture set_speed(SFFloat val) {
      speed_ = val;
      return this;
   };
   public final MovieTexture set_speed(double val0) {
      speed_ = new SFFloat(val0);
      return this;
   };
   public final MovieTexture set_speed(String alias) {
      speed_ = new Alias(alias);
      return this;
   };
   public final MovieTexture set_startTime(SFTime val) {
      startTime_ = val;
      return this;
   };
   public final MovieTexture set_startTime(long val0) {
      startTime_ = new SFTime(val0);
      return this;
   };
   public final MovieTexture set_startTime(String alias) {
      startTime_ = new Alias(alias);
      return this;
   };
   public final MovieTexture set_stopTime(SFTime val) {
      stopTime_ = val;
      return this;
   };
   public final MovieTexture set_stopTime(long val0) {
      stopTime_ = new SFTime(val0);
      return this;
   };
   public final MovieTexture set_stopTime(String alias) {
      stopTime_ = new Alias(alias);
      return this;
   };
   public final MFString add_url(SFString val) {
      return ((MFString)url_).add(val);
   };
   public final MFString add_url(java.lang.String val0) {
      return ((MFString)url_).add(val0);
   };
   public final MovieTexture set_url(MFString val) {
      url_ = val;
      return this;
   };
   public final MovieTexture set_url(String alias) {
      url_ = new Alias(alias);
      return this;
   };
   public final MovieTexture set_repeatS(SFBool val) {
      repeatS_ = val;
      return this;
   };
   public final MovieTexture set_repeatS(boolean val0) {
      repeatS_ = new SFBool(val0);
      return this;
   };
   public final MovieTexture set_repeatS(String alias) {
      repeatS_ = new Alias(alias);
      return this;
   };
   public final MovieTexture set_repeatT(SFBool val) {
      repeatT_ = val;
      return this;
   };
   public final MovieTexture set_repeatT(boolean val0) {
      repeatT_ = new SFBool(val0);
      return this;
   };
   public final MovieTexture set_repeatT(String alias) {
      repeatT_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("MovieTexture {\n");

      if (null != loop_ &&
          ! loop_.equals(loopDefault_)) {
         sb.append(i(l + 1) + "loop " + loop_.codeString(l + 1) + "\n");
      }
      if (null != speed_ &&
          ! speed_.equals(speedDefault_)) {
         sb.append(i(l + 1) + "speed " + speed_.codeString(l + 1) + "\n");
      }
      if (null != startTime_ &&
          ! startTime_.equals(startTimeDefault_)) {
         sb.append(i(l + 1) + "startTime " + startTime_.codeString(l + 1) + "\n");
      }
      if (null != stopTime_ &&
          ! stopTime_.equals(stopTimeDefault_)) {
         sb.append(i(l + 1) + "stopTime " + stopTime_.codeString(l + 1) + "\n");
      }
      if (null != url_ &&
          ! url_.equals(urlDefault_)) {
         sb.append(i(l + 1) + "url " + url_.codeString(l + 1) + "\n");
      }
      if (null != repeatS_ &&
          ! repeatS_.equals(repeatSDefault_)) {
         sb.append(i(l + 1) + "repeatS " + repeatS_.codeString(l + 1) + "\n");
      }
      if (null != repeatT_ &&
          ! repeatT_.equals(repeatTDefault_)) {
         sb.append(i(l + 1) + "repeatT " + repeatT_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value loop_ = null;
   protected static final SFBool loopDefault_ = new SFBool(false);
   protected Value speed_ = null;
   protected static final SFFloat speedDefault_ = new SFFloat(1.0);
   protected Value startTime_ = null;
   protected static final SFTime startTimeDefault_ = new SFTime(0);
   protected Value stopTime_ = null;
   protected static final SFTime stopTimeDefault_ = new SFTime(0);
   protected Value url_ = new MFString();
   protected static final MFString urlDefault_ = new VRML2.VALUES.MFString();
   protected Value repeatS_ = null;
   protected static final SFBool repeatSDefault_ = new SFBool(true);
   protected Value repeatT_ = null;
   protected static final SFBool repeatTDefault_ = new SFBool(true);
}
