package VRML2;

import VRML2.VALUES.*;

public class Text extends NamedNode {
   public Text( ) {
      super();
   }
   public Text(String val) {
      super(val);
   }
   public Text(boolean val) {
      super(val);
   }

   public final MFString add_string(SFString val) {
      return ((MFString)string_).add(val);
   };
   public final MFString add_string(java.lang.String val0) {
      return ((MFString)string_).add(val0);
   };
   public final Text set_string(MFString val) {
      string_ = val;
      return this;
   };
   public final Text set_string(String alias) {
      string_ = new Alias(alias);
      return this;
   };
   public final Text set_fontStyle(SFNode val) {
      fontStyle_ = val;
      return this;
   };
   public final Text set_fontStyle(VRML2.VRML2Node val0) {
      fontStyle_ = new SFNode(val0);
      return this;
   };
   public final Text set_fontStyle(String alias) {
      fontStyle_ = new Alias(alias);
      return this;
   };
   public final MFFloat add_length(SFFloat val) {
      return ((MFFloat)length_).add(val);
   };
   public final MFFloat add_length(double val0) {
      return ((MFFloat)length_).add(val0);
   };
   public final Text set_length(MFFloat val) {
      length_ = val;
      return this;
   };
   public final Text set_length(String alias) {
      length_ = new Alias(alias);
      return this;
   };
   public final Text set_maxExtent(SFFloat val) {
      maxExtent_ = val;
      return this;
   };
   public final Text set_maxExtent(double val0) {
      maxExtent_ = new SFFloat(val0);
      return this;
   };
   public final Text set_maxExtent(String alias) {
      maxExtent_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Text {\n");

      if (null != string_ &&
          ! string_.equals(stringDefault_)) {
         sb.append(i(l + 1) + "string " + string_.codeString(l + 1) + "\n");
      }
      if (null != fontStyle_ &&
          ! fontStyle_.equals(fontStyleDefault_)) {
         sb.append(i(l + 1) + "fontStyle " + fontStyle_.codeString(l + 1) + "\n");
      }
      if (null != length_ &&
          ! length_.equals(lengthDefault_)) {
         sb.append(i(l + 1) + "length " + length_.codeString(l + 1) + "\n");
      }
      if (null != maxExtent_ &&
          ! maxExtent_.equals(maxExtentDefault_)) {
         sb.append(i(l + 1) + "maxExtent " + maxExtent_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value string_ = new MFString();
   protected static final MFString stringDefault_ = new VRML2.VALUES.MFString();
   protected Value fontStyle_ = null;
   protected static final SFNode fontStyleDefault_ = new SFNode();
   protected Value length_ = new MFFloat();
   protected static final MFFloat lengthDefault_ = new VRML2.VALUES.MFFloat();
   protected Value maxExtent_ = null;
   protected static final SFFloat maxExtentDefault_ = new SFFloat(0.0);
}
