package com.pluralsight.leapyear;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//to add junit library: https://www.youtube.com/watch?v=BoyxIIGTAr0


public class TestLeapYear {
    //@BeforeClass
    @Test
    public void Is2020LeapYear() {    Assert.assertTrue(LeapYear.isLeapYear(2020));   }
    @Before
    @Test
    public void Is2021LeapYear() {   Assert.assertEquals("2021LeapYear",false, LeapYear.isLeapYear(2021));   }
    @After
    @Test
    public void IsLeapYearDivbyfour() {      Assert.assertTrue(LeapYear.isLeapYear(2016));    }
    @Test
    public void IsnonLeapYearDivbyfour() {      Assert.assertFalse(LeapYear.isLeapYear(2015));   }
    @Test
    public void IsnotLeapYearCenturyRounded() {      Assert.assertFalse(LeapYear.isLeapYear(1700));    }
    @Test
    public void IsLeapYearDivby400() {       Assert.assertTrue(LeapYear.isLeapYear(1600));    }

}
