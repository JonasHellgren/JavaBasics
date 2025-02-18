package medium.enum_based_patterns;

public enum ShapeFactory {
    CIRCLE {
        @Override
        public ShapeI create() {
            return new Circle();
        }
    },
    SQUARE {
        @Override
        public ShapeI create() {
            return new Square();
        }
    };

    public abstract ShapeI create();

}
