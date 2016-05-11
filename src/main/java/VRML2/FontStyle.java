package VRML2;

import VRML2.VALUES.*;

public class FontStyle extends NamedNode {
   public FontStyle( ) {
      super();
   }
   public FontStyle(String val) {
      super(val);
   }
   public FontStyle(boolean val) {
      super(val);
   }

   public final FontStyle set_family(SFString val) {
      family_ = val;
      return this;
   };
   public final FontStyle set_family(String alias) {
      family_ = new Alias(alias);
      return this;
   };
   public final FontStyle set_horizontal(SFBool val) {
      horizontal_ = val;
      return this;
   };
   public final FontStyle set_horizontal(boolean val0) {
      horizontal_ = new SFBool(val0);
      return this;
   };
   public final FontStyle set_horizontal(String alias) {
      horizontal_ = new Alias(alias);
      return this;
   };
   public final MFString add_justify(SFString val) {
      return ((MFString)justify_).add(val);
   };
   public final MFString add_justify(java.lang.String val0) {
      return ((MFString)justify_).add(val0);
   };
   public final FontStyle set_justify(MFString val) {
      justify_ = val;
      return this;
   };
   public final FontStyle set_justify(String alias) {
      justify_ = new Alias(alias);
      return this;
   };
   public final FontStyle set_language(SFString val) {
      language_ = val;
      return this;
   };
   public final FontStyle set_language(String alias) {
      language_ = new Alias(alias);
      return this;
   };
   public final FontStyle set_leftToRight(SFBool val) {
      leftToRight_ = val;
      return this;
   };
   public final FontStyle set_leftToRight(boolean val0) {
      leftToRight_ = new SFBool(val0);
      return this;
   };
   public final FontStyle set_leftToRight(String alias) {
      leftToRight_ = new Alias(alias);
      return this;
   };
   public final FontStyle set_size(SFFloat val) {
      size_ = val;
      return this;
   };
   public final FontStyle set_size(double val0) {
      size_ = new SFFloat(val0);
      return this;
   };
   public final FontStyle set_size(String alias) {
      size_ = new Alias(alias);
      return this;
   };
   public final FontStyle set_spacing(SFFloat val) {
      spacing_ = val;
      return this;
   };
   public final FontStyle set_spacing(double val0) {
      spacing_ = new SFFloat(val0);
      return this;
   };
   public final FontStyle set_spacing(String alias) {
      spacing_ = new Alias(alias);
      return this;
   };
   public final FontStyle set_style(SFString val) {
      style_ = val;
      return this;
   };
   public final FontStyle set_style(String alias) {
      style_ = new Alias(alias);
      return this;
   };
   public final FontStyle set_topToBottom(SFBool val) {
      topToBottom_ = val;
      return this;
   };
   public final FontStyle set_topToBottom(boolean val0) {
      topToBottom_ = new SFBool(val0);
      return this;
   };
   public final FontStyle set_topToBottom(String alias) {
      topToBottom_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("FontStyle {\n");

      if (null != family_ &&
          ! family_.equals(familyDefault_)) {
         sb.append(i(l + 1) + "family " + family_.codeString(l + 1) + "\n");
      }
      if (null != horizontal_ &&
          ! horizontal_.equals(horizontalDefault_)) {
         sb.append(i(l + 1) + "horizontal " + horizontal_.codeString(l + 1) + "\n");
      }
      if (null != justify_ &&
          ! justify_.equals(justifyDefault_)) {
         sb.append(i(l + 1) + "justify " + justify_.codeString(l + 1) + "\n");
      }
      if (null != language_ &&
          ! language_.equals(languageDefault_)) {
         sb.append(i(l + 1) + "language " + language_.codeString(l + 1) + "\n");
      }
      if (null != leftToRight_ &&
          ! leftToRight_.equals(leftToRightDefault_)) {
         sb.append(i(l + 1) + "leftToRight " + leftToRight_.codeString(l + 1) + "\n");
      }
      if (null != size_ &&
          ! size_.equals(sizeDefault_)) {
         sb.append(i(l + 1) + "size " + size_.codeString(l + 1) + "\n");
      }
      if (null != spacing_ &&
          ! spacing_.equals(spacingDefault_)) {
         sb.append(i(l + 1) + "spacing " + spacing_.codeString(l + 1) + "\n");
      }
      if (null != style_ &&
          ! style_.equals(styleDefault_)) {
         sb.append(i(l + 1) + "style " + style_.codeString(l + 1) + "\n");
      }
      if (null != topToBottom_ &&
          ! topToBottom_.equals(topToBottomDefault_)) {
         sb.append(i(l + 1) + "topToBottom " + topToBottom_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value family_ = null;
   protected static final SFString familyDefault_ = new SFString("SERIF");
   protected Value horizontal_ = null;
   protected static final SFBool horizontalDefault_ = new SFBool(true);
   protected Value justify_ = new MFString();
   protected static final MFString justifyDefault_ = new VRML2.VALUES.MFString().add(new SFString("BEGIN"));
   protected Value language_ = null;
   protected static final SFString languageDefault_ = new SFString("");
   protected Value leftToRight_ = null;
   protected static final SFBool leftToRightDefault_ = new SFBool(true);
   protected Value size_ = null;
   protected static final SFFloat sizeDefault_ = new SFFloat(1.0);
   protected Value spacing_ = null;
   protected static final SFFloat spacingDefault_ = new SFFloat(1.0);
   protected Value style_ = null;
   protected static final SFString styleDefault_ = new SFString("PLAIN");
   protected Value topToBottom_ = null;
   protected static final SFBool topToBottomDefault_ = new SFBool(true);
}
