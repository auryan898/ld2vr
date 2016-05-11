package VRML2;

import VRML2.VALUES.*;

public class Fog extends NamedNode {
   public Fog( ) {
      super();
   }
   public Fog(String val) {
      super(val);
   }
   public Fog(boolean val) {
      super(val);
   }

   public final Fog set_color(SFColor val) {
      color_ = val;
      return this;
   };
   public final Fog set_color(double val0,double val1,double val2) {
      color_ = new SFColor(val0,val1,val2);
      return this;
   };
   public final Fog set_color(String alias) {
      color_ = new Alias(alias);
      return this;
   };
   public final Fog set_fogType(SFString val) {
      fogType_ = val;
      return this;
   };
   public final Fog set_fogType(String alias) {
      fogType_ = new Alias(alias);
      return this;
   };
   public final Fog set_visibilityRange(SFFloat val) {
      visibilityRange_ = val;
      return this;
   };
   public final Fog set_visibilityRange(double val0) {
      visibilityRange_ = new SFFloat(val0);
      return this;
   };
   public final Fog set_visibilityRange(String alias) {
      visibilityRange_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Fog {\n");

      if (null != color_ &&
          ! color_.equals(colorDefault_)) {
         sb.append(i(l + 1) + "color " + color_.codeString(l + 1) + "\n");
      }
      if (null != fogType_ &&
          ! fogType_.equals(fogTypeDefault_)) {
         sb.append(i(l + 1) + "fogType " + fogType_.codeString(l + 1) + "\n");
      }
      if (null != visibilityRange_ &&
          ! visibilityRange_.equals(visibilityRangeDefault_)) {
         sb.append(i(l + 1) + "visibilityRange " + visibilityRange_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value color_ = null;
   protected static final SFColor colorDefault_ = new SFColor(1.0, 1.0, 1.0);
   protected Value fogType_ = null;
   protected static final SFString fogTypeDefault_ = new SFString("LINEAR");
   protected Value visibilityRange_ = null;
   protected static final SFFloat visibilityRangeDefault_ = new SFFloat(0.0);
}
