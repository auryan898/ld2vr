package VRML2;

import VRML2.VALUES.*;

public class TimeSensor extends NamedNode {
   public TimeSensor( ) {
      super();
   }
   public TimeSensor(String val) {
      super(val);
   }
   public TimeSensor(boolean val) {
      super(val);
   }

   public final TimeSensor set_cycleInterval(SFTime val) {
      cycleInterval_ = val;
      return this;
   };
   public final TimeSensor set_cycleInterval(long val0) {
      cycleInterval_ = new SFTime(val0);
      return this;
   };
   public final TimeSensor set_cycleInterval(String alias) {
      cycleInterval_ = new Alias(alias);
      return this;
   };
   public final TimeSensor set_enabled(SFBool val) {
      enabled_ = val;
      return this;
   };
   public final TimeSensor set_enabled(boolean val0) {
      enabled_ = new SFBool(val0);
      return this;
   };
   public final TimeSensor set_enabled(String alias) {
      enabled_ = new Alias(alias);
      return this;
   };
   public final TimeSensor set_loop(SFBool val) {
      loop_ = val;
      return this;
   };
   public final TimeSensor set_loop(boolean val0) {
      loop_ = new SFBool(val0);
      return this;
   };
   public final TimeSensor set_loop(String alias) {
      loop_ = new Alias(alias);
      return this;
   };
   public final TimeSensor set_startTime(SFTime val) {
      startTime_ = val;
      return this;
   };
   public final TimeSensor set_startTime(long val0) {
      startTime_ = new SFTime(val0);
      return this;
   };
   public final TimeSensor set_startTime(String alias) {
      startTime_ = new Alias(alias);
      return this;
   };
   public final TimeSensor set_stopTime(SFTime val) {
      stopTime_ = val;
      return this;
   };
   public final TimeSensor set_stopTime(long val0) {
      stopTime_ = new SFTime(val0);
      return this;
   };
   public final TimeSensor set_stopTime(String alias) {
      stopTime_ = new Alias(alias);
      return this;
   };

   public String codeStringAux(int l) {
      StringBuffer sb = new StringBuffer("TimeSensor {\n");

      if (null != cycleInterval_ &&
          ! cycleInterval_.equals(cycleIntervalDefault_)) {
         sb.append(i(l + 1) + "cycleInterval " + cycleInterval_.codeString(l + 1) + "\n");
      }
      if (null != enabled_ &&
          ! enabled_.equals(enabledDefault_)) {
         sb.append(i(l + 1) + "enabled " + enabled_.codeString(l + 1) + "\n");
      }
      if (null != loop_ &&
          ! loop_.equals(loopDefault_)) {
         sb.append(i(l + 1) + "loop " + loop_.codeString(l + 1) + "\n");
      }
      if (null != startTime_ &&
          ! startTime_.equals(startTimeDefault_)) {
         sb.append(i(l + 1) + "startTime " + startTime_.codeString(l + 1) + "\n");
      }
      if (null != stopTime_ &&
          ! stopTime_.equals(stopTimeDefault_)) {
         sb.append(i(l + 1) + "stopTime " + stopTime_.codeString(l + 1) + "\n");
      }
      return sb.append(i(l) + "}").toString();
   }

   protected Value cycleInterval_ = null;
   protected static final SFTime cycleIntervalDefault_ = new SFTime(1);
   protected Value enabled_ = null;
   protected static final SFBool enabledDefault_ = new SFBool(true);
   protected Value loop_ = null;
   protected static final SFBool loopDefault_ = new SFBool(false);
   protected Value startTime_ = null;
   protected static final SFTime startTimeDefault_ = new SFTime(0);
   protected Value stopTime_ = null;
   protected static final SFTime stopTimeDefault_ = new SFTime(0);
}
