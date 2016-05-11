package VRML2;

import VRML2.VALUES.*;

public class IndexedLineSet extends NamedNode {
   public IndexedLineSet( ) {
      super();
   }
   public IndexedLineSet(String val) {
      super(val);
   }
   public IndexedLineSet(boolean val) {
      super(val);
   }

   public final IndexedLineSet set_color(SFNode val) {
      color_ = val;
      return this;
   };
   public final IndexedLineSet set_color(VRML2.VRML2Node val0) {
      color_ = new SFNode(val0);
      return this;
   };
   public final IndexedLineSet set_color(String alias) {
      color_ = new Alias(alias);
      return this;
   };
   public final IndexedLineSet set_coord(SFNode val) {
      coord_ = val;
      return this;
   };
   public final IndexedLineSet set_coord(VRML2.VRML2Node val0) {
      coord_ = new SFNode(val0);
      return this;
   };
   public final IndexedLineSet set_coord(String alias) {
      coord_ = new Alias(alias);
      return this;
   };
   public final MFInt32 add_colorIndex(SFInt32 val) {
      return ((MFInt32)colorIndex_).add(val);
   };
   public final MFInt32 add_colorIndex(int val0) {
      return ((MFInt32)colorIndex_).add(val0);
   };
   public final IndexedLineSet set_colorIndex(MFInt32 val) {
      colorIndex_ = val;
      return this;
   };
   public final IndexedLineSet set_colorIndex(String alias) {
      colorIndex_ = new Alias(alias);
      return this;
   };
   public final IndexedLineSet set_colorPerVertex(SFBool val) {
      colorPerVertex_ = val;
      return this;
   };
   public final IndexedLineSet set_colorPerVertex(boolean val0) {
      colorPerVertex_ = new SFBool(val0);
      return this;
   };
   public final IndexedLineSet set_colorPerVertex(String alias) {
      colorPerVertex_ = new Alias(alias);
      return this;
   };
   public final MFInt32 add_coordIndex(SFInt32 val) {
      return ((MFInt32)coordIndex_).add(val);
   };
   public final MFInt32 add_coordIndex(int val0) {
      return ((MFInt32)coordIndex_).add(val0);
   };
   public final IndexedLineSet set_coordIndex(MFInt32 val) {
      coordIndex_ = val;
      return this;
   };
   public final IndexedLineSet set_coordIndex(String alias) {
      coordIndex_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("IndexedLineSet {\n");

      if (null != color_ &&
          ! color_.equals(colorDefault_)) {
         sb.append(i(l + 1) + "color " + color_.codeString(l + 1) + "\n");
      }
      if (null != coord_ &&
          ! coord_.equals(coordDefault_)) {
         sb.append(i(l + 1) + "coord " + coord_.codeString(l + 1) + "\n");
      }
      if (null != colorIndex_ &&
          ! colorIndex_.equals(colorIndexDefault_)) {
         sb.append(i(l + 1) + "colorIndex " + colorIndex_.codeString(l + 1) + "\n");
      }
      if (null != colorPerVertex_ &&
          ! colorPerVertex_.equals(colorPerVertexDefault_)) {
         sb.append(i(l + 1) + "colorPerVertex " + colorPerVertex_.codeString(l + 1) + "\n");
      }
      if (null != coordIndex_ &&
          ! coordIndex_.equals(coordIndexDefault_)) {
         sb.append(i(l + 1) + "coordIndex " + coordIndex_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value color_ = null;
   protected static final SFNode colorDefault_ = new SFNode();
   protected Value coord_ = null;
   protected static final SFNode coordDefault_ = new SFNode();
   protected Value colorIndex_ = new MFInt32();
   protected static final MFInt32 colorIndexDefault_ = new VRML2.VALUES.MFInt32();
   protected Value colorPerVertex_ = null;
   protected static final SFBool colorPerVertexDefault_ = new SFBool(true);
   protected Value coordIndex_ = new MFInt32();
   protected static final MFInt32 coordIndexDefault_ = new VRML2.VALUES.MFInt32();
}
