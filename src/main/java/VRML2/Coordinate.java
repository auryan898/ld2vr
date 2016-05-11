package VRML2;

import VRML2.VALUES.*;

public class Coordinate extends NamedNode {
   public Coordinate( ) {
      super();
   }
   public Coordinate(String val) {
      super(val);
   }
   public Coordinate(boolean val) {
      super(val);
   }

   public final MFVec3f add_point(SFVec3f val) {
      return ((MFVec3f)point_).add(val);
   };
   public final MFVec3f add_point(double val0,double val1,double val2) {
      return ((MFVec3f)point_).add(val0,val1,val2);
   };
   public final Coordinate set_point(MFVec3f val) {
      point_ = val;
      return this;
   };
   public final Coordinate set_point(String alias) {
      point_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Coordinate {\n");

      if (null != point_ &&
          ! point_.equals(pointDefault_)) {
         sb.append(i(l + 1) + "point " + point_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value point_ = new MFVec3f();
   protected static final MFVec3f pointDefault_ = new VRML2.VALUES.MFVec3f();
}
