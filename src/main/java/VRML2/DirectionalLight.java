package VRML2;

import VRML2.VALUES.*;

public class DirectionalLight extends NamedNode {
   public DirectionalLight( ) {
      super();
   }
   public DirectionalLight(String val) {
      super(val);
   }
   public DirectionalLight(boolean val) {
      super(val);
   }

   public final DirectionalLight set_ambientIntensity(SFFloat val) {
      ambientIntensity_ = val;
      return this;
   };
   public final DirectionalLight set_ambientIntensity(double val0) {
      ambientIntensity_ = new SFFloat(val0);
      return this;
   };
   public final DirectionalLight set_ambientIntensity(String alias) {
      ambientIntensity_ = new Alias(alias);
      return this;
   };
   public final DirectionalLight set_color(SFColor val) {
      color_ = val;
      return this;
   };
   public final DirectionalLight set_color(double val0,double val1,double val2) {
      color_ = new SFColor(val0,val1,val2);
      return this;
   };
   public final DirectionalLight set_color(String alias) {
      color_ = new Alias(alias);
      return this;
   };
   public final DirectionalLight set_direction(SFVec3f val) {
      direction_ = val;
      return this;
   };
   public final DirectionalLight set_direction(double val0,double val1,double val2) {
      direction_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final DirectionalLight set_direction(String alias) {
      direction_ = new Alias(alias);
      return this;
   };
   public final DirectionalLight set_intensity(SFFloat val) {
      intensity_ = val;
      return this;
   };
   public final DirectionalLight set_intensity(double val0) {
      intensity_ = new SFFloat(val0);
      return this;
   };
   public final DirectionalLight set_intensity(String alias) {
      intensity_ = new Alias(alias);
      return this;
   };
   public final DirectionalLight set_on(SFBool val) {
      on_ = val;
      return this;
   };
   public final DirectionalLight set_on(boolean val0) {
      on_ = new SFBool(val0);
      return this;
   };
   public final DirectionalLight set_on(String alias) {
      on_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("DirectionalLight {\n");

      if (null != ambientIntensity_ &&
          ! ambientIntensity_.equals(ambientIntensityDefault_)) {
         sb.append(i(l + 1) + "ambientIntensity " + ambientIntensity_.codeString(l + 1) + "\n");
      }
      if (null != color_ &&
          ! color_.equals(colorDefault_)) {
         sb.append(i(l + 1) + "color " + color_.codeString(l + 1) + "\n");
      }
      if (null != direction_ &&
          ! direction_.equals(directionDefault_)) {
         sb.append(i(l + 1) + "direction " + direction_.codeString(l + 1) + "\n");
      }
      if (null != intensity_ &&
          ! intensity_.equals(intensityDefault_)) {
         sb.append(i(l + 1) + "intensity " + intensity_.codeString(l + 1) + "\n");
      }
      if (null != on_ &&
          ! on_.equals(onDefault_)) {
         sb.append(i(l + 1) + "on " + on_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value ambientIntensity_ = null;
   protected static final SFFloat ambientIntensityDefault_ = new SFFloat(0.0);
   protected Value color_ = null;
   protected static final SFColor colorDefault_ = new SFColor(1.0, 1.0, 1.0);
   protected Value direction_ = null;
   protected static final SFVec3f directionDefault_ = new SFVec3f(0.0, 0.0, -1.0);
   protected Value intensity_ = null;
   protected static final SFFloat intensityDefault_ = new SFFloat(1.0);
   protected Value on_ = null;
   protected static final SFBool onDefault_ = new SFBool(true);
}
