package VRML2;

import VRML2.VALUES.*;

public class Color extends NamedNode {
   public Color( ) {
      super();
   }
   public Color(String val) {
      super(val);
   }
   public Color(boolean val) {
      super(val);
   }

   public final MFColor add_color(SFColor val) {
      return ((MFColor)color_).add(val);
   };
   public final MFColor add_color(double val0,double val1,double val2) {
      return ((MFColor)color_).add(val0,val1,val2);
   };
   public final Color set_color(MFColor val) {
      color_ = val;
      return this;
   };
   public final Color set_color(String alias) {
      color_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Color {\n");

      if (null != color_ &&
          ! color_.equals(colorDefault_)) {
         sb.append(i(l + 1) + "color " + color_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value color_ = new MFColor();
   protected static final MFColor colorDefault_ = new VRML2.VALUES.MFColor();
}
