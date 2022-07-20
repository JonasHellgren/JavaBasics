package java_design_patterns.F_observer_test;

import java_design_patterns.F_observer.news.NewsPaper;
import java_design_patterns.F_observer.news.Subscriber;
import org.junit.Assert;
import org.junit.Test;

public class TestNews {

    @Test
    public void test() {
        NewsPaper newsPaper = new NewsPaper();
        Subscriber subscriber1 = new Subscriber("Jonas");
        Subscriber subscriber2 = new Subscriber("Katja");

        newsPaper.addSubscriber(subscriber1);
        newsPaper.addSubscriber(subscriber2);
        newsPaper.setNews("news 1");
        newsPaper.setNews("news 2");

        Assert.assertEquals(subscriber1.getNews(), "news 2");
        Assert.assertEquals(2,newsPaper.nofSubscribers());

        newsPaper.removeSubscriber(subscriber1);
        Assert.assertEquals(1,newsPaper.nofSubscribers());

    }

}
