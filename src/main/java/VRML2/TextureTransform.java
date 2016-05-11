package VRML2;

import VRML2.VALUES.*;

public class TextureTransform extends NamedNode {
   public TextureTransform( ) {
      super();
   }
   public TextureTransform(String val) {
      super(val);
   }
   public TextureTransform(boolean val) {
      super(val);
   }

   public final TextureTransform set_center(SFVec2f val) {
      center_ = val;
      return this;
   };
   public final TextureTransform set_center(double val0,double val1) {
      center_ = new SFVec2f(val0,val1);
      return this;
   };
   public final TextureTransform set_center(String alias) {
      center_ = new Alias(alias);
      return this;
   };
   public final TextureTransform set_rotation(SFFloat val) {
      rotation_ = val;
      return this;
   };
   public final TextureTransform set_rotation(double val0) {
      rotation_ = new SFFloat(val0);
      return this;
   };
   public final TextureTransform set_rotation(String alias) {
      rotation_ = new Alias(alias);
      return this;
   };
   public final TextureTransform set_scale(SFVec2f val) {
      scale_ = val;
      return this;
   };
   public final TextureTransform set_scale(double val0,double val1) {
      scale_ = new SFVec2f(val0,val1);
      return this;
   };
   public final TextureTransform set_scale(String alias) {
      scale_ = new Alias(alias);
      return this;
   };
   public final TextureTransform set_translation(SFVec2f val) {
      translation_ = val;
      return this;
   };
   public final TextureTransform set_translation(double val0,double val1) {
      translation_ = new SFVec2f(val0,val1);
      return this;
   };
   public final TextureTransform set_translation(String alias) {
      translation_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("TextureTransform {\n");

      if (null != center_ &&
          ! center_.equals(centerDefault_)) {
         sb.append(i(l + 1) + "center " + center_.codeString(l + 1) + "\n");
      }
      if (null != rotation_ &&
          ! rotation_.equals(rotationDefault_)) {
         sb.append(i(l + 1) + "rotation " + rotation_.codeString(l + 1) + "\n");
      }
      if (null != scale_ &&
          ! scale_.equals(scaleDefault_)) {
         sb.append(i(l + 1) + "scale " + scale_.codeString(l + 1) + "\n");
      }
      if (null != translation_ &&
          ! translation_.equals(translationDefault_)) {
         sb.append(i(l + 1) + "translation " + translation_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value center_ = null;
   protected static final SFVec2f centerDefault_ = new SFVec2f(0.0, 0.0);
   protected Value rotation_ = null;
   protected static final SFFloat rotationDefault_ = new SFFloat(0.0);
   protected Value scale_ = null;
   protected static final SFVec2f scaleDefault_ = new SFVec2f(1.0, 1.0);
   protected Value translation_ = null;
   protected static final SFVec2f translationDefault_ = new SFVec2f(0.0, 0.0);
}
