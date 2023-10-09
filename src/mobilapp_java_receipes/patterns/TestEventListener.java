package mobilapp_java_receipes.patterns;

import lombok.ToString;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEventListener {


    //In Java there are no events type
    interface GameListener {
        void gameStarted(String name);
    }

    static class Game {
        private final List<GameListener> listeners = new ArrayList<>();

        public void addListener(GameListener listener) {
            listeners.add(listener);
        }

        public String name;

        public void Start() {
            for (GameListener listener : listeners)
                listener.gameStarted(name);
        }

        public Game(String name) {
            this.name = name;
        }
    }

    @ToString
    static
    class EventListener implements GameListener {
        public int startsCount;
        public String lastGame;

        public void gameStarted(String name) {
            startsCount++;
            lastGame = name;
        }
    }

    @Test
    public void whenListeners_thenCorrect() {
        var listener = new EventListener();
        var heroes = new Game("Heroes");
        var doom = new Game("Doom");

        //subscribe to events
        heroes.addListener(listener);
        doom.addListener(listener);

        doom.Start();
        heroes.Start();

        System.out.println("statistic = " + listener);
        Assert.assertEquals(2,listener.startsCount);
        Assert.assertEquals("Heroes",listener.lastGame);


    }


}
