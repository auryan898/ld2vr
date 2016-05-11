package VRML2;

import VRML2.VALUES.*;

public class CoordinateInterpolator extends NamedNode {
   public CoordinateInterpolator( ) {
      super();
   }
   public CoordinateInterpolator(String val) {
      super(val);
   }
   public CoordinateInterpolator(boolean val) {
      super(val);
   }

   public final MFFloat add_key(SFFloat val) {
      return ((MFFloat)key_).add(val);
   };
   public final MFFloat add_key(double val0) {
      return ((MFFloat)key_).add(val0);
   };
   public final CoordinateInterpolator set_key(MFFloat val) {
      key_ = val;
      return this;
   };
   public final CoordinateInterpolator set_key(String alias) {
      key_ = new Alias(alias);
      return this;
   };
   public final MFVec3f add_keyValue(SFVec3f val) {
      return ((MFVec3f)keyValue_).add(val);
   };
   public final MFVec3f add_keyValue(double val0,double val1,double val2) {
      return ((MFVec3f)keyValue_).add(val0,val1,val2);
   };
   public final CoordinateInterpolator set_keyValue(MFVec3f val) {
      keyValue_ = val;
      return this;
   };
   public final CoordinateInterpolator set_keyValue(String alias) {
      keyValue_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("CoordinateInterpolator {\n");

      if (null != key_ &&
          ! key_.equals(keyDefault_)) {
         sb.append(i(l + 1) + "key " + key_.codeString(l + 1) + "\n");
      }
      if (null != keyValue_ &&
          ! keyValue_.equals(keyValueDefault_)) {
         sb.append(i(l + 1) + "keyValue " + keyValue_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value key_ = new MFFloat();
   protected static final MFFloat keyDefault_ = new VRML2.VALUES.MFFloat();
   protected Value keyValue_ = new MFVec3f();
   protected static final MFVec3f keyValueDefault_ = new VRML2.VALUES.MFVec3f();
}
