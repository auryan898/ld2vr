package VRML2;

import VRML2.VALUES.*;

public class Shape extends NamedNode {
   public Shape( ) {
      super();
   }
   public Shape(String val) {
      super(val);
   }
   public Shape(boolean val) {
      super(val);
   }

   public final Shape set_appearance(SFNode val) {
      appearance_ = val;
      return this;
   };
   public final Shape set_appearance(VRML2.VRML2Node val0) {
      appearance_ = new SFNode(val0);
      return this;
   };
   public final Shape set_appearance(String alias) {
      appearance_ = new Alias(alias);
      return this;
   };
   public final Shape set_geometry(SFNode val) {
      geometry_ = val;
      return this;
   };
   public final Shape set_geometry(VRML2.VRML2Node val0) {
      geometry_ = new SFNode(val0);
      return this;
   };
   public final Shape set_geometry(String alias) {
      geometry_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Shape {\n");

      if (null != appearance_ &&
          ! appearance_.equals(appearanceDefault_)) {
         sb.append(i(l + 1) + "appearance " + appearance_.codeString(l + 1) + "\n");
      }
      if (null != geometry_ &&
          ! geometry_.equals(geometryDefault_)) {
         sb.append(i(l + 1) + "geometry " + geometry_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value appearance_ = null;
   protected static final SFNode appearanceDefault_ = new SFNode();
   protected Value geometry_ = null;
   protected static final SFNode geometryDefault_ = new SFNode();
}
