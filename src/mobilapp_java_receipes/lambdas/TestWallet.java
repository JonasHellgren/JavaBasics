package mobilapp_java_receipes.lambdas;

import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

public class TestWallet {

    @AllArgsConstructor
    static class MoneyTracker {
        int sum;
    }

    public Function<Integer, Integer> MakeWallet(MoneyTracker moneyTracker) {
        return pay -> moneyTracker.sum -= pay;
    }

    @Test
    public void givenWalletFunction_whenCorrect() {
        var wallet = MakeWallet(new MoneyTracker(1000));
        Assert.assertEquals(950, wallet.apply(50).intValue());
        Assert.assertEquals(900, wallet.apply(50).intValue());

    }

}
