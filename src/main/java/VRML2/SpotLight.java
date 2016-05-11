package VRML2;

import VRML2.VALUES.*;

public class SpotLight extends NamedNode {
   public SpotLight( ) {
      super();
   }
   public SpotLight(String val) {
      super(val);
   }
   public SpotLight(boolean val) {
      super(val);
   }

   public final SpotLight set_ambientIntensity(SFFloat val) {
      ambientIntensity_ = val;
      return this;
   };
   public final SpotLight set_ambientIntensity(double val0) {
      ambientIntensity_ = new SFFloat(val0);
      return this;
   };
   public final SpotLight set_ambientIntensity(String alias) {
      ambientIntensity_ = new Alias(alias);
      return this;
   };
   public final SpotLight set_attenuation(SFVec3f val) {
      attenuation_ = val;
      return this;
   };
   public final SpotLight set_attenuation(double val0,double val1,double val2) {
      attenuation_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final SpotLight set_attenuation(String alias) {
      attenuation_ = new Alias(alias);
      return this;
   };
   public final SpotLight set_beamWidth(SFFloat val) {
      beamWidth_ = val;
      return this;
   };
   public final SpotLight set_beamWidth(double val0) {
      beamWidth_ = new SFFloat(val0);
      return this;
   };
   public final SpotLight set_beamWidth(String alias) {
      beamWidth_ = new Alias(alias);
      return this;
   };
   public final SpotLight set_color(SFColor val) {
      color_ = val;
      return this;
   };
   public final SpotLight set_color(double val0,double val1,double val2) {
      color_ = new SFColor(val0,val1,val2);
      return this;
   };
   public final SpotLight set_color(String alias) {
      color_ = new Alias(alias);
      return this;
   };
   public final SpotLight set_cutOffAngle(SFFloat val) {
      cutOffAngle_ = val;
      return this;
   };
   public final SpotLight set_cutOffAngle(double val0) {
      cutOffAngle_ = new SFFloat(val0);
      return this;
   };
   public final SpotLight set_cutOffAngle(String alias) {
      cutOffAngle_ = new Alias(alias);
      return this;
   };
   public final SpotLight set_direction(SFVec3f val) {
      direction_ = val;
      return this;
   };
   public final SpotLight set_direction(double val0,double val1,double val2) {
      direction_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final SpotLight set_direction(String alias) {
      direction_ = new Alias(alias);
      return this;
   };
   public final SpotLight set_intensity(SFFloat val) {
      intensity_ = val;
      return this;
   };
   public final SpotLight set_intensity(double val0) {
      intensity_ = new SFFloat(val0);
      return this;
   };
   public final SpotLight set_intensity(String alias) {
      intensity_ = new Alias(alias);
      return this;
   };
   public final SpotLight set_location(SFVec3f val) {
      location_ = val;
      return this;
   };
   public final SpotLight set_location(double val0,double val1,double val2) {
      location_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final SpotLight set_location(String alias) {
      location_ = new Alias(alias);
      return this;
   };
   public final SpotLight set_on(SFBool val) {
      on_ = val;
      return this;
   };
   public final SpotLight set_on(boolean val0) {
      on_ = new SFBool(val0);
      return this;
   };
   public final SpotLight set_on(String alias) {
      on_ = new Alias(alias);
      return this;
   };
   public final SpotLight set_radius(SFFloat val) {
      radius_ = val;
      return this;
   };
   public final SpotLight set_radius(double val0) {
      radius_ = new SFFloat(val0);
      return this;
   };
   public final SpotLight set_radius(String alias) {
      radius_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("SpotLight {\n");

      if (null != ambientIntensity_ &&
          ! ambientIntensity_.equals(ambientIntensityDefault_)) {
         sb.append(i(l + 1) + "ambientIntensity " + ambientIntensity_.codeString(l + 1) + "\n");
      }
      if (null != attenuation_ &&
          ! attenuation_.equals(attenuationDefault_)) {
         sb.append(i(l + 1) + "attenuation " + attenuation_.codeString(l + 1) + "\n");
      }
      if (null != beamWidth_ &&
          ! beamWidth_.equals(beamWidthDefault_)) {
         sb.append(i(l + 1) + "beamWidth " + beamWidth_.codeString(l + 1) + "\n");
      }
      if (null != color_ &&
          ! color_.equals(colorDefault_)) {
         sb.append(i(l + 1) + "color " + color_.codeString(l + 1) + "\n");
      }
      if (null != cutOffAngle_ &&
          ! cutOffAngle_.equals(cutOffAngleDefault_)) {
         sb.append(i(l + 1) + "cutOffAngle " + cutOffAngle_.codeString(l + 1) + "\n");
      }
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
      if (null != on_ &&
          ! on_.equals(onDefault_)) {
         sb.append(i(l + 1) + "on " + on_.codeString(l + 1) + "\n");
      }
      if (null != radius_ &&
          ! radius_.equals(radiusDefault_)) {
         sb.append(i(l + 1) + "radius " + radius_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value ambientIntensity_ = null;
   protected static final SFFloat ambientIntensityDefault_ = new SFFloat(0.0);
   protected Value attenuation_ = null;
   protected static final SFVec3f attenuationDefault_ = new SFVec3f(1.0, 0.0, 0.0);
   protected Value beamWidth_ = null;
   protected static final SFFloat beamWidthDefault_ = new SFFloat(1.570796);
   protected Value color_ = null;
   protected static final SFColor colorDefault_ = new SFColor(1.0, 1.0, 1.0);
   protected Value cutOffAngle_ = null;
   protected static final SFFloat cutOffAngleDefault_ = new SFFloat(0.785398);
   protected Value direction_ = null;
   protected static final SFVec3f directionDefault_ = new SFVec3f(0.0, 0.0, -1.0);
   protected Value intensity_ = null;
   protected static final SFFloat intensityDefault_ = new SFFloat(1.0);
   protected Value location_ = null;
   protected static final SFVec3f locationDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value on_ = null;
   protected static final SFBool onDefault_ = new SFBool(true);
   protected Value radius_ = null;
   protected static final SFFloat radiusDefault_ = new SFFloat(100.0);
}
