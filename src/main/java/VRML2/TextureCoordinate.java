package VRML2;

import VRML2.VALUES.*;

public class TextureCoordinate extends NamedNode {
   public TextureCoordinate( ) {
      super();
   }
   public TextureCoordinate(String val) {
      super(val);
   }
   public TextureCoordinate(boolean val) {
      super(val);
   }

   public final MFVec2f add_point(SFVec2f val) {
      return ((MFVec2f)point_).add(val);
   };
   public final MFVec2f add_point(double val0,double val1) {
      return ((MFVec2f)point_).add(val0,val1);
   };
   public final TextureCoordinate set_point(MFVec2f val) {
      point_ = val;
      return this;
   };
   public final TextureCoordinate set_point(String alias) {
      point_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("TextureCoordinate {\n");

      if (null != point_ &&
          ! point_.equals(pointDefault_)) {
         sb.append(i(l + 1) + "point " + point_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value point_ = new MFVec2f();
   protected static final MFVec2f pointDefault_ = new VRML2.VALUES.MFVec2f();
}
