package hellgren.rule_engine.predicate_function_map;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestErrorCode {

    @Test
    public void givenErrorCodeUtilIfElse_when1_thenVery() {
        String message1=ErrorCodeUtilIfElse.handleError("1");
        String message2=ErrorCodeUtilIfElse.handleError("2");
        String message3=ErrorCodeUtilIfElse.handleError("3");

        assertMessages(message1, message2, message3);
    }

    @Test
    public void givenErrorCodeUtilDecTableIfElse_when1_thenVery() {
        ErrorCodeUtilIfElse utilIfElse=new ErrorCodeUtilIfElse();

        String message1=utilIfElse.handleErrorDecTable("1");
        String message2=utilIfElse.handleErrorDecTable("2");
        String message3=utilIfElse.handleErrorDecTable("3");

        assertMessages(message1, message2, message3);
    }

    @Test
    public void givenErrorCodeUtilDecTableStreamsIfElse_when1_thenVery() {
        ErrorCodeUtilIfElse utilIfElse=new ErrorCodeUtilIfElse();

        String message1=utilIfElse.handleErrorDecTableStreams("1");
        String message2=utilIfElse.handleErrorDecTableStreams("2");
        String message3=utilIfElse.handleErrorDecTableStreams("3");

        assertMessages(message1, message2, message3);
    }




    private void assertMessages(String message1, String message2, String message3) {
        assertEquals("Very bad error", message1);
        assertEquals("Very very bad error", message2);
        assertEquals("Not known error", message3);
    }

}
