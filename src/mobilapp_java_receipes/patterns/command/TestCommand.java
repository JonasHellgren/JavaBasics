package mobilapp_java_receipes.patterns.command;

import org.junit.Before;
import org.junit.Test;

public class TestCommand {

    //Invoker
    static class BankClient {
        private final Command putCommand;
        private final Command getCommand;

        public BankClient(
                Command cPut, Command cGet) {
            putCommand = cPut;
            getCommand = cGet;
        }

        void putMoney() {
            putCommand.execute();
        }

        void getMoney() {
            getCommand.execute();
        }
    }

    //Receiver
    static class Bank {
        void giveMoney() {
            System.out.println("money to the client");
        }

        void receiveMoney() {
            System.out.println("money from the client");
        }
    }

    interface Command {
        void execute();
    }

    //ConcreteCommand
    static class PutCommand implements Command {
        private final Bank bank;

        public PutCommand(Bank bank) {
            this.bank = bank;
        }

        public void execute() {
            bank.receiveMoney();
        }
    }

    //ConcreteCommand
    static class GetCommand implements Command {
        private final Bank bank;

        public GetCommand(Bank bank) {
            this.bank = bank;
        }

        public void execute() {
            bank.giveMoney();
        }
    }

    Bank bank;
    PutCommand cPut;
    GetCommand cGet;
    BankClient client;

    @Before
    public void init() {
        bank = new Bank();
        cPut = new PutCommand(bank);
        cGet = new GetCommand(bank);
        client = new BankClient(cPut, cGet);
    }

    @Test
    public void whenGet_thenCorrect() {
        client.getMoney();  //prints "money to the client"
    }

    @Test
    public void whenReceive_thenCorrect() {
        client.putMoney();  //prints "money from the client"
    }

}
