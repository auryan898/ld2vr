package VRML2;

import VRML2.VALUES.*;

public class ScalarInterpolator extends NamedNode {
   public ScalarInterpolator( ) {
      super();
   }
   public ScalarInterpolator(String val) {
      super(val);
   }
   public ScalarInterpolator(boolean val) {
      super(val);
   }

   public final MFFloat add_key(SFFloat val) {
      return ((MFFloat)key_).add(val);
   };
   public final MFFloat add_key(double val0) {
      return ((MFFloat)key_).add(val0);
   };
   public final ScalarInterpolator set_key(MFFloat val) {
      key_ = val;
      return this;
   };
   public final ScalarInterpolator set_key(String alias) {
      key_ = new Alias(alias);
      return this;
   };
   public final MFFloat add_keyValue(SFFloat val) {
      return ((MFFloat)keyValue_).add(val);
   };
   public final MFFloat add_keyValue(double val0) {
      return ((MFFloat)keyValue_).add(val0);
   };
   public final ScalarInterpolator set_keyValue(MFFloat val) {
      keyValue_ = val;
      return this;
   };
   public final ScalarInterpolator set_keyValue(String alias) {
      keyValue_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("ScalarInterpolator {\n");

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
   protected Value keyValue_ = new MFFloat();
   protected static final MFFloat keyValueDefault_ = new VRML2.VALUES.MFFloat();
}
