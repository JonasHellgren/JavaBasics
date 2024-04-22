package apache.runners;

import org.apache.commons.lang3.reflect.FieldUtils;

public class ReflectionExamples {

        private String secret = "shh";

        public static void main(String[] args) throws IllegalAccessException {
            ReflectionExamples example = new ReflectionExamples();
            // Access and modify private fields safely
            String secretValue = (String) FieldUtils.readField(example, "secret", true);
            System.out.println("Secret value: " + secretValue);

            FieldUtils.writeField(example, "secret", "not a secret anymore", true);
            secretValue = (String) FieldUtils.readField(example, "secret", true);
            System.out.println("Modified secret value: " + secretValue);
        }

}
