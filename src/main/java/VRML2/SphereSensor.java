package VRML2;

import VRML2.VALUES.*;

public class SphereSensor extends NamedNode {
   public SphereSensor( ) {
      super();
   }
   public SphereSensor(String val) {
      super(val);
   }
   public SphereSensor(boolean val) {
      super(val);
   }

   public final SphereSensor set_autoOffset(SFBool val) {
      autoOffset_ = val;
      return this;
   };
   public final SphereSensor set_autoOffset(boolean val0) {
      autoOffset_ = new SFBool(val0);
      return this;
   };
   public final SphereSensor set_autoOffset(String alias) {
      autoOffset_ = new Alias(alias);
      return this;
   };
   public final SphereSensor set_enabled(SFBool val) {
      enabled_ = val;
      return this;
   };
   public final SphereSensor set_enabled(boolean val0) {
      enabled_ = new SFBool(val0);
      return this;
   };
   public final SphereSensor set_enabled(String alias) {
      enabled_ = new Alias(alias);
      return this;
   };
   public final SphereSensor set_offset(SFRotation val) {
      offset_ = val;
      return this;
   };
   public final SphereSensor set_offset(double val0,double val1,double val2,double val3) {
      offset_ = new SFRotation(val0,val1,val2,val3);
      return this;
   };
   public final SphereSensor set_offset(String alias) {
      offset_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("SphereSensor {\n");

      if (null != autoOffset_ &&
          ! autoOffset_.equals(autoOffsetDefault_)) {
         sb.append(i(l + 1) + "autoOffset " + autoOffset_.codeString(l + 1) + "\n");
      }
      if (null != enabled_ &&
          ! enabled_.equals(enabledDefault_)) {
         sb.append(i(l + 1) + "enabled " + enabled_.codeString(l + 1) + "\n");
      }
      if (null != offset_ &&
          ! offset_.equals(offsetDefault_)) {
         sb.append(i(l + 1) + "offset " + offset_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value autoOffset_ = null;
   protected static final SFBool autoOffsetDefault_ = new SFBool(true);
   protected Value enabled_ = null;
   protected static final SFBool enabledDefault_ = new SFBool(true);
   protected Value offset_ = null;
   protected static final SFRotation offsetDefault_ = new SFRotation(0.0, 1.0, 0.0, 0.0);
}
