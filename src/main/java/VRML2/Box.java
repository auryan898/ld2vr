package VRML2;

import VRML2.VALUES.*;

public class Box extends NamedNode {
   public Box( ) {
      super();
   }
   public Box(String val) {
      super(val);
   }
   public Box(boolean val) {
      super(val);
   }

   public final Box set_size(SFVec3f val) {
      size_ = val;
      return this;
   };
   public final Box set_size(double val0,double val1,double val2) {
      size_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final Box set_size(String alias) {
      size_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Box {\n");

      if (null != size_ &&
          ! size_.equals(sizeDefault_)) {
         sb.append(i(l + 1) + "size " + size_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value size_ = null;
   protected static final SFVec3f sizeDefault_ = new SFVec3f(2.0, 2.0, 2.0);
}
