package VRML2;

import VRML2.VALUES.*;

public class CylinderSensor extends NamedNode {
   public CylinderSensor( ) {
      super();
   }
   public CylinderSensor(String val) {
      super(val);
   }
   public CylinderSensor(boolean val) {
      super(val);
   }

   public final CylinderSensor set_autoOffset(SFBool val) {
      autoOffset_ = val;
      return this;
   };
   public final CylinderSensor set_autoOffset(boolean val0) {
      autoOffset_ = new SFBool(val0);
      return this;
   };
   public final CylinderSensor set_autoOffset(String alias) {
      autoOffset_ = new Alias(alias);
      return this;
   };
   public final CylinderSensor set_diskAngle(SFFloat val) {
      diskAngle_ = val;
      return this;
   };
   public final CylinderSensor set_diskAngle(double val0) {
      diskAngle_ = new SFFloat(val0);
      return this;
   };
   public final CylinderSensor set_diskAngle(String alias) {
      diskAngle_ = new Alias(alias);
      return this;
   };
   public final CylinderSensor set_enabled(SFBool val) {
      enabled_ = val;
      return this;
   };
   public final CylinderSensor set_enabled(boolean val0) {
      enabled_ = new SFBool(val0);
      return this;
   };
   public final CylinderSensor set_enabled(String alias) {
      enabled_ = new Alias(alias);
      return this;
   };
   public final CylinderSensor set_maxAngle(SFFloat val) {
      maxAngle_ = val;
      return this;
   };
   public final CylinderSensor set_maxAngle(double val0) {
      maxAngle_ = new SFFloat(val0);
      return this;
   };
   public final CylinderSensor set_maxAngle(String alias) {
      maxAngle_ = new Alias(alias);
      return this;
   };
   public final CylinderSensor set_minAngle(SFFloat val) {
      minAngle_ = val;
      return this;
   };
   public final CylinderSensor set_minAngle(double val0) {
      minAngle_ = new SFFloat(val0);
      return this;
   };
   public final CylinderSensor set_minAngle(String alias) {
      minAngle_ = new Alias(alias);
      return this;
   };
   public final CylinderSensor set_offset(SFFloat val) {
      offset_ = val;
      return this;
   };
   public final CylinderSensor set_offset(double val0) {
      offset_ = new SFFloat(val0);
      return this;
   };
   public final CylinderSensor set_offset(String alias) {
      offset_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("CylinderSensor {\n");

      if (null != autoOffset_ &&
          ! autoOffset_.equals(autoOffsetDefault_)) {
         sb.append(i(l + 1) + "autoOffset " + autoOffset_.codeString(l + 1) + "\n");
      }
      if (null != diskAngle_ &&
          ! diskAngle_.equals(diskAngleDefault_)) {
         sb.append(i(l + 1) + "diskAngle " + diskAngle_.codeString(l + 1) + "\n");
      }
      if (null != enabled_ &&
          ! enabled_.equals(enabledDefault_)) {
         sb.append(i(l + 1) + "enabled " + enabled_.codeString(l + 1) + "\n");
      }
      if (null != maxAngle_ &&
          ! maxAngle_.equals(maxAngleDefault_)) {
         sb.append(i(l + 1) + "maxAngle " + maxAngle_.codeString(l + 1) + "\n");
      }
      if (null != minAngle_ &&
          ! minAngle_.equals(minAngleDefault_)) {
         sb.append(i(l + 1) + "minAngle " + minAngle_.codeString(l + 1) + "\n");
      }
      if (null != offset_ &&
          ! offset_.equals(offsetDefault_)) {
         sb.append(i(l + 1) + "offset " + offset_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value autoOffset_ = null;
   protected static final SFBool autoOffsetDefault_ = new SFBool(true);
   protected Value diskAngle_ = null;
   protected static final SFFloat diskAngleDefault_ = new SFFloat(0.262);
   protected Value enabled_ = null;
   protected static final SFBool enabledDefault_ = new SFBool(true);
   protected Value maxAngle_ = null;
   protected static final SFFloat maxAngleDefault_ = new SFFloat(-1.0);
   protected Value minAngle_ = null;
   protected static final SFFloat minAngleDefault_ = new SFFloat(0.0);
   protected Value offset_ = null;
   protected static final SFFloat offsetDefault_ = new SFFloat(0.0);
}
