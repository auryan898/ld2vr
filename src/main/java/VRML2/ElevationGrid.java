package VRML2;

import VRML2.VALUES.*;

public class ElevationGrid extends NamedNode {
   public ElevationGrid( ) {
      super();
   }
   public ElevationGrid(String val) {
      super(val);
   }
   public ElevationGrid(boolean val) {
      super(val);
   }

   public final ElevationGrid set_color(SFNode val) {
      color_ = val;
      return this;
   };
   public final ElevationGrid set_color(VRML2.VRML2Node val0) {
      color_ = new SFNode(val0);
      return this;
   };
   public final ElevationGrid set_color(String alias) {
      color_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_normal(SFNode val) {
      normal_ = val;
      return this;
   };
   public final ElevationGrid set_normal(VRML2.VRML2Node val0) {
      normal_ = new SFNode(val0);
      return this;
   };
   public final ElevationGrid set_normal(String alias) {
      normal_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_texCoord(SFNode val) {
      texCoord_ = val;
      return this;
   };
   public final ElevationGrid set_texCoord(VRML2.VRML2Node val0) {
      texCoord_ = new SFNode(val0);
      return this;
   };
   public final ElevationGrid set_texCoord(String alias) {
      texCoord_ = new Alias(alias);
      return this;
   };
   public final MFFloat add_height(SFFloat val) {
      return ((MFFloat)height_).add(val);
   };
   public final MFFloat add_height(double val0) {
      return ((MFFloat)height_).add(val0);
   };
   public final ElevationGrid set_height(MFFloat val) {
      height_ = val;
      return this;
   };
   public final ElevationGrid set_height(String alias) {
      height_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_ccw(SFBool val) {
      ccw_ = val;
      return this;
   };
   public final ElevationGrid set_ccw(boolean val0) {
      ccw_ = new SFBool(val0);
      return this;
   };
   public final ElevationGrid set_ccw(String alias) {
      ccw_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_colorPerVertex(SFBool val) {
      colorPerVertex_ = val;
      return this;
   };
   public final ElevationGrid set_colorPerVertex(boolean val0) {
      colorPerVertex_ = new SFBool(val0);
      return this;
   };
   public final ElevationGrid set_colorPerVertex(String alias) {
      colorPerVertex_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_creaseAngle(SFFloat val) {
      creaseAngle_ = val;
      return this;
   };
   public final ElevationGrid set_creaseAngle(double val0) {
      creaseAngle_ = new SFFloat(val0);
      return this;
   };
   public final ElevationGrid set_creaseAngle(String alias) {
      creaseAngle_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_normalPerVertex(SFBool val) {
      normalPerVertex_ = val;
      return this;
   };
   public final ElevationGrid set_normalPerVertex(boolean val0) {
      normalPerVertex_ = new SFBool(val0);
      return this;
   };
   public final ElevationGrid set_normalPerVertex(String alias) {
      normalPerVertex_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_solid(SFBool val) {
      solid_ = val;
      return this;
   };
   public final ElevationGrid set_solid(boolean val0) {
      solid_ = new SFBool(val0);
      return this;
   };
   public final ElevationGrid set_solid(String alias) {
      solid_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_xDimension(SFInt32 val) {
      xDimension_ = val;
      return this;
   };
   public final ElevationGrid set_xDimension(int val0) {
      xDimension_ = new SFInt32(val0);
      return this;
   };
   public final ElevationGrid set_xDimension(String alias) {
      xDimension_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_xSpacing(SFFloat val) {
      xSpacing_ = val;
      return this;
   };
   public final ElevationGrid set_xSpacing(double val0) {
      xSpacing_ = new SFFloat(val0);
      return this;
   };
   public final ElevationGrid set_xSpacing(String alias) {
      xSpacing_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_zDimension(SFInt32 val) {
      zDimension_ = val;
      return this;
   };
   public final ElevationGrid set_zDimension(int val0) {
      zDimension_ = new SFInt32(val0);
      return this;
   };
   public final ElevationGrid set_zDimension(String alias) {
      zDimension_ = new Alias(alias);
      return this;
   };
   public final ElevationGrid set_zSpacing(SFFloat val) {
      zSpacing_ = val;
      return this;
   };
   public final ElevationGrid set_zSpacing(double val0) {
      zSpacing_ = new SFFloat(val0);
      return this;
   };
   public final ElevationGrid set_zSpacing(String alias) {
      zSpacing_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("ElevationGrid {\n");

      if (null != color_ &&
          ! color_.equals(colorDefault_)) {
         sb.append(i(l + 1) + "color " + color_.codeString(l + 1) + "\n");
      }
      if (null != normal_ &&
          ! normal_.equals(normalDefault_)) {
         sb.append(i(l + 1) + "normal " + normal_.codeString(l + 1) + "\n");
      }
      if (null != texCoord_ &&
          ! texCoord_.equals(texCoordDefault_)) {
         sb.append(i(l + 1) + "texCoord " + texCoord_.codeString(l + 1) + "\n");
      }
      if (null != height_ &&
          ! height_.equals(heightDefault_)) {
         sb.append(i(l + 1) + "height " + height_.codeString(l + 1) + "\n");
      }
      if (null != ccw_ &&
          ! ccw_.equals(ccwDefault_)) {
         sb.append(i(l + 1) + "ccw " + ccw_.codeString(l + 1) + "\n");
      }
      if (null != colorPerVertex_ &&
          ! colorPerVertex_.equals(colorPerVertexDefault_)) {
         sb.append(i(l + 1) + "colorPerVertex " + colorPerVertex_.codeString(l + 1) + "\n");
      }
      if (null != creaseAngle_ &&
          ! creaseAngle_.equals(creaseAngleDefault_)) {
         sb.append(i(l + 1) + "creaseAngle " + creaseAngle_.codeString(l + 1) + "\n");
      }
      if (null != normalPerVertex_ &&
          ! normalPerVertex_.equals(normalPerVertexDefault_)) {
         sb.append(i(l + 1) + "normalPerVertex " + normalPerVertex_.codeString(l + 1) + "\n");
      }
      if (null != solid_ &&
          ! solid_.equals(solidDefault_)) {
         sb.append(i(l + 1) + "solid " + solid_.codeString(l + 1) + "\n");
      }
      if (null != xDimension_ &&
          ! xDimension_.equals(xDimensionDefault_)) {
         sb.append(i(l + 1) + "xDimension " + xDimension_.codeString(l + 1) + "\n");
      }
      if (null != xSpacing_ &&
          ! xSpacing_.equals(xSpacingDefault_)) {
         sb.append(i(l + 1) + "xSpacing " + xSpacing_.codeString(l + 1) + "\n");
      }
      if (null != zDimension_ &&
          ! zDimension_.equals(zDimensionDefault_)) {
         sb.append(i(l + 1) + "zDimension " + zDimension_.codeString(l + 1) + "\n");
      }
      if (null != zSpacing_ &&
          ! zSpacing_.equals(zSpacingDefault_)) {
         sb.append(i(l + 1) + "zSpacing " + zSpacing_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value color_ = null;
   protected static final SFNode colorDefault_ = new SFNode();
   protected Value normal_ = null;
   protected static final SFNode normalDefault_ = new SFNode();
   protected Value texCoord_ = null;
   protected static final SFNode texCoordDefault_ = new SFNode();
   protected Value height_ = new MFFloat();
   protected static final MFFloat heightDefault_ = new VRML2.VALUES.MFFloat();
   protected Value ccw_ = null;
   protected static final SFBool ccwDefault_ = new SFBool(true);
   protected Value colorPerVertex_ = null;
   protected static final SFBool colorPerVertexDefault_ = new SFBool(true);
   protected Value creaseAngle_ = null;
   protected static final SFFloat creaseAngleDefault_ = new SFFloat(0.0);
   protected Value normalPerVertex_ = null;
   protected static final SFBool normalPerVertexDefault_ = new SFBool(true);
   protected Value solid_ = null;
   protected static final SFBool solidDefault_ = new SFBool(true);
   protected Value xDimension_ = null;
   protected static final SFInt32 xDimensionDefault_ = new SFInt32(0);
   protected Value xSpacing_ = null;
   protected static final SFFloat xSpacingDefault_ = new SFFloat(0.0);
   protected Value zDimension_ = null;
   protected static final SFInt32 zDimensionDefault_ = new SFInt32(0);
   protected Value zSpacing_ = null;
   protected static final SFFloat zSpacingDefault_ = new SFFloat(0.0);
}
