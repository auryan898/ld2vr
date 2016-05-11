package VRML2;

import VRML2.VALUES.*;

public class Switch extends NamedNode {
   public Switch( ) {
      super();
   }
   public Switch(String val) {
      super(val);
   }
   public Switch(boolean val) {
      super(val);
   }

   public final MFNode add_choice(SFNode val) {
      return ((MFNode)choice_).add(val);
   };
   public final MFNode add_choice(VRML2.VRML2Node val0) {
      return ((MFNode)choice_).add(val0);
   };
   public final Switch set_choice(MFNode val) {
      choice_ = val;
      return this;
   };
   public final Switch set_choice(String alias) {
      choice_ = new Alias(alias);
      return this;
   };
   public final Switch set_whichChoice(SFInt32 val) {
      whichChoice_ = val;
      return this;
   };
   public final Switch set_whichChoice(int val0) {
      whichChoice_ = new SFInt32(val0);
      return this;
   };
   public final Switch set_whichChoice(String alias) {
      whichChoice_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("Switch {\n");

      if (null != choice_ &&
          ! choice_.equals(choiceDefault_)) {
         sb.append(i(l + 1) + "choice " + choice_.codeString(l + 1) + "\n");
      }
      if (null != whichChoice_ &&
          ! whichChoice_.equals(whichChoiceDefault_)) {
         sb.append(i(l + 1) + "whichChoice " + whichChoice_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value choice_ = new MFNode();
   protected static final MFNode choiceDefault_ = new VRML2.VALUES.MFNode();
   protected Value whichChoice_ = null;
   protected static final SFInt32 whichChoiceDefault_ = new SFInt32(-1);
}
