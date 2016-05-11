package VRML2;

import VRML2.VALUES.*;

public class Sound extends NamedNode {
   public Sound( ) {
      super();
   }
   public Sound(String val) {
      super(val);
   }
   public Sound(boolean val) {
      super(val);
   }

   public final Sound set_direction(SFVec3f val) {
      direction_ = val;
      return this;
   };
   public final Sound set_direction(double val0,double val1,double val2) {
      direction_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Sound set_direction(String alias) {
      direction_ = new Alias(alias);
      return this;
   };
   public final Sound set_intensity(SFFloat val) {
      intensity_ = val;
      return this;
   };
   public final Sound set_intensity(double val0) {
      intensity_ = new SFFloat(val0);
      return this;
   };
   public final Sound set_intensity(String alias) {
      intensity_ = new Alias(alias);
      return this;
   };
   public final Sound set_location(SFVec3f val) {
      location_ = val;
      return this;
   };
   public final Sound set_location(double val0,double val1,double val2) {
      location_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Sound set_location(String alias) {
      location_ = new Alias(alias);
      return this;
   };
   public final Sound set_maxBack(SFFloat val) {
      maxBack_ = val;
      return this;
   };
   public final Sound set_maxBack(double val0) {
      maxBack_ = new SFFloat(val0);
      return this;
   };
   public final Sound set_maxBack(String alias) {
      maxBack_ = new Alias(alias);
      return this;
   };
   public final Sound set_maxFront(SFFloat val) {
      maxFront_ = val;
      return this;
   };
   public final Sound set_maxFront(double val0) {
      maxFront_ = new SFFloat(val0);
      return this;
   };
   public final Sound set_maxFront(String alias) {
      maxFront_ = new Alias(alias);
      return this;
   };
   public final Sound set_minBack(SFFloat val) {
      minBack_ = val;
      return this;
   };
   public final Sound set_minBack(double val0) {
      minBack_ = new SFFloat(val0);
      return this;
   };
   public final Sound set_minBack(String alias) {
      minBack_ = new Alias(alias);
      return this;
   };
   public final Sound set_minFront(SFFloat val) {
      minFront_ = val;
      return this;
   };
   public final Sound set_minFront(double val0) {
      minFront_ = new SFFloat(val0);
      return this;
   };
   public final Sound set_minFront(String alias) {
      minFront_ = new Alias(alias);
      return this;
   };
   public final Sound set_priority(SFFloat val) {
      priority_ = val;
      return this;
   };
   public final Sound set_priority(double val0) {
      priority_ = new SFFloat(val0);
      return this;
   };
   public final Sound set_priority(String alias) {
      priority_ = new Alias(alias);
      return this;
   };
   public final Sound set_source(SFNode val) {
      source_ = val;
      return this;
   };
   public final Sound set_source(VRML2.VRML2Node val0) {
      source_ = new SFNode(val0);
      return this;
   };
   public final Sound set_source(String alias) {
      source_ = new Alias(alias);
      return this;
   };
   public final Sound set_spatialize(SFBool val) {
      spatialize_ = val;
      return this;
   };
   public final Sound set_spatialize(boolean val0) {
      spatialize_ = new SFBool(val0);
      return this;
   };
   public final Sound set_spatialize(String alias) {
      spatialize_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Sound {\n");

      if (null != direction_ &&
          ! direction_.equals(directionDefault_)) {
         sb.append(i(l + 1) + "direction " + direction_.codeString(l + 1) + "\n");
      }
      if (null != intensity_ &&
          ! intensity_.equals(intensityDefault_)) {
         sb.append(i(l + 1) + "intensity " + intensity_.codeString(l + 1) + "\n");
      }
      if (null != location_ &&
          ! location_.equals(locationDefault_)) {
         sb.append(i(l + 1) + "location " + location_.codeString(l + 1) + "\n");
      }
      if (null != maxBack_ &&
          ! maxBack_.equals(maxBackDefault_)) {
         sb.append(i(l + 1) + "maxBack " + maxBack_.codeString(l + 1) + "\n");
      }
      if (null != maxFront_ &&
          ! maxFront_.equals(maxFrontDefault_)) {
         sb.append(i(l + 1) + "maxFront " + maxFront_.codeString(l + 1) + "\n");
      }
      if (null != minBack_ &&
          ! minBack_.equals(minBackDefault_)) {
         sb.append(i(l + 1) + "minBack " + minBack_.codeString(l + 1) + "\n");
      }
      if (null != minFront_ &&
          ! minFront_.equals(minFrontDefault_)) {
         sb.append(i(l + 1) + "minFront " + minFront_.codeString(l + 1) + "\n");
      }
      if (null != priority_ &&
          ! priority_.equals(priorityDefault_)) {
         sb.append(i(l + 1) + "priority " + priority_.codeString(l + 1) + "\n");
      }
      if (null != source_ &&
          ! source_.equals(sourceDefault_)) {
         sb.append(i(l + 1) + "source " + source_.codeString(l + 1) + "\n");
      }
      if (null != spatialize_ &&
          ! spatialize_.equals(spatializeDefault_)) {
         sb.append(i(l + 1) + "spatialize " + spatialize_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value direction_ = null;
   protected static final SFVec3f directionDefault_ = new SFVec3f(0.0, 0.0, 1.0);
   protected Value intensity_ = null;
   protected static final SFFloat intensityDefault_ = new SFFloat(1.0);
   protected Value location_ = null;
   protected static final SFVec3f locationDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value maxBack_ = null;
   protected static final SFFloat maxBackDefault_ = new SFFloat(10.0);
   protected Value maxFront_ = null;
   protected static final SFFloat maxFrontDefault_ = new SFFloat(10.0);
   protected Value minBack_ = null;
   protected static final SFFloat minBackDefault_ = new SFFloat(1.0);
   protected Value minFront_ = null;
   protected static final SFFloat minFrontDefault_ = new SFFloat(1.0);
   protected Value priority_ = null;
   protected static final SFFloat priorityDefault_ = new SFFloat(0.0);
   protected Value source_ = null;
   protected static final SFNode sourceDefault_ = new SFNode();
   protected Value spatialize_ = null;
   protected static final SFBool spatializeDefault_ = new SFBool(true);
}
