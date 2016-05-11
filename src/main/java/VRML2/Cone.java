package VRML2;

import VRML2.VALUES.*;

public class Cone extends NamedNode {
   public Cone( ) {
      super();
   }
   public Cone(String val) {
      super(val);
   }
   public Cone(boolean val) {
      super(val);
   }

   public final Cone set_bottomRadius(SFFloat val) {
      bottomRadius_ = val;
      return this;
   };
   public final Cone set_bottomRadius(double val0) {
      bottomRadius_ = new SFFloat(val0);
      return this;
   };
   public final Cone set_bottomRadius(String alias) {
      bottomRadius_ = new Alias(alias);
      return this;
   };
   public final Cone set_height(SFFloat val) {
      height_ = val;
      return this;
   };
   public final Cone set_height(double val0) {
      height_ = new SFFloat(val0);
      return this;
   };
   public final Cone set_height(String alias) {
      height_ = new Alias(alias);
      return this;
   };
   public final Cone set_side(SFBool val) {
      side_ = val;
      return this;
   };
   public final Cone set_side(boolean val0) {
      side_ = new SFBool(val0);
      return this;
   };
   public final Cone set_side(String alias) {
      side_ = new Alias(alias);
      return this;
   };
   public final Cone set_bottom(SFBool val) {
      bottom_ = val;
      return this;
   };
   public final Cone set_bottom(boolean val0) {
      bottom_ = new SFBool(val0);
      return this;
   };
   public final Cone set_bottom(String alias) {
      bottom_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Cone {\n");

      if (null != bottomRadius_ &&
          ! bottomRadius_.equals(bottomRadiusDefault_)) {
         sb.append(i(l + 1) + "bottomRadius " + bottomRadius_.codeString(l + 1) + "\n");
      }
      if (null != height_ &&
          ! height_.equals(heightDefault_)) {
         sb.append(i(l + 1) + "height " + height_.codeString(l + 1) + "\n");
      }
      if (null != side_ &&
          ! side_.equals(sideDefault_)) {
         sb.append(i(l + 1) + "side " + side_.codeString(l + 1) + "\n");
      }
      if (null != bottom_ &&
          ! bottom_.equals(bottomDefault_)) {
         sb.append(i(l + 1) + "bottom " + bottom_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value bottomRadius_ = null;
   protected static final SFFloat bottomRadiusDefault_ = new SFFloat(1.0);
   protected Value height_ = null;
   protected static final SFFloat heightDefault_ = new SFFloat(2.0);
   protected Value side_ = null;
   protected static final SFBool sideDefault_ = new SFBool(true);
   protected Value bottom_ = null;
   protected static final SFBool bottomDefault_ = new SFBool(true);
}
