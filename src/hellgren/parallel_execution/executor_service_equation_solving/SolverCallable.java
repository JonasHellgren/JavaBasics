package hellgren.parallel_execution.executor_service_equation_solving;

import common.CpuTimer;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.function.Function;


/***
 *   y=f(x)
 *   y=0=f(xBest)
 *
 *   Example:  y=4*x-2  => x=0.5
 */

@Log
class SolverCallable implements Callable<SolverCallable.XYPair> {

    record XYPair(double x, double y) {
        XYPair returnOtherPairIfBetter(XYPair otherPair) {
            return (Math.abs(y)>Math.abs(otherPair.y))
                    ? otherPair
                    :this;
        }

        static XYPair newRandom(Random r, Function<Double, Double> function) {
            double x=getRandomNumber(r,0,1d);
            return new XYPair(x,function.apply(x));

        }

    }

    Function<Double,Double> function;
    long maxTimeInMillis;
    XYPair bestPair;

    public SolverCallable(Function<Double, Double> function, long maxTimeInMillis) {
        this.function = function;
        this.maxTimeInMillis = maxTimeInMillis;
        log.info("Solver created");
    }

    @Override
    public XYPair call() throws Exception {
        CpuTimer timer=new CpuTimer(maxTimeInMillis);
        Random r=new Random();
        bestPair=XYPair.newRandom(r,function);
        log.info("Solving");
        int i=0;
        do {
            XYPair testPair=XYPair.newRandom(r,function);
            bestPair=bestPair.returnOtherPairIfBetter(testPair);
            i++;
        } while (!timer.isTimeExceeded());
        log.info("nof iterations = "+i);
        return bestPair;
    }

    private static double getRandomNumber(Random r, double rangeMin, double rangeMax) {
        return  rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }

    public String toString() {

        return "bestPair: x = "+bestPair.x;

    }

}
