package VRML2;

import VRML2.VALUES.*;

public class PointSet extends NamedNode {
   public PointSet( ) {
      super();
   }
   public PointSet(String val) {
      super(val);
   }
   public PointSet(boolean val) {
      super(val);
   }

   public final PointSet set_color(SFNode val) {
      color_ = val;
      return this;
   };
   public final PointSet set_color(VRML2.VRML2Node val0) {
      color_ = new SFNode(val0);
      return this;
   };
   public final PointSet set_color(String alias) {
      color_ = new Alias(alias);
      return this;
   };
   public final PointSet set_coord(SFNode val) {
      coord_ = val;
      return this;
   };
   public final PointSet set_coord(VRML2.VRML2Node val0) {
      coord_ = new SFNode(val0);
      return this;
   };
   public final PointSet set_coord(String alias) {
      coord_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("PointSet {\n");

      if (null != color_ &&
          ! color_.equals(colorDefault_)) {
         sb.append(i(l + 1) + "color " + color_.codeString(l + 1) + "\n");
      }
      if (null != coord_ &&
          ! coord_.equals(coordDefault_)) {
         sb.append(i(l + 1) + "coord " + coord_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value color_ = null;
   protected static final SFNode colorDefault_ = new SFNode();
   protected Value coord_ = null;
   protected static final SFNode coordDefault_ = new SFNode();
}
