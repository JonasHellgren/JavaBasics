package medium.enum_based_patterns;

public enum Command {
    START {
        @Override
        public void execute() {
            System.out.println("System is starting...");
        }
    },
    STOP {
        @Override
        public void execute() {
            System.out.println("System is stopping...");
        }
    },
    RESTART {
        @Override
        public void execute() {
            System.out.println("System is restarting...");
        }
    };

    public abstract void execute();

    // A helper to parse a string into a Command.
    public static Command fromString(String commandStr) {
        try {
            return Command.valueOf(commandStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new UnsupportedOperationException("Unsupported command: " + commandStr);
        }
    }

}
