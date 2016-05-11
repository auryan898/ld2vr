package VRML2;

import VRML2.VALUES.*;

public class Normal extends NamedNode {
   public Normal( ) {
      super();
   }
   public Normal(String val) {
      super(val);
   }
   public Normal(boolean val) {
      super(val);
   }

   public final MFVec3f add_vector(SFVec3f val) {
      return ((MFVec3f)vector_).add(val);
   };
   public final MFVec3f add_vector(double val0,double val1,double val2) {
      return ((MFVec3f)vector_).add(val0,val1,val2);
   };
   public final Normal set_vector(MFVec3f val) {
      vector_ = val;
      return this;
   };
   public final Normal set_vector(String alias) {
      vector_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Normal {\n");

      if (null != vector_ &&
          ! vector_.equals(vectorDefault_)) {
         sb.append(i(l + 1) + "vector " + vector_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value vector_ = new MFVec3f();
   protected static final MFVec3f vectorDefault_ = new VRML2.VALUES.MFVec3f();
}
