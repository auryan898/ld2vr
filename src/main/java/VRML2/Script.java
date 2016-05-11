package VRML2;

import VRML2.VALUES.*;

public class Script extends NamedNode {
   public Script( ) {
      super();
   }
   public Script(String val) {
      super(val);
   }
   public Script(boolean val) {
      super(val);
   }

   public final MFString add_url(SFString val) {
      return ((MFString)url_).add(val);
   };
   public final MFString add_url(java.lang.String val0) {
      return ((MFString)url_).add(val0);
   };
   public final Script set_url(MFString val) {
      url_ = val;
      return this;
   };
   public final Script set_url(String alias) {
      url_ = new Alias(alias);
      return this;
   };
   public final Script set_directOutput(SFBool val) {
      directOutput_ = val;
      return this;
   };
   public final Script set_directOutput(boolean val0) {
      directOutput_ = new SFBool(val0);
      return this;
   };
   public final Script set_directOutput(String alias) {
      directOutput_ = new Alias(alias);
      return this;
   };
   public final Script set_mustEvaluate(SFBool val) {
      mustEvaluate_ = val;
      return this;
   };
   public final Script set_mustEvaluate(boolean val0) {
      mustEvaluate_ = new SFBool(val0);
      return this;
   };
   public final Script set_mustEvaluate(String alias) {
      mustEvaluate_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Script {\n");

      if (null != url_ &&
          ! url_.equals(urlDefault_)) {
         sb.append(i(l + 1) + "url " + url_.codeString(l + 1) + "\n");
      }
      if (null != directOutput_ &&
          ! directOutput_.equals(directOutputDefault_)) {
         sb.append(i(l + 1) + "directOutput " + directOutput_.codeString(l + 1) + "\n");
      }
      if (null != mustEvaluate_ &&
          ! mustEvaluate_.equals(mustEvaluateDefault_)) {
         sb.append(i(l + 1) + "mustEvaluate " + mustEvaluate_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value url_ = new MFString();
   protected static final MFString urlDefault_ = new VRML2.VALUES.MFString();
   protected Value directOutput_ = null;
   protected static final SFBool directOutputDefault_ = new SFBool(false);
   protected Value mustEvaluate_ = null;
   protected static final SFBool mustEvaluateDefault_ = new SFBool(false);
}
