// $Id: ParallelException.java 1.1 1999/05/19 21:27:14 parisjp Exp $

package TOOLS;

public class ParallelException extends Exception {
   public ParallelException(String msg) {
      super(msg);
   };
   public ParallelException() {
      this("parallel");
   };
   
};
