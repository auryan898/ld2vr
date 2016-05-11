package VRML2;

import VRML2.VALUES.*;

public class PlaneSensor extends NamedNode {
   public PlaneSensor( ) {
      super();
   }
   public PlaneSensor(String val) {
      super(val);
   }
   public PlaneSensor(boolean val) {
      super(val);
   }

   public final PlaneSensor set_autoOffset(SFBool val) {
      autoOffset_ = val;
      return this;
   };
   public final PlaneSensor set_autoOffset(boolean val0) {
      autoOffset_ = new SFBool(val0);
      return this;
   };
   public final PlaneSensor set_autoOffset(String alias) {
      autoOffset_ = new Alias(alias);
      return this;
   };
   public final PlaneSensor set_enabled(SFBool val) {
      enabled_ = val;
      return this;
   };
   public final PlaneSensor set_enabled(boolean val0) {
      enabled_ = new SFBool(val0);
      return this;
   };
   public final PlaneSensor set_enabled(String alias) {
      enabled_ = new Alias(alias);
      return this;
   };
   public final PlaneSensor set_maxPosition(SFVec2f val) {
      maxPosition_ = val;
      return this;
   };
   public final PlaneSensor set_maxPosition(double val0,double val1) {
      maxPosition_ = new SFVec2f(val0,val1);
      return this;
   };
   public final PlaneSensor set_maxPosition(String alias) {
      maxPosition_ = new Alias(alias);
      return this;
   };
   public final PlaneSensor set_minPosition(SFVec2f val) {
      minPosition_ = val;
      return this;
   };
   public final PlaneSensor set_minPosition(double val0,double val1) {
      minPosition_ = new SFVec2f(val0,val1);
      return this;
   };
   public final PlaneSensor set_minPosition(String alias) {
      minPosition_ = new Alias(alias);
      return this;
   };
   public final PlaneSensor set_offset(SFVec3f val) {
      offset_ = val;
      return this;
   };
   public final PlaneSensor set_offset(double val0,double val1,double val2) {
      offset_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final PlaneSensor set_offset(String alias) {
      offset_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("PlaneSensor {\n");

      if (null != autoOffset_ &&
          ! autoOffset_.equals(autoOffsetDefault_)) {
         sb.append(i(l + 1) + "autoOffset " + autoOffset_.codeString(l + 1) + "\n");
      }
      if (null != enabled_ &&
          ! enabled_.equals(enabledDefault_)) {
         sb.append(i(l + 1) + "enabled " + enabled_.codeString(l + 1) + "\n");
      }
      if (null != maxPosition_ &&
          ! maxPosition_.equals(maxPositionDefault_)) {
         sb.append(i(l + 1) + "maxPosition " + maxPosition_.codeString(l + 1) + "\n");
      }
      if (null != minPosition_ &&
          ! minPosition_.equals(minPositionDefault_)) {
         sb.append(i(l + 1) + "minPosition " + minPosition_.codeString(l + 1) + "\n");
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
   protected Value maxPosition_ = null;
   protected static final SFVec2f maxPositionDefault_ = new SFVec2f(-1.0, -1.0);
   protected Value minPosition_ = null;
   protected static final SFVec2f minPositionDefault_ = new SFVec2f(0.0, 0.0);
   protected Value offset_ = null;
   protected static final SFVec3f offsetDefault_ = new SFVec3f(0.0, 0.0, 0.0);
}
