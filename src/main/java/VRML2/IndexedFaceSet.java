package VRML2;

import VRML2.VALUES.*;

public class IndexedFaceSet extends NamedNode {
   public IndexedFaceSet( ) {
      super();
   }
   public IndexedFaceSet(String val) {
      super(val);
   }
   public IndexedFaceSet(boolean val) {
      super(val);
   }

   public final IndexedFaceSet set_color(SFNode val) {
      color_ = val;
      return this;
   };
   public final IndexedFaceSet set_color(VRML2.VRML2Node val0) {
      color_ = new SFNode(val0);
      return this;
   };
   public final IndexedFaceSet set_color(String alias) {
      color_ = new Alias(alias);
      return this;
   };
   public final IndexedFaceSet set_coord(SFNode val) {
      coord_ = val;
      return this;
   };
   public final IndexedFaceSet set_coord(VRML2.VRML2Node val0) {
      coord_ = new SFNode(val0);
      return this;
   };
   public final IndexedFaceSet set_coord(String alias) {
      coord_ = new Alias(alias);
      return this;
   };
   public final IndexedFaceSet set_normal(SFNode val) {
      normal_ = val;
      return this;
   };
   public final IndexedFaceSet set_normal(VRML2.VRML2Node val0) {
      normal_ = new SFNode(val0);
      return this;
   };
   public final IndexedFaceSet set_normal(String alias) {
      normal_ = new Alias(alias);
      return this;
   };
   public final IndexedFaceSet set_texCoord(SFNode val) {
      texCoord_ = val;
      return this;
   };
   public final IndexedFaceSet set_texCoord(VRML2.VRML2Node val0) {
      texCoord_ = new SFNode(val0);
      return this;
   };
   public final IndexedFaceSet set_texCoord(String alias) {
      texCoord_ = new Alias(alias);
      return this;
   };
   public final IndexedFaceSet set_ccw(SFBool val) {
      ccw_ = val;
      return this;
   };
   public final IndexedFaceSet set_ccw(boolean val0) {
      ccw_ = new SFBool(val0);
      return this;
   };
   public final IndexedFaceSet set_ccw(String alias) {
      ccw_ = new Alias(alias);
      return this;
   };
   public final MFInt32 add_colorIndex(SFInt32 val) {
      return ((MFInt32)colorIndex_).add(val);
   };
   public final MFInt32 add_colorIndex(int val0) {
      return ((MFInt32)colorIndex_).add(val0);
   };
   public final IndexedFaceSet set_colorIndex(MFInt32 val) {
      colorIndex_ = val;
      return this;
   };
   public final IndexedFaceSet set_colorIndex(String alias) {
      colorIndex_ = new Alias(alias);
      return this;
   };
   public final IndexedFaceSet set_colorPerVertex(SFBool val) {
      colorPerVertex_ = val;
      return this;
   };
   public final IndexedFaceSet set_colorPerVertex(boolean val0) {
      colorPerVertex_ = new SFBool(val0);
      return this;
   };
   public final IndexedFaceSet set_colorPerVertex(String alias) {
      colorPerVertex_ = new Alias(alias);
      return this;
   };
   public final IndexedFaceSet set_convex(SFBool val) {
      convex_ = val;
      return this;
   };
   public final IndexedFaceSet set_convex(boolean val0) {
      convex_ = new SFBool(val0);
      return this;
   };
   public final IndexedFaceSet set_convex(String alias) {
      convex_ = new Alias(alias);
      return this;
   };
   public final MFInt32 add_coordIndex(SFInt32 val) {
      return ((MFInt32)coordIndex_).add(val);
   };
   public final MFInt32 add_coordIndex(int val0) {
      return ((MFInt32)coordIndex_).add(val0);
   };
   public final IndexedFaceSet set_coordIndex(MFInt32 val) {
      coordIndex_ = val;
      return this;
   };
   public final IndexedFaceSet set_coordIndex(String alias) {
      coordIndex_ = new Alias(alias);
      return this;
   };
   public final IndexedFaceSet set_creaseAngle(SFFloat val) {
      creaseAngle_ = val;
      return this;
   };
   public final IndexedFaceSet set_creaseAngle(double val0) {
      creaseAngle_ = new SFFloat(val0);
      return this;
   };
   public final IndexedFaceSet set_creaseAngle(String alias) {
      creaseAngle_ = new Alias(alias);
      return this;
   };
   public final MFInt32 add_normalIndex(SFInt32 val) {
      return ((MFInt32)normalIndex_).add(val);
   };
   public final MFInt32 add_normalIndex(int val0) {
      return ((MFInt32)normalIndex_).add(val0);
   };
   public final IndexedFaceSet set_normalIndex(MFInt32 val) {
      normalIndex_ = val;
      return this;
   };
   public final IndexedFaceSet set_normalIndex(String alias) {
      normalIndex_ = new Alias(alias);
      return this;
   };
   public final IndexedFaceSet set_normalPerVertex(SFBool val) {
      normalPerVertex_ = val;
      return this;
   };
   public final IndexedFaceSet set_normalPerVertex(boolean val0) {
      normalPerVertex_ = new SFBool(val0);
      return this;
   };
   public final IndexedFaceSet set_normalPerVertex(String alias) {
      normalPerVertex_ = new Alias(alias);
      return this;
   };
   public final IndexedFaceSet set_solid(SFBool val) {
      solid_ = val;
      return this;
   };
   public final IndexedFaceSet set_solid(boolean val0) {
      solid_ = new SFBool(val0);
      return this;
   };
   public final IndexedFaceSet set_solid(String alias) {
      solid_ = new Alias(alias);
      return this;
   };
   public final MFInt32 add_texCoordIndex(SFInt32 val) {
      return ((MFInt32)texCoordIndex_).add(val);
   };
   public final MFInt32 add_texCoordIndex(int val0) {
      return ((MFInt32)texCoordIndex_).add(val0);
   };
   public final IndexedFaceSet set_texCoordIndex(MFInt32 val) {
      texCoordIndex_ = val;
      return this;
   };
   public final IndexedFaceSet set_texCoordIndex(String alias) {
      texCoordIndex_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("IndexedFaceSet {\n");

      if (null != color_ &&
          ! color_.equals(colorDefault_)) {
         sb.append(i(l + 1) + "color " + color_.codeString(l + 1) + "\n");
      }
      if (null != coord_ &&
          ! coord_.equals(coordDefault_)) {
         sb.append(i(l + 1) + "coord " + coord_.codeString(l + 1) + "\n");
      }
      if (null != normal_ &&
          ! normal_.equals(normalDefault_)) {
         sb.append(i(l + 1) + "normal " + normal_.codeString(l + 1) + "\n");
      }
      if (null != texCoord_ &&
          ! texCoord_.equals(texCoordDefault_)) {
         sb.append(i(l + 1) + "texCoord " + texCoord_.codeString(l + 1) + "\n");
      }
      if (null != ccw_ &&
          ! ccw_.equals(ccwDefault_)) {
         sb.append(i(l + 1) + "ccw " + ccw_.codeString(l + 1) + "\n");
      }
      if (null != colorIndex_ &&
          ! colorIndex_.equals(colorIndexDefault_)) {
         sb.append(i(l + 1) + "colorIndex " + colorIndex_.codeString(l + 1) + "\n");
      }
      if (null != colorPerVertex_ &&
          ! colorPerVertex_.equals(colorPerVertexDefault_)) {
         sb.append(i(l + 1) + "colorPerVertex " + colorPerVertex_.codeString(l + 1) + "\n");
      }
      if (null != convex_ &&
          ! convex_.equals(convexDefault_)) {
         sb.append(i(l + 1) + "convex " + convex_.codeString(l + 1) + "\n");
      }
      if (null != coordIndex_ &&
          ! coordIndex_.equals(coordIndexDefault_)) {
         sb.append(i(l + 1) + "coordIndex " + coordIndex_.codeString(l + 1) + "\n");
      }
      if (null != creaseAngle_ &&
          ! creaseAngle_.equals(creaseAngleDefault_)) {
         sb.append(i(l + 1) + "creaseAngle " + creaseAngle_.codeString(l + 1) + "\n");
      }
      if (null != normalIndex_ &&
          ! normalIndex_.equals(normalIndexDefault_)) {
         sb.append(i(l + 1) + "normalIndex " + normalIndex_.codeString(l + 1) + "\n");
      }
      if (null != normalPerVertex_ &&
          ! normalPerVertex_.equals(normalPerVertexDefault_)) {
         sb.append(i(l + 1) + "normalPerVertex " + normalPerVertex_.codeString(l + 1) + "\n");
      }
      if (null != solid_ &&
          ! solid_.equals(solidDefault_)) {
         sb.append(i(l + 1) + "solid " + solid_.codeString(l + 1) + "\n");
      }
      if (null != texCoordIndex_ &&
          ! texCoordIndex_.equals(texCoordIndexDefault_)) {
         sb.append(i(l + 1) + "texCoordIndex " + texCoordIndex_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value color_ = null;
   protected static final SFNode colorDefault_ = new SFNode();
   protected Value coord_ = null;
   protected static final SFNode coordDefault_ = new SFNode();
   protected Value normal_ = null;
   protected static final SFNode normalDefault_ = new SFNode();
   protected Value texCoord_ = null;
   protected static final SFNode texCoordDefault_ = new SFNode();
   protected Value ccw_ = null;
   protected static final SFBool ccwDefault_ = new SFBool(true);
   protected Value colorIndex_ = new MFInt32();
   protected static final MFInt32 colorIndexDefault_ = new VRML2.VALUES.MFInt32();
   protected Value colorPerVertex_ = null;
   protected static final SFBool colorPerVertexDefault_ = new SFBool(true);
   protected Value convex_ = null;
   protected static final SFBool convexDefault_ = new SFBool(true);
   protected Value coordIndex_ = new MFInt32();
   protected static final MFInt32 coordIndexDefault_ = new VRML2.VALUES.MFInt32();
   protected Value creaseAngle_ = null;
   protected static final SFFloat creaseAngleDefault_ = new SFFloat(0.0);
   protected Value normalIndex_ = new MFInt32();
   protected static final MFInt32 normalIndexDefault_ = new VRML2.VALUES.MFInt32();
   protected Value normalPerVertex_ = null;
   protected static final SFBool normalPerVertexDefault_ = new SFBool(true);
   protected Value solid_ = null;
   protected static final SFBool solidDefault_ = new SFBool(true);
   protected Value texCoordIndex_ = new MFInt32();
   protected static final MFInt32 texCoordIndexDefault_ = new VRML2.VALUES.MFInt32();
}
