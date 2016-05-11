package VRML2;

import VRML2.VALUES.*;

public class AudioClip extends NamedNode {
   public AudioClip( ) {
      super();
   }
   public AudioClip(String val) {
      super(val);
   }
   public AudioClip(boolean val) {
      super(val);
   }

   public final AudioClip set_description(SFString val) {
      description_ = val;
      return this;
   };
   public final AudioClip set_description(String alias) {
      description_ = new Alias(alias);
      return this;
   };
   public final AudioClip set_loop(SFBool val) {
      loop_ = val;
      return this;
   };
   public final AudioClip set_loop(boolean val0) {
      loop_ = new SFBool(val0);
      return this;
   };
   public final AudioClip set_loop(String alias) {
      loop_ = new Alias(alias);
      return this;
   };
   public final AudioClip set_pitch(SFFloat val) {
      pitch_ = val;
      return this;
   };
   public final AudioClip set_pitch(double val0) {
      pitch_ = new SFFloat(val0);
      return this;
   };
   public final AudioClip set_pitch(String alias) {
      pitch_ = new Alias(alias);
      return this;
   };
   public final AudioClip set_startTime(SFTime val) {
      startTime_ = val;
      return this;
   };
   public final AudioClip set_startTime(long val0) {
      startTime_ = new SFTime(val0);
      return this;
   };
   public final AudioClip set_startTime(String alias) {
      startTime_ = new Alias(alias);
      return this;
   };
   public final AudioClip set_stopTime(SFTime val) {
      stopTime_ = val;
      return this;
   };
   public final AudioClip set_stopTime(long val0) {
      stopTime_ = new SFTime(val0);
      return this;
   };
   public final AudioClip set_stopTime(String alias) {
      stopTime_ = new Alias(alias);
      return this;
   };
   public final MFString add_url(SFString val) {
      return ((MFString)url_).add(val);
   };
   public final MFString add_url(java.lang.String val0) {
      return ((MFString)url_).add(val0);
   };
   public final AudioClip set_url(MFString val) {
      url_ = val;
      return this;
   };
   public final AudioClip set_url(String alias) {
      url_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("AudioClip {\n");

      if (null != description_ &&
          ! description_.equals(descriptionDefault_)) {
         sb.append(i(l + 1) + "description " + description_.codeString(l + 1) + "\n");
      }
      if (null != loop_ &&
          ! loop_.equals(loopDefault_)) {
         sb.append(i(l + 1) + "loop " + loop_.codeString(l + 1) + "\n");
      }
      if (null != pitch_ &&
          ! pitch_.equals(pitchDefault_)) {
         sb.append(i(l + 1) + "pitch " + pitch_.codeString(l + 1) + "\n");
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
      return sb.append(i(l) + "}").toString();
   }

   protected Value description_ = null;
   protected static final SFString descriptionDefault_ = new SFString("");
   protected Value loop_ = null;
   protected static final SFBool loopDefault_ = new SFBool(false);
   protected Value pitch_ = null;
   protected static final SFFloat pitchDefault_ = new SFFloat(1.0);
   protected Value startTime_ = null;
   protected static final SFTime startTimeDefault_ = new SFTime(0);
   protected Value stopTime_ = null;
   protected static final SFTime stopTimeDefault_ = new SFTime(0);
   protected Value url_ = new MFString();
   protected static final MFString urlDefault_ = new VRML2.VALUES.MFString();
}
