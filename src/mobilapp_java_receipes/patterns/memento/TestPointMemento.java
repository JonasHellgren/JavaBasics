package mobilapp_java_receipes.patterns.memento;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class TestPointMemento {

    //State
    static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Point op) {
            return x==op.x && y==op.y;
        }

        public void print() {
            System.out.println(x + ", " + y);
        }
    }

    static class Memento{
        private final Point state;

        public Memento(Point state) {
            this.state = state;
        }

        public Point getState() {
            return state;
        }
    }

    //Originator
    static class Shape {
        public Point position = new Point(0, 0);

        public void move(int left, int top) {
            position.x += left;
            position.y += top;
        }

        public Memento getMemento() {
            var state = new Point(
                    position.x, position.y);
            return new Memento(state);
        }

        public void setMemento(Memento memento) {
            position = memento.getState();
        }
    }

    //Caretaker
    static class ShapeHelper {
        private final Stack<Memento> stack = new Stack<>();
        private final Shape shape;

        public ShapeHelper(Shape shape) {
            this.shape = shape;
        }

        public void move(int left, int top) {
            stack.push(shape.getMemento());
            shape.move(left, top);
        }

        public void undo() {
            if (!stack.isEmpty()) {
                shape.setMemento(stack.pop());
            }
        }
    }

    @Test
    public void whenMemento() {
        var shape = new Shape();
        var helper = new ShapeHelper(shape);

        helper.move(2, 3);
        shape.position.print();

        helper.move(-5, 4);
        shape.position.print();
        Assert.assertTrue(shape.position.equals(new Point(-3, 7)));

        helper.undo();
        shape.position.print();
        Assert.assertTrue(shape.position.equals(new Point(2, 3)));
    }


}
