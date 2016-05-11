package VRML2;

import VRML2.VALUES.*;

public class PixelTexture extends NamedNode {
   public PixelTexture( ) {
      super();
   }
   public PixelTexture(String val) {
      super(val);
   }
   public PixelTexture(boolean val) {
      super(val);
   }

   public final PixelTexture set_image(SFImage val) {
      image_ = val;
      return this;
   };
   public final PixelTexture set_image(String alias) {
      image_ = new Alias(alias);
      return this;
   };
   public final PixelTexture set_repeatS(SFBool val) {
      repeatS_ = val;
      return this;
   };
   public final PixelTexture set_repeatS(boolean val0) {
      repeatS_ = new SFBool(val0);
      return this;
   };
   public final PixelTexture set_repeatS(String alias) {
      repeatS_ = new Alias(alias);
      return this;
   };
   public final PixelTexture set_repeatT(SFBool val) {
      repeatT_ = val;
      return this;
   };
   public final PixelTexture set_repeatT(boolean val0) {
      repeatT_ = new SFBool(val0);
      return this;
   };
   public final PixelTexture set_repeatT(String alias) {
      repeatT_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("PixelTexture {\n");

      if (null != image_ &&
          ! image_.equals(imageDefault_)) {
         sb.append(i(l + 1) + "image " + image_.codeString(l + 1) + "\n");
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

   protected Value image_ = null;
   protected static final SFImage imageDefault_ = new SFImage(0, 0, 0);
   protected Value repeatS_ = null;
   protected static final SFBool repeatSDefault_ = new SFBool(true);
   protected Value repeatT_ = null;
   protected static final SFBool repeatTDefault_ = new SFBool(true);
}
