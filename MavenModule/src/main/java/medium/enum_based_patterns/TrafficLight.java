package medium.enum_based_patterns;

public enum TrafficLight {
    RED {
        @Override
        public TrafficLight next() {
            return GREEN;
        }

        @Override
        public String action() {
            return "Stop";
        }
    },
    YELLOW {
        @Override
        public TrafficLight next() {
            return RED;
        }

        @Override
        public String action() {
            return "Caution";
        }
    },
    GREEN {
        @Override
        public TrafficLight next() {
            return YELLOW;
        }

        @Override
        public String action() {
            return "Go";
        }
    };


    public abstract TrafficLight next();

    public abstract String action();

}
