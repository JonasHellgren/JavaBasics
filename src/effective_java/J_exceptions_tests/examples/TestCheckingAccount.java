package effective_java.J_exceptions_tests.examples;

import effective_java.J_exceptions.examples.CheckingAccount;
import effective_java.J_exceptions.examples.InsufficientFundsException;
import lombok.extern.java.Log;
import org.junit.Test;

@Log
public class TestCheckingAccount {

    public static final double INIT_AMOUNT = 500.00;
    public static final int ACCOUNT_NUMBER = 324352134;

    @Test(expected = InsufficientFundsException.class)
    public void toMuchWithDrawGivesException() throws InsufficientFundsException {
        CheckingAccount c = new CheckingAccount(ACCOUNT_NUMBER);
        c.deposit(INIT_AMOUNT);
        c.withdraw(1000.00);
    }

    @Test(expected = Test.None.class)   //not thrown because caught
    public void toMuchWithDrawGivesExceptionCaughtInTryCatch()  {
        CheckingAccount c = new CheckingAccount(ACCOUNT_NUMBER);
        c.deposit(INIT_AMOUNT);
        try {
            System.out.println("\nWithdrawing $1000...");
            c.withdraw(1000.00);
        } catch (InsufficientFundsException e) {
            log.warning("Sorry, but you are short $" + e.getAmount());
        }
    }

    @Test(expected = Test.None.class)
    public void okWithDrawGivesException() throws InsufficientFundsException {
        CheckingAccount c = new CheckingAccount(ACCOUNT_NUMBER);
        c.deposit(INIT_AMOUNT);
        c.withdraw(100.00);
    }




}
