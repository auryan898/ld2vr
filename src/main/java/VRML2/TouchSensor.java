package VRML2;

import VRML2.VALUES.*;

public class TouchSensor extends NamedNode {
   public TouchSensor( ) {
      super();
   }
   public TouchSensor(String val) {
      super(val);
   }
   public TouchSensor(boolean val) {
      super(val);
   }

   public final TouchSensor set_enabled(SFBool val) {
      enabled_ = val;
      return this;
   };
   public final TouchSensor set_enabled(boolean val0) {
      enabled_ = new SFBool(val0);
      return this;
   };
   public final TouchSensor set_enabled(String alias) {
      enabled_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("TouchSensor {\n");

      if (null != enabled_ &&
          ! enabled_.equals(enabledDefault_)) {
         sb.append(i(l + 1) + "enabled " + enabled_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value enabled_ = null;
   protected static final SFBool enabledDefault_ = new SFBool(true);
}
