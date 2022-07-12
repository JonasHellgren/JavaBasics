package effective_java.E_generics_tests.item33;

import effective_java.E_generics.item33.Favorites;
import org.junit.Test;

/***
 *  Enables multiple types in a data container
 * can only store one instance of a particular type. That’s where we need to extend this pattern one step further.
 * https://michaelbfullan.com/extending-the-typesafe-heterogeneous-container-pattern/
 */

public class TestUser {

    @Test
    public void test() {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);

        System.out.println("favoriteString = " + favoriteString);
        System.out.println("favoriteInteger = " + favoriteInteger);
        System.out.println("favoriteClass = " + favoriteClass);

    }

}
