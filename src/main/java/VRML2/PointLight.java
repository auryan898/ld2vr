package VRML2;

import VRML2.VALUES.*;

public class PointLight extends NamedNode {
   public PointLight( ) {
      super();
   }
   public PointLight(String val) {
      super(val);
   }
   public PointLight(boolean val) {
      super(val);
   }

   public final PointLight set_ambientIntensity(SFFloat val) {
      ambientIntensity_ = val;
      return this;
   };
   public final PointLight set_ambientIntensity(double val0) {
      ambientIntensity_ = new SFFloat(val0);
      return this;
   };
   public final PointLight set_ambientIntensity(String alias) {
      ambientIntensity_ = new Alias(alias);
      return this;
   };
   public final PointLight set_attenuation(SFVec3f val) {
      attenuation_ = val;
      return this;
   };
   public final PointLight set_attenuation(double val0,double val1,double val2) {
      attenuation_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final PointLight set_attenuation(String alias) {
      attenuation_ = new Alias(alias);
      return this;
   };
   public final PointLight set_color(SFColor val) {
      color_ = val;
      return this;
   };
   public final PointLight set_color(double val0,double val1,double val2) {
      color_ = new SFColor(val0,val1,val2);
      return this;
   };
   public final PointLight set_color(String alias) {
      color_ = new Alias(alias);
      return this;
   };
   public final PointLight set_intensity(SFFloat val) {
      intensity_ = val;
      return this;
   };
   public final PointLight set_intensity(double val0) {
      intensity_ = new SFFloat(val0);
      return this;
   };
   public final PointLight set_intensity(String alias) {
      intensity_ = new Alias(alias);
      return this;
   };
   public final PointLight set_location(SFVec3f val) {
      location_ = val;
      return this;
   };
   public final PointLight set_location(double val0,double val1,double val2) {
      location_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final PointLight set_location(String alias) {
      location_ = new Alias(alias);
      return this;
   };
   public final PointLight set_on(SFBool val) {
      on_ = val;
      return this;
   };
   public final PointLight set_on(boolean val0) {
      on_ = new SFBool(val0);
      return this;
   };
   public final PointLight set_on(String alias) {
      on_ = new Alias(alias);
      return this;
   };
   public final PointLight set_radius(SFFloat val) {
      radius_ = val;
      return this;
   };
   public final PointLight set_radius(double val0) {
      radius_ = new SFFloat(val0);
      return this;
   };
   public final PointLight set_radius(String alias) {
      radius_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("PointLight {\n");

      if (null != ambientIntensity_ &&
          ! ambientIntensity_.equals(ambientIntensityDefault_)) {
         sb.append(i(l + 1) + "ambientIntensity " + ambientIntensity_.codeString(l + 1) + "\n");
      }
      if (null != attenuation_ &&
          ! attenuation_.equals(attenuationDefault_)) {
         sb.append(i(l + 1) + "attenuation " + attenuation_.codeString(l + 1) + "\n");
      }
      if (null != color_ &&
          ! color_.equals(colorDefault_)) {
         sb.append(i(l + 1) + "color " + color_.codeString(l + 1) + "\n");
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
   protected Value color_ = null;
   protected static final SFColor colorDefault_ = new SFColor(1.0, 1.0, 1.0);
   protected Value intensity_ = null;
   protected static final SFFloat intensityDefault_ = new SFFloat(1.0);
   protected Value location_ = null;
   protected static final SFVec3f locationDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value on_ = null;
   protected static final SFBool onDefault_ = new SFBool(true);
   protected Value radius_ = null;
   protected static final SFFloat radiusDefault_ = new SFFloat(100.0);
}
