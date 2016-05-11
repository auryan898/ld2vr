package VRML2;

import VRML2.VALUES.*;

public class Sphere extends NamedNode {
   public Sphere( ) {
      super();
   }
   public Sphere(String val) {
      super(val);
   }
   public Sphere(boolean val) {
      super(val);
   }

   public final Sphere set_radius(SFFloat val) {
      radius_ = val;
      return this;
   };
   public final Sphere set_radius(double val0) {
      radius_ = new SFFloat(val0);
      return this;
   };
   public final Sphere set_radius(String alias) {
      radius_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Sphere {\n");

      if (null != radius_ &&
          ! radius_.equals(radiusDefault_)) {
         sb.append(i(l + 1) + "radius " + radius_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value radius_ = null;
   protected static final SFFloat radiusDefault_ = new SFFloat(1.0);
}
