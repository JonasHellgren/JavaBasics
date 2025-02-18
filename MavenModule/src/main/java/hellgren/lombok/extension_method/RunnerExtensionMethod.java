package hellgren.lombok.extension_method;

import lombok.experimental.ExtensionMethod;

/***
 * does not work
 */

@ExtensionMethod({Math.class})
public class RunnerExtensionMethod {
    public static void main(String[] args) {

        int value = -10;
      //  int absValue = value.abs();  // Calls Math.abs()
  //      System.out.println(absValue);

    }
}