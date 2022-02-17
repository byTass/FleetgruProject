package com.Fleetgru.stepdefinitions;

import com.Fleetgru.utilities.ConfigurationReader;
import com.Fleetgru.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        Driver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }
}
