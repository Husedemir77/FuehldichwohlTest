package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utillities.Driver;
import utillities.ParentClass;

public class _Hooks {

    @Before // this should be in stepDefinitions package
    public void before(io.cucumber.java.Scenario scenario){
        System.out.println(scenario.getName() + " has been started...");
    }

    @After // this should be in stepDefinitions package
    public void after(Scenario scenario){
        System.out.println(scenario.getName() + " : " + scenario.getStatus());

        if (scenario.isFailed()) new ParentClass().takeScreenshot(scenario.getName() + "_" + Driver.browsers.get());

        Driver.quitDriver();
    }

}
