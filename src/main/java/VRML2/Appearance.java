package VRML2;

import VRML2.VALUES.*;

public class Appearance extends NamedNode {
   public Appearance( ) {
      super();
   }
   public Appearance(String val) {
      super(val);
   }
   public Appearance(boolean val) {
      super(val);
   }

   public final Appearance set_material(SFNode val) {
      material_ = val;
      return this;
   };
   public final Appearance set_material(VRML2.VRML2Node val0) {
      material_ = new SFNode(val0);
      return this;
   };
   public final Appearance set_material(String alias) {
      material_ = new Alias(alias);
      return this;
   };
   public final Appearance set_texture(SFNode val) {
      texture_ = val;
      return this;
   };
   public final Appearance set_texture(VRML2.VRML2Node val0) {
      texture_ = new SFNode(val0);
      return this;
   };
   public final Appearance set_texture(String alias) {
      texture_ = new Alias(alias);
      return this;
   };
   public final Appearance set_textureTransform(SFNode val) {
      textureTransform_ = val;
      return this;
   };
   public final Appearance set_textureTransform(VRML2.VRML2Node val0) {
      textureTransform_ = new SFNode(val0);
      return this;
   };
   public final Appearance set_textureTransform(String alias) {
      textureTransform_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Appearance {\n");

      if (null != material_ &&
          ! material_.equals(materialDefault_)) {
         sb.append(i(l + 1) + "material " + material_.codeString(l + 1) + "\n");
      }
      if (null != texture_ &&
          ! texture_.equals(textureDefault_)) {
         sb.append(i(l + 1) + "texture " + texture_.codeString(l + 1) + "\n");
      }
      if (null != textureTransform_ &&
          ! textureTransform_.equals(textureTransformDefault_)) {
         sb.append(i(l + 1) + "textureTransform " + textureTransform_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value material_ = null;
   protected static final SFNode materialDefault_ = new SFNode();
   protected Value texture_ = null;
   protected static final SFNode textureDefault_ = new SFNode();
   protected Value textureTransform_ = null;
   protected static final SFNode textureTransformDefault_ = new SFNode();
}
