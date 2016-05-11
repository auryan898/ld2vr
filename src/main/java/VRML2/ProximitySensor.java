package VRML2;

import VRML2.VALUES.*;

public class ProximitySensor extends NamedNode {
   public ProximitySensor( ) {
      super();
   }
   public ProximitySensor(String val) {
      super(val);
   }
   public ProximitySensor(boolean val) {
      super(val);
   }

   public final ProximitySensor set_center(SFVec3f val) {
      center_ = val;
      return this;
   };
   public final ProximitySensor set_center(double val0,double val1,double val2) {
      center_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final ProximitySensor set_center(String alias) {
      center_ = new Alias(alias);
      return this;
   };
   public final ProximitySensor set_size(SFVec3f val) {
      size_ = val;
      return this;
   };
   public final ProximitySensor set_size(double val0,double val1,double val2) {
      size_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final ProximitySensor set_size(String alias) {
      size_ = new Alias(alias);
      return this;
   };
   public final ProximitySensor set_enabled(SFBool val) {
      enabled_ = val;
      return this;
   };
   public final ProximitySensor set_enabled(boolean val0) {
      enabled_ = new SFBool(val0);
      return this;
   };
   public final ProximitySensor set_enabled(String alias) {
      enabled_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("ProximitySensor {\n");

      if (null != center_ &&
          ! center_.equals(centerDefault_)) {
         sb.append(i(l + 1) + "center " + center_.codeString(l + 1) + "\n");
      }
      if (null != size_ &&
          ! size_.equals(sizeDefault_)) {
         sb.append(i(l + 1) + "size " + size_.codeString(l + 1) + "\n");
      }
      if (null != enabled_ &&
          ! enabled_.equals(enabledDefault_)) {
         sb.append(i(l + 1) + "enabled " + enabled_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value center_ = null;
   protected static final SFVec3f centerDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value size_ = null;
   protected static final SFVec3f sizeDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value enabled_ = null;
   protected static final SFBool enabledDefault_ = new SFBool(true);
}
