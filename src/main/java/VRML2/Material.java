package VRML2;

import VRML2.VALUES.*;

public class Material extends NamedNode {
   public Material( ) {
      super();
   }
   public Material(String val) {
      super(val);
   }
   public Material(boolean val) {
      super(val);
   }

   public final Material set_ambientIntensity(SFFloat val) {
      ambientIntensity_ = val;
      return this;
   };
   public final Material set_ambientIntensity(double val0) {
      ambientIntensity_ = new SFFloat(val0);
      return this;
   };
   public final Material set_ambientIntensity(String alias) {
      ambientIntensity_ = new Alias(alias);
      return this;
   };
   public final Material set_diffuseColor(SFColor val) {
      diffuseColor_ = val;
      return this;
   };
   public final Material set_diffuseColor(double val0,double val1,double val2) {
      diffuseColor_ = new SFColor(val0,val1,val2);
      return this;
   };
   public final Material set_diffuseColor(String alias) {
      diffuseColor_ = new Alias(alias);
      return this;
   };
   public final Material set_emissiveColor(SFColor val) {
      emissiveColor_ = val;
      return this;
   };
   public final Material set_emissiveColor(double val0,double val1,double val2) {
      emissiveColor_ = new SFColor(val0,val1,val2);
      return this;
   };
   public final Material set_emissiveColor(String alias) {
      emissiveColor_ = new Alias(alias);
      return this;
   };
   public final Material set_shininess(SFFloat val) {
      shininess_ = val;
      return this;
   };
   public final Material set_shininess(double val0) {
      shininess_ = new SFFloat(val0);
      return this;
   };
   public final Material set_shininess(String alias) {
      shininess_ = new Alias(alias);
      return this;
   };
   public final Material set_specularColor(SFColor val) {
      specularColor_ = val;
      return this;
   };
   public final Material set_specularColor(double val0,double val1,double val2) {
      specularColor_ = new SFColor(val0,val1,val2);
      return this;
   };
   public final Material set_specularColor(String alias) {
      specularColor_ = new Alias(alias);
      return this;
   };
   public final Material set_transparency(SFFloat val) {
      transparency_ = val;
      return this;
   };
   public final Material set_transparency(double val0) {
      transparency_ = new SFFloat(val0);
      return this;
   };
   public final Material set_transparency(String alias) {
      transparency_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Material {\n");

      if (null != ambientIntensity_ &&
          ! ambientIntensity_.equals(ambientIntensityDefault_)) {
         sb.append(i(l + 1) + "ambientIntensity " + ambientIntensity_.codeString(l + 1) + "\n");
      }
      if (null != diffuseColor_ &&
          ! diffuseColor_.equals(diffuseColorDefault_)) {
         sb.append(i(l + 1) + "diffuseColor " + diffuseColor_.codeString(l + 1) + "\n");
      }
      if (null != emissiveColor_ &&
          ! emissiveColor_.equals(emissiveColorDefault_)) {
         sb.append(i(l + 1) + "emissiveColor " + emissiveColor_.codeString(l + 1) + "\n");
      }
      if (null != shininess_ &&
          ! shininess_.equals(shininessDefault_)) {
         sb.append(i(l + 1) + "shininess " + shininess_.codeString(l + 1) + "\n");
      }
      if (null != specularColor_ &&
          ! specularColor_.equals(specularColorDefault_)) {
         sb.append(i(l + 1) + "specularColor " + specularColor_.codeString(l + 1) + "\n");
      }
      if (null != transparency_ &&
          ! transparency_.equals(transparencyDefault_)) {
         sb.append(i(l + 1) + "transparency " + transparency_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value ambientIntensity_ = null;
   protected static final SFFloat ambientIntensityDefault_ = new SFFloat(0.2);
   protected Value diffuseColor_ = null;
   protected static final SFColor diffuseColorDefault_ = new SFColor(0.8, 0.8, 0.8);
   protected Value emissiveColor_ = null;
   protected static final SFColor emissiveColorDefault_ = new SFColor(0.0, 0.0, 0.0);
   protected Value shininess_ = null;
   protected static final SFFloat shininessDefault_ = new SFFloat(0.2);
   protected Value specularColor_ = null;
   protected static final SFColor specularColorDefault_ = new SFColor(0.0, 0.0, 0.0);
   protected Value transparency_ = null;
   protected static final SFFloat transparencyDefault_ = new SFFloat(0.0);
}
