package VRML2;

import VRML2.VALUES.*;

public class ImageTexture extends NamedNode {
   public ImageTexture( ) {
      super();
   }
   public ImageTexture(String val) {
      super(val);
   }
   public ImageTexture(boolean val) {
      super(val);
   }

   public final MFString add_url(SFString val) {
      return ((MFString)url_).add(val);
   };
   public final MFString add_url(java.lang.String val0) {
      return ((MFString)url_).add(val0);
   };
   public final ImageTexture set_url(MFString val) {
      url_ = val;
      return this;
   };
   public final ImageTexture set_url(String alias) {
      url_ = new Alias(alias);
      return this;
   };
   public final ImageTexture set_repeatS(SFBool val) {
      repeatS_ = val;
      return this;
   };
   public final ImageTexture set_repeatS(boolean val0) {
      repeatS_ = new SFBool(val0);
      return this;
   };
   public final ImageTexture set_repeatS(String alias) {
      repeatS_ = new Alias(alias);
      return this;
   };
   public final ImageTexture set_repeatT(SFBool val) {
      repeatT_ = val;
      return this;
   };
   public final ImageTexture set_repeatT(boolean val0) {
      repeatT_ = new SFBool(val0);
      return this;
   };
   public final ImageTexture set_repeatT(String alias) {
      repeatT_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("ImageTexture {\n");

      if (null != url_ &&
          ! url_.equals(urlDefault_)) {
         sb.append(i(l + 1) + "url " + url_.codeString(l + 1) + "\n");
      }
      if (null != repeatS_ &&
          ! repeatS_.equals(repeatSDefault_)) {
         sb.append(i(l + 1) + "repeatS " + repeatS_.codeString(l + 1) + "\n");
      }
      if (null != repeatT_ &&
          ! repeatT_.equals(repeatTDefault_)) {
         sb.append(i(l + 1) + "repeatT " + repeatT_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value url_ = new MFString();
   protected static final MFString urlDefault_ = new VRML2.VALUES.MFString();
   protected Value repeatS_ = null;
   protected static final SFBool repeatSDefault_ = new SFBool(true);
   protected Value repeatT_ = null;
   protected static final SFBool repeatTDefault_ = new SFBool(true);
}
