package VRML2;

import VRML2.VALUES.*;

public class LOD extends NamedNode {
   public LOD( ) {
      super();
   }
   public LOD(String val) {
      super(val);
   }
   public LOD(boolean val) {
      super(val);
   }

   public final MFNode add_level(SFNode val) {
      return ((MFNode)level_).add(val);
   };
   public final MFNode add_level(VRML2.VRML2Node val0) {
      return ((MFNode)level_).add(val0);
   };
   public final LOD set_level(MFNode val) {
      level_ = val;
      return this;
   };
   public final LOD set_level(String alias) {
      level_ = new Alias(alias);
      return this;
   };
   public final LOD set_center(SFVec3f val) {
      center_ = val;
      return this;
   };
   public final LOD set_center(double val0,double val1,double val2) {
      center_ = new SFVec3f(val0,val1,val2);
      return this;
   };
   public final LOD set_center(String alias) {
      center_ = new Alias(alias);
      return this;
   };
   public final MFFloat add_range(SFFloat val) {
      return ((MFFloat)range_).add(val);
   };
   public final MFFloat add_range(double val0) {
      return ((MFFloat)range_).add(val0);
   };
   public final LOD set_range(MFFloat val) {
      range_ = val;
      return this;
   };
   public final LOD set_range(String alias) {
      range_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("LOD {\n");

      if (null != level_ &&
          ! level_.equals(levelDefault_)) {
         sb.append(i(l + 1) + "level " + level_.codeString(l + 1) + "\n");
      }
      if (null != center_ &&
          ! center_.equals(centerDefault_)) {
         sb.append(i(l + 1) + "center " + center_.codeString(l + 1) + "\n");
      }
      if (null != range_ &&
          ! range_.equals(rangeDefault_)) {
         sb.append(i(l + 1) + "range " + range_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value level_ = new MFNode();
   protected static final MFNode levelDefault_ = new VRML2.VALUES.MFNode();
   protected Value center_ = null;
   protected static final SFVec3f centerDefault_ = new SFVec3f(0.0, 0.0, 0.0);
   protected Value range_ = new MFFloat();
   protected static final MFFloat rangeDefault_ = new VRML2.VALUES.MFFloat();
}
