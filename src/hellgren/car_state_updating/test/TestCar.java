package hellgren.car_state_updating.test;

import hellgren.car_state_updating.classes.Car;
import hellgren.car_state_updating.classes.CarParameters;
import hellgren.car_state_updating.classes.SimulationSettings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCar {

    Car car;

    @Before
    public void init() {
        var parameters= CarParameters.builder().mass(1000).airRes(0.2*2).build();
        car=new Car(parameters, SimulationSettings.newDefault());
    }

    @Test
    public void whenInit_thenCorrect() {
        Assert.assertEquals(0,car.getState().getVelocity(),1e-4);
    }

    @Test
    public void whenAppliedSpeed_thenCorrect() {
        car.applyForce(10_000);
        Assert.assertNotEquals(0,car.getState().getVelocity(),1e-4);

        System.out.println("state = " + car.getState());
    }

    @Test
    public void whenSimAcc_thenCorrect() {

        for (int i = 0; i < 100 ; i++) {
            car.applyForce(1000);

        }

        System.out.println("state = " + car.getState());

        Assert.assertTrue(car.getState().getVelocity()>10);
        Assert.assertTrue(car.getState().getVelocity()<100);

    }

    }
