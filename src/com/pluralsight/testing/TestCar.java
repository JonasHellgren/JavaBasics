package com.pluralsight.testing;

import org.junit.*;

public class TestCar {

    private Car car;
    @BeforeClass  //the aftercoming function is executed before all tests are started
    static public void beforeclass() {   System.out.println("Set of tests started"); }
    @AfterClass //the aftercoming function is executed after all tests are finished
    static public void afterclass() {   System.out.println("Set of tests finished"); }
    @Before //the aftercoming function is executed before a test is started
    public void before() {   System.out.println("Test started"); }
    @After //the aftercoming function is executed after a test is finished
    public void after() {   System.out.println("Test finished"); }

    private void createStandStillCar() {    car = new Car(0.0);   }  //constructor

    @Test
    public void FromStillToCreep() {
        createStandStillCar();   //given
        car.UpdSpd(1.0, 10.0);   //when
        Assert.assertTrue(car.GetSpd() > 0.1);  //then
    }
    @Test
    public void FromStillToFast() {
        createStandStillCar();   //given
        car.UpdSpd(2.0, 10.0);   //when
        Assert.assertTrue(car.GetSpd() > 10);  //then
    }
    @Test (expected = NullPointerException.class)
    public void InvalidAccType() {
        createStandStillCar();   //given
        car.UpdSpd(null, 10.0);   //when
    }
    @Test (expected = IllegalArgumentException.class)
    public void InvalidDT() {
        createStandStillCar();   //given
        car.UpdSpd(2.0, 0.0);   //when
    }
}
